package edu.aku.hassannaqvi.sero_afghanistan.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.IdRes;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.FormsContract;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.UCsContract;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;

public class SectionAActivity extends Activity {

    private static final String TAG = SectionAActivity.class.getSimpleName();

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;
    @BindView(R.id.lbl_mainhead)
    TextView lblMainhead;
    @BindView(R.id.mainhead)
    EditText mainhead;
    @BindView(R.id.lbl_mnaheading)
    TextView lblMnaheading;
    @BindView(R.id.mnaheading)
    EditText mnaheading;
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
    EditText mna4;
    @BindView(R.id.lbl_mna5)
    TextView lblMna5;
    @BindView(R.id.mna5)
    EditText mna5;
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
    @BindView(R.id.mnbheading)
    EditText mnbheading;
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
    @BindView(R.id.mnb4)
    EditText mnb4;
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
    @BindView(R.id.mnb5)
    EditText mnb5;
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
    @BindView(R.id.mnb6)
    EditText mnb6;
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
    @BindView(R.id.mnb7)
    EditText mnb7;
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
    @BindView(R.id.mncheading)
    EditText mncheading;
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
    @BindView(R.id.mnc3)
    EditText mnc3;
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
    RadioButton mnc4E;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_a);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnNext)
    public void SaveData() {
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean SaveDraft() throws JSONException {

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();



        return true;
    }


    private boolean ValidateForm() {

        Toast.makeText(this, "Validating Section A, B and C", Toast.LENGTH_SHORT).show();

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

        if (mna5.getText().toString().isEmpty() || mna5.getText().toString() == null) {
            mna5.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mna5), Toast.LENGTH_LONG).show();
            mna5.requestFocus();
            return false;
        } else {
            mna5.setError(null);
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

        if (mnb4.getText().toString().isEmpty() || mnb4.getText().toString() == null) {
            mnb4.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb4), Toast.LENGTH_LONG).show();
            mnb4.requestFocus();
            return false;
        } else {
            mnb4.setError(null);
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

        if (mnb5.getText().toString().isEmpty() || mnb5.getText().toString() == null) {
            mnb5.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb5), Toast.LENGTH_LONG).show();
            mnb5.requestFocus();
            return false;
        } else {
            mnb5.setError(null);
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

        if (mnb6.getText().toString().isEmpty() || mnb6.getText().toString() == null) {
            mnb6.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb6), Toast.LENGTH_LONG).show();
            mnb6.requestFocus();
            return false;
        } else {
            mnb6.setError(null);
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

        if (mnb7.getText().toString().isEmpty() || mnb7.getText().toString() == null) {
            mnb7.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnb7), Toast.LENGTH_LONG).show();
            mnb7.requestFocus();
            return false;
        } else {
            mnb7.setError(null);
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
            mnc2.requestFocus();
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
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnc2x), Toast.LENGTH_LONG).show();
                mnc2x.requestFocus();
                return false;
            } else {
                mnc2x.setError(null);
            }
        }


        if (mnc3.getText().toString().isEmpty() || mnc3.getText().toString() == null) {
            mnc3.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnc3), Toast.LENGTH_LONG).show();
            mnc3.requestFocus();
            return false;
        } else {
            mnc3.setError(null);
        }

        if (mnc3years.getText().toString().isEmpty() || mnc3years.getText().toString() == null) {
            mnc3years.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnc3years), Toast.LENGTH_LONG).show();
            mnc3years.requestFocus();
            return false;
        } else {
            mnc3years.setError(null);
        }

        rdo_mnc4 = mnc4.getCheckedRadioButtonId();

        if (rdo_mnc4 == -1) {
            mnc4a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnc4), Toast.LENGTH_LONG).show();
            mnc4.requestFocus();
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
                Toast.makeText(getApplicationContext(), "ERROR(empty): " + getString(R.string.mnc4x), Toast.LENGTH_LONG).show();
                mnc4x.requestFocus();
                return false;
            } else {
                mnc4x.setError(null);
            }

        }

        return true;
    }

}