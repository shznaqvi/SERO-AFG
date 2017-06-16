package edu.aku.hassannaqvi.sero_afghanistan.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;

public class SectionFActivity extends Activity {

    private static final String TAG = SectionFActivity.class.getSimpleName();

    @BindView(R.id.mnf1a)
    CheckBox mnf1a;

    @BindView(R.id.mnf1b)
    CheckBox mnf1b;

    @BindView(R.id.mnf1c)
    CheckBox mnf1c;

    @BindView(R.id.mnf1d)
    CheckBox mnf1d;

    @BindView(R.id.mnf1e)
    CheckBox mnf1e;

    @BindView(R.id.mnf1f)
    CheckBox mnf1f;

    @BindView(R.id.mnf1g)
    CheckBox mnf1g;

    @BindView(R.id.mnf1h)
    CheckBox mnf1h;

    @BindView(R.id.mnf188)
    CheckBox mnf188;

    @BindView(R.id.mnf1x)
    EditText mnf1x;

    @BindView(R.id.mnf2)
    RadioGroup mnf2;

    @BindView(R.id.mnf2a)
    RadioButton mnf2a;
    @BindView(R.id.mnf2b)
    RadioButton mnf2b;
    @BindView(R.id.mnf2c)
    RadioButton mnf2c;
    @BindView(R.id.mnf288)
    RadioButton mnf288;

    @BindView(R.id.mnf2x)
    EditText mnf2x;

    @BindView(R.id.mnf3years)
    EditText mnf3years;

    @BindView(R.id.mnf3months)
    EditText mnf3months;

    @BindView(R.id.mnf4)
    RadioGroup mnf4;
    @BindView(R.id.mnf4a)
    RadioButton mnf4a;
    @BindView(R.id.mnf4b)
    RadioButton mnf4b;

    @BindView(R.id.mnf5)
    EditText mnf5;

    @BindView(R.id.fldGrpmnf1x)
    LinearLayout fldGrpmnf1x;

    @BindView(R.id.fldGrpmnf2x)
    LinearLayout fldGrpmnf2x;

    @BindView(R.id.fldGrpmnf4a)
    LinearLayout fldGrpmnf4a;

    int rdo_mnf2;
    String var_mnf2;

    int rdo_mnf4;
    String var_mnf4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_f);
        ButterKnife.bind(this);

        mnf188.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mnf188.isChecked()) {
                    fldGrpmnf1x.setVisibility(View.VISIBLE);
                    mnf1x.requestFocus();
                } else {
                    mnf1x.setText(null);
                    fldGrpmnf1x.setVisibility(View.GONE);
                }
            }
        });


        mnf2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (mnf288.isChecked()) {
                    fldGrpmnf2x.setVisibility(View.VISIBLE);
                    mnf2x.requestFocus();
                } else {
                    mnf2x.setText(null);
                    fldGrpmnf2x.setVisibility(View.GONE);
                }
            }
        });

        mnf4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (mnf4a.isChecked()) {
                    fldGrpmnf4a.setVisibility(View.VISIBLE);
                    mnf5.requestFocus();
                } else {
                    mnf5.setText(null);
                    fldGrpmnf4a.setVisibility(View.GONE);
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
                    Toast.makeText(this, "Starting Section G", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent secG = new Intent(this, SectionGActivity.class);
                    startActivity(secG);
                } else {
                    Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
                }
            } else {
                finish();
                startActivity(new Intent(this, MainActivity.class));
            }
        }
    }


    @OnClick(R.id.btn_End)
    void endInterview() {
        Intent endSec = new Intent(this, EndingActivity.class);
        endSec.putExtra("complete", false);
        startActivity(endSec);
    }


    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        // 1. INSERT FORM
        //rowId = db.addForm(AppMain.fc);

        //AppMain.fc.setID(String.valueOf(rowId));

        //if (rowId != null) {

        Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
        /*AppMain.fc.setUID(
                (AppMain.fc.getDeviceID() + AppMain.fc.getID()));*/
        //Toast.makeText(this, "Current Form No: " + AppMain.fc.getUID(), Toast.LENGTH_SHORT).show();

        // 2. UPDATE FORM ROWID
        int updcount = db.updateSectionsF();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
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


    private boolean SaveDraft() throws JSONException {

        Toast.makeText(this, "Validating Section F", Toast.LENGTH_SHORT).show();

        JSONObject sF = new JSONObject();

        sF.put("mnf1a", mnf1a.isChecked() ? "1" : "0");
        sF.put("mnf1b", mnf1b.isChecked() ? "2" : "0");
        sF.put("mnf1c", mnf1c.isChecked() ? "3" : "0");
        sF.put("mnf1d", mnf1d.isChecked() ? "4" : "0");
        sF.put("mnf1e", mnf1e.isChecked() ? "5" : "0");
        sF.put("mnf1f", mnf1f.isChecked() ? "6" : "0");
        sF.put("mnf1g", mnf1g.isChecked() ? "7" : "0");
        sF.put("mnf1h", mnf1h.isChecked() ? "8" : "0");
        sF.put("mnf188", mnf188.isChecked() ? "88" : "0");

        rdo_mnf2 = mnf2.getCheckedRadioButtonId();

        switch (rdo_mnf2) {
            case R.id.mnf2a:
                var_mnf2 = "1";
                break;
            case R.id.mnf2b:
                var_mnf2 = "2";
                break;
            case R.id.mnf2c:
                var_mnf2 = "3";
                break;
            case R.id.mnf288:
                var_mnf2 = "88";
                break;
        }


        sF.put("mnf1x", mnf1x.getText().toString());


        sF.put("mnf2", mnf2a.isChecked() ? "1"
                : mnf2b.isChecked() ? "2"
                : mnf2c.isChecked() ? "3"
                : mnf288.isChecked() ? "88"
                : "0");


        sF.put("mnf2x", mnf2x.getText().toString());


        sF.put("mnf3years", mnf3years.getText().toString());
        sF.put("mnf3months", mnf3months.getText().toString());

        rdo_mnf4 = mnf4.getCheckedRadioButtonId();

        switch (rdo_mnf4) {
            case R.id.mnf4a:
                var_mnf4 = "1";
                break;
            case R.id.mnf4b:
                var_mnf4 = "2";
                break;
        }

        sF.put("mnf4", mnf4a.isChecked() ? "1" : mnf4b.isChecked() ? "2" : "0");
        sF.put("mnf5", mnf5.getText().toString());

        AppMain.fc.setsF(String.valueOf(sF));

        Toast.makeText(this, "Saving Draft... Successful!", Toast.LENGTH_SHORT).show();

        return true;
    }

    private boolean ValidateForm() {

        if (!mnf1a.isChecked() &&
                !mnf1b.isChecked() &&
                !mnf1c.isChecked() &&
                !mnf1d.isChecked() &&
                !mnf1e.isChecked() &&
                !mnf1f.isChecked() &&
                !mnf1g.isChecked() &&
                !mnf1h.isChecked() &&
                !mnf188.isChecked()) {
            mnf1a.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnf1), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnf1a: This Data is Required!");
            mnf1a.requestFocus();
            return false;
        } else {
            mnf1a.setError(null);
        }


        if (mnf188.isChecked()) {

            if (mnf1x.getText().toString().isEmpty() || mnf1x.getText().toString() == null) {

                mnf1x.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.others), Toast.LENGTH_LONG).show();
                Log.i(TAG, "mnf1x: This Data is Required!");
                mnf1x.requestFocus();
                return false;

            } else {
                mnf1x.setError(null);
            }
        }


        rdo_mnf2 = mnf2.getCheckedRadioButtonId();

        if (rdo_mnf2 == -1) {
            mnf2a.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnf2), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnf2a: This Data is Required!");
            mnf2a.requestFocus();
            return false;
        } else {
            mnf2a.setError(null);
        }

//        switch (rdo_mnf2) {
//            case R.id.mnf2a:
//                var_mnf2 = "1";
//                break;
//            case R.id.mnf2b:
//                var_mnf2 = "2";
//                break;
//            case R.id.mnf2c:
//                var_mnf2 = "3";
//                break;
//            case R.id.mnf288:
//                var_mnf2 = "88";
//                break;
//        }


        if (mnf288.isChecked()) {

            if (mnf2x.getText().toString().isEmpty() || mnf2x.getText().toString() == null) {

                mnf2x.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.others), Toast.LENGTH_LONG).show();
                Log.i(TAG, "mnf2x: This Data is Required!");
                mnf2x.requestFocus();
                return false;

            } else {
                mnf2x.setError(null);
            }
        }


        if (mnf3years.getText().toString().isEmpty() || mnf3years.getText().toString() == null) {
            mnf3years.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnf3), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnf3years: This Data is Required!");
            mnf3years.requestFocus();
            return false;
        } else {
            mnf3years.setError(null);
        }

        if (mnf3months.getText().toString().isEmpty() || mnf3months.getText().toString() == null) {
            mnf3months.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnf3), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnf3months: This Data is Required!");
            mnf3months.requestFocus();
            return false;
        } else {
            mnf3months.setError(null);
        }

        if (Integer.parseInt(mnf3months.getText().toString()) > 11) {
            mnf3months.setError("Range 0 - 11");
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnf3), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnf3months: This Data is invalid!");
            mnf3months.requestFocus();
            return false;
        } else {
            mnf3months.setError(null);
        }

        if ((Integer.valueOf(mnf3years.getText().toString()) == 0)
                && (Integer.valueOf(mnf3months.getText().toString()) == 0)) {
            Toast.makeText(this, "Invalid:" + getString(R.string.mnf3), Toast.LENGTH_SHORT).show();
            mnf3years.setError("Invalid: Years and months can not be zero");
            mnf3months.setError("Invalid: Years and months can not be zero");

            Log.i(TAG, "mnf3: Years and months can not be zero");
            return false;
        } else {
            mnf3years.setError(null);
            mnf3months.setError(null);
        }

        rdo_mnf4 = mnf4.getCheckedRadioButtonId();

        if (rdo_mnf4 == -1) {
            mnf4a.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnf4), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnf4a: This Data is Required!");
            mnf4a.requestFocus();
            return false;
        } else {
            mnf4a.setError(null);
        }

        /*switch (rdo_mnf4) {
            case R.id.mnf4a:
                var_mnf4 = "1";
                break;
            case R.id.mnf4b:
                var_mnf4 = "2";
                break;
        }*/


        if (mnf4a.isChecked()) {

            if (mnf5.getText().toString().isEmpty() || mnf5.getText().toString() == null) {
                mnf5.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnf5), Toast.LENGTH_LONG).show();
                Log.i(TAG, "mnf5: This Data is Required!");
                mnf5.requestFocus();
                return false;
            } else {
                mnf5.setError(null);
            }

        }


        if (mnf3years.getText().toString() == "0" && mnf3months.getText().toString() == "0") {
            mnf3years.setError("Year and month both cannot be 0");
            Toast.makeText(getApplicationContext(), "ERROR(invalid): Year and month both cannot be 0 ", Toast.LENGTH_LONG).show();
            Log.i(TAG, "mnf3years: This Data is invalid!");
            mnf3years.requestFocus();
            return false;
        } else {
            mnf3years.setError(null);
        }


        return true;
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}