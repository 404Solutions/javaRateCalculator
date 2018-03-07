public class Driver extends User {

    private String driversLicenceNumber;
    private String licenceDateIssued;

    public Driver (int userId, String dateOfBirth, String address, String city, String province, String phoneNumber,
                   String email, String gender, String postalCode, String driversLicenceNumber, String licenceDateIssued) {

        super(userId, dateOfBirth, address, city, province, phoneNumber,
                email, gender, postalCode);

        this.driversLicenceNumber = driversLicenceNumber;
        this.licenceDateIssued = licenceDateIssued;
    }

    public String getDriversLicenceNumber() {
        return driversLicenceNumber;
    }

    public void setDriversLicenceNumber(String driversLicenceNumber) {
        this.driversLicenceNumber = driversLicenceNumber;
    }

    public String getLicenceDateIssued() {
        return licenceDateIssued;
    }

    public void setLicenceDateIssued(String licenceDateIssued) {
        this.licenceDateIssued = licenceDateIssued;
    }
}
