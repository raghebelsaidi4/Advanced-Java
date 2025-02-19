package com.ragheb.mapper.impl;

import com.ragheb.domain.Car;
import com.ragheb.mapper.GenericMapper;
import com.ragheb.util.contanst.CarConstant;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements GenericMapper<Car> {

    @Override
    public Car rowMapper(ResultSet resultSet) throws SQLException {
        long carId = resultSet.getLong(CarConstant.TABLE_CAR_ID);
        String carModel = resultSet.getString(CarConstant.TABLE_CAR_MODEL);
        String carReleaseYear = resultSet.getString(CarConstant.TABLE_CAR_RELEASE_YEAR);
        String carColor = resultSet.getString(CarConstant.TABLE_CAR_COLOR);
        String carCompany = resultSet.getString(CarConstant.TABLE_CAR_COMPANY);
        int quantity = resultSet.getInt(CarConstant.TABLE_CAR_QUANTITY);

        return new Car(carId, carModel, carReleaseYear, carColor, carCompany, quantity);
    }
}
