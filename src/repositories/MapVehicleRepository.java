package repositories;

import exceptions.InexistentRouteIdException;
import model.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapVehicleRepository implements VehicleRepository {
    private Map<Integer, Vehicle> vehicles;

    public MapVehicleRepository() {

        vehicles = new HashMap<>();
    }
    @Override
    public void addVehicle(Vehicle v) {
        vehicles.put(v.getNumber(), v);
    }

    @Override
    public Optional<Vehicle> findVehicleByNumber(Integer nr) {

        Vehicle vehicle = null;

        try {
            if (vehicles.get(nr).equals(null)) {
                throw new InexistentRouteIdException();
            }
            vehicle = vehicles.get(nr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(vehicle);
    }
}

