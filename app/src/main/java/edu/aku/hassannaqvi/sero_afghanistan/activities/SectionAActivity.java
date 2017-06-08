package edu.aku.hassannaqvi.sero_afghanistan.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.FormsContract;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;
import io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText;

public class SectionAActivity extends AppCompatActivity {

    private static final String TAG = SectionAActivity.class.getSimpleName();

    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;
    @BindView(R.id.lbl_mainhead)
    TextView lblMainhead;
    @BindView(R.id.lbl_mnaheading)
    TextView lblMnaheading;
    @BindView(R.id.studyid)
    EditText studyid;
    @BindView(R.id.lbl_mna1)
    TextView lblMna1;
    @BindView(R.id.mna1)
    EditText mna1;
    @BindView(R.id.lbl_mna2)
    TextView lblMna2;
    @BindView(R.id.mna2)
    EditText mna2;
    @BindView(R.id.lbl_mna3)
    TextView lblMna3;
    @BindView(R.id.mna3)
    EditText mna3;
    @BindView(R.id.lbl_mna4)
    TextView lblMna4;
    @BindView(R.id.mna4)
    DatePickerInputEditText mna4;
    @BindView(R.id.lbl_mna5months)
    TextView lblMna5months;
    @BindView(R.id.mna5months)
    EditText mna5months;
    @BindView(R.id.lbl_mna5days)
    TextView lblMna5days;
    @BindView(R.id.mna5days)
    EditText mna5days;
    @BindView(R.id.lbl_mna6)
    TextView lblMna6;
    @BindView(R.id.mna6)
    RadioGroup mna6;
    @BindView(R.id.mna6_a)
    RadioButton mna6A;
    @BindView(R.id.mna6_b)
    RadioButton mna6B;
    @BindView(R.id.lbl_mnbheading)
    TextView lblMnbheading;
    @BindView(R.id.lbl_mnb1)
    TextView lblMnb1;
    @BindView(R.id.mnb1)
    EditText mnb1;
    @BindView(R.id.lbl_mnb2)
    TextView lblMnb2;
    @BindView(R.id.mnb2)
    EditText mnb2;
    @BindView(R.id.lbl_mnb3)
    TextView lblMnb3;
    @BindView(R.id.mnb3)
    EditText mnb3;
    @BindView(R.id.lbl_mnb4)
    TextView lblMnb4;
    @BindView(R.id.lbl_mnb4name)
    TextView lblMnb4name;
    @BindView(R.id.mnb4name)
    EditText mnb4name;
    @BindView(R.id.lbl_mnb4address)
    TextView lblMnb4address;
    @BindView(R.id.mnb4address)
    EditText mnb4address;
    @BindView(R.id.lbl_mnb5)
    TextView lblMnb5;
    @BindView(R.id.lbl_mnb5walk)
    TextView lblMnb5walk;
    @BindView(R.id.mnb5walk)
    EditText mnb5walk;
    @BindView(R.id.lbl_mnb5mints)
    TextView lblMnb5mints;
    @BindView(R.id.mnb5mints)
    EditText mnb5mints;
    @BindView(R.id.lbl_mnb5km)
    TextView lblMnb5km;
    @BindView(R.id.mnb5km)
    EditText mnb5km;
    @BindView(R.id.lbl_mnb6)
    TextView lblMnb6;
    @BindView(R.id.lbl_mnb6name)
    TextView lblMnb6name;
    @BindView(R.id.mnb6name)
    EditText mnb6name;
    @BindView(R.id.lbl_mnb6code)
    TextView lblMnb6code;
    @BindView(R.id.mnb6code)
    EditText mnb6code;
    @BindView(R.id.lbl_mnb7)
    TextView lblMnb7;
    @BindView(R.id.lbl_mnb7name)
    TextView lblMnb7name;
    @BindView(R.id.mnb7name)
    EditText mnb7name;
    @BindView(R.id.lbl_mnb7code)
    TextView lblMnb7code;
    @BindView(R.id.mnb7code)
    EditText mnb7code;
    @BindView(R.id.lbl_mncheading)
    TextView lblMncheading;
    @BindView(R.id.lbl_mnc1)
    TextView lblMnc1;
    @BindView(R.id.mnc1)
    EditText mnc1;
    @BindView(R.id.lbl_mnc2)
    TextView lblMnc2;
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
    @BindView(R.id.lbl_mnc2x)
    TextView lblMnc2x;
    @BindView(R.id.mnc2x)
    EditText mnc2x;
    @BindView(R.id.lbl_mnc3)
    TextView lblMnc3;
    @BindView(R.id.lbl_mnc3years)
    TextView lblMnc3years;
    @BindView(R.id.mnc3years)
    EditText mnc3years;
    @BindView(R.id.lbl_mnc4)
    TextView lblMnc4;
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
    @BindView(R.id.lbl_mnc4x)
    TextView lblMnc4x;
    @BindView(R.id.mnc4x)
    EditText mnc4x;
    @BindView(R.id.fldGrpbtn)
    LinearLayout fldGrpbtn;

    int rdo_mna6;
    String var_mna6;

    int rdo_mnc2;
    String var_mnc2;

    int rdo_mnc4;
    String var_mnc4;

    String dateToday;
    String maxDateyear;

    Calendar now = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_a);
        ButterKnife.bind(this);

        mna4.setManager(getSupportFragmentManager());


        dateToday = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        maxDateyear = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - (AppMain.MILLISECONDS_IN_YEAR));
        mna4.setMaxDate(dateToday);

        mna4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mna4.onFocusChange(v, true);
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

    }

    @OnClick(R.id.btnNext)
    void SaveData() {

        DatabaseHelper db = new DatabaseHelper(this);

        if (ValidateForm()) {

            if (!db.IsStudyid_Exists(studyid.getText().toString())) {

                try {
                    SaveDraft();
                    SaveDraftA();
                    SaveDraftB();
                    SaveDraftC();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (UpdateDB()) {
                    Toast.makeText(this, "Starting Section D", Toast.LENGTH_SHORT).show();

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
        AppMain.fc.setstudyid(studyid.getText().toString());

        setGPS();

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

        return true;
    }

    private boolean SaveDraftA() throws JSONException {

        JSONObject sA = new JSONObject();

        sA.put("mna2", mna2.getText().toString());
        sA.put("mna3", mna3.getText().toString());
        sA.put("mna4", mna4.getText().toString());
        sA.put("mna5days", mna5days.getText().toString());
        sA.put("mna5months", mna5months.getText().toString());

        rdo_mna6 = mna6.getCheckedRadioButtonId();

        switch (rdo_mna6) {
            case R.id.mna6_a:
                var_mna6 = "1";
                break;
            case R.id.mna6_b:
                var_mna6 = "2";
                break;
        }

        sA.put("mna6", var_mna6);

        AppMain.fc.setsA(String.valueOf(sA));

        return true;
    }

    private boolean SaveDraftB() throws JSONException {

        JSONObject sB = new JSONObject();

        sB.put("mnb1", mnb1.getText().toString());
        sB.put("mnb2", mnb2.getText().toString());
        sB.put("mnb3", mnb3.getText().toString());
        sB.put("mnb4name", mnb4name.getText().toString());
        sB.put("mnb4address", mnb4address.getText().toString());
        sB.put("mnb5walk", mnb5walk.getText().toString());
        sB.put("mnb5mints", mnb5mints.getText().toString());
        sB.put("mnb5km", mnb5km.getText().toString());
        sB.put("mnb6name", mnb6name.getText().toString());
        sB.put("mnb6code", mnb6code.getText().toString());
        sB.put("mnb7name", mnb7name.getText().toString());
        sB.put("mnb7code", mnb7code.getText().toString());

        AppMain.fc.setsB(String.valueOf(sB));

        return true;
    }

    private boolean SaveDraftC() throws JSONException {

        JSONObject sC = new JSONObject();

        sC.put("mnc1", mnc1.getText().toString());

        rdo_mnc2 = mnc2.getCheckedRadioButtonId();

        switch (rdo_mnc2) {
            case R.id.mnc2a:
                var_mnc2 = "1";
                break;
            case R.id.mnc2b:
                var_mnc2 = "2";
                break;
            case R.id.mnc2c:
                var_mnc2 = "3";
                break;
            case R.id.mnc2d:
                var_mnc2 = "4";
                break;
            case R.id.mnc2e:
                var_mnc2 = "5";
                break;
            case R.id.mnc288:
                var_mnc2 = "88";
                break;
        }

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


        rdo_mnc4 = mnc4.getCheckedRadioButtonId();

        switch (rdo_mnc4) {
            case R.id.mnc4a:
                var_mnc4 = "1";
                break;
            case R.id.mnc4b:
                var_mnc4 = "2";
                break;
            case R.id.mnc4c:
                var_mnc4 = "3";
                break;
            case R.id.mnc4d:
                var_mnc4 = "4";
                break;
            case R.id.mnc4e:
                var_mnc4 = "5";
                break;
            case R.id.mnc4f:
                var_mnc4 = "6";
                break;
            case R.id.mnc4g:
                var_mnc4 = "7";
                break;
            case R.id.mnc4h:
                var_mnc4 = "8";
                break;
            case R.id.mnc488:
                var_mnc4 = "88";
                break;
        }


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

        // CONVERTING GPS TIMESTAMP TO DATETIME FORMAT
        String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

        AppMain.fc.setGpsLat(GPSPref.getString("Latitude", "0"));
        AppMain.fc.setGpsLng(GPSPref.getString("Longitude", "0"));
        AppMain.fc.setGpsAcc(GPSPref.getString("Accuracy", "0"));
        AppMain.fc.setGpsTime(date); // Timestamp is converted to date above

        Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
    }


    private boolean ValidateForm() {

        if (studyid.getText().toString().isEmpty() || studyid.getText().toString() == null) {
            studyid.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): Study ID is required ", Toast.LENGTH_LONG).show();
            studyid.requestFocus();
            return false;
        } else {
            studyid.setError(null);
        }

        if (mna1.getText().toString().isEmpty() || mna1.getText().toString() == null) {
            mna1.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna1), Toast.LENGTH_LONG).show();
            mna1.requestFocus();
            return false;
        } else {
            mna1.setError(null);
        }

        if (mna2.getText().toString().isEmpty() || mna2.getText().toString() == null) {
            mna2.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna2), Toast.LENGTH_LONG).show();
            mna2.requestFocus();
            return false;
        } else {
            mna2.setError(null);
        }

        if (mna3.getText().toString().isEmpty() || mna3.getText().toString() == null) {
            mna3.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna3), Toast.LENGTH_LONG).show();
            mna3.requestFocus();
            return false;
        } else {
            mna3.setError(null);
        }

        if (mna4.getText().toString().isEmpty() || mna4.getText().toString() == null) {
            mna4.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna4), Toast.LENGTH_LONG).show();
            mna4.requestFocus();
            return false;
        } else {
            mna4.setError(null);
        }


        if (mna5months.getText().toString().isEmpty() || mna5months.getText().toString() == null) {
            mna5months.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna5months), Toast.LENGTH_LONG).show();
            mna5months.requestFocus();
            return false;
        } else {
            mna5months.setError(null);
        }

        if (mna5days.getText().toString().isEmpty() || mna5days.getText().toString() == null) {
            mna5days.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna5days), Toast.LENGTH_LONG).show();
            mna5days.requestFocus();
            return false;
        } else {
            mna5days.setError(null);
        }

        rdo_mna6 = mna6.getCheckedRadioButtonId();

        if (rdo_mna6 == -1) {
            mna6A.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna6), Toast.LENGTH_LONG).show();
            mna6A.requestFocus();
            return false;
        } else {
            mna6A.setError(null);
        }

        switch (rdo_mna6) {
            case R.id.mna6_a:
                var_mna6 = "1";
                break;
            case R.id.mna6_b:
                var_mna6 = "2";
                break;
        }


        if (mnb1.getText().toString().isEmpty() || mnb1.getText().toString() == null) {
            mnb1.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb1), Toast.LENGTH_LONG).show();
            mnb1.requestFocus();
            return false;
        } else {
            mnb1.setError(null);
        }

        if (mnb2.getText().toString().isEmpty() || mnb2.getText().toString() == null) {
            mnb2.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb2), Toast.LENGTH_LONG).show();
            mnb2.requestFocus();
            return false;
        } else {
            mnb2.setError(null);
        }

        if (mnb3.getText().toString().isEmpty() || mnb3.getText().toString() == null) {
            mnb3.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb3), Toast.LENGTH_LONG).show();
            mnb3.requestFocus();
            return false;
        } else {
            mnb3.setError(null);
        }


        if (mnb4name.getText().toString().isEmpty() || mnb4name.getText().toString() == null) {
            mnb4name.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb4name), Toast.LENGTH_LONG).show();
            mnb4name.requestFocus();
            return false;
        } else {
            mnb4name.setError(null);
        }

        if (mnb4address.getText().toString().isEmpty() || mnb4address.getText().toString() == null) {
            mnb4address.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb4address), Toast.LENGTH_LONG).show();
            mnb4address.requestFocus();
            return false;
        } else {
            mnb4address.setError(null);
        }


        if (mnb5walk.getText().toString().isEmpty() || mnb5walk.getText().toString() == null) {
            mnb5walk.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb5walk), Toast.LENGTH_LONG).show();
            mnb5walk.requestFocus();
            return false;
        } else {
            mnb5walk.setError(null);
        }

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
            mnb5km.requestFocus();
            return false;
        } else {
            mnb5km.setError(null);
        }


        if (mnb6name.getText().toString().isEmpty() || mnb6name.getText().toString() == null) {
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
        }


        if (mnb7name.getText().toString().isEmpty() || mnb7name.getText().toString() == null) {
            mnb7name.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb7name), Toast.LENGTH_LONG).show();
            mnb7name.requestFocus();
            return false;
        } else {
            mnb7name.setError(null);
        }

        if (mnb7code.getText().toString().isEmpty() || mnb7code.getText().toString() == null) {
            mnb7code.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb7code), Toast.LENGTH_LONG).show();
            mnb7code.requestFocus();
            return false;
        } else {
            mnb7code.setError(null);
        }

        if (mnc1.getText().toString().isEmpty() || mnc1.getText().toString() == null) {
            mnc1.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnc1), Toast.LENGTH_LONG).show();
            mnc1.requestFocus();
            return false;
        } else {
            mnc1.setError(null);
        }

        rdo_mnc2 = mnc2.getCheckedRadioButtonId();

        if (rdo_mnc2 == -1) {
            mnc2a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnc2), Toast.LENGTH_LONG).show();
            mnc2a.requestFocus();
            return false;
        } else {
            mnc2a.setError(null);
        }

        switch (rdo_mnc2) {
            case R.id.mnc2a:
                var_mnc2 = "1";
                break;
            case R.id.mnc2b:
                var_mnc2 = "2";
                break;
            case R.id.mnc2c:
                var_mnc2 = "3";
                break;
            case R.id.mnc2d:
                var_mnc2 = "4";
                break;
            case R.id.mnc2e:
                var_mnc2 = "5";
                break;
            case R.id.mnc288:
                var_mnc2 = "88";
                break;
        }


        if (var_mnc2 == "88") {

            if (mnc2x.getText().toString().isEmpty() || mnc2x.getText().toString() == null) {
                mnc2x.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.others), Toast.LENGTH_LONG).show();
                mnc2x.requestFocus();
                return false;
            } else {
                mnc2x.setError(null);
            }
        }


        if (mnc3years.getText().toString().isEmpty() || mnc3years.getText().toString() == null) {
            mnc3years.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnc3), Toast.LENGTH_LONG).show();
            mnc3years.requestFocus();
            return false;
        } else {
            mnc3years.setError(null);
        }

        rdo_mnc4 = mnc4.getCheckedRadioButtonId();

        if (rdo_mnc4 == -1) {
            mnc4a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnc4), Toast.LENGTH_LONG).show();
            mnc4a.requestFocus();
            return false;
        } else {
            mnc4a.setError(null);
        }

        switch (rdo_mnc4) {
            case R.id.mnc4a:
                var_mnc4 = "1";
                break;
            case R.id.mnc4b:
                var_mnc4 = "2";
                break;
            case R.id.mnc4c:
                var_mnc4 = "3";
                break;
            case R.id.mnc4d:
                var_mnc4 = "4";
                break;
            case R.id.mnc4e:
                var_mnc4 = "5";
                break;
            case R.id.mnc4f:
                var_mnc4 = "6";
                break;
            case R.id.mnc4g:
                var_mnc4 = "7";
                break;
            case R.id.mnc4h:
                var_mnc4 = "8";
                break;
            case R.id.mnc488:
                var_mnc4 = "88";
                break;
        }

        if (var_mnc4 == "88") {

            if (mnc4x.getText().toString().isEmpty() || mnc4x.getText().toString() == null) {
                mnc4x.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.others), Toast.LENGTH_LONG).show();
                mnc4x.requestFocus();
                return false;
            } else {
                mnc4x.setError(null);
            }

        }

        return true;
    }
}