package my.firstapp.byblos;

public class Employee {

    //public String address;
    //public String currentUserId;
    public String workingHoursStart;
    public String workingHoursEnd;
    public String workingDaysStart;
    public String workingDaysEnd;
    public String phoneNumber;

    public Employee() {

    }

    public Employee (String workingHoursStart,
                 String workingHoursEnd, String workingDaysStart, String workingDaysEnd, String phoneNumber) {
        //this.address = address;
        //this.currentUserId = currentUserId;
        this.workingHoursStart = workingHoursStart;
        this.workingHoursEnd = workingHoursEnd;
        this.workingDaysStart = workingDaysStart;
        this.workingDaysEnd = workingDaysEnd;
        this.phoneNumber = phoneNumber;
    }

    //public void setAddress (String address) { this.address = address; }

    public void setWorkingHoursStart (String workingHoursStart) { this.workingHoursStart = workingHoursStart; }

    public void setWorkingHoursEnd (String workingHoursEnd) { this.workingHoursEnd = workingHoursEnd; }

    public void setWorkingDaysStart (String workingDaysStart) { this.workingDaysStart = workingDaysStart; }

    public void setWorkingDaysEnd (String workingDaysEnd) { this.workingDaysEnd = workingDaysEnd; }

    public void setPhoneNumber (String phoneNumber) { this.phoneNumber = phoneNumber; }

    //public String getAddress() { return this.address; }

    public String getWorkingHoursStart() { return this.workingHoursStart; }

    public String getWorkingHoursEnd() { return this.workingHoursEnd; }

    public String getWorkingDaysStart() { return this.workingDaysStart; }

    public String getWorkingDaysEnd() { return this.workingDaysEnd; }

    public String getPhoneNumber() { return this.phoneNumber; }

}
