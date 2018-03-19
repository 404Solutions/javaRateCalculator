package Managers;

import Conversions.ConvertDates;
import Insurance.Home;
import Insurance.HomeOwner;
import Insurance.HomeQuote;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class HomeQuoteManager {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/comp_database?autoReconnect=true&useSSL=false";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    /**
     * createNewQuote takes in all variables that are needed to generate a quote, inserts it to the database,
     * gets the generated ID of the homeQuote, and returns the quote as an object.
     * @param basePremium
     * @param tax
     * @param total
     * @param home
     * @param homeOwner
     * @return
     * @throws SQLException
     */
    public HomeQuote createNewQuote(double basePremium, double tax, double total, Home home, HomeOwner homeOwner) throws SQLException {
        HomeQuote quote =  new HomeQuote("", homeOwner, null, null, basePremium, tax, total, home, home.getValue(), 0,0, 0);
        try {
            connection = DriverManager.getConnection(DATABASE_URL, "compUser", "compUser1");
            //InsertQuote
            statement = connection.createStatement();
            String query = "INSERT INTO HomeQuotes(DateQuoted, QuoteExpired, BasePremium, Tax, Total)\n" +
                    "VALUES(CURDATE(), DATE_ADD(CURDATE(), INTERVAL 30 DAY), ?, ?, ?)";
            PreparedStatement prepState = connection.prepareStatement(query);
            prepState.setDouble(1, basePremium);
            prepState.setDouble(2, tax);
            prepState.setDouble(3, total);
            prepState.executeUpdate();
            //Get created quote
            query = "SELECT * FROM homequotes WHERE QuoteID = (SELECT MAX(QuoteID) FROM HomeQuotes)";
            PreparedStatement prep = connection.prepareStatement(query);
            resultSet = prep.executeQuery();
            resultSet.next();
            quote.setQuoteID(resultSet.getString("QuoteID"));
            quote.setBasePremium(resultSet.getDouble("BasePremium"));
            quote.setTax(resultSet.getDouble("Tax"));
            quote.setTotal(resultSet.getDouble("Total"));
            ConvertDates convertDates = new ConvertDates();
            quote.setStartDate(convertDates.convertToUtilDate(resultSet.getDate("DateQuoted")));
            quote.setEndDate(convertDates.convertToUtilDate(resultSet.getDate("QuoteExpired")));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeConnections(statement, resultSet,connection);
        }
        return quote;
    }

    /**
     * selectHomeQuote selects a homequote based on the quoteID and returns a HomeQuote object.
     * @param quoteID
     * @param home
     * @param homeOwner
     * @return
     */
    public HomeQuote selectQuote(String quoteID, Home home, HomeOwner homeOwner){
        HomeQuote quote =  new HomeQuote("", homeOwner, null, null, 0, 0, 0, home, 1234, 2121,4322, 534);

        try {
            connection = DriverManager.getConnection(DATABASE_URL, "compUser", "compUser1");
            //InsertQuote
            statement = connection.createStatement();
            String query = "SELECT * FROM homequotes WHERE QuoteID = ?";
            PreparedStatement prepState = connection.prepareStatement(query);
            prepState.setString(1, quoteID);
            //execute query
            resultSet = prepState.executeQuery();
            resultSet.next();
            //populate quote
            quote.setQuoteID(resultSet.getString("QuoteID"));
            quote.setBasePremium(resultSet.getDouble("BasePremium"));
            quote.setTax(resultSet.getDouble("Tax"));
            quote.setTotal(resultSet.getDouble("Total"));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeConnections(statement, resultSet,connection);
        }
      return quote;
    }

    /**
     * closeConnections servers as a function to close all connections to the database.
     * @param statement
     * @param resultSet
     * @param connection
     */
    public void closeConnections(Statement statement, ResultSet resultSet, Connection connection ){
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
