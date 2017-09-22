package edu.aku.hassannaqvi.sero_afghanistan.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;

public class SectionGActivity extends Activity {

    private static final String TAG = SectionGActivity.class.getSimpleName();

    @BindView(R.id.mng1)
    RadioGroup mng1;
    @BindView(R.id.mng1a)
    RadioButton mng1a;
    @BindView(R.id.mng1b)
    RadioButton mng1b;
    @BindView(R.id.mng1c)
    EditText mng1c;
    @BindView(R.id.mng2a)
    EditText mng2a;
    @BindView(R.id.mng2b)
    EditText mng2b;
    @BindView(R.id.mngsticker)
    EditText mngsticker;

    @BindView(R.id.fldGrpmng1c)
    LinearLayout fldGrpmng1c;

    @BindView(R.id.fldGrpmng2a)
    LinearLayout fldGrpmng2a;

    /*@BindView(R.id.mnh1)
    RadioGroup mnh1;
    @BindView(R.id.mnh1a)
    RadioButton mnh1a;
    @BindView(R.id.mnh1b)
    RadioButton mnh1b;

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

    @BindView(R.id.fldGrpmnh2)
    LinearLayout fldGrpmnh2;*/


    int rdo_mng1;
    String var_mng1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_g);
        ButterKnife.bind(this);

        /*mnh4cdt.setManager(getSupportFragmentManager());

        String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

        mnh4cdt.setMaxDate(dtToday);*/

        mng1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (mng1a.isChecked()) {

                    fldGrpmng2a.setVisibility(View.VISIBLE);

                    mng2a.requestFocus();
                    mng1c.setText(null);

                    fldGrpmng1c.setVisibility(View.GONE);
                } else {

                    fldGrpmng1c.setVisibility(View.VISIBLE);
                    fldGrpmng2a.setVisibility(View.GONE);

                    mng2a.setText(null);
                    mng2b.setText(null);
                    mngsticker.setText(null);

                    mng1c.requestFocus();
                }
            }
        });


       /* mnh1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (mnh1a.isChecked()) {

                    mnh2.setText(null);
                    mnh3a.setText(null);
                    mnh3b.setText(null);
                    mnh4.clearCheck();

                    fldGrpmnh2.setVisibility(View.GONE);

                } else {
                    fldGrpmnh2.setVisibility(View.VISIBLE);
                    mnh2.requestFocus();
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
                    mnh4cdt.requestFocus();

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
        });*/


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
                    Toast.makeText(this, "Starting Main", Toast.LENGTH_SHORT).show();
                    finish();

                    Intent main = new Intent(this, EndingActivity.class);
                    main.putExtra("complete", true);
                    startActivity(main);
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
        int updcount = db.updateSectionsG();

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


    private boolean ValidateForm() {

        rdo_mng1 = mng1.getCheckedRadioButtonId();

        if (rdo_mng1 == -1) {
            mng1a.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mng1), Toast.LENGTH_LONG).show();
            Log.i(TAG, "mng1a: This Data is Required!");
            mng1a.requestFocus();
            return false;
        } else {
            mng1a.setError(null);
        }

        switch (rdo_mng1) {
            case R.id.mng1a:
                var_mng1 = "1";
                break;
            case R.id.mng1b:
                var_mng1 = "2";
                break;
        }

        if (var_mng1 == "2") {

            if (mng1c.getText().toString().isEmpty() || mng1c.getText().toString() == null) {
                mng1c.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mng1c), Toast.LENGTH_LONG).show();
                Log.i(TAG, "mng1c: This Data is Required!");
                mng1c.requestFocus();
                return false;
            } else {
                mng1c.setError(null);
            }

        } else {

            if (mng2a.getText().toString().isEmpty() || mng2a.getText().toString() == null) {
                mng2a.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mng2), Toast.LENGTH_LONG).show();
                Log.i(TAG, "mng2a: This Data is Required!");
                mng2a.requestFocus();
                return false;
            } else {
                mng2a.setError(null);
            }


            if (mng2b.getText().toString().isEmpty() || mng2b.getText().toString() == null) {
                mng2b.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mng2), Toast.LENGTH_LONG).show();
                Log.i(TAG, "mng2b: This Data is Required!");
                mng2b.requestFocus();
                return false;
            } else {
                mng2b.setError(null);
            }


            if (mngsticker.getText().toString().isEmpty() || mng2b.getText().toString() == null) {
                mngsticker.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(empty): Please scanned sticker ", Toast.LENGTH_LONG).show();
                Log.i(TAG, "mngsticker: This Data is Required!");
                mngsticker.requestFocus();
                return false;
            } else {
                mngsticker.setError(null);
            }

        }


        /*if (mnh1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.mnh1), Toast.LENGTH_SHORT).show();
            mnh1a.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "mnh1: This data is Required!");
            return false;
        } else {
            mnh1a.setError(null);
        }


        if (mnh1b.isChecked()) {

            if (mnh2.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.mnh2), Toast.LENGTH_SHORT).show();
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

        }*/

        return true;
    }

    private boolean SaveDraft() throws JSONException {

        Toast.makeText(this, "Validating Section G", Toast.LENGTH_SHORT).show();

        JSONObject sG = new JSONObject();

        rdo_mng1 = mng1.getCheckedRadioButtonId();

        switch (rdo_mng1) {
            case R.id.mng1a:
                var_mng1 = "1";
                break;
            case R.id.mng1b:
                var_mng1 = "2";
                break;
        }

        sG.put("mng1", mng1a.isChecked() ? "1" : mng1b.isChecked() ? "2" : "0");
        sG.put("mng2a", mng2a.getText().toString());
        sG.put("mng2b", mng2b.getText().toString());

        if (mng2b.getText().toString().equals("Sticker") || mng2b.getText().toString() == "Sticker") {
            sG.put("mngsticker", "");
        } else {
            sG.put("mngsticker", mngsticker.getText().toString());
        }


        /*sG.put("mnh1", mnh1a.isChecked() ? "1" : mnh1b.isChecked() ? "2" : "0");
        sG.put("mnh2", mnh2.getText().toString());
        sG.put("mnh3a", mnh3a.getText().toString());
        sG.put("mnh3b", mnh3b.getText().toString());
        sG.put("mnh4", mnh4a.isChecked() ? "1"
                : mnh4b.isChecked() ? "2"
                : mnh4c.isChecked() ? "3"
                : mnh4d.isChecked() ? "4"
                : mnh4e.isChecked() ? "5"
                : mnh488.isChecked() ? "88"
                : "0");

        sG.put("mnh4cdt", mnh4cdt.getText().toString());
        sG.put("mnh488x", mnh488x.getText().toString());*/


        AppMain.fc.setsG(String.valueOf(sG));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

        return true;
    }

    @OnClick(R.id.btnScan)
    public void startScan() {
        mngsticker.setText(null);
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scan a blood sample sticker");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.setOrientationLocked(false);

        integrator.initiateScan();
    }

    // Get the results:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                mngsticker.setText("§" + result.getContents());
                //mngsticker.setEnabled(false);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}