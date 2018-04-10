package Managers;

import Conversions.ConvertDates;
import Insurance.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * ProfileSelect that manages the connection to the database and selections of
 */
public class ProfileSelect {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/comp_database?autoReconnect=true&useSSL=false";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    /**
     * selects an entire profile based on a user id and returns all as objects in an ArrayList<object>
     * @param userId int
     * @return arrayList<Object>
     */
    public ArrayList<Object> select(int userId){
        ArrayList<Object> list = new ArrayList<>();

        DriversManager driversManager = new DriversManager();
        PrimaryDriver primaryDriver = driversManager.selectPrimaryDriver(userId);
        list.add(primaryDriver);

        HomeOwnerManager homeOwnerManager =  new HomeOwnerManager();
        HomeOwner homeOwner = homeOwnerManager.selectHomeOwner(userId);
        list.add(homeOwner);


        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection(DATABASE_URL, "compUser", "compUser1");
            //InsertQuote
            statement = connection.createStatement();
            String query = "SELECT * FROM HomeQuotes hq\n" +
                    "JOIN Home h ON h.HomeID = hq.HomeID\n" +
                    "LEFT JOIN HomePolicy hp ON hp.QuoteID = hq.QuoteID\n" +
                    "WHERE hq.UserID = ? ORDER BY hq.DateQuoted DESC LIMIT 1;";
            PreparedStatement prepState = connection.prepareStatement(query);
            prepState.setInt(1, userId);
            resultSet = prepState.executeQuery();
            resultSet.next();

            Home home = new Home(resultSet.getInt("HomeID"), resultSet.getDouble("Value"),
                    resultSet.getInt("YearBuilt"), resultSet.getInt("HomeTypeID"),
                    resultSet.getInt("HeatingTypeID"), resultSet.getString("PostalCode"),
                    resultSet.getString("Address"), resultSet.getString("City"),
                    resultSet.getString("Province"));

            list.add(home);

            HomeQuote homeQuote =  new HomeQuote(resultSet.getString("QuoteID"),
                    homeOwner, ConvertDates.convertToUtilDate(resultSet.getDate("DateQuoted")),
                    ConvertDates.convertToUtilDate(resultSet.getDate("QuoteExpired")),
                    resultSet.getDouble("BasePremium"), resultSet.getDouble("Tax"),
                    resultSet.getDouble("Total"), home, home.getValue(), 0, 0, 0);

            list.add(homeQuote);

            HomePolicy homePolicy = new HomePolicy(resultSet.getString("PolicyID"),
                    homeOwner, homeQuote, ConvertDates.convertToUtilDate(resultSet.getDate("StartDate")),
                    ConvertDates.convertToUtilDate(resultSet.getDate("EndDate")) ,
                    resultSet.getDouble("BasePremium"), resultSet.getDouble("Tax"),
                    resultSet.getDouble("Total"), home);

            list.add(homePolicy);

            String query2 = "SELECT * FROM VehicleQuotes vq\n" +
                    "JOIN Vehicle v on v.VehicleID = vq.VehicleID\n" +
                    "LEFT JOIN VehiclePolicy vp ON vp.QuoteID = vq.QuoteID\n" +
                    "WHERE vq.UserID = ? ORDER BY vq.DateQuoted DESC LIMIT 1;";
            PreparedStatement prepState2 = connection.prepareStatement(query2);
            prepState2.setInt(1, userId);
            resultSet = prepState2.executeQuery();
            resultSet.next();

            Vehicle vehicle = new Vehicle(resultSet.getInt("VehicleID"), resultSet.getDouble("ReplacementCost"),
                    resultSet.getString("Make"),
                    resultSet.getInt("Year"), resultSet.getString("Model"),
                    resultSet.getString("PlateNumber"));

            list.add(vehicle);

            VehicleQuote vehicleQuote = new VehicleQuote(resultSet.getString("QuoteID"),
                    primaryDriver,
                    ConvertDates.convertToUtilDate(resultSet.getDate("DateQuoted")),
                    ConvertDates.convertToUtilDate(resultSet.getDate("QuoteExpiredDate")),
                    resultSet.getDouble("BasePremium"),
                    resultSet.getDouble("Tax"),
                    resultSet.getDouble("Total"),
                    vehicle, vehicle.getVehicleValue());

            list.add(vehicleQuote);

            VehiclePolicy vehiclePolicy = new VehiclePolicy(resultSet.getString("PolicyID"),
                    primaryDriver, vehicleQuote, ConvertDates.convertToUtilDate(resultSet.getDate("StartDate")),
                    ConvertDates.convertToUtilDate(resultSet.getDate("EndDate")) ,
                    vehicleQuote.getBasePremium(),
                    vehicleQuote.getTax(), vehicleQuote.getTotal(),
                    vehicleQuote.getVehicle(), vehicleQuote.getVehicle().getVehicleValue());

            list.add(vehiclePolicy);
            
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnections(statement, resultSet, connection);
        }


        return list;
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
