package model;

public class Vehicle {

    protected float fuelConsumption;
    protected int seats;
    protected int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    @Override
    public String toString(){
        return String.format(number +  ","  +  seats +  "," + fuelConsumption);
    }
}
