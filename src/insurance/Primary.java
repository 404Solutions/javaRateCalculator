package insurance;

public class Primary extends Driver{

    public Primary (int userId, String dateOfBirth, String address, String city, String province, String phoneNumber,
                    String email, String gender, String postalCode, String driversLicenceNumber, int licenceDateIssued,
                    int locationCode) {

        super (userId, dateOfBirth, address, city, province, phoneNumber,
                email, gender, postalCode, driversLicenceNumber, licenceDateIssued, locationCode);
    }

}