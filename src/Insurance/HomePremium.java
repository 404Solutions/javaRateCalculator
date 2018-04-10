package Insurance;

import java.util.Calendar;
/**
 * HomePremium class that contains all private variables related to an HomePremium Object.
 */
public class HomePremium {

    private static final double basePremium = 280.00;
    private static final double valueBase = 250000.00;
    private static final double valueFactor = 0.001;

    /**
     * CalculatePremium calculates the premium of a home
     * @param homeVal double
     * @param yearBuilt int
     * @param homeType int
     * @param heatingType int
     * @return
     */
    public static double calcPremium (double homeVal, int yearBuilt, int homeType, int heatingType) {
        return calcValuePremium(homeVal) * getAgeFactor(yearBuilt) * getTypeFactor(homeType) * getHeatingFactor(heatingType);
    }

    /**
     * calValuePremium calculates the value premium of a home.
     * @param homeVal double
     * @return double
     */
    private static double calcValuePremium(double homeVal) {
        if ((homeVal - valueBase) > 0) {
            return (homeVal - valueBase) * valueFactor + basePremium;
        }
        else {
            return basePremium;
        }
    }

    /**
     * getAgeFactor returns the factor for a home depending on the year it was built in.
     * @param yearBuilt int
     * @return double
     */
    private static double getAgeFactor(int yearBuilt) {
        int homeAge = Calendar.getInstance().get(Calendar.YEAR) - yearBuilt;

        if (homeAge < 20) {
            return 1.00;
        }
        else if (homeAge < 50) {
            return 1.25;
        }
        else {
            return 1.5;
        }
    }

    /**
     * getTypeFactor returns a factor depending on the type of home
     * @param homeType int
     * @return double
     */
    private static double getTypeFactor(int homeType) {
        if (homeType == 1){
            return 1.00;
        }
        else if (homeType == 2) {
            return 0.75;
        }
        else if (homeType == 3) {
            return 1.00;
        }
        else {
            return 1.15;
        }
    }

    /**
     * getHeatingFactor returns a heating factor depending on the heating type
     * @param heatingType int
     * @return double
     */
    private static double getHeatingFactor(int heatingType) {
        if (heatingType == 1) {
            return 1.00;
        }
        else if (heatingType == 2) {
            return 1.75;
        }
        else if (heatingType == 3) {
            return 1.30;
        }
        else if (heatingType == 4) {
            return 1.40;
        }
        else {
            return 1.25;
        }
    }

}
