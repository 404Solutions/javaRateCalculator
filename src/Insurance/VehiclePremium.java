package Insurance;

import java.util.Calendar;

/**
 * VehiclePremium that calculates the base premium, tax, and total of a vehicle quote.
 */
public class VehiclePremium {

    private static final double basePremium = 325.00;
    private static final double valueBase = 15000.00;
    private static final double valueFactor = 0.0125;

    public static double calcPremium(double vehicleVal, int licenceYear, int locationType, int accidentsWithin5,
                                     int accidentsWithin10){
        return calcValuePremium(vehicleVal) * getExpFactor(licenceYear) * getLocationFactor(locationType) *
                getAccidentFactor(accidentsWithin5, accidentsWithin10);
    }

    /**
     * calcValuePremium calculates the premium for the vehiclequote
     * @param vehicleVal
     * @return
     */
    private static double calcValuePremium(double vehicleVal) {
        if ((vehicleVal - valueBase) > 0) {
            return (vehicleVal - valueBase) * valueFactor + basePremium;
        }
        else {
            return basePremium;
        }
    }

    /**
     * getExpFactor returns an experience factor based on the number of years of driving experience
     * @param licenceYear int
     * @return double
     */
    private static double getExpFactor(int licenceYear) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if (currentYear - licenceYear <= 5) {
            return 2.50;
        }
        else if (currentYear - licenceYear < 10) {
            return 1.25;
        }
        else {
            return 1.00;
        }
    }

    /**
     * getLocationFactor returns a factor based on the location type
     * @param locationType int
     * @return double
     */
    private static double getLocationFactor(int locationType) {
        if (locationType == 1) {
            return 1.50;
        }
        else if (locationType == 2) {
            return 1.25;
        } else {
            return 1.00;
        }
    }

    /**
     * getAccidentFactor returns an accident factor based on the count of accidents in 5 and 10 years.
     * @param within5Years int
     * @param within10Years int
     * @return double
     */
    private static double getAccidentFactor(int within5Years, int within10Years) {

        if (within5Years + within10Years == 0) {
            return 1.00;
        }
        else if (within5Years == 1) {
            return 1.25;
        }
        else if (within5Years == 2) {
            return 2.25;
        }
        else if (within10Years >= 1 && within10Years <= 2) {
            return 1.35;
        }
        else {
            return 2.75;
        }
    }
}