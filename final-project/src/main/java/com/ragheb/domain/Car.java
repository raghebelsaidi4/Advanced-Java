package com.ragheb.domain;

import java.util.Objects;

public class Car {
    private long carId;
    private String carModel;
    private String carReleaseYear;
    private String carColor;
    private String carCompany;
    //private int quantity;


    public Car() {}

    public Car(String carModel, String carReleaseYear, String carColor, String carCompany) {
        this.carModel = carModel;
        this.carReleaseYear = carReleaseYear;
        this.carColor = carColor;
        this.carCompany = carCompany;
    }

    public Car(long carId, String carModel, String carReleaseYear, String carColor, String carCompany, int quantity) {
        this.carId = carId;
        this.carModel = carModel;
        this.carReleaseYear = carReleaseYear;
        this.carColor = carColor;
        this.carCompany = carCompany;
    }


    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarReleaseYear() {
        return carReleaseYear;
    }

    public void setCarReleaseYear(String carReleaseYear) {
        this.carReleaseYear = carReleaseYear;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId && Objects.equals(carModel, car.carModel) && Objects.equals(carReleaseYear, car.carReleaseYear) && Objects.equals(carColor, car.carColor) && Objects.equals(carCompany, car.carCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, carModel, carReleaseYear, carColor, carCompany);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carModel='" + carModel + '\'' +
                ", carReleaseYear='" + carReleaseYear + '\'' +
                ", carColor='" + carColor + '\'' +
                ", carCompany='" + carCompany + '\'' +
                '}';
    }
}
