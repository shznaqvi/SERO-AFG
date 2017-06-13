package edu.aku.hassannaqvi.sero_afghanistan.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by javed.khan on 6/12/2017.
 */

public class ProvinceContract {

    private static final String TAG = "PROVINCE_CONTRACT";
    String _ID;
    String ROW_PROVCODE;
    String ROW_PROVINCE;

    public ProvinceContract() {
        // Default Constructor
    }

    public ProvinceContract hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(ProvinceEntry._ID));
        this.ROW_PROVCODE = cursor.getString(cursor.getColumnIndex(ProvinceEntry.ROW_PROVCODE));
        this.ROW_PROVINCE = cursor.getString(cursor.getColumnIndex(ProvinceEntry.ROW_PROVINCE));

        return this;




    }


    public ProvinceContract sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(ProvinceEntry._ID);
        this.ROW_PROVCODE = jsonObject.getString(ProvinceEntry.ROW_PROVCODE);
        this.ROW_PROVINCE = jsonObject.getString(ProvinceEntry.ROW_PROVINCE);

        return this;
    }


    public ProvinceContract(String provcode, String province) {
        this.ROW_PROVCODE = provcode;
        this.ROW_PROVINCE = province;
    }

    public String getProvince() {
        return this.ROW_PROVINCE;
    }

    public void setProvince(String province) {
        this.ROW_PROVINCE = province;
    }


    public String getProvCode() {
        return this.ROW_PROVCODE;
    }

    public void setProvCode(String provcode) {
        this.ROW_PROVCODE = provcode;
    }


    public String getID() {
        return this._ID;
    }

    public void setID(String id) {
        this._ID = id;
    }


    public static abstract class ProvinceEntry implements BaseColumns {

        public static final String URI = "/getprovince.php";

        public static final String TABLE_NAME = "prov";
        public static final String _ID = "id";
        public static final String ROW_PROVCODE = "provcode";
        public static final String ROW_PROVINCE = "provna";
    }
}