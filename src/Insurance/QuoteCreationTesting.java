package Insurance;

import Managers.HomeQuoteManager;
import Managers.VehicleQuoteManager;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;
//import com.sun.org.apache.xpath.internal.SourceTree;

public class QuoteCreationTesting {

    public static void main(String[] args) throws SQLException {

        HomeQuoteManager homeQuoteManager = new HomeQuoteManager();
        VehicleQuoteManager vehicleQuoteManager = new VehicleQuoteManager();

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
