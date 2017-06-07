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
import android.widget.TextView;
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

    private static final String TAG = SectionAActivity.class.getSimpleName();

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
    TextView mngsticker;

    @BindView(R.id.fldGrpmng1c)
    LinearLayout fldGrpmng1c;

    @BindView(R.id.fldGrpmng2a)
    LinearLayout fldGrpmng2a;

    int rdo_mng1;
    String var_mng1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_g);
        ButterKnife.bind(this);

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
    }

    @OnClick(R.id.btnNext)
    public void SaveData() {

        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (UpdateDB()) {
                Toast.makeText(this, "Starting Main", Toast.LENGTH_SHORT).show();

                Intent main = new Intent(this, EndingActivity.class);
                main.putExtra("complete", true);
                startActivity(main);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
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
        db.updateSectionsG();

        return true;

        /*} else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

    }


    private boolean ValidateForm() {

        rdo_mng1 = mng1.getCheckedRadioButtonId();

        if (rdo_mng1 == -1) {
            mng1a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mng1), Toast.LENGTH_LONG).show();
            mng1.requestFocus();
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
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mng1c), Toast.LENGTH_LONG).show();
                mng1c.requestFocus();
                return false;
            } else {
                mng1c.setError(null);
            }

        } else {

            if (mng2a.getText().toString().isEmpty() || mng2a.getText().toString() == null) {
                mng2a.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mng2), Toast.LENGTH_LONG).show();
                mng2a.requestFocus();
                return false;
            } else {
                mng2a.setError(null);
            }


            if (mng2b.getText().toString().isEmpty() || mng2b.getText().toString() == null) {
                mng2b.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mng2), Toast.LENGTH_LONG).show();
                mng2b.requestFocus();
                return false;
            } else {
                mng2b.setError(null);
            }


            if (mngsticker.getText().toString().isEmpty() || mng2b.getText().toString() == null) {
                mngsticker.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mng2), Toast.LENGTH_LONG).show();
                mngsticker.requestFocus();
                return false;
            } else {
                mngsticker.setError(null);
            }

        }


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

        sG.put("mng1", var_mng1);
        sG.put("mng2a", mng2a.getText().toString());
        sG.put("mng2b", mng2b.getText().toString());

        if (mng2b.getText().toString().equals("Sticker") || mng2b.getText().toString() == "Sticker") {
            sG.put("mngsticker", "");
        } else {
            sG.put("mngsticker", mngsticker.getText().toString());
        }


        AppMain.fc.setsG(String.valueOf(sG));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

        return true;
    }

    @OnClick(R.id.btnScan)
    public void startScan() {
        mngsticker.setText(null);
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
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
                mngsticker.setEnabled(false);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}