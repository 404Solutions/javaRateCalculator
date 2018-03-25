package Managers;

import Conversions.ConvertDates;
import Insurance.PrimaryDriver;
import Insurance.Vehicle;
import Insurance.VehicleQuote;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class HomeOwnerManager {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/comp_database?autoReconnect=true&useSSL=false";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
}
