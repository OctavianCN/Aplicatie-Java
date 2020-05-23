package repositories;

import model.Route;

public interface RouteRepository {

    void addRoute(Route r);
    Route findRouteById(Integer id);
    static RouteRepository build(RouteRepository.Type type) {
        switch (type) {
            case DB: return new DBRouteRepository();
            case FILE: return new FileRouteRepository();
            case ARRAY:return new MapRouteRepository();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        DB, FILE, ARRAY
    }
}
