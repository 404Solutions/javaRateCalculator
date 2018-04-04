package Managers;

import Conversions.ConvertDates;
import Insurance.HomeOwner;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class HomeOwnerManager {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/comp_database?autoReconnect=true&useSSL=false";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public HomeOwner insertHomeOwner(int userId, String firstName, String lastName, String dateOfBirth, String address, String city,
                                           String province, String postalCode, String phoneNumber, String email, String gender) throws SQLException {

        HomeOwner homeOwner = null;
        try {
            connection = java.sql.DriverManager.getConnection(DATABASE_URL, "compUser", "compUser1");
            //InsertQuote
            statement = connection.createStatement();
            String query = "INSERT INTO HomeOwner(UserID, FirstName, LastName, DOB, Address, City, Province, PostalCode,  Email, Gender, PhoneNumber) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
            PreparedStatement prepState = connection.prepareStatement(query);
            prepState.setInt(1,userId);
            prepState.setString(2,firstName);
            prepState.setString(3,lastName);
            prepState.setDate(4, ConvertDates.convertStringToSqlDate(dateOfBirth));
            prepState.setString(5, address);
            prepState.setString(6, city);
            prepState.setString(7, province);
            prepState.setString(8, postalCode);
            prepState.setString(9, email);
            prepState.setString(10, gender);
            prepState.setString(11, phoneNumber);
            prepState.executeUpdate();
            //select object from db

            query = "SELECT * FROM HomeOwner WHERE QuoteID = (SELECT MAX(QuoteID) FROM HomeOwner)";
            PreparedStatement prep = connection.prepareStatement(query);
            resultSet = prep.executeQuery();
            resultSet.next();

            homeOwner = new HomeOwner(userId, firstName, lastName, ConvertDates.convertStringToUtilDate(dateOfBirth), address, city, province, postalCode, phoneNumber, email, gender);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeConnections(statement, resultSet,connection);
        }
        return homeOwner;
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
