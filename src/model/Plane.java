package model;

public class Plane extends Vehicle {

    private int registrationNumber;
    private int numberOfOxigenMasks;
    private int numberOfParachutes;

    public  Plane(int registrationNr, int nrOfOxigenMasks, int nrOfParachutes){
        registrationNumber = registrationNr;
        numberOfOxigenMasks = nrOfOxigenMasks;
        numberOfParachutes = nrOfParachutes;
    }
    public int getNumberOfOxigenMasks() {
        return numberOfOxigenMasks;
    }

    public void setNumberOfOxigenMasks(int numberOfOxigenMasks) {
        this.numberOfOxigenMasks = numberOfOxigenMasks;
    }

    public int getNumberOfParachutes() {
        return numberOfParachutes;
    }

    public void setNumberOfParachutes(int numberOfParachutes) {
        this.numberOfParachutes = numberOfParachutes;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    @Override
    public String toString(){
        return String.format(number +  ","  +  seats +  "," + fuelConsumption + "," + registrationNumber + "," + numberOfOxigenMasks + "," + numberOfParachutes);
    }
}
