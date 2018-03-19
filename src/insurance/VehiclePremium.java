package insurance;

import java.util.ArrayList;
import java.util.Calendar;

public class VehiclePremium {

    private static final double basePremium = 325.00;
    private static final double valueBase = 15000.00;
    private static final double valueFactor = 0.0125;

    public static double calcPremium(double vehicleVal, int licenceYear, int locationType, ArrayList<Accident> accidents){
        return calcValuePremium(vehicleVal) * getExpFactor(licenceYear) * getLocationFactor(locationType) * getAccidentFactor(accidents);
    }

    private static double calcValuePremium(double vehicleVal) {
        if ((vehicleVal - valueBase) > 0) {
            return (vehicleVal - valueBase) * valueFactor + basePremium;
        }
        else {
            return basePremium;
        }
    }

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

    private static double getAccidentFactor(ArrayList<Accident> accidents) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int within5Years = 0;
        int within10Years = 0;

        for (Accident accident : accidents) {
            if (currentYear - accident.getYearOfAccident() <= 5) {
                within5Years++;
            }
            else if (currentYear - accident.getYearOfAccident() <= 10) {
                within10Years++;
            }
        }

        if (within5Years + within10Years > 2) {
            return 2.75;
        }
        else if (within5Years + within10Years == 0) {
            return 1.00;
        }
        else if (within5Years == 2) {
            return 2.25;
        }
        else if (within10Years > 0) {
            return 1.35;
        }
        else {
            return 1.35;
        }
    }
}
