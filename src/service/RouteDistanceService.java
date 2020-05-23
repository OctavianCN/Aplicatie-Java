package service;

import model.City;
import model.Route;
import repositories.MapRouteRepository;

import java.util.List;

public class RouteDistanceService {

    private MapRouteRepository routeRepository;

    public RouteDistanceService(MapRouteRepository rp){
        routeRepository = rp;
    }

    public float Distance(int id){

        float distance = 0;
        Route route = routeRepository.findRouteById(id);
        if(!route.equals(null)) {

            List<City> cities = route.getCities();

            for (int i = 0; i < cities.size() - 1; i++) {

                distance = distance + DistanceBetweenTwoCities(cities.get(i),cities.get(i + 1));
            }
        }
        return distance;
    }

    private float DistanceBetweenTwoCities(City a,City b){
        float dist = 0;

        try {
            if((a.getLongitude()>90)||(b.getLongitude()>90)||(a.getLatitude()>90)||(b.getLatitude()>90)){
                throw new Exception();
            }

            if (!((a.getLatitude() == b.getLatitude()) && (a.getLongitude() == b.getLongitude()))) {

                float theta = a.getLongitude() - b.getLongitude();
                dist = (float) (Math.sin(Math.toRadians(a.getLatitude())) * Math.sin(Math.toRadians(b.getLatitude())) + Math.cos(Math.toRadians(a.getLatitude())) * Math.cos(Math.toRadians(b.getLatitude())) * Math.cos(Math.toRadians(theta)));
                dist = (float) Math.acos(dist);
                dist = (float) Math.toDegrees(dist);
                dist = (float) (dist * 60 * 1.1515* 1.609344);

            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return dist;
    }
}
