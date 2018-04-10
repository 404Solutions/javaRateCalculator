package Insurance;

import java.util.ArrayList;
import java.util.Date;
/**
 * Driver class that contains all private variables related to an Driver Object.
 */
public abstract class Driver extends User {

    private String driversLicenceNumber;
    //TODO Change licenceYearIssued to Date AFTER Console Calculation
    private Date licenceIssuedDate;
    private ArrayList<Accident> accidents;

    /**
     * Constructor for driver class
     * @param userId int
     * @param firstName string
     * @param lastName string
     * @param dateOfBirth date
     * @param address string
     * @param city string
     * @param province string
     * @param postalCode string
     * @param phoneNumber string
     * @param email string
     * @param gender string
     * @param driversLicenceNumber string
     * @param licenceIssuedDate date
     */
    public Driver (int userId, String firstName, String lastName, Date dateOfBirth, String address, String city,
                   String province, String postalCode, String phoneNumber, String email, String gender,
                   String driversLicenceNumber, Date licenceIssuedDate) {

        super(userId, firstName, lastName, dateOfBirth, address, city, province, phoneNumber, postalCode,
                email, gender);

        this.licenceIssuedDate = licenceIssuedDate;
        this.driversLicenceNumber = driversLicenceNumber;
        accidents = new ArrayList<>();
    }


    public Date getLicenceIssuedDate() {
        return licenceIssuedDate;
    }

    public void setLicenceIssuedDate(Date licenceIssuedDate) {
        this.licenceIssuedDate = licenceIssuedDate;
    }

    public String getDriversLicenceNumber() {
        return driversLicenceNumber;
    }

    public void setDriversLicenceNumber(String driversLicenceNumber) {
        this.driversLicenceNumber = driversLicenceNumber;
    }

    public void addAccident (Accident accident) {
        accidents.add(accident);
    }

    public ArrayList<Accident> getAccidents() {
        return accidents;
    }
}
