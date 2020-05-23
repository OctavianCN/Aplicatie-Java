package gui;

import model.City;
import model.Employee;
import model.Route;
import repositories.DBRouteRepository;
import service.AuditService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RouteFrame extends JFrame {
    private JPanel panel1;
    private JTextField enterNameTextField;
    private JTextField enterNameTextField1;
    private JTextField enterDateTextField;
    private JTextField enterLongitudeTextField;
    private JTextField enterLatitudeTextField;
    private JButton addButton;
    private JButton addButton1;
    private JButton findRouteButton;
    private JTextField enterIdTextField1;
    private JButton backButton;

    public RouteFrame(){
        DBRouteRepository dbRouteRepository = new DBRouteRepository();
        List<City> cityList = new ArrayList<City>();
        AuditService auditService = AuditService.getInstance();
        auditService.writeAction("S-a intrat pe pagina routes");
        pack();
        setContentPane(panel1);

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
                try {
                    City city = new City();
                    city.setName(enterNameTextField.getText());
                    city.setLatitude(Float.parseFloat(enterLatitudeTextField.getText()));
                    city.setLongitude(Float.parseFloat(enterLongitudeTextField.getText()));
                    cityList.add(city);
                    JOptionPane.showMessageDialog(null, "Oras adaugat la ruta!");
                    AuditService auditService = AuditService.getInstance();
                    auditService.writeAction("S-a adaugat un oras nou");
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Date introduse incorect!");
                }
            }

        });
        addButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Route r = new Route();
                    if(cityList.size()>=2)
                        r.setCities(cityList);
                    else{
                        JOptionPane.showMessageDialog(null, "Ruta trebuie sa aiba cel putin 2 orase!");
                        throw new Exception();
                    }
                    r.setName(enterNameTextField1.getText());
                    r.setDate(enterDateTextField.getText());
                    dbRouteRepository.addRoute(r);
                    JOptionPane.showMessageDialog(null, "Ruta a fost adaugata!");
                    AuditService auditService = AuditService.getInstance();
                    auditService.writeAction("S-a adaugat o ruta noua");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Date introduse incorect!");
                }
            }
        });
        findRouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    Route r = dbRouteRepository.findRouteById(Integer.parseInt(enterIdTextField1.getText()));
                    AuditService auditService = AuditService.getInstance();
                    auditService.writeAction("S-a cautat o ruta");
                    if(r != null)
                        JOptionPane.showMessageDialog(null, r.toString());
                    else
                        JOptionPane.showMessageDialog(null, "Ruta cu id-ul " + enterIdTextField1.getText() + " nu a fost gasit!");
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ruta cu id-ul " + enterIdTextField1.getText() + " nu a fost gasit!");
                }
            }
        });
    }
}
