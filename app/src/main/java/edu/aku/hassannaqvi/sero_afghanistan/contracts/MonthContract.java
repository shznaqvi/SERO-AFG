package edu.aku.hassannaqvi.sero_afghanistan.contracts;

/**
 * Created by javed.khan on 10/10/2017.
 */

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class MonthContract {

    private static final String TAG = "MonthNameContract";
    String COLUMN_ID;
    String COLUMN_MONTHNAME;


    public MonthContract() {
        // Default Constructor
    }

    public MonthContract(String id, String monthname) {
        this.COLUMN_ID = id;
        this.COLUMN_MONTHNAME = monthname;
    }

    public String getID() {
        return this.COLUMN_ID;
    }

    public void setID(String id) {
        this.COLUMN_ID = id;
    }

    public String getMonthName() {
        return this.COLUMN_MONTHNAME;
    }

    public void setMonthName(String monthname) {
        this.COLUMN_MONTHNAME = monthname;
    }
}