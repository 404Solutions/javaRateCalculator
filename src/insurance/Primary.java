package insurance;

import java.util.Calendar;

public class Primary extends Driver{

    public Primary (int userId, String firstName, String lastName, String dateOfBirth, String address, String city,
                    String province, String postalCode, String phoneNumber, String email, String gender,
                    String driversLicenceNumber, Calendar licenceYearIssued, int locationCode) {

        super (userId, firstName, lastName, dateOfBirth, address, city, province, postalCode, phoneNumber,
                email, gender, driversLicenceNumber, licenceYearIssued, locationCode);
    }

}
