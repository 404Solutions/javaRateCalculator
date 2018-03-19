package insurance;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Driver extends User {

    private String driversLicenceNumber;
    private Calendar licenceDateIssued;
    private int locationCode;
    private ArrayList<Accident> accidents;

    public Driver (int userId, String firstName, String lastName, String dateOfBirth, String address, String city,
                   String province, String postalCode, String phoneNumber, String email, String gender,
                   String driversLicenceNumber, Calendar licenceDateIssued, int locationCode) {

        super(userId, firstName, lastName, dateOfBirth, address, city, province, postalCode, phoneNumber, email, gender);

        this.driversLicenceNumber = driversLicenceNumber;
        this.licenceDateIssued = licenceDateIssued;
        this.locationCode = locationCode;
        accidents = new ArrayList<>();
    }

    public int getLicenseYear() {
        return licenceDateIssued.get(Calendar.YEAR);
    }

    public String getDriversLicenceNumber() {
        return driversLicenceNumber;
    }

    public void setDriversLicenceNumber(String driversLicenceNumber) {
        this.driversLicenceNumber = driversLicenceNumber;
    }

    public Calendar getLicenceDateIssued() {
        return licenceDateIssued;
    }

    public void setLicenceDateIssued(Calendar licenceDateIssued) {
        this.licenceDateIssued = licenceDateIssued;
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
