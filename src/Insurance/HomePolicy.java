package Insurance;

import java.util.Date;
/**
 * HomePolicy class that contains all private variables related to an HomePolicy Object.
 */
public class HomePolicy extends Policy {

    private Home home;

    /**
     * Constructor for HomePolicy Class
     * @param policyID String
     * @param user User
     * @param quote Quote
     * @param startDate Date
     * @param endDate Date
     * @param basePremium double
     * @param tax double
     * @param total double
     * @param home Home
     */
    public HomePolicy(String policyID, User user, Quote quote, Date startDate, Date endDate, double basePremium, double tax, double total, Home home) {
        super(policyID, user, quote, startDate, endDate, basePremium, tax, total);
        this.home = home;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}