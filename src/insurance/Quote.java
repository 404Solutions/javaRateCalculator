package insurance;

public abstract class Quote {

    private int quoteID;
    private User user;
    private String startDate;
    private String endDate;
    private double basePremium;
    private double tax;
    private double total;

    public Quote(int quoteID, User user, String startDate, String endDate, double basePremium, double tax, double total) {
        this.quoteID = quoteID;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.basePremium = basePremium;
        this.tax = tax;
        this.total = total;
    }

    public int getQuoteID() {
        return quoteID;
    }

    public void setQuoteID(int quoteID) {
        this.quoteID = quoteID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getBasePremium() {
        return basePremium;
    }

    public void setBasePremium(double basePremium) {
        this.basePremium = basePremium;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
