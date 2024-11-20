package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost,String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        int currentYear = LocalDate.now().getYear();
        double value = getOriginalCost();
        int age = currentYear - year;

        if (age <= 3) {
            value -= value * (age * 0.03); // 3% reduction per year for the first 3 years
        } else if (age <= 6) {
            value -= value * (age * 0.06); // 6% reduction per year for years 4-6
        } else if (age <= 10) {
            value -= value * (age * 0.08); // 8% reduction per year for years 7-10
        } else {
            value -= 1000.0; // Flat reduction for ages greater than 10 years
        }

        if (odometer > 100000 && !makeModel.toLowerCase().contains("honda") && !makeModel.toLowerCase().contains("toyota")) {
            value -= value * 0.25;
        }
        return value;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "description='" + getDescription() + '\'' +
                ", dateAcquired='" + getDateAcquired() + '\'' +
                ", originalCost=" + getOriginalCost() +
                ", makeModel='" + makeModel + '\'' +
                ", year=" + year +
                ", odometer=" + odometer +
                ", value=" + getValue() +
                '}';
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
