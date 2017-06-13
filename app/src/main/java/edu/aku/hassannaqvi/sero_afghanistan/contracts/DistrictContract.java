package edu.aku.hassannaqvi.sero_afghanistan.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by javed.khan on 6/12/2017.
 */

public class DistrictContract {

    private static final String TAG = "DIST_CONTRACT";
    Long _ID;
    String ROW_PROVCODE;
    String ROW_DISTCODE;
    String ROW_DISTNME;

    public DistrictContract() {
        // Default Constructor
    }

    public DistrictContract(String procode, String distcode, String distnme) {
        this.ROW_PROVCODE = procode;
        this.ROW_DISTCODE = distcode;
        this.ROW_DISTNME = distnme;
    }

    public DistrictContract hydrate(Cursor cursor) {
        this.ROW_PROVCODE = cursor.getString(cursor.getColumnIndex(DistrictEntry.ROW_PROVCODE));
        this.ROW_DISTCODE = cursor.getString(cursor.getColumnIndex(DistrictEntry.ROW_DISTCODE));
        this.ROW_DISTNME = cursor.getString(cursor.getColumnIndex(DistrictEntry.ROW_DISTNME));

        return this;
    }

    public DistrictContract sync(JSONObject jsonObject) throws JSONException {
        this.ROW_PROVCODE = jsonObject.getString(DistrictEntry.ROW_PROVCODE);
        this.ROW_DISTCODE = jsonObject.getString(DistrictEntry.ROW_DISTCODE);
        this.ROW_DISTNME = jsonObject.getString(DistrictEntry.ROW_DISTNME);

        return this;
    }


    public String getProvCode() {
        return ROW_PROVCODE;
    }

    public void setProvCode(String provcode) {
        this.ROW_PROVCODE = provcode;
    }


    public String getDistCode() {
        return ROW_DISTCODE;
    }

    public void setDistCode(String distcode) {
        this.ROW_DISTCODE = distcode;
    }


    public String getDistNme() {
        return ROW_DISTNME;
    }

    public void setDistNme(String distnme) {
        this.ROW_DISTNME = distnme;
    }


    public static abstract class DistrictEntry implements BaseColumns {

        public static final String URI = "/getdistricts.php";

        public static final String TABLE_NAME = "dist";
        public static final String _ID = "id";
        public static final String ROW_PROVCODE = "provcode";
        public static final String ROW_DISTCODE = "distcode";
        public static final String ROW_DISTNME = "distna";

    }
}