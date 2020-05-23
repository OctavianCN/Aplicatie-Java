package gui;

import model.Employee;
import model.Ticket;
import repositories.DBTicketRepository;
import service.AuditService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class TicketFrame extends JFrame {
    private JPanel panel1;
    private JTextField enterPriceTextField;
    private JTextField enterDateTextField;
    private JTextField enterVehicleNumberTextField;
    private JTextField enterSeatTextField;
    private JButton addButton;
    private JButton findTicketByCodeButton;
    private JTextField enterTicketByCodeTextField;
    private JLabel Code;
    private JLabel Price;
    private JLabel Date;
    private JLabel VehicleNumber;
    private JLabel Seat;
    private JTextField enterCode;
    private JPanel South;
    private JButton back;

    public TicketFrame(){
        DBTicketRepository dbTicketRepository = new DBTicketRepository();
        pack();
        setContentPane(panel1);
        setContentPane(South);
        AuditService auditService = AuditService.getInstance();
        auditService.writeAction("S-a intrat pe pagina bilete");
        setSize(750,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        back.addActionListener(new ActionListener() {
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
                    Ticket t = new Ticket();
                    t.setVehicleNumber(Integer.parseInt(enterVehicleNumberTextField.getText()));
                    t.setPrice(Float.parseFloat(enterPriceTextField.getText()));
                    t.setSeat(Integer.parseInt(enterSeatTextField.getText()));
                    t.setDate(enterDateTextField.getText());
                    t.setCode(enterCode.getText());
                    Optional<Ticket> test = dbTicketRepository.findTicketByCode(enterCode.getText());
                    if(test.isEmpty()){
                        dbTicketRepository.addTicket(t);
                        AuditService auditService = AuditService.getInstance();
                        auditService.writeAction("S-a adaugat un bilet");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Codul introdus deja exista!\n");
                        throw (new NumberFormatException());
                    }

                    JOptionPane.showMessageDialog(null, "Biletul a fost adaugat in baza de date!");

                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Date introduse gresit!");
                }
            }
        });
        findTicketByCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Integer.parseInt(enterTicketByCodeTextField.getText());
                    Optional<Ticket> ticket = dbTicketRepository.findTicketByCode(enterTicketByCodeTextField.getText());
                    Ticket t = ticket.get();
                    if(!ticket.isEmpty())

                        JOptionPane.showMessageDialog(null, t.toString());
                    else
                        JOptionPane.showMessageDialog(null, "Biletul cu id-ul " + enterTicketByCodeTextField.getText() + " nu a fost gasit!");
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Eroare la gasirea biletului!");
                }
            }
        });
    }
}
