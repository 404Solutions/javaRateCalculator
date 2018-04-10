package Insurance;

import java.util.Date;
/**
 * SecondaryDriver class that contains all private variables related to an SecondaryDriver Object.
 */
public class SecondaryDriver extends Driver {

    /**
     * Constructor for Secondary Driver object
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
     * @param licenceYearIssued date
     */
    public SecondaryDriver(int userId, String firstName, String lastName, Date dateOfBirth, String address, String city,
                           String province, String postalCode, String phoneNumber, String email, String gender,
                           String driversLicenceNumber, Date licenceYearIssued) {

        super (userId, firstName, lastName, dateOfBirth, address, city, province, postalCode, phoneNumber,
                email, gender, driversLicenceNumber, licenceYearIssued);

    }

}
