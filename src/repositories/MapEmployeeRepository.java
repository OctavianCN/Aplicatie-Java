package repositories;

import exceptions.InexistentRouteIdException;
import model.Employee;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapEmployeeRepository implements EmployeeRepository {

    private Map<Integer, Employee> employees;

    public MapEmployeeRepository(){

        employees = new HashMap<>();
    }

    @Override
    public void AddEmployee(Employee e){

        employees.put(e.getId(),e);
    }

    @Override
    public Employee GetEmployeeById(Integer id){

        Employee employee = null;

        try{
            if(employees.get(id).equals(null)){
                throw new InexistentRouteIdException();
            }
            employee = employees.get(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public Map<Integer, Employee> getEmployees() {
        return employees;
    }
}
