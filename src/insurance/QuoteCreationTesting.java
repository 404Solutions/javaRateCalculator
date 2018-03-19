package insurance;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class QuoteCreationTesting {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        System.out.println("Taylor Insurance Quote Generator");
        System.out.println("--------------------------------");

        System.out.println("Enter 1 for Home Quote 2 for Auto Quote");
        int quoteType = input.nextInt();

        System.out.println("Please enter the following questions about yourself:\n");
        System.out.println("First Name:");
        String firstName = input.next();
        System.out.println("Last Name");
        String lastName = input.next();
        System.out.println("Date of Birth DD-MM-YYY:");
        String DOB = input.next();
        System.out.println("Street Address:");
        String address = input.next();
        System.out.println("City:");
        String city = input.next();
        System.out.println("Province:");
        String province = input.next();
        System.out.println("Postal Code");
        String postal = input.next();
        System.out.println("Phone Number:");
        String phone = input.next();
        System.out.println("Email:");
        String email = input.next();
        System.out.println("Gender:");
        String gender = input.next();

        if (quoteType == 1) {

            HomeOwner homeOwner = new HomeOwner(1, firstName, lastName, DOB, address, city, province,
                    postal, phone, email, gender);

            System.out.println("Please answer the following questions regarding your home:\n");
            System.out.println("Home value:");
            double value = input.nextDouble();
            System.out.println("Year built:");
            int year = input.nextInt();
            System.out.println("Dwelling Type:\n1 for Single\n2 for Apartment\n3 for Bungalow\n4 for Semi-Attached");
            int type = input.nextInt();
            System.out.println("Heating Type:\n1 for Electric\n2 for Oil\n3 for Wood\n4 for Gas\n5 for Other");
            int heat = input.nextInt();

            Home home = new Home(1, value, year, type, heat, "A1A1A1", "123 Fake Street",
                    "Citytown", "NL");

            double premium = HomePremium.calcPremium(home.getValue(), home.getYearBuilt(), home.getHomeType(), home.getHeatingType());

            System.out.printf("Your home's premium is: %s", formatter.format(premium));

        } else {

            System.out.println("Driver's license number:");
            String licenseNumber = input.next();
            System.out.println("Driver's license issue date (YYYY/MM/DD):");
            String licenseDate = input.next();

            System.out.println("Primary driving location:\n1 for Downtown\n2 for Avalon\n3 for Outside Avalon");
            int location = input.nextInt();

            //Primary driver = new Primary(1, firstName, lastName, DOB, address, city, province, postal, phone,
                    //email, gender, licenseNumber, , location);

            //TODO Add driver init questions

            System.out.println("Please answer the following questions regarding your vehicle:\n");
            System.out.println("Vehicle value:");
            double value = input.nextDouble();
            System.out.println("Vehicle make: ");
            String make = input.next();
            System.out.println("Vehicle year: ");
            int year = input.nextInt();
            System.out.println("Vehicle model: ");
            String model = input.next();
            System.out.println("Vehicle plate number: ");
            String plate = input.next();

            Vehicle vehicle = new Vehicle(1, value, make, year, model, plate);

            String addAccident = "y";

            while (!addAccident.equalsIgnoreCase("n")) {
                System.out.println("Would you like to add an accident to your record? (y/n)");
                addAccident = input.next();

                if (addAccident == "y") {

                }
            }
            //TODO Add accident questions - in a loop?

            //TODO Add Home/VehicleQuote

            //VehiclePremium.calcPremium(45000.00,2017,1, )
        }
    }
}
