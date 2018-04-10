package Managers;

import Insurance.Home;

import java.sql.*;

/**
 * HomeManager that manages all related database connections and queries related to a Home object.
 */
public class HomeManager {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/comp_database?autoReconnect=true&useSSL=false";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    /**
     * insertHome is an function that inserts a home into the database as a row and returns an object
     * @param value double
     * @param yearBuilt int
     * @param homeType int
     * @param heatingType int
     * @param postalCode String
     * @param address String
     * @param city String
     * @param province String
     * @return Home
     */
    public Home insertHome(double value, int yearBuilt, int homeType, int heatingType, String postalCode, String address, String city, String province) {

        Home home = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection(DATABASE_URL, "compUser", "compUser1");
            //InsertQuote
            statement = connection.createStatement();
            String query = "INSERT INTO Home(YearBuilt, HomeTypeID, HeatingTypeID, Value, Address, City, Province, PostalCode)\n" +
                    "Values(?,?,?,?,?,?,?,?);;";
            PreparedStatement prepState = connection.prepareStatement(query);
            prepState.setInt(1,yearBuilt);
            prepState.setInt(2,homeType);
            prepState.setInt(3,heatingType);
            prepState.setDouble(4, value);
            prepState.setString(5, address);
            prepState.setString(6, city);
            prepState.setString(7, province);
            prepState.setString(8, postalCode);
            prepState.executeUpdate();
            //create driver object

            query = "SELECT * FROM Home WHERE HomeID = (SELECT MAX(HomeID) FROM Home)";
            PreparedStatement prep = connection.prepareStatement(query);
            resultSet = prep.executeQuery();
            resultSet.next();
            home = new Home(resultSet.getInt("HomeID"), value, yearBuilt, homeType, heatingType, postalCode, address, city, province);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnections(statement, resultSet,connection);
        }
        return home;
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
}
