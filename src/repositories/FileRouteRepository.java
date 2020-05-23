package repositories;


import model.City;
import model.Route;
import service.AuditService;
import service.FileService;

import java.util.ArrayList;
import java.util.List;


public class FileRouteRepository implements RouteRepository {
    private final String  filePath = "Routes";
    @Override
    public void addRoute(Route r) {
        FileService service = FileService.getInstance();
        AuditService auditService = AuditService.getInstance();
        String routeData = r.toString();
        auditService.writeAction("S-a adaugat o ruta in fisierul " + filePath);
        service.writeFile(filePath,routeData);
    }

    @Override
    public Route findRouteById(Integer id) {
        FileService service = FileService.getInstance();
        Route route  = null;
        try {
            List<String> routeList = service.getFile(filePath);
            for (String u : routeList) {
                String [] attr = u.split(",");
                if (attr[1].equals(id.toString()))  {
                    route = new Route();
                    route.setId(Integer.parseInt(attr[1]));
                    route.setName(attr[0]);
                    route.setDate(attr[2]);
                    List<City> citiesList = new ArrayList<>();
                    for (int i = 3;i<attr.length;i++){
                        City city = new City();
                        city.setName(attr[i]);
                        city.setLongitude(Float.parseFloat(attr[++i]));
                        city.setLatitude(Float.parseFloat(attr[++i]));
                        citiesList.add(city);
                    }
                    route.setCities(citiesList);
                    break;
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return route;
    }

}
