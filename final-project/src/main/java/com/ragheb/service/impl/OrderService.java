package com.ragheb.service.impl;

import com.ragheb.dao.api.DaoException;
import com.ragheb.dao.impl.OrderDao;
import com.ragheb.domain.Order;
import com.ragheb.service.api.GenericService;
import com.ragheb.service.api.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * OrderService handles business logic related to Orders.
 */
public class OrderService implements GenericService<Order> {
    private static final Logger LOGGER = LogManager.getLogger(OrderService.class);

    private final OrderDao orderDao;

    /**
     * Constructor for OrderService.
     *
     * @param orderDao the DAO for accessing Order data
     */
    public OrderService(final OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public int insertItem(final Order order) throws ServiceException {
        try {
            return orderDao.insertItem(order);
        } catch (DaoException e) {
            LOGGER.error("Unable to insert order in OrderService", e);
            throw new ServiceException("Unable to insert order in OrderService", e);
        }
    }

    @Override
    public List<Order> getAllItems() throws ServiceException {
        try {
            return orderDao.getAllItems();
        } catch (DaoException e) {
            LOGGER.error("Unable to retrieve all orders in OrderService", e);
            throw new ServiceException("Unable to retrieve all orders in OrderService", e);
        }
    }

    @Override
    public Order getItemById(final long id) throws ServiceException {
        try {
            return orderDao.getItemById(id);
        } catch (DaoException e) {
            LOGGER.error("Unable to retrieve order by ID in OrderService", e);
            throw new ServiceException("Unable to retrieve order by ID in OrderService", e);
        }
    }

    @Override
    public int updateItem(final Order order) throws ServiceException {
        try {
            return orderDao.updateItem(order);
        } catch (DaoException e) {
            LOGGER.error("Unable to update order in OrderService", e);
            throw new ServiceException("Unable to update order in OrderService", e);
        }
    }

    @Override
    public int deleteItem(final long id) throws ServiceException {
        try {
            return orderDao.deleteItem(id);
        } catch (DaoException e) {
            LOGGER.error("Unable to delete order in OrderService", e);
            throw new ServiceException("Unable to delete order in OrderService", e);
        }
    }
}
