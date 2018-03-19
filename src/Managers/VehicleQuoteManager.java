package Managers;

import Conversions.ConvertDates;
import Insurance.PrimaryDriver;
import Insurance.Vehicle;
import Insurance.VehicleQuote;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class VehicleQuoteManager {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/comp_database?autoReconnect=true&useSSL=false";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public VehicleQuote createNewQuote(double basePremium, double tax, double total, Vehicle vehicle, PrimaryDriver primaryDriver){
        VehicleQuote quote = new VehicleQuote("", primaryDriver,null,null, basePremium, tax, total, vehicle,0);


        try {
            connection = DriverManager.getConnection(DATABASE_URL, "compUser", "compUser1");
            //InsertQuote
            statement = connection.createStatement();
            String query = "INSERT INTO VehicleQuotes(DateQuoted, QuoteExpired, BasePremium, Tax, Total)\n" +
                    "VALUES(CURDATE(), DATE_ADD(CURDATE(), INTERVAL 30 DAY), ?, ?, ?)";
            PreparedStatement prepState = connection.prepareStatement(query);
            prepState.setDouble(1, basePremium);
            prepState.setDouble(2, tax);
            prepState.setDouble(3, total);
            prepState.executeUpdate();
            //Get created quote
            query = "SELECT * FROM VehicleQuotes WHERE QuoteID = (SELECT MAX(QuoteID) FROM VehicleQuotes)";
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
            //TODO: Remove this print.
            System.out.print(quote.getQuoteID() + ","  + quote.getBasePremium()+ "," + quote.getTax() + "," + quote.getStartDate());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeConnections(statement, resultSet,connection);
        }
        return quote;
    }


    public VehicleQuote selectQuote(String quoteID, Vehicle vehicle, PrimaryDriver primaryDriver){
        VehicleQuote quote = new VehicleQuote("", primaryDriver,null,null, 0, 0, 0, vehicle,0);

        try {
            connection = DriverManager.getConnection(DATABASE_URL, "compUser", "compUser1");
            //InsertQuote
            statement = connection.createStatement();
            String query = "SELECT * FROM vehiclequotes WHERE QuoteID = ?";
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
            //TODO: Remove this print.
            System.out.print(quote.getQuoteID() + ","  + quote.getBasePremium()+ "," + quote.getTax());
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
