package insurance;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Driver extends User {

    private String driversLicenceNumber;
    //TODO should this be a full date or is year fine?
    private Calendar licenceYearIssued;
    private int locationCode;
    private ArrayList<Accident> accidents;
    private int licenseYear;

    public Driver (int userId, String dateOfBirth, String address, String city, String province, String phoneNumber,
                   String email, String gender, String postalCode, String driversLicenceNumber, Calendar licenceYearIssued,
                    int locationCode, int licenseYear) {

        super(userId, dateOfBirth, address, city, province, phoneNumber,
                email, gender, postalCode);

        this.driversLicenceNumber = driversLicenceNumber;
        this.licenceYearIssued = licenceYearIssued;
        this.locationCode = locationCode;
        accidents = new ArrayList<>();
        this.licenseYear= licenseYear;
    }

    public int getLicenseYear() {
        return licenceYearIssued.get(Calendar.YEAR);
    }

    public String getDriversLicenceNumber() {
        return driversLicenceNumber;
    }

    public void setDriversLicenceNumber(String driversLicenceNumber) {
        this.driversLicenceNumber = driversLicenceNumber;
    }

    public Calendar getLicenceYearIssued() {
        return licenceYearIssued;
    }

    public void setLicenceYearIssued(Calendar licenceYearIssued) {
        this.licenceYearIssued = licenceYearIssued;
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
