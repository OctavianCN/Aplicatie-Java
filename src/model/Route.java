package model;

import java.util.ArrayList;
import java.util.List;

public class Route {

    private List<City> cities;
    private int id;
    private String name;
    private String date;

    public Route(){
        cities = new ArrayList<>();
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        String result;
        result = name + "," + id + "," + date + ",";
        for (int i=0;i<cities.size();i++){
            result = result + (cities.get(i)).toString() + ",";
        }
        //result = result + cities.get(cities.size()-1).toString();
        return String.format(result);
    }
}
