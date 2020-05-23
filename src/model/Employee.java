package model;

public class Employee {

    protected String name;
    protected int id;
    protected float salary;

    public Employee(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return String.format(name +  ","  +  id +  "," + salary);
    }
}
