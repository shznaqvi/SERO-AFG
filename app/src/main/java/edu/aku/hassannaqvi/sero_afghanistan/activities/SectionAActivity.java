package edu.aku.hassannaqvi.sero_afghanistan.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.DistrictContract;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.FormsContract;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.ProvinceContract;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;
import io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText;


public class SectionAActivity extends AppCompatActivity {

    private static final String TAG = SectionAActivity.class.getSimpleName();

    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;
    @BindView(R.id.studyid)
    EditText studyid;

    @BindView(R.id.studycode)
    EditText studycode;

    @BindView(R.id.dov)
    DatePickerInputEditText dov;

    @BindView(R.id.mna1)
    EditText mna1;

    @BindView(R.id.mna2)
    EditText mna2;

    @BindView(R.id.mna3)
    EditText mna3;

    @BindView(R.id.mna4)
    DatePickerInputEditText mna4;

    @BindView(R.id.mna5months)
    EditText mna5months;

    @BindView(R.id.mna5days)
    EditText mna5days;

    @BindView(R.id.mna6)
    RadioGroup mna6;
    @BindView(R.id.mna6_a)
    RadioButton mna6A;
    @BindView(R.id.mna6_b)
    RadioButton mna6B;
    @BindView(R.id.mnb1)
    EditText mnb1;

    @BindView(R.id.mnb2)
    Spinner mnb2;

    @BindView(R.id.mnb3)
    Spinner mnb3;

    @BindView(R.id.mnb4name)
    EditText mnb4name;

    @BindView(R.id.mnb4address)
    EditText mnb4address;
    /*@BindView(R.id.mnb5walk)
    EditText mnb5walk;*/

    @BindView(R.id.mnb5mints)
    EditText mnb5mints;

    @BindView(R.id.mnb5km)
    EditText mnb5km;


   /* @BindView(R.id.mnb6name)
    EditText mnb6name;

    @BindView(R.id.mnb6code)
    EditText mnb6code;*/


    @BindView(R.id.mnb7name)
    EditText mnb7name;

    /*@BindView(R.id.mnb7code)
    EditText mnb7code;*/

    @BindView(R.id.mnc1)
    EditText mnc1;

    @BindView(R.id.mnc2)
    RadioGroup mnc2;
    @BindView(R.id.mnc2a)
    RadioButton mnc2a;
    @BindView(R.id.mnc2b)
    RadioButton mnc2b;
    @BindView(R.id.mnc2c)
    RadioButton mnc2c;
    @BindView(R.id.mnc2d)
    RadioButton mnc2d;
    @BindView(R.id.mnc2e)
    RadioButton mnc2e;
    @BindView(R.id.mnc288)
    RadioButton mnc288;
    @BindView(R.id.fldGrpmnc2x)
    LinearLayout fldGrpmnc2x;

    @BindView(R.id.mnc2x)
    EditText mnc2x;
    @BindView(R.id.mnc3years)
    EditText mnc3years;

    @BindView(R.id.mnc4)
    RadioGroup mnc4;
    @BindView(R.id.mnc4a)
    RadioButton mnc4a;
    @BindView(R.id.mnc4b)
    RadioButton mnc4b;
    @BindView(R.id.mnc4c)
    RadioButton mnc4c;
    @BindView(R.id.mnc4d)
    RadioButton mnc4d;
    @BindView(R.id.mnc4e)
    RadioButton mnc4e;
    @BindView(R.id.mnc4f)
    RadioButton mnc4f;
    @BindView(R.id.mnc4g)
    RadioButton mnc4g;
    @BindView(R.id.mnc4h)
    RadioButton mnc4h;
    @BindView(R.id.mnc488)
    RadioButton mnc488;
    @BindView(R.id.fldGrpmnc4x)
    LinearLayout fldGrpmnc4x;
    @BindView(R.id.mnc4x)
    EditText mnc4x;
    @BindView(R.id.fldGrpbtn)
    LinearLayout fldGrpbtn;

    @BindView(R.id.dcbdob)
    RadioGroup dcbdob;
    @BindView(R.id.dcbdob01)
    RadioButton dcbdob01;
    @BindView(R.id.dcbAge02)
    RadioButton dcbAge02;
    @BindView(R.id.fldGrpdcbdob)
    LinearLayout fldGrpdcbdob;
    @BindView(R.id.fldGrpdcpAge)
    LinearLayout fldGrpdcpAge;

    int rdo_mna6;
    String var_mna6;

    int rdo_mnc2;
    String var_mnc2;

    int rdo_mnc4;
    String var_mnc4;

    String dateToday;
    String dateToday1;
    String date6Months;
    String date11Months;
    String date36Months;
    String date48Months;
    String minDate;

    Calendar now = Calendar.getInstance();

    List<String> dist, prov;

    Map<String, String> prov_map, dist_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_a);
        ButterKnife.bind(this);

        mna4.setManager(getSupportFragmentManager());
        dov.setManager(getSupportFragmentManager());


        dateToday = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());


        date6Months = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - (AppMain.MILLISECONDS_IN_6_MONTHS));
        date11Months = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - (AppMain.MILLISECONDS_IN_11_MONTHS));
        date36Months = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - (AppMain.MILLISECONDS_IN_36_MONTHS));
        date48Months = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - (AppMain.MILLISECONDS_IN_48_MONTHS));

        dov.setMinDate("01/06/2017");
        dov.setMaxDate(dateToday);

        studycode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Integer.valueOf(studycode.getText().toString().isEmpty() ? "0" : studycode.getText().toString()) == 1) {
                    mna4.setMaxDate(date6Months);
                    mna4.setMinDate(date11Months);
                } else {
                    mna4.setMaxDate(date36Months);
                    mna4.setMinDate(date48Months);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        prov = new ArrayList<>();
        dist = new ArrayList<>();

        prov_map = new HashMap<String, String>();
        dist_map = new HashMap<String, String>();

        final DatabaseHelper db = new DatabaseHelper(this);

        Collection<ProvinceContract> arr_province = new ArrayList<>();
        arr_province = db.getAllProvinces();

        prov.add("...");
        prov_map.put("...", "...");

        for (ProvinceContract m : arr_province) {
            prov.add(m.getProvince());
            prov_map.put(m.getProvince(), m.getProvCode());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(SectionAActivity.this,
                android.R.layout.simple_spinner_item, prov);
        adapter.setDropDownViewResource(android.R.layout.
                simple_dropdown_item_1line);
        mnb3.setAdapter(adapter);


        mnb3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub

                dist.clear();

                String item = mnb3.getSelectedItem().toString();
                //var.setClusterName(item);

                Collection<DistrictContract> arr_districts = new ArrayList<>();
                arr_districts = db.getAllDistrictsByProvince(prov_map.get(item));

                dist.add("...");
                dist_map.put("...", "...");

                for (DistrictContract dst : arr_districts) {
                    dist.add(dst.getDistNme());
                    dist_map.put(dst.getDistNme(), dst.getDistCode());
                }


                ArrayAdapter<String> adapter1 = new ArrayAdapter<>(SectionAActivity.this,
                        android.R.layout.simple_spinner_item, dist);
                adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                mnb2.setAdapter(adapter1);

            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        mnc2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (mnc288.isChecked()) {
                    fldGrpmnc2x.setVisibility(View.VISIBLE);
                    mnc2x.requestFocus();
                } else {
                    mnc2x.setText(null);
                    fldGrpmnc2x.setVisibility(View.GONE);
                }
            }
        });


        mnc4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (mnc488.isChecked()) {
                    fldGrpmnc4x.setVisibility(View.VISIBLE);
                    mnc4x.requestFocus();
                } else {
                    mnc4x.setText(null);
                    fldGrpmnc4x.setVisibility(View.GONE);
                }
            }
        });

        dcbdob.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (dcbdob01.isChecked()) {
                    fldGrpdcbdob.setVisibility(View.VISIBLE);
                    fldGrpdcpAge.setVisibility(View.GONE);
                    mna5months.setText(null);
                    mna5days.setText(null);
                } else {
                    fldGrpdcpAge.setVisibility(View.VISIBLE);
                    fldGrpdcbdob.setVisibility(View.GONE);

                    mna4.setText(null);
                }
            }
        });


    }

    @OnClick(R.id.btnNext)
    void SaveData() {

        DatabaseHelper db = new DatabaseHelper(this);

        if (ValidateForm()) {

            if (AppMain.flag) {
                if (!db.IsStudyid_Exists(studyid.getText().toString())) {

                    try {
                        SaveDraft();
                        SaveDraftA();
                        SaveDraftB();
                        SaveDraftC();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } finally {

                    }

                    if (UpdateDB()) {
                        Toast.makeText(this, "Starting Section D", Toast.LENGTH_SHORT).show();

                        AppMain.studyCode = studycode.getText().toString();
                        AppMain.studyid = studyid.getText().toString();


                        finish();
                        Intent secD = new Intent(this, SectionDActivity.class);
                        //AppMain.chTotal = Integer.valueOf(mna13.getText().toString()) - 1; // exclude index child
                        startActivity(secD);
                    } else {
                        Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Study ID already exists ", Toast.LENGTH_SHORT).show();
                    studyid.requestFocus();
                }
            } else {
                finish();
//                startActivity(new Intent(this, MainActivity.class));
            }
        }
    }


    @OnClick(R.id.btn_End)
    void endInterview() {

        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                Intent endSec = new Intent(this, EndingActivity.class);
                endSec.putExtra("complete", false);
                startActivity(endSec);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {

        Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        // 1. INSERT FORM
        rowId = db.addForm(AppMain.fc);

        AppMain.fc.setID(String.valueOf(rowId));

        if (rowId != null) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            AppMain.fc.setUID(
                    (AppMain.fc.getDeviceID() + AppMain.fc.getID()));
            Toast.makeText(this, "Current Form No: " + AppMain.fc.getUID(), Toast.LENGTH_SHORT).show();
            // 2. UPDATE FORM ROWID
            int updcount = db.updateSectionsABC();

            if (updcount == 1) {
                Toast.makeText(this, "Updating Database ABC Sections ... Successful!", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                Toast.makeText(this, "Updating Database ABC Sections ... ERROR!", Toast.LENGTH_SHORT).show();
                return false;
            }

        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private boolean SaveDraft() throws JSONException {

        Toast.makeText(this, "Validating Section A, B and C", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        AppMain.fc = new FormsContract();

        AppMain.fc.setTagId(sharedPref.getString("tagName", null));
        AppMain.fc.setDeviceID(AppMain.deviceId);
        AppMain.fc.setUserName(AppMain.username);
        AppMain.fc.setFormDate(dtToday);
        AppMain.fc.setdov(dov.getText().toString());
        AppMain.fc.setstudycode(studycode.getText().toString());
        AppMain.fc.setstudyid(studyid.getText().toString());

        setGPS();

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

        return true;
    }

    private boolean SaveDraftA() throws JSONException {

        JSONObject sA = new JSONObject();

        sA.put("hfacility", AppMain.hfacility);
        sA.put("mna1", mna1.getText().toString());
        sA.put("mna2", mna2.getText().toString());
        sA.put("mna3", mna3.getText().toString());
        sA.put("mna4", mna4.getText().toString());
        sA.put("dov", dov.getText().toString());
        sA.put("mna5days", mna5days.getText().toString());
        sA.put("mna5months", mna5months.getText().toString());


        sA.put("mna6", mna6A.isChecked() ? "1" : mna6B.isChecked() ? "2" : "0");

        AppMain.fc.setsA(String.valueOf(sA));


        return true;
    }

    private boolean SaveDraftB() throws JSONException {

        JSONObject sB = new JSONObject();

        sB.put("mnb1", mnb1.getText().toString());
        sB.put("mnb2", dist_map.get(mnb2.getSelectedItem().toString()));
        sB.put("mnb3", prov_map.get(mnb3.getSelectedItem().toString()));

        AppMain.provcode = prov_map.get(mnb3.getSelectedItem().toString());
        AppMain.distcode = dist_map.get(mnb2.getSelectedItem().toString());


        sB.put("mnb4name", mnb4name.getText().toString());
        sB.put("mnb4address", mnb4address.getText().toString());
/*
        sB.put("mnb5walk", mnb5walk.getText().toString());
*/
        sB.put("mnb5mints", mnb5mints.getText().toString());
        sB.put("mnb5km", mnb5km.getText().toString());

        /*sB.put("mnb6name", mnb6name.getText().toString());
        sB.put("mnb6code", mnb6code.getText().toString());*/

        sB.put("mnb7name", mnb7name.getText().toString());
/*
        sB.put("mnb7code", mnb7code.getText().toString());
*/

        AppMain.fc.setsB(String.valueOf(sB));

        return true;
    }

    private boolean SaveDraftC() throws JSONException {

        JSONObject sC = new JSONObject();

        sC.put("mnc1", mnc1.getText().toString());


        sC.put("mnc2", mnc2a.isChecked() ? "1"
                : mnc2b.isChecked() ? "2"
                : mnc2c.isChecked() ? "3"
                : mnc2d.isChecked() ? "4"
                : mnc2e.isChecked() ? "5"
                : mnc288.isChecked() ? "88"
                : "0"
        );

        sC.put("mnc2x", mnc2x.getText().toString());
        sC.put("mnc3years", mnc3years.getText().toString());


        sC.put("mnc4", mnc4a.isChecked() ? "1" : mnc4b.isChecked() ? "2"
                : mnc4c.isChecked() ? "3"
                : mnc4d.isChecked() ? "4"
                : mnc4e.isChecked() ? "5"
                : mnc4f.isChecked() ? "6"
                : mnc4g.isChecked() ? "7"
                : mnc4h.isChecked() ? "8"
                : mnc488.isChecked() ? "88" : "0");


        sC.put("mnc4x", mnc4x.getText().toString());

        AppMain.fc.setsC(String.valueOf(sC));

        return true;
    }

    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);

//        String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String dt = GPSPref.getString("Time", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            AppMain.fc.setGpsLat(GPSPref.getString("Latitude", "0"));
            AppMain.fc.setGpsLng(GPSPref.getString("Longitude", "0"));
            AppMain.fc.setGpsAcc(GPSPref.getString("Accuracy", "0"));
//            AppMain.fc.setGpsTime(GPSPref.getString(date, "0")); // Timestamp is converted to date above
            AppMain.fc.setGpsTime(date); // Timestamp is converted to date above

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }


    private boolean ValidateForm() {

        int count = 0, count1 = 0, count2 = 0;

        if (studycode.getText().toString().isEmpty() || studycode.getText().toString() == null) {
            studycode.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): Study code is required ", Toast.LENGTH_LONG).show();
            Log.i(TAG, "studycode: Study code is required!");
            studycode.requestFocus();
            return false;
        } else {
            studycode.setError(null);
        }

        if (!studycode.getText().toString().equals("1") && !studycode.getText().toString().equals("2")) {
            studycode.setError("Study Code must be 1 - 2 ");
            Toast.makeText(getApplicationContext(), "ERROR(Invalid): Study Code must be 1 - 2 ", Toast.LENGTH_LONG).show();
            Log.i(TAG, "studycode: Study Code must be 1 - 2!");
            studycode.requestFocus();
            return false;
        } else {
            studycode.setError(null);
        }


        if (studyid.getText().toString().isEmpty() || studyid.getText().toString() == null) {
            studyid.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): Study ID is required ", Toast.LENGTH_LONG).show();
            Log.i(TAG, "studyid: Study ID is required");
            studyid.requestFocus();
            return false;
        } else {
            studyid.setError(null);
        }


        if (dov.getText().toString().isEmpty() || dov.getText().toString() == null) {
            dov.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): Date of visit is required ", Toast.LENGTH_LONG).show();
            Log.i(TAG, "dov: Date of Visit is required");
            dov.requestFocus();
            return false;
        } else {
            dov.setError(null);
        }


        if (mna1.getText().toString().isEmpty() || mna1.getText().toString() == null) {
            mna1.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna1), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mna1: This Data is Required!");
            mna1.requestFocus();
            return false;
        } else {
            mna1.setError(null);
        }

        if (mna2.getText().toString().isEmpty() || mna2.getText().toString() == null) {
            mna2.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna2), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mna2: This Data is Required!");
            mna2.requestFocus();
            return false;
        } else {
            mna2.setError(null);
        }

        if (mna3.getText().toString().isEmpty() || mna3.getText().toString() == null) {
            mna3.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna3), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mna3: This Data is Required!");
            mna3.requestFocus();
            return false;
        } else {
            mna3.setError(null);
        }

        if (dcbdob.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.txterr), Toast.LENGTH_SHORT).show();
            dcbAge02.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "dcbdob: This data is Required!");
            return false;
        } else {
            dcbAge02.setError(null);
        }

        if (dcbdob01.isChecked()) {
            if (mna4.getText().toString().isEmpty() || mna4.getText().toString() == null) {
                mna4.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna4), Toast.LENGTH_LONG).show();
                Log.i(TAG, "mna4: required " + getString(R.string.mna4));
                mna4.requestFocus();
                return false;
            } else {
                mna4.setError(null);
            }
        }

        if (dcbAge02.isChecked()) {
            if (mna5months.getText().toString().isEmpty() || mna5months.getText().toString() == null) {
                mna5months.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna5months), Toast.LENGTH_LONG).show();
                Log.i(TAG, "mna5months: required " + getString(R.string.mna5months));
                mna5months.requestFocus();
                return false;
            } else {
                mna5months.setError(null);
            }


            if (mna5days.getText().toString().isEmpty() || mna5days.getText().toString() == null) {
                mna5days.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna5days), Toast.LENGTH_LONG).show();
                Log.i(TAG, "mna5days: required " + getString(R.string.mna5days));
                mna5days.requestFocus();
                return false;
            } else {
                mna5days.setError(null);
            }

            if (studycode.getText().toString().equals("1") ?
                    (Integer.valueOf(mna5months.getText().toString()) < 6 || Integer.valueOf(mna5months.getText().toString()) > 11) :
                    (Integer.valueOf(mna5months.getText().toString()) < 36 || Integer.valueOf(mna5months.getText().toString()) > 48)) {
                mna5months.setError("Months must be between " + (
                        studycode.getText().toString().equals("1") ? "6 - 11" : "36 - 48"));
                Toast.makeText(getApplicationContext(), "ERROR(Invalid): Months must be between " + (
                        studycode.getText().toString().equals("1") ? "6 - 11" : "36 - 48"), Toast.LENGTH_LONG).show();
                Log.i(TAG, "mna5months: This Data is Invalid!");
                mna5months.requestFocus();
                return false;
            } else {
                mna5months.setError(null);
            }


            if (Integer.valueOf(mna5days.getText().toString()) < 0 || Integer.valueOf(mna5days.getText().toString()) > 29) {
                mna5days.setError("Days must be between 0 - 29");
                Toast.makeText(getApplicationContext(), "ERROR(Invalid): Days must be between 0 - 29 ", Toast.LENGTH_LONG).show();
                Log.i(TAG, "mna5days: This Data is Invalid!");
                mna5days.requestFocus();
                return false;
            } else {
                mna5days.setError(null);
            }
        }

        //rdo_mna6 = mna6.getCheckedRadioButtonId();

        if (mna6.getCheckedRadioButtonId() == -1) {
            mna6A.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna6), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mna6: required " + getString(R.string.mna6));
            mna6A.requestFocus();
            return false;
        } else {
            mna6A.setError(null);
        }

//        switch (rdo_mna6) {
//            case R.id.mna6_a:
//                var_mna6 = "1";
//                break;
//            case R.id.mna6_b:
//                var_mna6 = "2";
//                break;
//        }

        if (mnb3.getSelectedItem() == "...") {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.mnb3), Toast.LENGTH_SHORT).show();
            ((TextView) mnb3.getSelectedView()).setError("This Data is Required");

            Log.i(TAG, "mnb3: This Data is Required!");
            return false;
        } else {
            ((TextView) mnb3.getSelectedView()).setError(null);
        }

        if (mnb2.getSelectedItem() == "...") {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.mnb2), Toast.LENGTH_SHORT).show();
            ((TextView) mnb2.getSelectedView()).setError("This Data is Required");

            Log.i(TAG, "mnb2: This Data is Required!");
            return false;
        } else {
            ((TextView) mnb2.getSelectedView()).setError(null);
        }

        if (mnb1.getText().toString().isEmpty() || mnb1.getText().toString() == null) {
            mnb1.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb1), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnb1: This Data is Required!");
            mnb1.requestFocus();
            return false;
        } else {
            mnb1.setError(null);
        }

//        if (mnb2.getSelectedItem().toString().isEmpty() || mnb2.getSelectedItem().toString() == null) {
//            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb2), Toast.LENGTH_LONG).show();
//            mnb2.requestFocus();
//            return false;
//        }


        if (mnb4name.getText().toString().isEmpty() || mnb4name.getText().toString() == null) {
            mnb4name.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb4name), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnb4name: This Data is Required!");
            mnb4name.requestFocus();
            return false;
        } else {
            mnb4name.setError(null);
        }

        if (mnb4address.getText().toString().isEmpty() || mnb4address.getText().toString() == null) {
            mnb4address.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb4address), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnb4address: This Data is Required!");
            mnb4address.requestFocus();
            return false;
        } else {
            mnb4address.setError(null);
        }


/*        if (mnb5walk.getText().toString().isEmpty()) {
            mnb5walk.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb5walk), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnb5walk: This Data is Required!");
            mnb5walk.requestFocus();
            return false;
        } else {
            mnb5walk.setError(null);
        }*/

        if (mnb5mints.getText().toString().isEmpty() || mnb5mints.getText().toString() == null) {
            mnb5mints.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb5mints), Toast.LENGTH_LONG).show();
            mnb5mints.requestFocus();
            return false;
        } else {
            mnb5mints.setError(null);
        }

        if (mnb5km.getText().toString().isEmpty() || mnb5km.getText().toString() == null) {
            mnb5km.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb5km), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnb5km: This Data is Required!");
            mnb5km.requestFocus();
            return false;
        } else {
            mnb5km.setError(null);
        }


        /*if (mnb6name.getText().toString().isEmpty() || mnb6name.getText().toString() == null) {
            mnb6name.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb6name), Toast.LENGTH_LONG).show();
            mnb6name.requestFocus();
            return false;
        } else {
            mnb6name.setError(null);
        }

        if (mnb6code.getText().toString().isEmpty() || mnb6code.getText().toString() == null) {
            mnb6code.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb6code), Toast.LENGTH_LONG).show();
            mnb6code.requestFocus();
            return false;
        } else {
            mnb6code.setError(null);
        }*/


        if (mnb7name.getText().toString().isEmpty() || mnb7name.getText().toString() == null) {
            mnb7name.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb7name), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnb7name: This Data is Required!");
            mnb7name.requestFocus();
            return false;
        } else {
            mnb7name.setError(null);
        }

/*        if (mnb7code.getText().toString().isEmpty() || mnb7code.getText().toString() == null) {
            mnb7code.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb7code), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnb7code: This Data is Required!");
            mnb7code.requestFocus();
            return false;
        } else {
            mnb7code.setError(null);
        }*/

        if (mnc1.getText().toString().isEmpty() || mnc1.getText().toString() == null) {
            mnc1.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnc1), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnc1: This Data is Required!");
            mnc1.requestFocus();
            return false;
        } else {
            mnc1.setError(null);
        }

        //rdo_mnc2 = mnc2.getCheckedRadioButtonId();

        if (mnc2.getCheckedRadioButtonId() == -1) {
            mnc2a.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnc2), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnc2: This Data is Required!");
            mnc2a.requestFocus();
            return false;
        } else {
            mnc2a.setError(null);
        }

//        switch (rdo_mnc2) {
//            case R.id.mnc2a:
//                var_mnc2 = "1";
//                break;
//            case R.id.mnc2b:
//                var_mnc2 = "2";
//                break;
//            case R.id.mnc2c:
//                var_mnc2 = "3";
//                break;
//            case R.id.mnc2d:
//                var_mnc2 = "4";
//                break;
//            case R.id.mnc2e:
//                var_mnc2 = "5";
//                break;
//            case R.id.mnc288:
//                var_mnc2 = "88";
//                break;
//        }


        if (mnc288.isChecked()) {

            if (mnc2x.getText().toString().isEmpty() || mnc2x.getText().toString() == null) {
                mnc2x.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.others), Toast.LENGTH_LONG).show();
                Log.i(TAG, "mnc2x: This Data is Required!");
                mnc2x.requestFocus();
                return false;
            } else {
                mnc2x.setError(null);
            }
        }


        if (mnc3years.getText().toString().isEmpty() || mnc3years.getText().toString() == null) {
            mnc3years.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnc3), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnc3years: This Data is Required!");
            mnc3years.requestFocus();
            return false;
        } else {
            mnc3years.setError(null);
        }

        if (Integer.valueOf(mnc3years.getText().toString()) < 14 || Integer.valueOf(mnc3years.getText().toString()) > 99) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.mnc3), Toast.LENGTH_SHORT).show();
            mnc3years.setError("Invalid: Range is 14 - 19 years");
            Log.i(TAG, "mnc3years: Range is 14 - 99 years ");
            return false;
        } else {
            mnc3years.setError(null);
        }


        //rdo_mnc4 = mnc4.getCheckedRadioButtonId();

        if (mnc4.getCheckedRadioButtonId() == -1) {
            mnc4a.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnc4), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnc4a: This Data is Required!");
            mnc4a.requestFocus();
            return false;
        } else {
            mnc4a.setError(null);
        }

//        switch (rdo_mnc4) {
//            case R.id.mnc4a:
//                var_mnc4 = "1";
//                break;
//            case R.id.mnc4b:
//                var_mnc4 = "2";
//                break;
//            case R.id.mnc4c:
//                var_mnc4 = "3";
//                break;
//            case R.id.mnc4d:
//                var_mnc4 = "4";
//                break;
//            case R.id.mnc4e:
//                var_mnc4 = "5";
//                break;
//            case R.id.mnc4f:
//                var_mnc4 = "6";
//                break;
//            case R.id.mnc4g:
//                var_mnc4 = "7";
//                break;
//            case R.id.mnc4h:
//                var_mnc4 = "8";
//                break;
//            case R.id.mnc488:
//                var_mnc4 = "88";
//                break;
//        }

        if (mnc488.isChecked()) {

            if (mnc4x.getText().toString().isEmpty() || mnc4x.getText().toString() == null) {
                mnc4x.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.others), Toast.LENGTH_LONG).show();
                Log.i(TAG, "mnc4x: This Data is Required!");
                mnc4x.requestFocus();
                return false;
            } else {
                mnc4x.setError(null);
            }

        }

        /*if (Integer.parseInt(mnc3years.getText().toString()) < 14) {
            mnc3years.setError("Respondent age cannot be less than 14 years");
            Toast.makeText(getApplicationContext(), "ERROR(Invalid): Respondent age cannot be less than 14 years ", Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnc3years: This Data is Invalid!");
            mnc3years.requestFocus();
            return false;
        } else {
            mnc3years.setError(null);
        }*/


        if (mnc4e.isChecked() && Integer.valueOf(mnc3years.getText().toString()) < 16) {
            mnc3years.setError("Age must be 16 years or greater if the education level is Graduation");
            Toast.makeText(getApplicationContext(), "ERROR(Invalid): Age must be 16 years if the education level is Graduation ", Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnc3years: This Data is Invalid!");
            mnc3years.requestFocus();
            return false;
        } else {
            mnc3years.setError(null);
        }


        if (mnc4f.isChecked() && Integer.valueOf(mnc3years.getText().toString()) < 19) {
            mnc3years.setError("Age must be 19 years or greater if the education level is Masters");
            Toast.makeText(getApplicationContext(), "ERROR(Invalid): Age must be 19 years if the education level is Masters ", Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnc3years: This Data is Invalid!");
            mnc3years.requestFocus();
            return false;
        } else {
            mnc3years.setError(null);
        }


        /*String str2 = mnb5walk.getText().toString();
        for (int i = 0; i < str2.length(); i++) {
            if (mnb5walk.getText().toString().charAt(i) == '.') {
                count2++;
            }
        }


        if (count2 >= 2) {
            mnb5walk.setError("You cannot use two decimal points in distance by walk");
            Toast.makeText(getApplicationContext(), "ERROR(Invalid): You cannot use two decimal points in distance by walk ", Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnb5walk: This Data is Invalid!");
            mnb5walk.requestFocus();
            return false;
        } else {
            mnb5walk.setError(null);
        }*/


        String str1 = mnb5mints.getText().toString();
        for (int i = 0; i < str1.length(); i++) {
            if (mnb5mints.getText().toString().charAt(i) == '.') {
                count1++;
            }
        }


        if (count1 >= 2) {
            mnb5mints.setError("You cannot use two decimal points in distance in mints");
            Toast.makeText(getApplicationContext(), "ERROR(empty): You cannot use two decimal points in distance in mints ", Toast.LENGTH_LONG).show();
            mnb5mints.requestFocus();
            return false;
        } else {
            mnb5mints.setError(null);
        }


        String str = mnb5km.getText().toString();
        for (int i = 0; i < str.length(); i++) {
            if (mnb5km.getText().toString().charAt(i) == '.') {
                count++;
            }
        }


        if (count >= 2) {
            mnb5km.setError("You cannot use two decimal points in km");
            Toast.makeText(getApplicationContext(), "ERROR(Invalid): You cannot use two decimal points in km ", Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnb5km: This Data is Invalid!");
            mnb5km.requestFocus();
            return false;
        } else {
            mnb5km.setError(null);
        }


        return true;
    }

    public Calendar getCalendarDate(String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(value);
            calendar.setTime(date);
            return calendar;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public String convertDateFormat(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date d = sdf.parse(dateStr);
            return new SimpleDateFormat("dd/MM/yyyy").format(d);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return "";
    }


    private void exportDB1(String db_name) throws JSONException {
        final String inFileName = "/data/data/" + this.getPackageName() + "/databases/" + db_name;

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date dt = new Date();

            File sd = new File(Environment.getExternalStorageDirectory() + "/" + sdf.format(dt));

            boolean success = true;
            if (!sd.exists()) {
                success = sd.mkdir();
            }


            if (success) {

                File dbFile = new File(inFileName);

                if (!dbFile.exists()) {
                    dbFile.createNewFile();
                }

                FileInputStream fis = new FileInputStream(dbFile);

                String outFileName = Environment.getExternalStorageDirectory() + "/" + sdf.format(dt) + "/" + db_name;

                OutputStream output = new FileOutputStream(outFileName);

                byte[] buffer = new byte[1024];


                int length;

                while ((length = fis.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }


                output.flush();
                output.close();
                fis.close();
            }

        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

//    @Override
//    public void onBackPressed() {
//        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
//    }
}