package Insurance;

import java.util.Date;
/**
 * HomeQuote class that contains all private variables related to an HomeQuote Object.
 */
public class HomeQuote extends Quote {

    private Home home;
    private double replacementCost;
    private double liabilityLimit;
    private double contentsLimit;
    private double contentsDeductible;

    /**
     * Constructor for HomeQuote Class
     * @param quoteID String
     * @param user User
     * @param startDate date
     * @param endDate date
     * @param basePremium double
     * @param tax double
     * @param total double
     * @param home Home
     * @param replacementCost double
     * @param liabilityLimit double
     * @param contentsLimit double
     * @param contentsDeductible double
     */
    public HomeQuote(String quoteID, User user, Date startDate, Date endDate, double basePremium, double tax,
                     double total, Home home, double replacementCost, double liabilityLimit, double contentsLimit,
                     double contentsDeductible) {
        super(quoteID, user, startDate, endDate, basePremium, tax, total);
        this.home = home;
        this.replacementCost = replacementCost;
        this.liabilityLimit = liabilityLimit;
        this.contentsLimit = contentsLimit;
        this.contentsDeductible = contentsDeductible;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public double getLiabilityLimit() {
        return liabilityLimit;
    }

    public void setLiabilityLimit(double liabilityLimit) {
        this.liabilityLimit = liabilityLimit;
    }

    public double getContentsLimit() {
        return contentsLimit;
    }

    public void setContentsLimit(double contentsLimit) {
        this.contentsLimit = contentsLimit;
    }

    public double getContentsDeductible() {
        return contentsDeductible;
    }

    public void setContentsDeductible(double contentsDeductible) {
        this.contentsDeductible = contentsDeductible;
    }
}
