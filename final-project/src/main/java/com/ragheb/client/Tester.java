//package com.ragheb.client;
//
//import com.ragheb.config.DBConnection;
//import com.ragheb.dao.api.DaoException;
//import com.ragheb.dao.impl.CarDao;
//import com.ragheb.domain.Car;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//public class Tester {
//    public static void main(String[] args) throws DaoException {
//
//        // 1. Initialize DB Connection
//        DBConnection dbConnection = new DBConnection();
//        try (Connection connection = dbConnection.getConnection()) {
//            if (connection == null) {
//                System.err.println("Failed to establish database connection!");
//                return;
//            }
//
//            // 2. Initialize DAO
//            CarDao carDao = new CarDao(connection);
//
//            // 3. Test Car Dao
//            //testInsert(carDao);
//            testGetAll(carDao);
//            //testUpdateDelete(carDao);
//
//        } catch (SQLException e) {
//            System.err.println("Database error: " + e.getMessage());
//        } catch (Exception e) {
//            System.err.println("General error: " + e.getMessage());
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private static void testInsert(CarDao carDao) throws Exception {
//        Car newCar = new Car();
//        newCar.setCarModel("Model 3");
//        newCar.setCarReleaseYear("2023");
//        newCar.setCarColor("White");
//        newCar.setCarCompany("Tesla");
//
//        int result = carDao.insertItem(newCar);
//        System.out.println("Inserted rows: " + result);
//    }
//
//    private static void testGetAll(CarDao carDao) throws Exception {
//        List<Car> cars = carDao.getAllItems();
//        System.out.println("\nAll Cars:");
//        cars.forEach(System.out::println);
//    }
//
//    private static void testUpdateDelete(CarDao carDao) throws Exception {
//        List<Car> cars = carDao.getAllItems();
//        if (!cars.isEmpty()) {
//            long testId = cars.get(0).getCarId();
//            // Test Update
//            //Car toUpdate = cars.get(
////            int updateResult = carDao.updateItem(toUpdate);
////            System.out.println("\nUpdated rows: " + updateResult);
////
////            // Test Delete
////            int deleteResult = carDao.deleteItem(testId);
////            System.out.println("Deleted rows: " + deleteResult);
//        }
//    }
//}
