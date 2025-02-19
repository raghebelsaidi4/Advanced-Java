package com.ragheb.dao.impl;

import com.ragheb.dao.api.AbstractDao;
import com.ragheb.dao.api.DaoException;
import com.ragheb.domain.Car;
import com.ragheb.mapper.impl.CarMapper;
import com.ragheb.util.contanst.CarConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class CarDao extends AbstractDao<Car> {

    private static final Logger LOGGER = LogManager.getLogger(CarDao.class);

    public CarDao() {}

    public CarDao(Connection connection) {
        super(connection);
    }

    @Override
    public int insertItem(Car item) throws DaoException {
        return executeUpdate(
                CarConstant.INSERT_CAR,
                item.getCarModel(),
                item.getCarReleaseYear(),
                item.getCarColor(),
                item.getCarCompany()
        );
    }

    @Override
    public List<Car> getAllItems() throws DaoException {
        return queryForObjects(CarConstant.SELECT_ALL_CARS, new CarMapper());
    }

    @Override
    public Car getItemById(long id) throws DaoException {
        return queryForObject(CarConstant.SELECT_CAR_BY_ID, new CarMapper(), String.valueOf(id));
    }

    @Override
    public int updateItem(Car item) throws DaoException {
        return executeUpdate(
                CarConstant.UPDATE_CAR,
                item.getCarModel(),
                item.getCarReleaseYear(),
                item.getCarColor(),
                item.getCarCompany(),
                String.valueOf(item.getCarId())
        );
    }

    @Override
    public int deleteItem(long id) throws DaoException {
        return executeUpdate(CarConstant.DELETE_CAR_BY_ID, String.valueOf(id));
    }
}
