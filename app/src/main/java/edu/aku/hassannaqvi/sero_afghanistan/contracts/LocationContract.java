package edu.aku.hassannaqvi.sero_afghanistan.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by javed.khan on 9/19/2017.
 */

public class LocationContract {

    private final String projectName = "SERO-AFG";
    private String _ID = "";
    private String UID = "";
    private String deviceId = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer
    private String sH = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";

    public LocationContract() {

    }


    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getsH() {
        return sH;
    }

    public void setsH(String sH) {
        this.sH = sH;
    }

    public String getDevicetagID() {

        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public LocationContract Sync(JSONObject jsonObject) throws JSONException {

        this._ID = jsonObject.getString(LocationTable.COLUMN_ID);
        this.UID = jsonObject.getString(LocationTable.COLUMN_UID);
        this.formDate = jsonObject.getString(LocationTable.COLUMN_FORMDATE);
        this.deviceId = jsonObject.getString(LocationTable.COLUMN_DEVICEID);
        this.user = jsonObject.getString(LocationTable.COLUMN_USER);
        this.sH = jsonObject.getString(LocationTable.COLUMN_SH);
        this.synced = jsonObject.getString(LocationTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(LocationTable.COLUMN_SYNCED_DATE);
        this.devicetagID = jsonObject.getString(LocationTable.COLUMN_DEVICETAGID);

        return this;

    }

    public LocationContract Hydrate(Cursor cursor) {

        this._ID = cursor.getString(cursor.getColumnIndex(LocationTable.COLUMN_ID));
        this.UID = cursor.getString(cursor.getColumnIndex(LocationTable.COLUMN_UID));
        this.formDate = cursor.getString(cursor.getColumnIndex(LocationTable.COLUMN_FORMDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(LocationTable.COLUMN_DEVICEID));
        this.user = cursor.getString(cursor.getColumnIndex(LocationTable.COLUMN_USER));
        this.sH = cursor.getString(cursor.getColumnIndex(LocationTable.COLUMN_SH));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(LocationTable.COLUMN_DEVICETAGID));

        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(LocationTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(LocationTable.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        //json.put(LocationTable.COLUMN_PROJECT_NAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(LocationTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(LocationTable.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(LocationTable.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(LocationTable.COLUMN_SH, this.sH == null ? JSONObject.NULL : new JSONObject(this.sH));
        json.put(LocationTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);

        return json;
    }

    public static abstract class LocationTable implements BaseColumns {

        public static final String TABLE_NAME = "location";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";

        //public static final String COLUMN_PROJECT_NAME = "project_name";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_SH = "sh";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "sync_date";
        public static final String COLUMN_DEVICETAGID = "tagid";


        public static String _URL = "/location.php";
    }

}