package com.ragheb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "ragheb01276323608");
            //System.out.println("Connected to database");
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into student values(?,?,?)");
            preparedStatement.setInt(1, Integer.parseInt(args[0]));
            preparedStatement.setString(2, args[1]);
            preparedStatement.setInt(3, Integer.parseInt(args[2]));
            preparedStatement.executeUpdate();
            System.out.println("Student inserted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
