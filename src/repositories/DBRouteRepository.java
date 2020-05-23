package repositories;

import model.City;
import model.Employee;
import model.Route;
import service.DatabaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBRouteRepository implements RouteRepository {
    @Override
    public void addRoute(Route r) {
        String sql = "INSERT INTO routes VALUES (NULL,?, ?,?)";
        try {
            PreparedStatement statement =  DatabaseService.getStatament(sql);
            statement.setString(1,r.getName());
            statement.setString(2,r.getDate());
            String route = "";
            List<City> list = r.getCities();
            for (int i= 0;i<list.size();i++){
                route = route + list.get(i).getName() + "-";
            }
            statement.setString(3,route);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Route findRouteById(Integer id) {
        String sql = "SELECT * FROM routes WHERE id = ?";
        try{
            PreparedStatement statement = DatabaseService.getStatament(sql);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if(set.next()){
                Route r = new Route();
                r.setId(set.getInt("id"));
                r.setName(set.getString("name"));
                r.setDate(set.getString("date"));
                String cities = set.getString("route");
                String[] route = cities.split("-");
                List<City> list = new ArrayList<>();
                for(int i=0;i<route.length;i++){
                    City city = new City();
                    city.setName(route[i]);
                    list.add(city);
                }
                r.setCities(list);
                return r;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
