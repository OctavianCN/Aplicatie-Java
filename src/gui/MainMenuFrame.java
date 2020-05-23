package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame{
    private JPanel Menu;
    private JTextField mainMenuTextField;
    private JButton employeesButton;
    private JButton vehiclesButton;
    private JButton ticketsButton;
    private JButton routesButton;
    public MainMenuFrame(){
            pack();
            setContentPane(Menu);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
            setSize(750,500);
        employeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                EmployeesFrame f = new EmployeesFrame();
                f.setLocation(getLocation());
            }
        });
        ticketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                TicketFrame f = new TicketFrame();
                f.setLocation(getLocation());
            }
        });
        vehiclesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                VehicleFrame f = new VehicleFrame();
                f.setLocation(getLocation());
            }
        });
        routesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                RouteFrame f = new RouteFrame();
                f.setLocation(getLocation());
            }
        });
    }
}
