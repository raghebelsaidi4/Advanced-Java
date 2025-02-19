package com.ragheb.dao.api;

import java.util.List;

public interface GenericDao <T>{

    // C R U D

    // CREATE
    int insertItem(T item) throws DaoException;


    //READ
    List<T> getAllItems() throws DaoException;


    T getItemById(long id) throws DaoException;


    //UPDATE
    int updateItem(T item) throws DaoException;


    // DELETE
    int deleteItem(long id) throws DaoException;

}
