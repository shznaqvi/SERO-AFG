package edu.aku.hassannaqvi.sero_afghanistan.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.support.annotation.IdRes;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;


public class SectionHActivity extends Activity {

    private static final String TAG = SectionHActivity.class.getSimpleName();

    @BindView(R.id.mnh1)
    RadioGroup mnh1;
    @BindView(R.id.mnh1a)
    RadioButton mnh1a;
    @BindView(R.id.mnh1b)
    RadioButton mnh1b;

    @BindView(R.id.mnh2a)
    EditText mnh2a;

    @BindView(R.id.fldGrpmnh2)
    LinearLayout fldGrpmnh2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_h);
        ButterKnife.bind(this);

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
                        Toast.makeText(this, "Starting Ending", Toast.LENGTH_SHORT).show();
                        finish();
                        Intent main = new Intent(this, EndingActivity.class);
                        main.putExtra("complete", true);
                        startActivity(main);
                    } else {
                        Toast.makeText(this, "Starting Location", Toast.LENGTH_SHORT).show();
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
        Intent endSec = new Intent(this, EndingActivity.class);
        endSec.putExtra("complete", false);
        startActivity(endSec);
        finish();
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
            AppMain.NoOfLocations = Integer.parseInt(mnh2a.getText().toString());
        }

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
        }

        return true;
    }

}