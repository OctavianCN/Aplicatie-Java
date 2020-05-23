package repositories;

import model.Vehicle;
import service.AuditService;
import service.FileService;

import java.util.List;
import java.util.Optional;

public class FileVehicleRepository implements VehicleRepository {
    private final String filePath = "Vehicles";
    @Override
    public void addVehicle(Vehicle v) {
        FileService service = FileService.getInstance();
        AuditService auditService = AuditService.getInstance();
        String vehicleData = v.toString();
        auditService.writeAction("S-a adaugat un vehicul in fisierul " + filePath);
        service.writeFile(filePath,vehicleData);
    }

    @Override
    public Optional<Vehicle> findVehicleByNumber(Integer nr) {
        FileService service = FileService.getInstance();
        Vehicle vehicle =new Vehicle();;
        try {
            List<String> vehicleList = service.getFile(filePath);
            for (String u : vehicleList) {
                String [] attr = u.split(",");
                if (attr[0].equals(nr.toString()))  {
                    vehicle.setNumber(nr);
                    vehicle.setFuelConsumption(Float.parseFloat(attr[2]));
                    vehicle.setSeats(Integer.parseInt(attr[1]));
                    break;
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return Optional.of(vehicle);
    }
}
