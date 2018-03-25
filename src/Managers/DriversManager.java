package Managers;

import Conversions.ConvertDates;
import Insurance.Driver;
import Insurance.PrimaryDriver;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class DriversManager {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/comp_database?autoReconnect=true&useSSL=false";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public PrimaryDriver createNewQuote(int userId, String firstName, String lastName, Date dateOfBirth, String address, String city,
                                        String province, String postalCode, String phoneNumber, String email, String gender,
                                        String driversLicenceNumber, Date licenseDateIssued, int locationCode) throws SQLException {

        PrimaryDriver driver = null;
        try {
            connection = java.sql.DriverManager.getConnection(DATABASE_URL, "compUser", "compUser1");
            //InsertQuote
            statement = connection.createStatement();
            String query = "INSERT INTO PrincipleDriver(UserID, FirstName, LastName, DOB, Address, City, Province, PostalCode, PhoneNumber, Email, Gender, DriversLicenseNumber, LicenseIssuedDate, LocationID)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?);";
            PreparedStatement prepState = connection.prepareStatement(query);
            prepState.setInt(1,userId);
            prepState.setString(2,firstName);
            prepState.setString(3,lastName);
            prepState.setDate(4, ConvertDates.convertToSqlDate(dateOfBirth));
            prepState.setString(5, address);
            prepState.setString(6, city);
            prepState.setString(7, province);
            prepState.setString(8, postalCode);
            prepState.setString(9, phoneNumber);
            prepState.setString(10, email);
            prepState.setString(11, gender);
            prepState.setString(12, driversLicenceNumber);
            prepState.setDate(13, ConvertDates.convertToSqlDate(licenseDateIssued));
            prepState.setInt(14,locationCode);
            prepState.executeUpdate();
            //create driver object

            driver = new PrimaryDriver(userId, firstName, lastName, dateOfBirth, address, city,
                    province, postalCode, phoneNumber, email, gender,
                    driversLicenceNumber, licenseDateIssued, locationCode);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeConnections(statement, resultSet,connection);
        }
        return driver;
    }

    private void closeConnections(Statement statement, ResultSet resultSet, Connection connection ){
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
