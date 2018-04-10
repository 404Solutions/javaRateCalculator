package Insurance;

import java.util.Date;
/**
 * VehiclePolicy class that contains all private variables related to an VehiclePolicy Object.
 */
public class VehiclePolicy extends Policy {

    private Vehicle vehicle;
    private double replacementCosts;

    /**
     * Constructor for VehiclePolicy
     * @param policyID String
     * @param user User
     * @param quote Quote
     * @param startDate Date
     * @param endDate Date
     * @param basePremium double
     * @param tax double
     * @param total double
     * @param vehicle vehicle
     * @param replacementCosts double
     */
    public VehiclePolicy(String policyID, User user, Quote quote, Date startDate, Date endDate, double basePremium, double tax, double total, Vehicle vehicle, double replacementCosts) {
        super(policyID, user, quote, startDate, endDate, basePremium, tax, total);
        this.vehicle = vehicle;
        this.replacementCosts = replacementCosts;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getReplacementCosts() {
        return replacementCosts;
    }

    public void setReplacementCosts(double replacementCosts) {
        this.replacementCosts = replacementCosts;
    }
}
