package Insurance;

import java.util.ArrayList;

public abstract class Driver extends User {

    private String driversLicenceNumber;
    //TODO Change licenceYearIssued to Date AFTER Console Calculation
    private int licenceYearIssued;
    private int locationCode;
    private ArrayList<Accident> accidents;

    public Driver (int userId, String firstName, String lastName, String dateOfBirth, String address, String city,
                   String province, String postalCode, String phoneNumber, String email, String gender,
                   String driversLicenceNumber, int licenseYearIssued, int locationCode) {

        super(userId, firstName, lastName, dateOfBirth, address, city, province, phoneNumber, postalCode,
                email, gender);

        this.licenceYearIssued = licenseYearIssued;
        this.driversLicenceNumber = driversLicenceNumber;
        this.locationCode = locationCode;
        accidents = new ArrayList<>();
    }


    public int getLicenceYearIssued() {
        return licenceYearIssued;
    }

    public void setLicenceYearIssued(int licenceYearIssued) {
        this.licenceYearIssued = licenceYearIssued;
    }

    public String getDriversLicenceNumber() {
        return driversLicenceNumber;
    }

    public void setDriversLicenceNumber(String driversLicenceNumber) {
        this.driversLicenceNumber = driversLicenceNumber;
    }

    public int getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(int locationCode) {
        this.locationCode = locationCode;
    }

    public void addAccident (Accident accident) {
        accidents.add(accident);
    }

    public ArrayList<Accident> getAccidents() {
        return accidents;
    }
}
