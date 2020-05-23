package service;

import model.Employee;
import repositories.MapEmployeeRepository;

import java.util.*;

public class EmployeeSalaryService {

    private MapEmployeeRepository employeeRepository;

    public  EmployeeSalaryService(MapEmployeeRepository empR){
        employeeRepository = empR;
    }

    public void GetAllEmployeesSortedBySalary(){
        Map<Integer, Employee> employees = employeeRepository.getEmployees();
        List<Employee> employeeList = new ArrayList<>();
        for(Integer key: employees.keySet()){
            employeeList.add(employees.get(key));
        }
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.getSalary() > o2.getSalary())
                    return 1;
                return -1;
            }
        });
        for(Employee e:employeeList){
            System.out.print(e);
            System.out.print("\n");
        }
    }
}
