package my.firstapp.byblos;

public class CarRental {

    public static String customerFirstName;
    public static String customerLastName;
    public static String customerBirthDate;
    public static String customerLicenseType;
    public static String carType;
    public static String pickUpDate;
    public static String dropOffDate;
    public static String pickUpTime;
    public static String dropOffTime;
    public static String estimatedPrice;
    public static String isApproved;

    public CarRental() {

    }

    public CarRental(String customerFirstName, String customerLastName, String customerBirthDate,
                     String customerLicenseType, String carType, String pickUpDate,
                     String dropOffDate, String pickUpTime, String dropOffTime, String estimatedPrice, String isApproved) {
        CarRental.customerFirstName = customerFirstName;
        CarRental.customerLastName = customerLastName;
        CarRental.customerBirthDate = customerBirthDate;
        CarRental.customerLicenseType = customerLicenseType;
        CarRental.carType = carType;
        CarRental.pickUpDate = pickUpDate;
        CarRental.dropOffDate = dropOffDate;
        CarRental.pickUpTime = pickUpTime;
        CarRental.dropOffTime = dropOffTime;
        CarRental.estimatedPrice = estimatedPrice;
        CarRental.isApproved = isApproved;
    }

    public String getCustomerFirstName() {return customerFirstName;}

    public String getCustomerLastName() {return customerLastName;}

    public String getCustomerBirthDate() {return customerBirthDate;}

    public String getCustomerLicenseType() {return customerLicenseType;}

    public String getCarType() {return CarRental.carType;}

    public String getPickUpDate() {return CarRental.pickUpDate;}

    public String getDropOffDate() {return CarRental.dropOffDate;}

    public String getPickUpTime() {return CarRental.pickUpTime;}

    public String getDropOffTime() {return CarRental.dropOffTime;}

    public String getEstimatedPrice() {return CarRental.estimatedPrice;}

    public String getIsApproved() {return CarRental.isApproved;}

    public static void setCustomerFirstName(String customerFirstName) {
        CarRental.customerFirstName = customerFirstName;
    }

    public static void setCustomerLastName(String customerLastName) {
        CarRental.customerLastName = customerLastName;
    }

    public static void setCustomerBirthDate(String customerBirthDate) {
        CarRental.customerBirthDate = customerBirthDate;
    }

    public static void setCustomerLicenseType(String customerLicenseType) {
        CarRental.customerLicenseType = customerLicenseType;
    }

    public static void setCarType(String carType) {
        CarRental.carType = carType;
    }

    public static void setPickUpDate(String pickUpDate) {
        CarRental.pickUpDate = pickUpDate;
    }

    public static void setDropOffDate(String dropOffDate) {
        CarRental.dropOffDate = dropOffDate;
    }

    public static void setPickUpTime(String pickUpTime) {
        CarRental.pickUpTime = pickUpTime;
    }

    public static void setDropOffTime(String dropOffTime) {
        CarRental.dropOffTime = dropOffTime;
    }

    public static void setEstimatedPrice(String estimatedPrice) {
        CarRental.estimatedPrice = estimatedPrice;
    }

    public static void setIsApproved(String isApproved) {
        CarRental.isApproved = isApproved;
    }
}
