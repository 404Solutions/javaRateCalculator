package Insurance;

import Managers.HomeQuoteManager;
import Managers.VehicleQuoteManager;

import java.sql.SQLException;

public class QuoteCreationTesting {

    public static void main(String[] args) throws SQLException {

        HomeQuoteManager homeQuoteManager = new HomeQuoteManager();
        VehicleQuoteManager vehicleQuoteManager = new VehicleQuoteManager();

        HomeOwner homeOwner = new HomeOwner(1, "","","","","","","","");
        Home home = new Home(1,123,1993,1,2,"a1v2k4","","","");
        homeQuoteManager.createNewQuote(4000.00,50.95,4050.96, home, homeOwner);

        Primary primary = new Primary(0,"","","","","","","","", "",1992,2);
        Vehicle vehicle = new Vehicle(0,321,"",1990,"","");
        vehicleQuoteManager.createNewQuote(4012.0,650,2451,vehicle,primary);


//
//        Scanner input = new Scanner(System.in);
//        NumberFormat formatter = NumberFormat.getCurrencyInstance();
//
//        System.out.println("Taylor Insurance Quote Generator");
//        System.out.println("--------------------------------");
//
//        System.out.println("Enter 1 for Home Quote 2 for Auto Quote");
//        int quoteType = input.nextInt();
//
//        if (quoteType == 1) {
//
//            System.out.println("Please answer the following questions regarding your home:\n");
//            System.out.println("Home value:");
//            double value = input.nextDouble();
//            System.out.println("Year built:");
//            int year = input.nextInt();
//            System.out.println("Dwelling Type:\n1 for Single\n2 for Apartment\n3 for Bungalow\n4 for Semi-Attached");
//            int type = input.nextInt();
//            System.out.println("Heating Type:\n1 for Electric\n2 for Oil\n3 for Wood\n4 for Gas\n5 for Other");
//            int heat = input.nextInt();
//
//            Home home = new Home(1, value, year, type, heat, "A1A1A1", "123 Fake Street",
//                    "Citytown", "NL");
//
//            double premium = HomeRisk.calcPremium(home.getValue(), home.getYearBuilt(), home.getHomeType(), home.getHeatingType());
//
//            System.out.printf("Your home's premium is: %s", formatter.format(premium));
//
//        } else {
//
//            System.out.println("Please answer the following questions regarding your vehicle:\n");
//        }
    }
}
