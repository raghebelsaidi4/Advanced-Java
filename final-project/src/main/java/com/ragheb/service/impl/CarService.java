package com.ragheb.service.impl;

import com.ragheb.dao.api.DaoException;
import com.ragheb.dao.impl.CarDao;
import com.ragheb.domain.Car;
import com.ragheb.service.api.GenericService;
import com.ragheb.service.api.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CarService implements GenericService<Car> {

    private static final Logger LOGGER = LogManager.getLogger(CarService.class);
    private final CarDao carDao;

    /**
     * Constructor for CarService.
     *
     * @param carDao the DAO for accessing Car data
     */
    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public int insertItem(Car car) throws ServiceException {
        try {
            return carDao.insertItem(car);
        } catch (DaoException e) {
            LOGGER.error("Unable to insert car in CarService", e);
            throw new ServiceException("Unable to insert car in CarService", e);
        }
    }

    @Override
    public List<Car> getAllItems() throws ServiceException {
        try {
            return carDao.getAllItems();
        } catch (DaoException e) {
            LOGGER.error("Unable to retrieve all cars in CarService", e);
            throw new ServiceException("Unable to retrieve all cars in CarService", e);
        }
    }

    @Override
    public Car getItemById(long id) throws ServiceException {
        try {
            return carDao.getItemById(id);
        } catch (DaoException e) {
            LOGGER.error("Unable to retrieve car by ID in CarService", e);
            throw new ServiceException("Unable to retrieve car by ID in CarService", e);
        }
    }

    @Override
    public int updateItem(Car car) throws ServiceException {
        try {
            return carDao.updateItem(car);
        } catch (DaoException e) {
            LOGGER.error("Unable to update car in CarService", e);
            throw new ServiceException("Unable to update car in CarService", e);
        }
    }

    @Override
    public int deleteItem(long id) throws ServiceException {
        try {
            return carDao.deleteItem(id);
        } catch (DaoException e) {
            LOGGER.error("Unable to delete car in CarService", e);
            throw new ServiceException("Unable to delete car in CarService", e);
        }
    }
}
