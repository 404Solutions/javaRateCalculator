package Insurance;

import Conversions.ConvertDates;
import Managers.*;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
//import com.sun.org.apache.xpath.internal.SourceTree;

public class QuoteCreationTesting {

    public static void main(String[] args) throws SQLException {


        //testing date conversions.
        System.out.print(ConvertDates.convertStringToUtilDate("1993-09-30"));


        HomeQuoteManager homeQuoteManager = new HomeQuoteManager();
        VehicleQuoteManager vehicleQuoteManager = new VehicleQuoteManager();
        HomeOwnerManager homeOwnerManager = new HomeOwnerManager();
        //HomeOwner homeOwner = homeOwnerManager.insertHomeOwner(2, "Jon", "Doe", "1997-09-30", "1 prince philip drive", "st.Johns","NL", "A1E5M2","709-555-5555", "email@email.com", "F");

//        VehicleManager vehicleManager = new VehicleManager();
//        Vehicle vehicle = vehicleManager.insertVehicle(45000, "toyota", 2013, "corolla", "HXL456");

        HomeManager homeManager = new HomeManager();
        Home home = homeManager.insertHome(200000, 1995, 1, 3, "a1e6h7", "1 prince philip drive", "St.Johns", "NL");
//      Test Data to be removed.
//        HomeOwner homeOwner = new HomeOwner(1, "","","","","","","","");
//        Home home = new Home(1,123,1993,1,2,"a1v2k4","","","");
//        homeQuoteManager.createNewQuote(4000.00,50.95,4050.96, home, homeOwner);
//
//        PrimaryDriver primary = new PrimaryDriver(0,"","","","","","","","", "",1992,2);
//        Vehicle vehicle = new Vehicle(0,321,"",1990,"","");
//        vehicleQuoteManager.createNewQuote(4012.0,650,2451,vehicle,primary);

    }
}
