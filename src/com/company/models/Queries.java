package com.company.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Queries {

    final String DB_URL = "jdbc:mysql://localhost:3306/titanicmanifest";
    final String DB_USER = "Julio";
    final String DB_PASSWORD = "gurthang.1";

    private PreparedStatement getPeopleByName;
    private PreparedStatement getPeopleByGender;
    private PreparedStatement getPeopleByAge;
    private PreparedStatement getPeopleByNameGender;

    public Queries() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //select by name
            String sqlNameQuery = "SELECT name, gender, age FROM titanic WHERE name LIKE ?";
            getPeopleByName = con.prepareStatement(sqlNameQuery);

            //select by gender
            String sqlGenderQuery = "SELECT name, gender, age FROM titanic WHERE gender LIKE ?";
            getPeopleByGender = con.prepareStatement(sqlGenderQuery);

            //select by age
            String sqlAgeQuery = "SELECT name, gender, age FROM titanic WHERE age LIKE ?";
            getPeopleByAge = con.prepareStatement(sqlAgeQuery);

            //select by name and gender
            String sqlNameGenderQuery = "SELECT name, gender, age FROM titanic WHERE name LIKE ? AND gender LIKE ?";
            getPeopleByNameGender = con.prepareStatement(sqlNameGenderQuery);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Passenger> getPassengerByName(String name) {
        try {
            List<Passenger> results = new ArrayList<>();
            getPeopleByName.setString(1, "%"+name+"%");
            ResultSet rs = getPeopleByName.executeQuery();

            while (rs.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = rs.getString("name");
                newPassenger.gender = rs.getString("gender");
                newPassenger.age = rs.getString("age");
                results.add(newPassenger);
            }

            return results;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Passenger> getPassengerByGender(String gender) {
        try {
            List<Passenger> results = new ArrayList<>();
            getPeopleByGender.setString(1, gender);
            ResultSet rs = getPeopleByGender.executeQuery();

            while (rs.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = rs.getString("name");
                newPassenger.gender = rs.getString("gender");
                newPassenger.age = rs.getString("age");
                results.add(newPassenger);
            }

            return results;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Passenger> getPassengerByAge(String age) {
        try {
            List<Passenger> results = new ArrayList<>();
            getPeopleByAge.setString(1, age);
            ResultSet rs = getPeopleByAge.executeQuery();

            while (rs.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = rs.getString("name");
                newPassenger.gender = rs.getString("gender");
                newPassenger.age = rs.getString("age");
                results.add(newPassenger);
            }

            return results;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Passenger> getPassengerByNameGender(String name, String gender) {
        try {
            List<Passenger> results = new ArrayList<>();
            getPeopleByNameGender.setString(1, "%"+name+"%");
            getPeopleByNameGender.setString(2, gender);
            ResultSet rs = getPeopleByNameGender.executeQuery();

            while (rs.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = rs.getString("name");
                newPassenger.gender = rs.getString("gender");
                newPassenger.age = rs.getString("age");
                results.add(newPassenger);
            }

            return results;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
