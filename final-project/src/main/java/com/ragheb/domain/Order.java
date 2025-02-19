package com.ragheb.domain;

import java.util.Date;
import java.util.Objects;

public class Order {
    private long orderId;
    private long userId;
    private long carId;
    private Date orderDate;
    private Date returnDate;
    private boolean carReturned;
    private double rentalCost;


    public Order(long userId, long carId, Date orderDate, Date returnDate, double rentalCost) {
        this.userId = userId;
        this.carId = carId;
        this.orderDate = orderDate;
        this.returnDate = returnDate;
        this.rentalCost = rentalCost;
    }

    public Order(long orderId, long userId, long carId, Date orderDate, Date returnDate, boolean carReturned, double rentalCost) {
        this.orderId = orderId;
        this.userId = userId;
        this.carId = carId;
        this.orderDate = orderDate;
        this.returnDate = returnDate;
        this.carReturned = carReturned;
        this.rentalCost = rentalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && userId == order.userId && carId == order.carId && carReturned == order.carReturned && Objects.equals(orderDate, order.orderDate) && Objects.equals(returnDate, order.returnDate) && Objects.equals(rentalCost, order.rentalCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, carId, orderDate, returnDate, carReturned, rentalCost);
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isCarReturned() {
        return carReturned;
    }

    public void setCarReturned(boolean carReturned) {
        this.carReturned = carReturned;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", carId=" + carId +
                ", orderDate=" + orderDate +
                ", returnDate=" + returnDate +
                ", carReturned=" + carReturned +
                ", rentalCost=" + rentalCost +
                '}';
    }
}
