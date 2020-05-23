package gui;

import model.Ticket;
import model.Vehicle;
import repositories.DBVehicleRepository;
import service.AuditService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class VehicleFrame extends JFrame{
    private JPanel panel1;
    private JTextField addFuelConsumptionTextField;
    private JTextField addSeatsTextField;
    private JButton addButton;
    private JButton findVehicleButton;
    private JTextField addNumberTextField1;
    private JButton backButton;
    private JLabel fuelConsumption;
    private JLabel Seats;
    public VehicleFrame(){
        DBVehicleRepository dbVehicleRepository = new DBVehicleRepository();
        pack();
        setContentPane(panel1);
        AuditService auditService = AuditService.getInstance();
        auditService.writeAction("S-a intrat pe pagina vehicles");

        setSize(750,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainMenuFrame f = new MainMenuFrame();
                f.setLocation(getLocation());
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Vehicle v = new Vehicle();
                    v.setSeats(Integer.parseInt(addSeatsTextField.getText()));
                    v.setFuelConsumption(Integer.parseInt(addFuelConsumptionTextField.getText()));
                    dbVehicleRepository.addVehicle(v);
                    JOptionPane.showMessageDialog(null, "Vehiculul a fost adaugat in baza de date!");
                    AuditService auditService = AuditService.getInstance();
                    auditService.writeAction("S-a adaugat un vehicul nou");

                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Date introduse gresit!");
                }
            }
        });
        findVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Optional<Vehicle> v = dbVehicleRepository.findVehicleByNumber(Integer.parseInt(addNumberTextField1.getText()));
                    Vehicle veh = v.get();
                    if (!v.isEmpty())
                        JOptionPane.showMessageDialog(null, veh.toString());
                    else
                        JOptionPane.showMessageDialog(null, "Vehiculul cu numarul " + addNumberTextField1.getText() + " nu a fost gasit!");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Vehiculul cu numarul " + addNumberTextField1.getText() + " nu a fost gasit!");
                }

            }
        });
    }
}
