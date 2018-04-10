package Managers;

import Conversions.ConvertDates;
import Insurance.HomeOwner;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

/**
 * HomeOwnerManager that managers all the database connections and queries related to a homeOwner object.
 */
public class HomeOwnerManager {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/comp_database?autoReconnect=true&useSSL=false";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    /**
     * insertHomeOwner inserts a new homeowner object to the the database
     * @param userId int
     * @param firstName string
     * @param lastName string
     * @param dateOfBirth string
     * @param address string
     * @param city string
     * @param province string
     * @param postalCode string
     * @param phoneNumber string
     * @param email string
     * @param gender string
     * @return
     */
    public HomeOwner insertHomeOwner(int userId, String firstName, String lastName, String dateOfBirth, String address, String city,
                                           String province, String postalCode, String phoneNumber, String email, String gender){

        HomeOwner homeOwner = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
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

            homeOwner = new HomeOwner(userId, firstName, lastName, ConvertDates.convertStringToUtilDate(dateOfBirth), address, city, province, postalCode, phoneNumber, email, gender);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnectionsNoResult(statement,connection);
        }
        return homeOwner;
    }

    /**
     * selectHomeOwner selects a homeOwner from the database based on their userID
     * @param userID int
     * @return HomeOwner
     */
    public HomeOwner selectHomeOwner(int userID){
        HomeOwner homeOwner = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, "compUser", "compUser1");
            //InsertQuote
            statement = connection.createStatement();
            String query = "SELECT * FROM HomeOwner WHERE UserID = ?";
            PreparedStatement prepState = connection.prepareStatement(query);
            prepState.setInt(1, userID);
            //execute query
            resultSet = prepState.executeQuery();
            resultSet.next();

            homeOwner = new HomeOwner(resultSet.getInt("UserID"), resultSet.getString("FirstName"),
                    resultSet.getString("LastName"), ConvertDates.convertToSqlDate(resultSet.getDate("DOB")),
                    resultSet.getString("Address"), resultSet.getString("City"), resultSet.getString("Province"),
                    resultSet.getString("PostalCode"), resultSet.getString("PhoneNumber"),
                    resultSet.getString("Email"), resultSet.getString("Gender"));

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnections(statement, resultSet,connection);
        }
        return homeOwner;
    }

    /**
     * updateHomeOwner updates a homeOwner in the database by their userID and returns the homeOwner object
     * @param userId int
     * @param firstName String
     * @param lastName String
     * @param dateOfBirth String
     * @param address String
     * @param city String
     * @param province String
     * @param postalCode String
     * @param phoneNumber String
     * @param email String
     * @param gender string
     * @return HomeOwner
     */
    public HomeOwner updateHomeOwner(int userId, String firstName, String lastName, String dateOfBirth, String address, String city,
                                          String province, String postalCode, String phoneNumber, String email, String gender){
        HomeOwner homeOwner = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, "compUser", "compUser1");
            //InsertQuote
            statement = connection.createStatement();
            String query =" UPDATE PrincipleDriver SET FirstName = ?, LastName = ?, DOB = ?, Address = ?, City = ?, Province = ?, PostalCode = ?,  Email = ?, Gender = ?  WHERE UserID = ?";
            PreparedStatement prepState = connection.prepareStatement(query);
            prepState.setString(1,firstName);
            prepState.setString(2,lastName);
            prepState.setDate(3, ConvertDates.convertStringToSqlDate(dateOfBirth));
            prepState.setString(4, address);
            prepState.setString(5, city);
            prepState.setString(6, province);
            prepState.setString(7, postalCode);
            prepState.setString(8, email);
            prepState.setString(9, gender);
            prepState.setString(10, phoneNumber);
            prepState.executeUpdate();

            homeOwner = new HomeOwner(userId, firstName, lastName, ConvertDates.convertStringToUtilDate(dateOfBirth), address,
            city, province, postalCode, phoneNumber, email, gender);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnectionsNoResult(statement,connection);
        }
        return homeOwner;
    }
    /**
     * Fucntion that closes the connection to the database, a result set and a statement
     * @param statement statement
     * @param resultSet resultSet
     * @param connection connection
     */
    private void closeConnections(Statement statement, ResultSet resultSet, Connection connection ){
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    /**
     * Fucntion that closes the connection to the database and a statement
     * @param statement statement
     * @param connection connection
     */
    private void closeConnectionsNoResult(Statement statement, Connection connection ){
        try {

            statement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
