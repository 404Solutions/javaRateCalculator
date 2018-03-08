public class User {

    private int userId;
    private String dateOfBirth;
    private String address;
    private String city;
    private String province;
    private String phoneNumber;
    private String email;
    private String gender;
    private String postalCode;

    public User (int userId, String dateOfBirth, String address, String city, String province, String phoneNumber,
                 String email, String gender, String postalCode) {

        this.userId = userId;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.province = province;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.postalCode = postalCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

}
