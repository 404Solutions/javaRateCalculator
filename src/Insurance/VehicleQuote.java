package Insurance;

import java.util.Date;
/**
 * VehicleQuote class that contains all private variables related to an VehicleQuote Object.
 */
public class VehicleQuote extends Quote {

    private Vehicle vehicle;
    private double replacementCost;

    /**
     * Constructor for VehicleQuote
     * @param quoteID String
     * @param user User
     * @param startDate Date
     * @param endDate Date
     * @param basePremium double
     * @param tax double
     * @param total double
     * @param vehicle Vehicle
     * @param replacementCost double
     */
    public VehicleQuote(String quoteID, User user, Date startDate, Date endDate, double basePremium, double tax,
                        double total, Vehicle vehicle, double replacementCost) {
        super(quoteID, user, startDate, endDate, basePremium, tax, total);
        this.vehicle = vehicle;
        this.replacementCost = replacementCost;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }
}
