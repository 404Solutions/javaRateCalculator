package Managers;

import insurance.Home;
import insurance.HomeOwner;
import insurance.HomeQuote;
import insurance.Quote;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import java.sql.*;

public class HomeQuoteManager {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/comp_database?autoReconnect=true&useSSL=false";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public HomeQuote createNewQuote(double basePremium, double tax, double total, Home home, HomeOwner homeOwner) throws SQLException {
        HomeQuote quote =  new HomeQuote("", homeOwner, "", "", basePremium, tax, total, home, 1234, 2121,4322, 534);
        try {
            connection = DriverManager.getConnection(DATABASE_URL, "compUser", "compUser1");
            statement = connection.createStatement();
            String query = "INSERT INTO HomeQuotes(DateQuoted, QuoteExpired, BasePremium, Tax, Total)\n" +
                    "VALUES(CURDATE(), DATE_ADD(CURDATE(), INTERVAL 30 DAY), ?, ?, ?)";
            PreparedStatement prepState = connection.prepareStatement(query);
            prepState.setDouble(1, basePremium);
            prepState.setDouble(2, tax);
            prepState.setDouble(3, total);

            prepState.executeUpdate();

            query = "SELECT MAX(QuoteID) AS QuoteID FROM HomeQuotes";
            PreparedStatement prep = connection.prepareStatement(query);
            resultSet = prep.executeQuery();
            resultSet.next();
            System.out.print(resultSet.getString("QuoteID"));


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                resultSet.close();
                //statement.close();
                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return quote;
    }


}
