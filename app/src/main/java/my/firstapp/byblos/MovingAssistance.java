package my.firstapp.byblos;

public class MovingAssistance {
    public static String customerFirstName;
    public static String customerLastName;
    public static String customerBirthDate;
    public static String customerAddress;
    //    public static String truckType;
    public static String customerEmailId;
    public static String startingAddress;
    public static String endingAddress;
    public static String numberOfMoversRequested;
    public static String estimatedPrice;
    public static String numberOfBoxes;
    public static String isApproved;
//    public static String areaDrivenIn;

    public MovingAssistance() {

    }

    public MovingAssistance(String customerFirstName, String customerLastName, String customerBirthDate,
                       String customerAddress, String customerEmailId,
                       String startingAddress, String endingAddress, String numberOfMoversRequested,
                            String estimatedPrice, String numberOfBoxes, String isApproved) {
        MovingAssistance.customerFirstName = customerFirstName;
        MovingAssistance.customerLastName = customerLastName;
        MovingAssistance.customerBirthDate = customerBirthDate;
        MovingAssistance.customerAddress = customerAddress;
//        MovingAssistance.truckType = truckType;
        MovingAssistance.customerEmailId = customerEmailId;
        MovingAssistance.startingAddress = startingAddress;
        MovingAssistance.endingAddress = endingAddress;
        MovingAssistance.numberOfMoversRequested = numberOfMoversRequested;
        MovingAssistance.estimatedPrice = estimatedPrice;
        MovingAssistance.numberOfBoxes = numberOfBoxes;
//        MovingAssistance.areaDrivenIn = areaDrivenIn;
        MovingAssistance.isApproved = isApproved;
    }

    public String getCustomerFirstName() {return customerFirstName;}

    public String getCustomerLastName() {return customerLastName;}

    public String getCustomerBirthDate() {return customerBirthDate;}

    public String getCustomerAddress() {return customerAddress;}

//    public String getTruckType() {return MovingAssistance.truckType;}

    public String getCustomerEmailId() {return MovingAssistance.customerEmailId;}

    public String getStartingAddress() {return MovingAssistance.startingAddress;}

    public String getEndingAddress() {return MovingAssistance.endingAddress;}

    public String getNumberOfMoversRequested() {return MovingAssistance.numberOfMoversRequested;}

    public String getEstimatedPrice() {return MovingAssistance.estimatedPrice;}

    public String getNumberOfBoxes() {return MovingAssistance.numberOfBoxes;}

//    public String getAreaDrivenIn() {return MovingAssistance.areaDrivenIn;}


    public String getIsApproved() {
        return isApproved;
    }

    public static void setCustomerFirstName(String customerFirstName) {
        MovingAssistance.customerFirstName = customerFirstName;
    }

    public static void setCustomerLastName(String customerLastName) {
        MovingAssistance.customerLastName = customerLastName;
    }

    public static void setCustomerBirthDate(String customerBirthDate) {
        MovingAssistance.customerBirthDate = customerBirthDate;
    }

    public static void setCustomerAddress(String customerAddress) {
        MovingAssistance.customerAddress = customerAddress;
    }

//    public static void setTruckType(String truckType) {
//        MovingAssistance.truckType= truckType;
//    }

    public static void setCustomerEmailId(String customerEmailId) {
        MovingAssistance.customerEmailId = customerEmailId;
    }

    public static void setStartingAddress(String startingAddress) {
        MovingAssistance.startingAddress = startingAddress;
    }

    public static void setEndingAddress(String endingAddress) {
        MovingAssistance.endingAddress = endingAddress;
    }

    public static void setNumberOfMoversRequested(String numberOfMoversRequested) {
        MovingAssistance.numberOfMoversRequested = numberOfMoversRequested;
    }

    public static void setEstimatedPrice(String estimatedPrice) {
        MovingAssistance.estimatedPrice = estimatedPrice;
    }

    public static void setNumberOfBoxes(String numberOfBoxes) {
        MovingAssistance.numberOfBoxes = numberOfBoxes;
    }

//    public static void setAreaDrivenIn(String areaDrivenIn) {
//        MovingAssistance.areaDrivenIn = areaDrivenIn;
//    }


    public static void setIsApproved(String isApproved) {
        MovingAssistance.isApproved = isApproved;
    }
}
