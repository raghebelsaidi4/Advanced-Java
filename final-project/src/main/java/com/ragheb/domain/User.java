package com.ragheb.domain;

import com.ragheb.enums.UserRole;

import java.util.Objects;

public class User {
    private long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userAddress;
    private boolean userBlocked;
    private UserRole userRole;

    public User() {
    }

    public User(String username, String userEmail, String userPassword, String userAddress, boolean userBlocked, UserRole userRole) {
        this.userName = username;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.userBlocked = userBlocked;
        this.userRole = userRole;
    }

    public User(long userId, String username, String userEmail, String userPassword, String userAddress, boolean userBlocked, UserRole userRole) {
        this.userId = userId;
        this.userName = username;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.userBlocked = userBlocked;
        this.userRole = userRole;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public boolean isUserBlocked() {
        return userBlocked;
    }

    public void setUserBlocked(boolean userBlocked) {
        this.userBlocked = userBlocked;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && userBlocked == user.userBlocked && Objects.equals(userName, user.userName) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userAddress, user.userAddress) && userRole == user.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userEmail, userPassword, userAddress, userBlocked, userRole);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userBlocked=" + userBlocked +
                ", userRole=" + userRole +
                '}';
    }
}
