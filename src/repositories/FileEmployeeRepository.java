package repositories;

import exceptions.InexistentRouteIdException;
import model.Employee;
import service.AuditService;
import service.FileService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FileEmployeeRepository implements EmployeeRepository{

    private final String filePath = "Employees";

    @Override
    public void AddEmployee(Employee e) {
        FileService service = FileService.getInstance();
        AuditService auditService = AuditService.getInstance();
        String employeeData = e.toString();
        auditService.writeAction("S-a adaugat un angajat in fisierul " + filePath);
        service.writeFile(filePath,employeeData);
    }

    @Override
    public Employee GetEmployeeById(Integer id) {
        FileService service = FileService.getInstance();
        Employee employee = null;

        try{
            List<String> employeeList = service.getFile(filePath);
            for (String u : employeeList) {
                String [] attr = u.split(",");
                if (attr[1].equals(id.toString())) {
                    employee = new Employee();
                    employee.setId(Integer.parseInt(attr[1]));
                    employee.setName(attr[0]);
                    employee.setSalary(Float.parseFloat(attr[2]));
                    break;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public Map<Integer, Employee> getEmployees() {
        FileService service = FileService.getInstance();
        Map<Integer, Employee> employees = null;
        List<String> employeeList = service.getFile(filePath);
        try{
            employees = new HashMap<>();
            for (String u : employeeList) {
                String [] attr = u.split(",");
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(attr[1]));
                employee.setName(attr[0]);
                employee.setSalary(Float.parseFloat(attr[2]));
                System.out.print(employee.toString());
                employees.put(Integer.parseInt(attr[1]),employee);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return  employees;
    }



}
