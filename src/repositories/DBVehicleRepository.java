package repositories;

import model.Employee;
import model.Vehicle;
import service.DatabaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DBVehicleRepository implements VehicleRepository {
    @Override
    public void addVehicle(Vehicle v) {
        String sql = "INSERT INTO vehicles VALUES (NULL,?, ?)";
        try {
            PreparedStatement statement =  DatabaseService.getStatament(sql);
            statement.setInt(1,v.getSeats());
            statement.setFloat(2,v.getFuelConsumption());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Optional<Vehicle> findVehicleByNumber(Integer nr) {
        String sql = "SELECT * FROM vehicles WHERE number = ?";
        try{
            PreparedStatement statement = DatabaseService.getStatament(sql);
            statement.setInt(1, nr);
            ResultSet set = statement.executeQuery();
            if(set.next()){
                Vehicle veh = new Vehicle();
                veh.setNumber(nr);
                veh.setSeats(set.getInt("seats"));
                veh.setFuelConsumption(set.getFloat("fuelConsumption"));
                return Optional.of(veh);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
