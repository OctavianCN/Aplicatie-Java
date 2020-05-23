package gui;

import model.Employee;
import repositories.DBEmployeeRepository;
import service.AuditService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class EmployeesFrame extends JFrame {
    private JPanel panel1;
    private JPanel South;
    private JLabel Name;
    private JLabel Salary;
    private JTextField enterName;
    private JTextField enterSalary;
    private JButton addButton;
    private JButton findEmployeeButton;
    private JTextField enterID;
    private JButton getAllEmployeesButton;
    private JButton backButton;


    public EmployeesFrame(){
        DBEmployeeRepository dbEmployeeRepository = new DBEmployeeRepository();
        AuditService auditService = AuditService.getInstance();
        auditService.writeAction("S-a intrat pe pagina employees");
        pack();
        setContentPane(panel1);
        setContentPane(South);

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
                    Float.parseFloat(enterSalary.getText());
                    Employee emp = new Employee();
                    emp.setName(enterName.getText());
                    emp.setSalary(Float.parseFloat(enterSalary.getText()));
                    dbEmployeeRepository.AddEmployee(emp);
                    JOptionPane.showMessageDialog(null, enterName.getText()+" a fost adaugat in baza de date!");
                    AuditService auditService = AuditService.getInstance();
                    auditService.writeAction("S-a adaugat un angajat");

                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Trebuie sa introduci un numar la salariu!");
                }
            }
        });
        findEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Integer.parseInt(enterID.getText());
                    Employee emp = dbEmployeeRepository.GetEmployeeById(Integer.parseInt(enterID.getText()));
                    if(emp != null)
                        JOptionPane.showMessageDialog(null, emp.toString());
                    else
                        JOptionPane.showMessageDialog(null, "Angajatul cu id-ul " + enterID.getText() + " nu a fost gasit!");
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Trebuie sa introduci un numar intreg pentru id!");
                }
            }
        });
        getAllEmployeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<Integer, Employee> employees = dbEmployeeRepository.getEmployees();
                String string = "";
                for(Integer key: employees.keySet()){
                    string = string + key +","+ employees.get(key).toString() + "\n";
                }
                JTextArea textArea = new JTextArea(string, 10,  10);
                JScrollPane sp = new JScrollPane(textArea);
                sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                JOptionPane.showMessageDialog(null, sp);
            }
        });
    }

}
