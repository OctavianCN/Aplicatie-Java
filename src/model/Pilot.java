package model;

public class Pilot extends Employee {

    private int certificateNumber;
    private int healthTestScore;
    private int bonus;

    public Pilot(int nr,int hts, int bon){
        certificateNumber = nr;
        healthTestScore = hts;
        bonus = bon;
    }
    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(int certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public int getHealthTestScore() {
        return healthTestScore;
    }

    public void setHealthTestScore(int healthTestScore) {
        this.healthTestScore = healthTestScore;
    }
    @Override
    public String toString(){
        return String.format(name +  ","  +  id +  "," + salary + "," + certificateNumber + "," + healthTestScore + "," + bonus);
    }
}

