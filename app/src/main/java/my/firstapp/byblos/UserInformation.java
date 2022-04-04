package my.firstapp.byblos;

import com.google.firebase.database.DatabaseReference;

public class UserInformation {

    private String accountType;
    //private String userName;
    //private String firstLogin;

    public UserInformation () {

    }

    public UserInformation(String accountType) {

        this.accountType = accountType;

    }
    /*
    public UserInformation(String userName, String accountType, String firstLogin) {
        this.userName = userName;
        this.accountType = accountType;
        this.firstLogin = firstLogin;
    }
    */
    public String getAccountType() {
        return accountType;
    }

    /*
    public String getUserName() {
        return userName;
    }

    public String getFirstLogin() {
        return firstLogin;
    }

     */
}



