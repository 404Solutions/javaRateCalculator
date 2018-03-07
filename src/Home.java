public class Home {
    private int homeID;
    private int yearBuilt;
    private String homeType;
    private String heatingType;
    private String postalCode;
    private String address;
    private String city;
    private String province;

    public Home(int homeID, int yearBuilt, String homeType, String heatingType, String postalCode, String address, String city, String province) {
        this.homeID = homeID;
        this.yearBuilt = yearBuilt;
        this.homeType = homeType;
        this.heatingType = heatingType;
        this.postalCode = postalCode;
        this.address = address;
        this.city = city;
        this.province = province;
    }

    public int getHomeID() {
        return homeID;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public String getHomeType() {
        return homeType;
    }

    public String getHeatingType() {
        return heatingType;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public void setHomeID(int homeID) {
        this.homeID = homeID;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }

    public void setHeatingType(String heatingType) {
        this.heatingType = heatingType;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
