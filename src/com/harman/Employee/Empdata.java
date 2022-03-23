package com.harman.Employee;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Empdata {
    public static void main(String[] args) {
        try {

            Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");
            Scanner in = new Scanner(System.in);
            String empcode, name, designation, salary, phone;
            System.out.println("Enter the code :");
            empcode = in.next();
            System.out.println("Enter the name :");
            name = in.next();
            System.out.println("Enter the designation :");
            designation = in.next();
            System.out.println("Enter the salary :");
            salary = in.next();
            System.out.println("Enter the phone :");
            phone = in.next();
            Statement stmt = c.createStatement();
            stmt.executeUpdate("INSERT INTO `employee`( `empcode`, `name`, `designation`, `salary`, `phone`)" +
                    " VALUES('" + empcode + "','" + name + "','" + designation + "'," + salary + "," + phone + ")");
            System.out.println("Inserted sucessfully");
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}

