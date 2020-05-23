package repositories;

import exceptions.InexistentRouteIdException;
import model.Route;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class MapRouteRepository implements RouteRepository {

    private Map<Integer, Route> routes;

    public MapRouteRepository(){

        routes = new HashMap<>();
    }
    @Override
    public void addRoute(Route r){
        routes.put(r.getId(),r);
    }

    @Override
    public Route findRouteById(Integer id){

        Route route = null;

        try{
                if(routes.get(id).equals(null)){
                    throw new InexistentRouteIdException();
                }
                route = routes.get(id);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        return route;
    }



}
