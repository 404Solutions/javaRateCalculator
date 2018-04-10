package Insurance;
import java.util.Date;
/**
 * PrimaryDriver class that contains all private variables related to an PrimaryDriver Object.
 */
public class PrimaryDriver extends Driver{
    private int locationCode;

    /**
     * Constructor for Primary Driver object
     * @param userId int
     * @param firstName String
     * @param lastName String
     * @param dateOfBirth Date
     * @param address String
     * @param city String
     * @param province String
     * @param postalCode String
     * @param phoneNumber String
     * @param email String
     * @param gender String
     * @param driversLicenceNumber String
     * @param licenceIssuedDate date
     * @param locationCode int
     */
    public PrimaryDriver(int userId, String firstName, String lastName, Date dateOfBirth, String address,
                         String city, String province, String postalCode, String phoneNumber, String email,
                         String gender, String driversLicenceNumber, Date licenceIssuedDate, int locationCode) {
        super(userId, firstName, lastName, dateOfBirth, address, city, province, postalCode,
                phoneNumber, email, gender, driversLicenceNumber, licenceIssuedDate);
        this.locationCode = locationCode;
    }

    public int getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(int locationCode) {
        this.locationCode = locationCode;
    }
}
