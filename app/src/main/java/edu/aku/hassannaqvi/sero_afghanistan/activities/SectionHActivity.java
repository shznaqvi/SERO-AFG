package edu.aku.hassannaqvi.sero_afghanistan.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;
import io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText;


public class SectionHActivity extends AppCompatActivity {

    private static final String TAG = SectionHActivity.class.getSimpleName();

    @BindView(R.id.mnh1)
    RadioGroup mnh1;
    @BindView(R.id.mnh1a)
    RadioButton mnh1a;
    @BindView(R.id.mnh1b)
    RadioButton mnh1b;

    @BindView(R.id.mnh2a)
    EditText mnh2a;

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


    @BindView(R.id.fldGrpmnh2)
    LinearLayout fldGrpmnh2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_h);
        ButterKnife.bind(this);

        mnh4cdt.setManager(getSupportFragmentManager());
        String dtToday = new SimpleDateFormat("dd/MM/yyyy").format(new Date().getTime());
        mnh4cdt.setMaxDate(dtToday);


        mnh1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (mnh1a.isChecked()) {
                    mnh2a.setText(null);
                    fldGrpmnh2.setVisibility(View.GONE);
                } else {
                    fldGrpmnh2.setVisibility(View.VISIBLE);
                    mnh2a.requestFocus();
                }
            }
        });

        mnh4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (mnh4c.isChecked()) {
                    mnh488x.setText(null);
                    fldGrpmnh488.setVisibility(View.GONE);

                    fldGrpmnh4c.setVisibility(View.VISIBLE);

                } else if (mnh488.isChecked()) {
                    //mnh4cdt.setText(null);
                    fldGrpmnh4c.setVisibility(View.GONE);

                    fldGrpmnh488.setVisibility(View.VISIBLE);
                    mnh488x.requestFocus();
                } else {
                    mnh488x.setText(null);
                    //mnh4cdt.setText(null);
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

                    if (mnh1a.isChecked()) {
                        Toast.makeText(this, "Starting Section G", Toast.LENGTH_SHORT).show();
                        finish();
                        Intent main = new Intent(this, SectionGActivity.class);
                        //main.putExtra("complete", true);
                        startActivity(main);
                    } else {
                        Toast.makeText(this, "Starting Location", Toast.LENGTH_SHORT).show();
                        finish();
                        Intent main = new Intent(this, LocationActivity.class);
                        startActivity(main);
                    }


                } else {
                    Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
                }
            } else {
                finish();
//                startActivity(new Intent(this, MainActivity.class));
            }
        }
    }


    @OnClick(R.id.btn_End)
    void endInterview() {
        AppMain.IsExit = false;
        AppMain.endActivity(this, this);
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateFormssH();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private boolean SaveDraft() throws JSONException {

        Toast.makeText(this, "Validating Section H", Toast.LENGTH_SHORT).show();

        JSONObject sH = new JSONObject();

        sH.put("mnh1", mnh1a.isChecked() ? "1" : mnh1b.isChecked() ? "2" : "0");
        sH.put("mnh2a", mnh2a.getText().toString());

        if (!mnh2a.getText().toString().isEmpty()) {
            AppMain.NoOfLocations = Integer.valueOf(mnh2a.getText().toString());
        }

        sH.put("mnh4", mnh4a.isChecked() ? "1"
                : mnh4b.isChecked() ? "2"
                : mnh4c.isChecked() ? "3"
                : mnh4d.isChecked() ? "4"
                : mnh4e.isChecked() ? "5"
                : mnh488.isChecked() ? "88"
                : "0");

        sH.put("mnh4cdt", mnh4cdt.getText().toString());
        sH.put("mnh488x", mnh488x.getText().toString());

        AppMain.fc.setsH(String.valueOf(sH));

        return true;
    }


    private boolean ValidateForm() {

        if (mnh1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.mnh1), Toast.LENGTH_SHORT).show();
            mnh1a.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "mnh1: This data is Required!");
            return false;
        } else {
            mnh1a.setError(null);
        }


        if (mnh1b.isChecked()) {

            if (mnh2a.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.mnh2a), Toast.LENGTH_SHORT).show();
                mnh2a.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "mnh2a: This data is Required!");
                return false;
            } else {
                mnh2a.setError(null);
            }


            if (Integer.valueOf(mnh2a.getText().toString()) <= 0) {
                Toast.makeText(this, "Number of location cannot be less than or equal to 0", Toast.LENGTH_SHORT).show();
                mnh2a.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "mnh2a: This data is Required!");
                return false;
            } else {
                mnh2a.setError(null);
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


        }

        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}