package my.firstapp.byblos;

public class User {

    public String userName;
    //public String currentUserId;
    public String userFirstTime;
    public String userAccountType;
    public String zipCode;
    public String isVerified;

    public User() {

    }

    public User (String currentUserName, String currentUserAccountType,
                        String currentUserFirstTime, String zipCode, String isVerified) {
        this.userName = currentUserName;
        //this.currentUserId = currentUserId;
        this.userFirstTime = currentUserFirstTime;
        this.userAccountType = currentUserAccountType;
        this.zipCode = zipCode;
        this.isVerified = isVerified;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }

    public void setUserFirstTime (String userFirstTime) {
        this.userFirstTime = userFirstTime;
    }

    public void setUserAccountType (String userAccountType) {
        this.userAccountType = userAccountType;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }

    public String getIsVerified() {
        return this.isVerified;
    }

    public String getUserName () {
        return this.userName;
    }

    public String getUserFirstTime () {
        return this.userFirstTime;
    }

    public String getUserAccountType () {
        return this.userAccountType;
    }

    public String getZipCode() {
        return this.zipCode;
    }
}
