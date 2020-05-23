package repositories;

import managers.DatabaseConnectionManager;
import model.Employee;
import service.DatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class DBEmployeeRepository implements EmployeeRepository{

    @Override
    public void AddEmployee(Employee e) {
        String sql = "INSERT INTO employees VALUES (NULL,?, ?)";
        try {
            PreparedStatement statement =  DatabaseService.getStatament(sql);
            statement.setString(1,e.getName());
            statement.setFloat(2,e.getSalary());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Employee GetEmployeeById(Integer id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try{
            PreparedStatement statement = DatabaseService.getStatament(sql);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if(set.next()){
                Employee emp = new Employee();
                emp.setId(set.getInt("id"));
                emp.setSalary(set.getFloat("salary"));
                emp.setName(set.getString("name"));
                return emp;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Integer, Employee> getEmployees() {
        String sql = "SELECT * FROM employees";
        try{
            Map<Integer, Employee> mp = new HashMap<>();
            PreparedStatement statement = DatabaseService.getStatament(sql);
            ResultSet set = statement.executeQuery();
            while(set.next()){
                Employee emp = new Employee();
                emp.setId(set.getInt("id"));
                emp.setSalary(set.getFloat("salary"));
                emp.setName(set.getString("name"));
                mp.put(set.getInt("id"),emp);
            }
            return mp;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
