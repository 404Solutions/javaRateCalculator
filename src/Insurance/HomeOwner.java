package Insurance;

import java.util.Date;
/**
 * HomeOwner class that contains all private variables related to an Homeowner Object.
 */
public class HomeOwner extends User {
    /**
     * Constructor for HomeOwner Class
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
     */
    public HomeOwner (int userId, String firstName, String lastName, Date dateOfBirth, String address, String city,
                      String province, String postalCode, String phoneNumber, String email, String gender) {

        super(userId, firstName, lastName, dateOfBirth, address, city, province, postalCode, phoneNumber,
                email, gender);

    }

}
