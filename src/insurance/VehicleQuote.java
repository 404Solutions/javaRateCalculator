package insurance;

public class VehicleQuote extends Quote {

    private Vehicle vehicle;

    public VehicleQuote(int quoteID, User user, String startDate, String endDate, double basePremium, double tax, double total, Vehicle vehicle) {
        super(quoteID, user, startDate, endDate, basePremium, tax, total);
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
