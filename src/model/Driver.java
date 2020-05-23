package model;



public class Driver extends Employee {

    private String driverLicence;
    private int mealVouchers;

    public Driver(String licence, int vouchers){
        driverLicence = licence;
        mealVouchers = vouchers;
    }
    public int getMealVouchers() {
        return mealVouchers;
    }

    public void setMealVouchers(int mealVouchers) {
        this.mealVouchers = mealVouchers;
    }

    public String getDriverLicence() {
        return driverLicence;
    }

    public void setDriverLicence(String driverLicence) {
        this.driverLicence = driverLicence;
    }

    @Override
    public String toString(){
        return String.format(name +  ","  +  id +  "," + salary + "," + driverLicence + "," + mealVouchers);
    }

}
