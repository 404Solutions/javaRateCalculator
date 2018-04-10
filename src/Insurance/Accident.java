package Insurance;

/**
 * Accident class that contains all private variables related to an Accident Object.
 */
public class Accident {
    private int accidentsID;
    private Driver driver;
    private int secondaryID;
    //TODO should we store the full date or just the year?
    private int yearOfAccident;
    private Boolean responsible;

    /**
     * Constructor for Accident object
     * @param accidentsID int
     * @param driver Driver object
     * @param secondaryID int
     * @param yearOfAccident int
     * @param responsible boolean
     */
    public Accident(int accidentsID, Driver driver, int secondaryID, int yearOfAccident, Boolean responsible) {
        this.accidentsID = accidentsID;
        this.driver = driver;
        this.secondaryID = secondaryID;
        this.yearOfAccident = yearOfAccident;
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

    public int getYearOfAccident() {
        return yearOfAccident;
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

    public void setYearOfAccident(int yearOfAccident) {
        this.yearOfAccident = yearOfAccident;
    }

    public void setResponsible(Boolean responsible) {
        this.responsible = responsible;
    }
}
