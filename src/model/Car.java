package model;

public class Car extends Vehicle {


    private String carPlate;

    public Car(String carPlt){
        carPlate = carPlt;
    }
    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }
    @Override
    public String toString(){
        return String.format(number +  ","  +  seats +  "," + fuelConsumption + "," + carPlate);
    }

}
