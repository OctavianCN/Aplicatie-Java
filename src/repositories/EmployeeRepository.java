package repositories;

import model.Employee;
import model.Pilot;

import java.io.File;
import java.util.Map;

public interface EmployeeRepository {
    void AddEmployee(Employee e);
    Employee GetEmployeeById(Integer id);
    Map<Integer, Employee> getEmployees();
    static EmployeeRepository build(Type type) {
        switch (type) {
            //case DB: return new DBUserRepository();
            case FILE: return new FileEmployeeRepository();
            case ARRAY:return new MapEmployeeRepository();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        DB, FILE, ARRAY
    }
}
