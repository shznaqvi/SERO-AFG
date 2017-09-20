package edu.aku.hassannaqvi.sero_afghanistan.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.LocationContract;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;
import io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText;


public class LocationActivity extends AppCompatActivity {

    private static final String TAG = LocationActivity.class.getSimpleName();

    /*@BindView(R.id.mnh1)
    RadioGroup mnh1;
    @BindView(R.id.mnh1a)
    RadioButton mnh1a;
    @BindView(R.id.mnh1b)
    RadioButton mnh1b;*/

    @BindView(R.id.mnh2)
    EditText mnh2;

    @BindView(R.id.mnh3a)
    EditText mnh3a;

    @BindView(R.id.mnh3b)
    EditText mnh3b;


    @BindView(R.id.mnh4)
    RadioGroup mnh4;
    @BindView(R.id.mnh4a)
    RadioButton mnh4a;
    @BindView(R.id.mnh4b)
    RadioButton mnh4b;
    @BindView(R.id.mnh4c)
    RadioButton mnh4c;
    @BindView(R.id.mnh4d)
    RadioButton mnh4d;
    @BindView(R.id.mnh4e)
    RadioButton mnh4e;
    @BindView(R.id.mnh488)
    RadioButton mnh488;

    @BindView(R.id.fldGrpmnh4c)
    LinearLayout fldGrpmnh4c;

    @BindView(R.id.fldGrpmnh488)
    LinearLayout fldGrpmnh488;

    @BindView(R.id.mnh4cdt)
    DatePickerInputEditText mnh4cdt;

    @BindView(R.id.mnh488x)
    EditText mnh488x;


    @BindView(R.id.btn_End)
    Button btn_End;

    @BindView(R.id.btnNext)
    Button btnNext;

    @BindView(R.id.activity_section_a)
    ScrollView activity_section_a;

    /*@BindView(R.id.mnh2a)
    EditText mnh2a;*/

    @BindView(R.id.lbl_count)
    TextView lbl_count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        ButterKnife.bind(this);

        lbl_count.setText("Location " + AppMain.locations + " of " + AppMain.NoOfLocations);

        mnh4cdt.setManager(getSupportFragmentManager());

        String dtToday = new SimpleDateFormat("dd/MM/yyyy").format(new Date().getTime());

        mnh4cdt.setMaxDate(dtToday);

        /*mnh1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (mnh1a.isChecked()) {

                    mnh2a.setText(null);
                    mnh2.setText(null);
                    mnh3a.setText(null);
                    mnh3b.setText(null);
                    mnh4.clearCheck();

                    fldGrpmnh2.setVisibility(View.GONE);

                } else {
                    fldGrpmnh2.setVisibility(View.VISIBLE);
                    mnh2a.requestFocus();
                }
            }
        });*/

        mnh4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (mnh4c.isChecked()) {
                    mnh488x.setText(null);
                    fldGrpmnh488.setVisibility(View.GONE);

                    fldGrpmnh4c.setVisibility(View.VISIBLE);

                } else if (mnh488.isChecked()) {
                    mnh4cdt.setText(null);
                    fldGrpmnh4c.setVisibility(View.GONE);

                    fldGrpmnh488.setVisibility(View.VISIBLE);
                    mnh488x.requestFocus();
                } else {
                    mnh488x.setText(null);
                    mnh4cdt.setText(null);
                    fldGrpmnh4c.setVisibility(View.GONE);
                    fldGrpmnh488.setVisibility(View.GONE);
                }
            }
        });
    }


    @OnClick(R.id.btnNext)
    void SaveData() {

        if (ValidateForm()) {
            if (AppMain.flag) {
                try {
                    SaveDraft();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (UpdateDB()) {

                    if (AppMain.locations >= AppMain.NoOfLocations) {

                        Toast.makeText(this, "Starting Ending", Toast.LENGTH_SHORT).show();
                        finish();
                        Intent main = new Intent(this, EndingActivity.class);
                        main.putExtra("complete", true);
                        startActivity(main);
                    }

                } else {
                    Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
                }

                AppMain.locations++;

                lbl_count.setText("Location " + AppMain.locations + " of " + AppMain.NoOfLocations);

                mnh2.setText(null);
                mnh3a.setText(null);
                mnh3b.setText(null);
                mnh4.clearCheck();
                mnh4cdt.setText(null);
                mnh488x.setText(null);

                mnh2.requestFocus();

                activity_section_a.setScrollY(0);


            } else {
                finish();
//                startActivity(new Intent(this, MainActivity.class));
            }
        }
    }


    @OnClick(R.id.btn_End)
    void endInterview() {
        Intent endSec = new Intent(this, EndingActivity.class);
        endSec.putExtra("complete", false);
        startActivity(endSec);
        finish();
    }


    private boolean UpdateDB() {

        Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        // 1. INSERT FORM
        rowId = db.addLocation(AppMain.lc);

        AppMain.lc.set_ID(String.valueOf(rowId));

        //if (rowId != null) {

        //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
        /*AppMain.fc.setUID(
                (AppMain.fc.getDeviceID() + AppMain.fc.getID()));*/
        //Toast.makeText(this, "Current Form No: " + AppMain.fc.getUID(), Toast.LENGTH_SHORT).show();

        // 2. UPDATE FORM ROWID

        if (rowId != -1) {

            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            AppMain.lc.setUID(AppMain.fc.getDeviceID() + AppMain.fc.getID());
            db.updateSectionsH();
            //db.updateFormssH();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        /*} else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

    }


    private boolean ValidateForm() {

        /*if (mnh1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.mnh1), Toast.LENGTH_SHORT).show();
            mnh1a.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "mnh1: This data is Required!");
            return false;
        } else {
            mnh1a.setError(null);
        }*/


        //if (mnh1b.isChecked()) {


        /*if (mnh2a.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.mnh2a), Toast.LENGTH_SHORT).show();
            mnh2a.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "mnh2a: This data is Required!");
            return false;
        } else {
            mnh2a.setError(null);
        }*/


        if (mnh2.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.mnh2a), Toast.LENGTH_SHORT).show();
            mnh2.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "mnh2: This data is Required!");
            return false;
        } else {
            mnh2.setError(null);
        }


        if (mnh3a.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.mnh3a), Toast.LENGTH_SHORT).show();
            mnh3a.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "mnh3a: This data is Required!");
            return false;
        } else {
            mnh3a.setError(null);
        }


        if (mnh3b.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.mnh3b), Toast.LENGTH_SHORT).show();
            mnh3b.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "mnh3b: This data is Required!");
            return false;
        } else {
            mnh3b.setError(null);
        }


        if (mnh4.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.mnh4), Toast.LENGTH_SHORT).show();
            mnh4a.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "mnh4a: This data is Required!");
            return false;
        } else {
            mnh4a.setError(null);
        }


        if (mnh4c.isChecked()) {

            if (mnh4cdt.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.mnh4cdt), Toast.LENGTH_SHORT).show();
                mnh4cdt.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "mnh4cdt: This data is Required!");
                return false;
            } else {
                mnh4cdt.setError(null);
            }

        }


        if (mnh488.isChecked()) {

            if (mnh488x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.others), Toast.LENGTH_SHORT).show();
                mnh488x.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "mnh488x: This data is Required!");
                return false;
            } else {
                mnh488x.setError(null);
            }

        }

        //}

        return true;
    }

    private boolean SaveDraft() throws JSONException {

        Toast.makeText(this, "Validating Section H", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        /*JSONObject sH1 = new JSONObject();

        sH1.put("mnh1", mnh1a.isChecked() ? "1" : mnh1b.isChecked() ? "2" : "0");
        sH1.put("mnh2a", mnh2a.getText().toString());

        AppMain.NoOfLocations = Integer.parseInt(mnh2a.getText().toString());

        AppMain.fc.setsH(String.valueOf(sH1));*/

        AppMain.lc = new LocationContract();
        AppMain.lc.setFormDate(AppMain.fc.getFormDate());
        AppMain.lc.setUser(AppMain.fc.getUserName());
        AppMain.lc.setsH(AppMain.fc.getUserName());
        AppMain.lc.setDeviceId(AppMain.fc.getDeviceID());
        AppMain.lc.setDevicetagID(sharedPref.getString("tagName", null));


        JSONObject sH = new JSONObject();

        sH.put("mnh2", mnh2.getText().toString());
        sH.put("mnh3a", mnh3a.getText().toString());
        sH.put("mnh3b", mnh3b.getText().toString());
        sH.put("mnh4", mnh4a.isChecked() ? "1"
                : mnh4b.isChecked() ? "2"
                : mnh4c.isChecked() ? "3"
                : mnh4d.isChecked() ? "4"
                : mnh4e.isChecked() ? "5"
                : mnh488.isChecked() ? "88"
                : "0");

        sH.put("mnh4cdt", mnh4cdt.getText().toString());
        sH.put("mnh488x", mnh488x.getText().toString());


        AppMain.lc.setsH(String.valueOf(sH));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

        return true;
    }

}