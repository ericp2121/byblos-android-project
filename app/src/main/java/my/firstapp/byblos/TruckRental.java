package my.firstapp.byblos;

public class TruckRental {
    public static String customerFirstName;
    public static String customerLastName;
    public static String customerBirthDate;
    public static String driverLicenseType;
//    public static String truckType;
    public static String pickUpDate;
    public static String dropOffDate;
    public static String pickUpTime;
    public static String dropOffTime;
    public static String estimatedPrice;
    public static String rangeDriven;
    public static String areaDrivenIn;
    public static String isApproved;

    public TruckRental() {

    }

    public TruckRental(String customerFirstName, String customerLastName, String customerBirthDate,
                     String driverLicenseType, String pickUpDate,
                     String dropOffDate, String pickUpTime, String dropOffTime, String estimatedPrice,
                       String rangeDriven, String areaDrivenIn, String isApproved) {
        TruckRental.customerFirstName = customerFirstName;
        TruckRental.customerLastName = customerLastName;
        TruckRental.customerBirthDate = customerBirthDate;
        TruckRental.driverLicenseType = driverLicenseType;
//        TruckRental.truckType = truckType;
        TruckRental.pickUpDate = pickUpDate;
        TruckRental.dropOffDate = dropOffDate;
        TruckRental.pickUpTime = pickUpTime;
        TruckRental.dropOffTime = dropOffTime;
        TruckRental.estimatedPrice = estimatedPrice;
        TruckRental.rangeDriven = rangeDriven;
        TruckRental.areaDrivenIn = areaDrivenIn;
        TruckRental.isApproved = isApproved;
    }

    public String getCustomerFirstName() {return customerFirstName;}

    public String getCustomerLastName() {return customerLastName;}

    public String getCustomerBirthDate() {return customerBirthDate;}

    public String getDriverLicenseType() {return driverLicenseType;}

//    public String getTruckType() {return TruckRental.truckType;}

    public String getPickUpDate() {return TruckRental.pickUpDate;}

    public String getDropOffDate() {return TruckRental.dropOffDate;}

    public String getPickUpTime() {return TruckRental.pickUpTime;}

    public String getDropOffTime() {return TruckRental.dropOffTime;}

    public String getEstimatedPrice() {return TruckRental.estimatedPrice;}

    public String getRangeDriven() {return TruckRental.rangeDriven;}

    public String getAreaDrivenIn() {return TruckRental.areaDrivenIn;}

    public String getIsApproved() {
        return TruckRental.isApproved;
    }

    public static void setCustomerFirstName(String customerFirstName) {
        TruckRental.customerFirstName = customerFirstName;
    }

    public static void setCustomerLastName(String customerLastName) {
        TruckRental.customerLastName = customerLastName;
    }

    public static void setCustomerBirthDate(String customerBirthDate) {
        TruckRental.customerBirthDate = customerBirthDate;
    }

    public static void setDriverLicenseType(String driverLicenseType) {
        TruckRental.driverLicenseType = driverLicenseType;
    }

//    public static void setTruckType(String truckType) {
//        TruckRental.truckType= truckType;
//    }

    public static void setPickUpDate(String pickUpDate) {
        TruckRental.pickUpDate = pickUpDate;
    }

    public static void setDropOffDate(String dropOffDate) {
        TruckRental.dropOffDate = dropOffDate;
    }

    public static void setPickUpTime(String pickUpTime) {
        TruckRental.pickUpTime = pickUpTime;
    }

    public static void setDropOffTime(String dropOffTime) {
        TruckRental.dropOffTime = dropOffTime;
    }

    public static void setEstimatedPrice(String estimatedPrice) {
        TruckRental.estimatedPrice = estimatedPrice;
    }

    public static void setRangeDriven(String rangeDriven) {
        TruckRental.rangeDriven = rangeDriven;
    }

    public static void setAreaDrivenIn(String areaDrivenIn) {
        TruckRental.areaDrivenIn = areaDrivenIn;
    }

    public static void setIsApproved(String isApproved) {
        TruckRental.isApproved = isApproved;
    }
}
