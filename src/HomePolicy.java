public class HomePolicy extends Policy {

    private Home home;
    private double replacementCost;
    private double liabilitLimit;
    private double contentsLimit;
    private double contentsDeductible;

    public HomePolicy(String policyID, User user, Quote quote, String startDate, String endDate, double basePremium, double tax, double total, Home home, double replacementCost, double liabilitLimit, double contentsLimit, double contentsDeductible) {
        super(policyID, user, quote, startDate, endDate, basePremium, tax, total);
        this.home = home;
        this.replacementCost = replacementCost;
        this.liabilitLimit = liabilitLimit;
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

    public double getLiabilitLimit() {
        return liabilitLimit;
    }

    public void setLiabilitLimit(double liabilitLimit) {
        this.liabilitLimit = liabilitLimit;
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
