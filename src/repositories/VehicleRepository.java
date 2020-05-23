package repositories;

import model.Vehicle;

import java.util.Optional;

public interface VehicleRepository {

    void addVehicle(Vehicle v);
    Optional<Vehicle> findVehicleByNumber(Integer nr);
    static VehicleRepository build(VehicleRepository.Type type) {
        switch (type) {
            case DB: return new DBVehicleRepository();
            case FILE: return new FileVehicleRepository();
            case ARRAY:return new MapVehicleRepository();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        DB, FILE, ARRAY
    }
}
