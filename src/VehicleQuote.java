public class VehicleQuote extends Quote {

    private Vehicle vehicle;
    private double replacementCost;

    public VehicleQuote(int quoteID, User user, String startDate, String endDate, double basePremium, double tax, double total, Vehicle vehicle, double replacementCost) {
        super(quoteID, user, startDate, endDate, basePremium, tax, total);
        this.vehicle = vehicle;
        this.replacementCost = replacementCost;
    }
}
