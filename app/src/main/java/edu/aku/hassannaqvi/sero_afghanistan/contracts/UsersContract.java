package edu.aku.hassannaqvi.sero_afghanistan.contracts;

import android.provider.BaseColumns;

/**
 * Created by hassan.naqvi on 4/27/2016.
 */
public class UsersContract {
    private static final String TAG = "Users_CONTRACT";
    Long _ID;
    String ROW_USERNAME;
    String ROW_PASSWORD;
    String ROW_USERSTATUS;
    String ROW_ISADMIN;

    public UsersContract() {
        // Default Constructor
    }

    public UsersContract(String username, String password, String userstatus, String isadmin) {
        this.ROW_PASSWORD = password;
        this.ROW_USERNAME = username;
        this.ROW_USERSTATUS = userstatus;
        this.ROW_ISADMIN = isadmin;
    }

    public Long getUserID() {
        return this._ID;
    }

    public void setId(int id) {
        this._ID = Long.valueOf(id);
    }

    public String getUserName() {
        return this.ROW_USERNAME;
    }

    public void setUserName(String username) {
        this.ROW_USERNAME = username;
    }

    public String getPassword() {
        return this.ROW_PASSWORD;
    }

    public void setPassword(String password) {
        this.ROW_PASSWORD = password;
    }


    public String getUserStatus() {
        return this.ROW_USERSTATUS;
    }

    public void setUserStatus(String userstatus) {
        this.ROW_USERSTATUS = userstatus;
    }


    public String getIsAdmin() {
        return this.ROW_ISADMIN;
    }

    public void setIsAdmin(String isadmin) {
        this.ROW_ISADMIN = isadmin;
    }


    public static abstract class singleUser implements BaseColumns {

        public static final String URI = "/getusers.php";

        public static final String TABLE_NAME = "users";
        public static final String _ID = "id";
        public static final String ROW_USERNAME = "username";
        public static final String ROW_PASSWORD = "password";
        public static final String ROW_USERSTATUS = "userstatus";
        public static final String ROW_ISADMIN = "isadmin";


    }
}