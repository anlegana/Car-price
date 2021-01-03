package info.hccis.tutor.bo;

import cis.util.CisUtility;
import java.util.Scanner;

/**
 * @author Andres Gaviria
 * @since 20201204
 */
public class Vehicle {

    private static final double LOSE_THIRTY = 0.30;
    private static final double LOSE_THIRTY_FIVE = 0.35;
    private static final double LOSE_FORTY = 0.40;
    private static final double LOSE_FIFTY = 0.50;
    private static final double AUTOMATIC = 0.05;
    private static final double SUNROOF = 0.1;
    private static final String TRANSMISION_AUTOMATIC_VEHICLE = "A";
    private static final String TRANSMISION_MANUAL_VEHICLE = "M";

    private double vehiclePrice;
    private double vehicleMileage;
    private String vehicleTransmision;
    private String vehicleSunroof;
    private String priceFormat;

    public Vehicle() {

    }

    
     /**
     * Get information from the user
     *
     * @since 2020-12-04
     * @author Andres Gaviria
     */
    public void getInformation() {
        Scanner input = new Scanner(System.in);
        vehiclePrice = CisUtility.getInputDouble("Vehicle Price:");
        vehicleMileage = CisUtility.getInputDouble("Mileage on Vehicle:");
        vehicleTransmision = CisUtility.getInputString("Transmission (A-automatic / M-manual): ");
        vehicleSunroof = CisUtility.getInputString("Sunroof  (Y/N): ");

        priceFormat = String.format("%.2f", getPrice()); //Placing 2 decimal of earnings
    }
    
     /**
     * Returns the calculated price for this vehicle
     *
     * @since 2020-12-04
     * @author Andres Gaviria
     */

    public double getPrice() {
        double price = vehiclePrice;
        if (vehicleMileage >= 0 && vehicleMileage <= 59999) {  //Price  would change depending on the mileage of the car
            price -= (vehiclePrice * LOSE_THIRTY);
        } else if (vehicleMileage >= 60000 && vehicleMileage <= 99999) {
            price -= (vehiclePrice * LOSE_THIRTY_FIVE);
        } else if (vehicleMileage >= 100000 && vehicleMileage <= 199999) {
            price -= (vehiclePrice * LOSE_FORTY);
        } else if (vehicleMileage >= 200000) {
            price -= (vehiclePrice * LOSE_FIFTY);
        }

        switch (vehicleTransmision) {   //Price  would change depending on the transmiion of the car(it is a requirement to use switch
            case TRANSMISION_AUTOMATIC_VEHICLE:                
                price += (vehiclePrice * AUTOMATIC);
                break;
            case TRANSMISION_MANUAL_VEHICLE:
                price -= (vehiclePrice * AUTOMATIC);
                break;

        }
        if (vehicleSunroof.equals("Y")) {    //Price  would change if the car has sunroof
            price += (vehiclePrice * SUNROOF);
        }

        return price;

    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public double getVehicleMileage() {
        return vehicleMileage;
    }

    public String getVehicleTransmision() {
        return vehicleTransmision;
    }

    public String VehicleSunroof() {
        return vehicleSunroof;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public void setVehicleMileage(double vehicleMileage) {
        this.vehicleMileage = vehicleMileage;
    }

    public void setVehicletransmision(String vehicleTransmision) {
        this.vehicleTransmision = vehicleTransmision;
    }

    public void setVehiclesunroof(String vehicleSunroof) {
        this.vehicleSunroof = vehicleSunroof;
    }

    public void display() {
        System.out.println(this.toString());
    }

    public String toString() {

        String output = "Your vehicle is now valued at: $" + priceFormat
                + "\n";

        return output;
    }
}
