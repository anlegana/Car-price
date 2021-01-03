package info.hccis.tutor;

import cis.util.CisUtility;
import info.hccis.tutor.bo.Vehicle;

/**
 * A project to track tutor transactions.
 *
 * @author Andres Gaviria
 * @since 20201204
 */
public class Controller {

    public static final int EXIT = 0;

    public static final String MENU = "1) Would you like to enter another vehicles information?" + System.lineSeparator()
            + EXIT + ") Exit" + System.lineSeparator();
    public static final String MESSAGE_MAINMENU = "Main Menu";
    public static final String MESSAGE_ERROR = "Invalid Option";
    public static final String MESSAGE_EXIT = "Goodbye";

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        vehicle.getInformation();
        vehicle.display();
        System.out.println(MESSAGE_MAINMENU);
        int menuOption;

        do {
            menuOption = CisUtility.getInputInt(MENU);
            switch (menuOption) {
                case EXIT:
                    System.out.println(MESSAGE_EXIT);
                    break; //Break out of the loop as we're finished.
                case 1:
                    vehicle.getInformation();
                    vehicle.display();
                    break;

                default:
                    System.out.println(MESSAGE_ERROR);
                    break;
            }
        } while (menuOption != EXIT);

    }
}
