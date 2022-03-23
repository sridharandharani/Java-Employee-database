package com.harman.Employee;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Empdata {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("Select an option :");
            System.out.println("1 . Add an employee ");
            System.out.println("2 . view all employee ");
            System.out.println("3. search an employee ");
            System.out.println("4. update an employee ");
            System.out.println("5 . delete the employee ");
            System.out.println("6 . Exit");
            option = in.nextInt();
            switch (option){
                case 1 :
                    try {

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");
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
                    break;
                case 2 :
                    System.out.println("View all employees selected");
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `id`, `empcode`, `name`, `designation`, `salary`, `phone` FROM `employee` WHERE 1");
                        while (rs.next()){
                            System.out.println("name = " + rs.getString("name"));
                            System.out.println("empcode = "+ rs.getInt("empcode"));
                            System.out.println("designation = "+ rs.getString("designation"));
                            System.out.println("salary = " + rs.getInt("salary"));
                            System.out.println("phone = "+ rs.getBigDecimal("phone"));
                        }
                    }

                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3 :
                    try {
                        int empcode;
                        System.out.println("Enter the employee code to be searched ");
                        empcode = in.nextInt();

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `employee` WHERE `empcode`="+empcode);
                        while (rs.next()){
                            System.out.println("name = " + rs.getString("name"));
                            System.out.println("designation = "+ rs.getString("designation"));
                            System.out.println("salary = " + rs.getInt("salary"));
                            System.out.println("phone = "+ rs.getBigDecimal("phone"));

                        }


                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4 :
                    try {
                        int empcode;
                        System.out.println("Enter the empcode to update :");
                        empcode = in.nextInt();
                        String name, designation, salary, phone;
                        System.out.println("Enter the name :");
                        name = in.next();
                        System.out.println("Enter the designation :");
                        designation = in.next();
                        System.out.println("Enter the salary :");
                        salary = in.next();
                        System.out.println("Enter the phone :");
                        phone = in.next();

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("UPDATE `employee` SET `name`='"+name+"',`designation`='"+designation+"',`salary`="+salary+",`phone`="+phone+" WHERE `empcode` = "+empcode);
                        System.out.println("Updated sucessfully");

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;

                case 5 :try {
                    int empcode;
                    System.out.println("Enter the code to be deleted");
                    empcode = in.nextInt();
                    Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");
                    Statement stmt = c.createStatement();
                    stmt.executeUpdate("DELETE FROM `employee` WHERE `empcode`=" +empcode);
                    System.out.println("Deleted sucessfully");


                }
                catch (Exception e){
                    System.out.println(e);
                }
                break;
                case 6 :
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }



    }
}

