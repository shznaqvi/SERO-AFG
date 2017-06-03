package edu.aku.hassannaqvi.sero_afghanistan.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by hassan.naqvi on 10/25/2016.
 */

public class FormsContract {

    private final String projectName = "SERO - AFGHANISTAN";
    private final String surveyType = "SN";
    private String formDate = "";
    private String userName = "";
    private String appVer = "";
    private String ID = "";
    private String UID = "";
    private String istatus = "";
    private String studyid = "";
    private String tagId = "";
    private String sA = "";
    private String sB = "";
    private String sC = "";
    private String sD = "";
    private String sE = "";
    private String sF = "";
    private String sG = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsTime = "";
    private String gpsAcc = "";
    private String deviceID = "";
    private String synced = "";
    private String synced_date = "";

    public FormsContract() {
    }

    public FormsContract sync(JSONObject jsonObject) throws JSONException {
        this.ID = jsonObject.getString(singleForm.COLUMN_ID);
        this.UID = jsonObject.getString(singleForm.COLUMN_UID);

        this.userName = jsonObject.getString(singleForm.COLUMN_NAME_USERNAME);
        this.tagId = jsonObject.getString(singleForm.COLUMN_DEVICETAGID);

        this.studyid = jsonObject.getString(singleForm.COLUMN_STUDYID);
        this.appVer = jsonObject.getString(singleForm.COLUMN_APPVER);
        this.istatus = jsonObject.getString(singleForm.COLUMN_ISTATUS);

        this.sA = jsonObject.getString(singleForm.COLUMN_SA);
        this.sB = jsonObject.getString(singleForm.COLUMN_SB);
        this.sC = jsonObject.getString(singleForm.COLUMN_SC);
        this.sD = jsonObject.getString(singleForm.COLUMN_SD);
        this.sE = jsonObject.getString(singleForm.COLUMN_SE);
        this.sF = jsonObject.getString(singleForm.COLUMN_SF);
        this.sG = jsonObject.getString(singleForm.COLUMN_SG);

        this.gpsLat = jsonObject.getString(singleForm.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(singleForm.COLUMN_GPSLNG);
        this.gpsTime = jsonObject.getString(singleForm.COLUMN_GPSTIME);
        this.gpsAcc = jsonObject.getString(singleForm.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(singleForm.COLUMN_DEVICEID);
        this.synced = jsonObject.getString(singleForm.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(singleForm.COLUMN_SYNCED_DATE);


        return this;
    }

    public String getProjectName() {

        return projectName;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public String getTagId() {
        return tagId;
    }


    public void setIstatus(String Istatus) {
        this.istatus = Istatus;
    }

    public String getIstatus() {
        return istatus;
    }


    public void setstudyid(String studyid) {
        this.studyid = studyid;
    }

    public String getstudyid() {
        return studyid;
    }


    public void setAppVer(String appVer) {
        this.appVer = appVer;
    }

    public String getAppVer() {
        return appVer;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }


    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }

    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }

    public String getsC() {
        return sC;
    }

    public void setsC(String sC) {
        this.sC = sC;
    }

    public String getsD() {
        return sD;
    }

    public void setsD(String sD) {
        this.sD = sD;
    }

    public String getsE() {
        return sE;
    }

    public void setsE(String sE) {
        this.sE = sE;
    }

    public String getsF() {
        return sF;
    }

    public void setsF(String sF) {
        this.sF = sF;
    }

    public String getsG() {
        return sG;
    }

    public void setsG(String sG) {
        this.sG = sG;
    }


    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
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

    public FormsContract hydrate(Cursor cursor) {
        this.ID = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_ID));
        this.UID = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_UID));

        this.userName = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_USERNAME));
        this.tagId = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_DEVICETAGID));
        this.studyid = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_STUDYID));


        this.appVer = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_APPVER));
        this.istatus = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_ISTATUS));

        this.sA = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_SA));
        this.sB = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_SB));
        this.sC = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_SC));
        this.sD = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_SD));
        this.sE = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_SE));
        this.sF = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_SF));
        this.sG = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_SG));

        this.gpsLat = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_GPSLNG));
        this.gpsTime = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_GPSTIME));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_DEVICEID));
        this.synced = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_SYNCED_DATE));


        return this;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(singleForm.COLUMN_PROJECT_NAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(singleForm.COLUMN_SURVEY_TYPE, this.surveyType == null ? JSONObject.NULL : this.surveyType);
        json.put(singleForm.COLUMN_ID, this.ID == null ? JSONObject.NULL : this.ID);
        json.put(singleForm.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);


        json.put(singleForm.COLUMN_NAME_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
        json.put(singleForm.COLUMN_DEVICETAGID, this.tagId == null ? JSONObject.NULL : this.tagId);

        json.put(singleForm.COLUMN_STUDYID, this.studyid == null ? JSONObject.NULL : this.studyid);
        json.put(singleForm.COLUMN_APPVER, this.appVer == null ? JSONObject.NULL : this.appVer);
        json.put(singleForm.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);


        json.put(singleForm.COLUMN_SA, this.sA == null ? JSONObject.NULL : this.sA);
        json.put(singleForm.COLUMN_SB, this.sB == null ? JSONObject.NULL : this.sB);
        json.put(singleForm.COLUMN_SC, this.sC == null ? JSONObject.NULL : this.sC);
        json.put(singleForm.COLUMN_SD, this.sD == null ? JSONObject.NULL : this.sD);
        json.put(singleForm.COLUMN_SE, this.sE == null ? JSONObject.NULL : this.sE);
        json.put(singleForm.COLUMN_SF, this.sF == null ? JSONObject.NULL : this.sF);
        json.put(singleForm.COLUMN_SG, this.sG == null ? JSONObject.NULL : this.sG);

        json.put(singleForm.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(singleForm.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(singleForm.COLUMN_GPSTIME, this.gpsTime == null ? JSONObject.NULL : this.gpsTime);
        json.put(singleForm.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(singleForm.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(singleForm.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(singleForm.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);

        return json;
    }

    public JSONObject jsonMerge(JSONObject o1, JSONObject o2) throws JSONException {

        JSONObject jm = new JSONObject();

        //I assume that your two JSONObjects are o1 and o2
        JSONObject mergedObj = new JSONObject();

        Iterator i1 = o1.keys();
        Iterator i2 = o2.keys();
        String tmp_key;
        while (i1.hasNext()) {
            tmp_key = (String) i1.next();
            mergedObj.put(tmp_key, o1.get(tmp_key));
        }
        while (i2.hasNext()) {
            tmp_key = (String) i2.next();
            mergedObj.put(tmp_key, o2.get(tmp_key));
        }

        return mergedObj;
    }

    public static abstract class singleForm implements BaseColumns {

        public static final String TABLE_NAME = "forms";
        public static final String URI = "/syncforms.php";

        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectname";
        public static final String COLUMN_SURVEY_TYPE = "surveytype";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_HHDT = "formDate";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_DEVICETAGID = "tagId";
        public static final String COLUMN_APPVER = "appver";

        public static final String COLUMN_STUDYID = "studyid";

        public static final String COLUMN_SA = "sa";
        public static final String COLUMN_SB = "sb";
        public static final String COLUMN_SC = "sc";
        public static final String COLUMN_SD = "sd";
        public static final String COLUMN_SE = "se";
        public static final String COLUMN_SF = "sf";
        public static final String COLUMN_SG = "sg";

        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSTIME = "gpstime";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";

    }
}