public class Accidents {
    private int accidentsID;
    private Driver driver;
    private int secondaryID;
    private String dateOfAccident;
    private Boolean responsible;

    public Accidents(int accidentsID, Driver driver, int secondaryID, String dateOfAccident, Boolean responsible) {
        this.accidentsID = accidentsID;
        this.driver = driver;
        this.secondaryID = secondaryID;
        this.dateOfAccident = dateOfAccident;
        this.responsible = responsible;
    }

    public int getAccidentsID() {
        return accidentsID;
    }

    public Driver getDriver() {
        return driver;
    }

    public int getSecondaryID() {
        return secondaryID;
    }

    public String getDateOfAccident() {
        return dateOfAccident;
    }

    public Boolean getResponsible() {
        return responsible;
    }

    public void setAccidentsID(int accidentsID) {
        this.accidentsID = accidentsID;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setSecondaryID(int secondaryID) {
        this.secondaryID = secondaryID;
    }

    public void setDateOfAccident(String dateOfAccident) {
        this.dateOfAccident = dateOfAccident;
    }

    public void setResponsible(Boolean responsible) {
        this.responsible = responsible;
    }
}
