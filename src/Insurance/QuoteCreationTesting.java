package Insurance;

import Managers.HomeQuoteManager;
import Managers.VehicleQuoteManager;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Scanner;
//import com.sun.org.apache.xpath.internal.SourceTree;

public class QuoteCreationTesting {

    public static void main(String[] args) throws SQLException {

        HomeQuoteManager homeQuoteManager = new HomeQuoteManager();
        VehicleQuoteManager vehicleQuoteManager = new VehicleQuoteManager();
        double tax = 0.15;

//      Test Data to be removed.
//        HomeOwner homeOwner = new HomeOwner(1, "","","","","","","","");
//        Home home = new Home(1,123,1993,1,2,"a1v2k4","","","");
//        homeQuoteManager.createNewQuote(4000.00,50.95,4050.96, home, homeOwner);
//
//        PrimaryDriver primary = new PrimaryDriver(0,"","","","","","","","", "",1992,2);
//        Vehicle vehicle = new Vehicle(0,321,"",1990,"","");
//        vehicleQuoteManager.createNewQuote(4012.0,650,2451,vehicle,primary);
        
        Scanner input = new Scanner(System.in);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        System.out.println("Taylor Insurance Quote Generator");
        System.out.println("--------------------------------");

        System.out.println("Enter 1 for Home Quote 2 for Auto Quote");
        int quoteType = input.nextInt();
        input.nextLine();

        //Get user info
        System.out.println("Please enter the following questions about yourself:\n");
        System.out.print("First Name:");
        String firstName = input.nextLine();
        System.out.print("Last Name:");
        String lastName = input.nextLine();
        System.out.println("Date of Birth DD-MM-YYYY:");
        String DOB = input.nextLine();
        System.out.println("Street Address:");
        String address = input.nextLine();
        System.out.println("City:");
        String city = input.nextLine();
        System.out.println("Province:");
        String province = input.nextLine();
        System.out.println("Postal Code");
        String postal = input.nextLine();
        System.out.println("Phone Number:");
        String phone = input.nextLine();
        System.out.println("Email:");
        String email = input.nextLine();
        System.out.println("Gender: (m/f)");
        String gender = input.nextLine();

        //If home quote create home owner
        if (quoteType == 1) {

            HomeOwner homeOwner = new HomeOwner(1, firstName, lastName, DOB, address, city, province,
                    postal, phone, email, gender);

            //Get home info & create home object
            System.out.println("Please answer the following questions regarding your home:\n");
            System.out.println("Home value:");
            double value = input.nextDouble();
            System.out.println("Year built:");
            int year = input.nextInt();
            input.nextLine();
            System.out.println("Dwelling Type:\n1 for Single\n2 for Apartment\n3 for Bungalow\n4 for Semi-Attached");
            int type = input.nextInt();
            input.nextLine();
            System.out.println("Heating Type:\n1 for Electric\n2 for Oil\n3 for Wood\n4 for Gas\n5 for Other");
            int heat = input.nextInt();
            input.nextLine();

            Home home = new Home(1, value, year, type, heat, "A1A1A1", "123 Fake Street",
                    "Citytown", "NL");

            //Calculate home premium and call quote manager to create a quote
            double homePremium = HomePremium.calcPremium(home.getValue(), home.getYearBuilt(), home.getHomeType(), home.getHeatingType());
            HomeQuote homeQuote = homeQuoteManager.createNewQuote(homePremium, tax, homePremium * tax, home, homeOwner);

            //Display the quote information to the user
            System.out.printf("--------------------Quote Number: %s--------------------", homeQuote.getQuoteID());
            System.out.printf("Address: %s", home.getAddress());
            System.out.printf("City: %s", home.getCity());
            System.out.printf("Province: %s", home.getProvince());
            System.out.printf("Postal Code: %s", home.getPostalCode());
            System.out.printf("Year Built: %d", home.getYearBuilt());
            System.out.println("----------------------------------------------------------");
            System.out.printf("Quote Start Date: %s", homeQuote.getStartDate());
            System.out.printf("Quote Expiry Date: %s", homeQuote.getEndDate());
            System.out.printf("Home Value: %f", home.getValue());
            System.out.printf("Base Premium: %f", homeQuote.getBasePremium());
            System.out.printf("Total: %f", homeQuote.getTotal());

        } else {

            // if vehicle quote get remaining driver info and create primary driver object
            System.out.println("Driver's license number:");
            String licenseNumber = input.nextLine();
            System.out.println("Driver's license year issued:");
            int licenseYear = input.nextInt();
            input.nextLine();
            System.out.println("PrimaryDriver driving location:\n1 for Downtown\n2 for Avalon\n3 for Outside Avalon");
            int location = input.nextInt();
            input.nextLine();

            PrimaryDriver driver = new PrimaryDriver(1, firstName, lastName, DOB, address, city, province, postal, phone,
                    email, gender, licenseNumber, licenseYear, location);

            //Get vehicle informaton and create vehicle object
            System.out.println("Please answer the following questions regarding your vehicle:\n");
            System.out.println("Vehicle value:");
            double value = input.nextDouble();
            System.out.println("Vehicle make: ");
            String make = input.nextLine();
            System.out.println("Vehicle year: ");
            int year = input.nextInt();
            input.nextLine();
            System.out.println("Vehicle model: ");
            String model = input.nextLine();
            System.out.println("Vehicle plate number: ");
            String plate = input.nextLine();

            Vehicle vehicle = new Vehicle(1, value, make, year, model, plate);

            // Prompt user to enter information about accidents and populate Accident ArrayList in driver object
            String addAccident = "y";
            int accidentId = 0;
            boolean atFault;

            while (!addAccident.equalsIgnoreCase("n")) {
                System.out.println("Would you like to add an accident to your record? (y/n)");
                addAccident = input.nextLine();

                accidentId++;

                if (addAccident.equalsIgnoreCase("y")) {
                    System.out.println("What was the year of the accident?");
                    int accidentYear = input.nextInt();
                    input.nextLine();
                    System.out.println("Were you at fault? (y/n)");
                    String atFaultCheck = input.nextLine();

                    //TODO check if code cleanup compiles
                    if (atFaultCheck.equalsIgnoreCase("y")){
                        atFault = true;
                    } else {
                        atFault = false;
                    }

                    driver.addAccident(new Accident(accidentId, driver, 1, accidentYear, atFault));
                }
            }

            //Calculate premium and create vehicle quote object
            double vehiclePremium = VehiclePremium.calcPremium(vehicle.getVehicleValue(), driver.getLicenceYearIssued(),
                    driver.getLocationCode(), driver.getAccidents());

            VehicleQuote vehicleQuote = vehicleQuoteManager.createNewQuote(vehiclePremium, tax, vehiclePremium * tax,
                    vehicle, driver);

            //Display quote information to user
            System.out.printf("--------------------Quote Number: %s--------------------", vehicleQuote.getQuoteID());
            System.out.printf("Vehicle Make: %s", vehicle.getMake());
            System.out.printf("Vehicle Model: %s", vehicle.getModel());
            System.out.printf("Vehicle Year: %d", vehicle.getYear());
            System.out.printf("Plate Number: %s", vehicle.getPlateNumber());
            System.out.println("----------------------------------------------------------");
            System.out.printf("Quote Start Date: %s", vehicleQuote.getStartDate());
            System.out.printf("Quote Expiry Date: %s", vehicleQuote.getEndDate());
            System.out.printf("Vehicle Value: %f", vehicleQuote.getReplacementCost());
            System.out.printf("Base Premium: %f", vehicleQuote.getBasePremium());
            System.out.printf("Total: %f", vehicleQuote.getTotal());
        }
    }
}
