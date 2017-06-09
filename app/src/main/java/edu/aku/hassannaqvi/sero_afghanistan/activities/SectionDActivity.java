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

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;
import butterknife.BindView;

import butterknife.OnClick;
import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.FormsContract;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;

public class SectionDActivity extends Activity {

    private static final String TAG = SectionAActivity.class.getSimpleName();

    @BindView(R.id.mnd1)
    RadioGroup mnd1;
    @BindView(R.id.mnd1a)
    RadioButton mnd1a;
    @BindView(R.id.mnd1b)
    RadioButton mnd1b;
    @BindView(R.id.mnd1c)
    RadioButton mnd1c;

    @BindView(R.id.mnd2)
    RadioGroup mnd2;
    @BindView(R.id.mnd2a)
    RadioButton mnd2a;
    @BindView(R.id.mnd2b)
    RadioButton mnd2b;
    @BindView(R.id.mnd2c)
    RadioButton mnd2c;

    @BindView(R.id.mnd3)
    RadioGroup mnd3;
    @BindView(R.id.mnd3a)
    RadioButton mnd3a;
    @BindView(R.id.mnd3b)
    RadioButton mnd3b;

    @BindView(R.id.mnd4)
    RadioGroup mnd4;
    @BindView(R.id.mnd4a)
    RadioButton mnd4a;
    @BindView(R.id.mnd4b)
    RadioButton mnd4b;
    @BindView(R.id.mnd4c)
    RadioButton mnd4c;

    @BindView(R.id.bcg)
    RadioGroup bcg;
    @BindView(R.id.bcga)
    RadioButton bcga;
    @BindView(R.id.bcgb)
    RadioButton bcgb;
    @BindView(R.id.opv0)
    RadioGroup opv0;
    @BindView(R.id.opv0a)
    RadioButton opv0a;
    @BindView(R.id.opv0b)
    RadioButton opv0b;
    @BindView(R.id.penta1)
    RadioGroup penta1;
    @BindView(R.id.penta1a)
    RadioButton penta1a;
    @BindView(R.id.penta1b)
    RadioButton penta1b;
    @BindView(R.id.pcv1)
    RadioGroup pcv1;
    @BindView(R.id.pcv1a)
    RadioButton pcv1a;
    @BindView(R.id.pcv1b)
    RadioButton pcv1b;
    @BindView(R.id.opv1)
    RadioGroup opv1;
    @BindView(R.id.opv1a)
    RadioButton opv1a;
    @BindView(R.id.opv1b)
    RadioButton opv1b;
    @BindView(R.id.penta2)
    RadioGroup penta2;
    @BindView(R.id.penta2a)
    RadioButton penta2a;
    @BindView(R.id.penta2b)
    RadioButton penta2b;
    @BindView(R.id.pcv2)
    RadioGroup pcv2;
    @BindView(R.id.pcv2a)
    RadioButton pcv2a;
    @BindView(R.id.pcv2b)
    RadioButton pcv2b;
    @BindView(R.id.opv2)
    RadioGroup opv2;
    @BindView(R.id.opv2a)
    RadioButton opv2a;
    @BindView(R.id.opv2b)
    RadioButton opv2b;
    @BindView(R.id.penta3)
    RadioGroup penta3;
    @BindView(R.id.penta3a)
    RadioButton penta3a;
    @BindView(R.id.penta3b)
    RadioButton penta3b;
    @BindView(R.id.pcv3)
    RadioGroup pcv3;
    @BindView(R.id.pcv3a)
    RadioButton pcv3a;
    @BindView(R.id.pcv3b)
    RadioButton pcv3b;
    @BindView(R.id.opv3)
    RadioGroup opv3;
    @BindView(R.id.opv3a)
    RadioButton opv3a;
    @BindView(R.id.opv3b)
    RadioButton opv3b;
    @BindView(R.id.ipv)
    RadioGroup ipv;
    @BindView(R.id.ipva)
    RadioButton ipva;
    @BindView(R.id.ipvb)
    RadioButton ipvb;
    @BindView(R.id.measles1)
    RadioGroup measles1;
    @BindView(R.id.measles1a)
    RadioButton measles1a;
    @BindView(R.id.measles1b)
    RadioButton measles1b;
    @BindView(R.id.measles2)
    RadioGroup measles2;
    @BindView(R.id.measles2a)
    RadioButton measles2a;
    @BindView(R.id.measles2b)
    RadioButton measles2b;
    @BindView(R.id.mnd6)
    RadioGroup mnd6;
    @BindView(R.id.mnd6a)
    RadioButton mnd6a;
    @BindView(R.id.mnd6b)
    RadioButton mnd6b;
    @BindView(R.id.mnd6c)
    RadioButton mnd6c;

    @BindView(R.id.mnd7)
    RadioGroup mnd7;
    @BindView(R.id.mnd7a)
    RadioButton mnd7a;
    @BindView(R.id.mnd7b)
    RadioButton mnd7b;
    @BindView(R.id.mnd7c)
    RadioButton mnd7c;

    @BindView(R.id.mnd8)
    EditText mnd8;
    @BindView(R.id.mnd9)
    RadioGroup mnd9;
    @BindView(R.id.mnd9a)
    RadioButton mnd9a;
    @BindView(R.id.mnd9b)
    RadioButton mnd9b;
    @BindView(R.id.mnd9c)
    RadioButton mnd9c;


    @BindView(R.id.mnd10years)
    EditText mnd10years;
    @BindView(R.id.mnd10months)
    EditText mnd10months;
    @BindView(R.id.mnd11)
    RadioGroup mnd11;
    @BindView(R.id.mnd11a)
    RadioButton mnd11a;
    @BindView(R.id.mnd11b)
    RadioButton mnd11b;
    @BindView(R.id.mnd11c)
    RadioButton mnd11c;
    @BindView(R.id.mnd11d)
    RadioButton mnd11d;
    @BindView(R.id.mnd11e)
    RadioButton mnd1188;
    @BindView(R.id.mnd11x)
    EditText mnd11x;
    @BindView(R.id.mnd12)
    RadioGroup mnd12;
    @BindView(R.id.mnd12a)
    RadioButton mnd12a;
    @BindView(R.id.mnd12b)
    RadioButton mnd12b;
    @BindView(R.id.mnd13)
    RadioGroup mnd13;
    @BindView(R.id.mnd13a)
    RadioButton mnd13a;
    @BindView(R.id.mnd13b)
    RadioButton mnd13b;
    @BindView(R.id.mnd13c)
    RadioButton mnd13c;
    @BindView(R.id.mnd13d)
    RadioButton mnd13d;

    @BindView(R.id.fldGrpmnd3)
    LinearLayout fldGrpmnd3;

    @BindView(R.id.fldGrpmnd5)
    LinearLayout fldGrpmnd5;

    @BindView(R.id.fldGrpmnd11)
    LinearLayout fldGrpmnd11;

    int rdo_mnd1;
    String var_mnd1;

    int rdo_mnd2;
    String var_mnd2;

    int rdo_mnd3;
    String var_mnd3;

    int rdo_mnd4;
    String var_mnd4;

    int rdo_mnd5;
    String var_mnd5;

    int rdo_bcg;
    String var_bcg;

    int rdo_opv0;
    String var_opv0;

    int rdo_penta1;
    String var_penta1;

    int rdo_pcv1;
    String var_pcv1;

    int rdo_opv1;
    String var_opv1;

    int rdo_penta2;
    String var_penta2;

    int rdo_pcv2;
    String var_pcv2;

    int rdo_opv2;
    String var_opv2;

    int rdo_penta3;
    String var_penta3;

    int rdo_pcv3;
    String var_pcv3;

    int rdo_opv3;
    String var_opv3;

    int rdo_ipv;
    String var_ipv;

    int rdo_measles1;
    String var_measles1;

    int rdo_measles2;
    String var_measles2;

    int rdo_mnd6;
    String var_mnd6;

    int rdo_mnd7;
    String var_mnd7;

    int rdo_mnd9;
    String var_mnd9;

    int rdo_mnd11;
    String var_mnd11;

    int rdo_mnd12;
    String var_mnd12;

    int rdo_mnd13;
    String var_mnd13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_d);
        ButterKnife.bind(this);

        mnd2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (mnd2a.isChecked()) {
                    fldGrpmnd3.setVisibility(View.VISIBLE);
                    mnd3a.requestFocus();
                } else {
                    mnd3.clearCheck();
                    fldGrpmnd3.setVisibility(View.GONE);
                }
            }
        });

        mnd4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (mnd4a.isChecked()) {
                    fldGrpmnd5.setVisibility(View.VISIBLE);
                    bcg.requestFocus();
                } else {
                    bcg.clearCheck();
                    opv0.clearCheck();
                    penta1.clearCheck();
                    pcv1.clearCheck();
                    opv1.clearCheck();
                    penta2.clearCheck();
                    pcv2.clearCheck();
                    opv2.clearCheck();
                    penta3.clearCheck();
                    pcv3.clearCheck();
                    opv3.clearCheck();
                    ipv.clearCheck();
                    measles1.clearCheck();
                    measles2.clearCheck();

                    fldGrpmnd5.setVisibility(View.GONE);
                }
            }
        });

        mnd11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (mnd1188.isChecked()) {
                    fldGrpmnd11.setVisibility(View.VISIBLE);
                    mnd11x.requestFocus();
                } else {
                    mnd11x.setText(null);
                    fldGrpmnd11.setVisibility(View.GONE);
                }
            }
        });
    }

    @OnClick(R.id.btnNext)
    void SaveData() {
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (UpdateDB()) {
                Toast.makeText(this, "Starting Section E", Toast.LENGTH_SHORT).show();

                Intent secE = new Intent(this, SectionEActivity.class);
                startActivity(secE);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
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
        int updcount = db.updateSectionsD();

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

        Toast.makeText(this, "Validating Section D", Toast.LENGTH_SHORT).show();

        JSONObject sD = new JSONObject();

        getCheckedRadioButtonID();

        sD.put("mnd1", mnd1a.isChecked() ? "1" : mnd1b.isChecked() ? "2" : mnd1c.isChecked() ? "99" : "0");
        sD.put("mnd2", mnd2a.isChecked() ? "1" : mnd2b.isChecked() ? "2" : mnd2c.isChecked() ? "99" : "0");
        sD.put("mnd3", mnd3a.isChecked() ? "1" : mnd3b.isChecked() ? "2" : "0");
        sD.put("mnd4", mnd4a.isChecked() ? "1" : mnd4b.isChecked() ? "2" : mnd4c.isChecked() ? "99" : "0");
        sD.put("bcg", bcga.isChecked() ? "1" : bcgb.isChecked() ? "2" : "0");
        sD.put("opv0", opv0a.isChecked() ? "1" : opv0b.isChecked() ? "2" : "0");
        sD.put("penta1", penta1a.isChecked() ? "1" : penta1b.isChecked() ? "2" : "0");
        sD.put("pcv1", pcv1a.isChecked() ? "1" : pcv1b.isChecked() ? "2" : "0");
        sD.put("opv1", opv1a.isChecked() ? "1" : opv1b.isChecked() ? "2" : "0");
        sD.put("penta2", penta2a.isChecked() ? "1" : penta2b.isChecked() ? "2" : "0");
        sD.put("pcv2", pcv2a.isChecked() ? "1" : pcv2b.isChecked() ? "2" : "0");
        sD.put("opv2", opv2a.isChecked() ? "1" : opv2b.isChecked() ? "2" : "0");
        sD.put("penta3", penta3a.isChecked() ? "1" : penta3b.isChecked() ? "2" : "0");
        sD.put("pcv3", pcv3a.isChecked() ? "1" : pcv3b.isChecked() ? "2" : "0");
        sD.put("opv3", opv3a.isChecked() ? "1" : opv3b.isChecked() ? "2" : "0");
        sD.put("ipv", ipva.isChecked() ? "1" : ipvb.isChecked() ? "2" : "0");
        sD.put("measles1", measles1a.isChecked() ? "1" : measles1b.isChecked() ? "2" : "0");
        sD.put("measles2", measles2a.isChecked() ? "1" : measles2b.isChecked() ? "2" : "0");
        sD.put("mnd6", mnd6a.isChecked() ? "1" : mnd6b.isChecked() ? "2" : mnd6c.isChecked() ? "99" : "0");
        sD.put("mnd7", mnd7a.isChecked() ? "1" : mnd7b.isChecked() ? "2" : mnd7c.isChecked() ? "99" : "0");
        sD.put("mnd8", mnd8.getText().toString());
        sD.put("mnd9", mnd9a.isChecked() ? "1" : mnd9b.isChecked() ? "2" : mnd9c.isChecked() ? "99" : "0");
        sD.put("mnd10years", mnd10years.getText().toString());
        sD.put("mnd10months", mnd10months.getText().toString());
        sD.put("mnd11", mnd11a.isChecked() ? "1" : mnd11b.isChecked() ? "2" : mnd11c.isChecked() ? "3" : mnd11d.isChecked() ? "4" : mnd1188.isChecked() ? "88" : "0");
        sD.put("mnd11x", mnd11x.getText().toString());
        sD.put("mnd12", mnd12a.isChecked() ? "1" : mnd12b.isChecked() ? "2" : "0");
        sD.put("mnd13", mnd13a.isChecked() ? "1" : mnd13b.isChecked() ? "2" : mnd13c.isChecked() ? "3" : mnd13d.isChecked() ? "99" : "0");

        AppMain.fc.setsD(String.valueOf(sD));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

        return true;
    }

    private void getCheckedRadioButtonID() {

        rdo_mnd1 = mnd1.getCheckedRadioButtonId();

        switch (rdo_mnd1) {
            case R.id.mnd1a:
                var_mnd1 = "1";
                break;
            case R.id.mnd1b:
                var_mnd1 = "2";
                break;
            case R.id.mnd1c:
                var_mnd1 = "99";
                break;
        }

        rdo_mnd2 = mnd2.getCheckedRadioButtonId();

        switch (rdo_mnd2) {
            case R.id.mnd2a:
                var_mnd2 = "1";
                break;
            case R.id.mnd2b:
                var_mnd2 = "2";
                break;
            case R.id.mnd2c:
                var_mnd2 = "99";
                break;
        }


        rdo_mnd3 = mnd3.getCheckedRadioButtonId();


        switch (rdo_mnd3) {
            case R.id.mnd3a:
                var_mnd3 = "1";
                break;
            case R.id.mnd3b:
                var_mnd3 = "2";
                break;
        }


        rdo_mnd4 = mnd4.getCheckedRadioButtonId();


        switch (rdo_mnd4) {
            case R.id.mnd4a:
                var_mnd4 = "1";
                break;
            case R.id.mnd4b:
                var_mnd4 = "2";
                break;
            case R.id.mnd4c:
                var_mnd4 = "99";
                break;
        }


        rdo_bcg = bcg.getCheckedRadioButtonId();


        switch (rdo_bcg) {
            case R.id.bcga:
                var_bcg = "1";
                break;
            case R.id.bcgb:
                var_bcg = "2";
                break;
        }


        rdo_opv0 = opv0.getCheckedRadioButtonId();

        switch (rdo_opv0) {
            case R.id.opv0a:
                var_opv0 = "1";
                break;
            case R.id.opv0b:
                var_opv0 = "2";
                break;
        }


        rdo_penta1 = penta1.getCheckedRadioButtonId();


        switch (rdo_penta1) {
            case R.id.penta1a:
                var_penta1 = "1";
                break;
            case R.id.penta1b:
                var_penta1 = "2";
                break;
        }


        rdo_pcv1 = pcv1.getCheckedRadioButtonId();


        switch (rdo_pcv1) {
            case R.id.pcv1a:
                var_pcv1 = "1";
                break;
            case R.id.pcv1b:
                var_pcv1 = "2";
                break;
        }


        rdo_opv1 = opv1.getCheckedRadioButtonId();

        switch (rdo_opv1) {
            case R.id.opv1a:
                var_opv1 = "1";
                break;
            case R.id.opv1b:
                var_opv1 = "2";
                break;
        }


        rdo_penta2 = penta2.getCheckedRadioButtonId();


        switch (rdo_penta2) {
            case R.id.penta2a:
                var_penta2 = "1";
                break;
            case R.id.penta2b:
                var_penta2 = "2";
                break;
        }


        rdo_pcv2 = pcv2.getCheckedRadioButtonId();


        switch (rdo_pcv2) {
            case R.id.pcv2a:
                var_pcv2 = "1";
                break;
            case R.id.pcv2b:
                var_pcv2 = "2";
                break;
        }


        rdo_opv2 = opv2.getCheckedRadioButtonId();


        switch (rdo_opv2) {
            case R.id.opv2a:
                var_opv2 = "1";
                break;
            case R.id.opv2b:
                var_opv2 = "2";
                break;
        }


        rdo_penta3 = penta3.getCheckedRadioButtonId();


        switch (rdo_penta3) {
            case R.id.penta3a:
                var_penta3 = "1";
                break;
            case R.id.penta3b:
                var_penta3 = "2";
                break;
        }


        rdo_pcv3 = pcv3.getCheckedRadioButtonId();

        switch (rdo_pcv3) {
            case R.id.pcv3a:
                var_pcv3 = "1";
                break;
            case R.id.pcv3b:
                var_pcv3 = "2";
                break;
        }


        rdo_opv3 = opv3.getCheckedRadioButtonId();


        switch (rdo_opv3) {
            case R.id.opv3a:
                var_opv3 = "1";
                break;
            case R.id.opv3b:
                var_opv3 = "2";
                break;
        }


        rdo_ipv = ipv.getCheckedRadioButtonId();


        switch (rdo_ipv) {
            case R.id.ipva:
                var_ipv = "1";
                break;
            case R.id.ipvb:
                var_ipv = "2";
                break;
        }


        rdo_measles1 = measles1.getCheckedRadioButtonId();


        switch (rdo_measles1) {
            case R.id.measles1a:
                var_measles1 = "1";
                break;
            case R.id.measles1b:
                var_measles1 = "2";
                break;
        }


        rdo_measles2 = measles2.getCheckedRadioButtonId();


        switch (rdo_measles2) {
            case R.id.measles2a:
                var_measles2 = "1";
                break;
            case R.id.measles2b:
                var_measles2 = "2";
                break;
        }


        rdo_mnd6 = mnd6.getCheckedRadioButtonId();


        switch (rdo_mnd6) {
            case R.id.mnd6a:
                var_mnd6 = "1";
                break;
            case R.id.mnd6b:
                var_mnd6 = "2";
                break;
            case R.id.mnd6c:
                var_mnd6 = "99";
                break;
        }


        rdo_mnd7 = mnd7.getCheckedRadioButtonId();


        switch (rdo_mnd7) {
            case R.id.mnd7a:
                var_mnd7 = "1";
                break;
            case R.id.mnd7b:
                var_mnd7 = "2";
                break;
            case R.id.mnd7c:
                var_mnd7 = "99";
                break;
        }


        rdo_mnd9 = mnd9.getCheckedRadioButtonId();


        switch (rdo_mnd9) {
            case R.id.mnd9a:
                var_mnd9 = "1";
                break;
            case R.id.mnd9b:
                var_mnd9 = "2";
                break;
            case R.id.mnd9c:
                var_mnd9 = "99";
                break;
        }


        rdo_mnd11 = mnd11.getCheckedRadioButtonId();


        switch (rdo_mnd11) {
            case R.id.mnd11a:
                var_mnd11 = "1";
                break;
            case R.id.mnd11b:
                var_mnd11 = "2";
                break;
            case R.id.mnd11c:
                var_mnd11 = "3";
                break;
            case R.id.mnd11d:
                var_mnd11 = "4";
                break;
            case R.id.mnd11e:
                var_mnd11 = "88";
                break;
        }


        rdo_mnd12 = mnd12.getCheckedRadioButtonId();


        switch (rdo_mnd12) {
            case R.id.mnd12a:
                var_mnd12 = "1";
                break;
            case R.id.mnd12b:
                var_mnd12 = "2";
                break;
        }


        rdo_mnd13 = mnd13.getCheckedRadioButtonId();


        switch (rdo_mnd13) {
            case R.id.mnd13a:
                var_mnd13 = "1";
                break;
            case R.id.mnd13b:
                var_mnd13 = "2";
                break;
            case R.id.mnd13c:
                var_mnd13 = "3";
                break;
            case R.id.mnd13d:
                var_mnd13 = "4";
                break;
        }

    }

    private boolean ValidateForm() {

        rdo_mnd1 = mnd1.getCheckedRadioButtonId();

        if (rdo_mnd1 == -1) {
            mnd1a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnd1), Toast.LENGTH_LONG).show();
            mnd1a.requestFocus();
            return false;
        } else {
            mnd1a.setError(null);
        }

        switch (rdo_mnd1) {
            case R.id.mnd1a:
                var_mnd1 = "1";
                break;
            case R.id.mnd1b:
                var_mnd1 = "2";
                break;
            case R.id.mnd1c:
                var_mnd1 = "99";
                break;
        }


        rdo_mnd2 = mnd2.getCheckedRadioButtonId();

        if (rdo_mnd2 == -1) {
            mnd2a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnd2), Toast.LENGTH_LONG).show();
            mnd2a.requestFocus();
            return false;
        } else {
            mnd2a.setError(null);
        }

        switch (rdo_mnd2) {
            case R.id.mnd2a:
                var_mnd2 = "1";
                break;
            case R.id.mnd2b:
                var_mnd2 = "2";
                break;
            case R.id.mnd2c:
                var_mnd2 = "99";
                break;
        }


        if (var_mnd2 == "1") {

            rdo_mnd3 = mnd3.getCheckedRadioButtonId();

            if (rdo_mnd3 == -1) {
                mnd3a.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnd3), Toast.LENGTH_LONG).show();
                mnd3a.requestFocus();
                return false;
            } else {
                mnd3a.setError(null);
            }

            switch (rdo_mnd3) {
                case R.id.mnd3a:
                    var_mnd3 = "1";
                    break;
                case R.id.mnd3b:
                    var_mnd3 = "2";
                    break;
            }

        }


        rdo_mnd4 = mnd4.getCheckedRadioButtonId();

        if (rdo_mnd4 == -1) {
            mnd4a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnd4), Toast.LENGTH_LONG).show();
            mnd4a.requestFocus();
            return false;
        } else {
            mnd4a.setError(null);
        }

        switch (rdo_mnd4) {
            case R.id.mnd4a:
                var_mnd4 = "1";
                break;
            case R.id.mnd4b:
                var_mnd4 = "2";
                break;
            case R.id.mnd4c:
                var_mnd4 = "99";
                break;
        }


        if (var_mnd4 == "1") {

            rdo_bcg = bcg.getCheckedRadioButtonId();

            if (rdo_bcg == -1) {
                bcga.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.bcg), Toast.LENGTH_LONG).show();
                bcga.requestFocus();
                return false;
            } else {
                bcga.setError(null);
            }

            switch (rdo_bcg) {
                case R.id.bcga:
                    var_bcg = "1";
                    break;
                case R.id.bcgb:
                    var_bcg = "2";
                    break;
            }


            rdo_opv0 = opv0.getCheckedRadioButtonId();

            if (rdo_opv0 == -1) {
                opv0a.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.opv0), Toast.LENGTH_LONG).show();
                opv0a.requestFocus();
                return false;
            } else {
                opv0a.setError(null);
            }

            switch (rdo_opv0) {
                case R.id.opv0a:
                    var_opv0 = "1";
                    break;
                case R.id.opv0b:
                    var_opv0 = "2";
                    break;
            }


            rdo_penta1 = penta1.getCheckedRadioButtonId();

            if (rdo_penta1 == -1) {
                penta1a.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.penta1), Toast.LENGTH_LONG).show();
                penta1a.requestFocus();
                return false;
            } else {
                penta1a.setError(null);
            }

            switch (rdo_penta1) {
                case R.id.penta1a:
                    var_penta1 = "1";
                    break;
                case R.id.penta1b:
                    var_penta1 = "2";
                    break;
            }


            rdo_pcv1 = pcv1.getCheckedRadioButtonId();

            if (rdo_pcv1 == -1) {
                pcv1a.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.pcv1), Toast.LENGTH_LONG).show();
                pcv1a.requestFocus();
                return false;
            } else {
                pcv1a.setError(null);
            }

            switch (rdo_pcv1) {
                case R.id.pcv1a:
                    var_pcv1 = "1";
                    break;
                case R.id.pcv1b:
                    var_pcv1 = "2";
                    break;
            }


            rdo_opv1 = opv1.getCheckedRadioButtonId();

            if (rdo_opv1 == -1) {
                opv1a.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.opv1), Toast.LENGTH_LONG).show();
                opv1a.requestFocus();
                return false;
            } else {
                opv1a.setError(null);
            }

            switch (rdo_opv1) {
                case R.id.opv1a:
                    var_opv1 = "1";
                    break;
                case R.id.opv1b:
                    var_opv1 = "2";
                    break;
            }


            rdo_penta2 = penta2.getCheckedRadioButtonId();

            if (rdo_penta2 == -1) {
                penta2a.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.penta2), Toast.LENGTH_LONG).show();
                penta2a.requestFocus();
                return false;
            } else {
                penta2a.setError(null);
            }

            switch (rdo_penta2) {
                case R.id.penta2a:
                    var_penta2 = "1";
                    break;
                case R.id.penta2b:
                    var_penta2 = "2";
                    break;
            }


            rdo_pcv2 = pcv2.getCheckedRadioButtonId();

            if (rdo_pcv2 == -1) {
                pcv2a.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.pcv2), Toast.LENGTH_LONG).show();
                pcv2a.requestFocus();
                return false;
            } else {
                pcv2a.setError(null);
            }

            switch (rdo_pcv2) {
                case R.id.pcv2a:
                    var_pcv2 = "1";
                    break;
                case R.id.pcv2b:
                    var_pcv2 = "2";
                    break;
            }


            rdo_opv2 = opv2.getCheckedRadioButtonId();

            if (rdo_opv2 == -1) {
                opv2a.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.opv2), Toast.LENGTH_LONG).show();
                opv2a.requestFocus();
                return false;
            } else {
                opv2a.setError(null);
            }

            switch (rdo_opv2) {
                case R.id.opv2a:
                    var_opv2 = "1";
                    break;
                case R.id.opv2b:
                    var_opv2 = "2";
                    break;
            }


            rdo_penta3 = penta3.getCheckedRadioButtonId();

            if (rdo_penta3 == -1) {
                penta3a.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.penta3), Toast.LENGTH_LONG).show();
                penta3a.requestFocus();
                return false;
            } else {
                penta3a.setError(null);
            }

            switch (rdo_penta3) {
                case R.id.penta3a:
                    var_penta3 = "1";
                    break;
                case R.id.penta3b:
                    var_penta3 = "2";
                    break;
            }


            rdo_pcv3 = pcv3.getCheckedRadioButtonId();

            if (rdo_pcv3 == -1) {
                pcv3a.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.pcv3), Toast.LENGTH_LONG).show();
                pcv3a.requestFocus();
                return false;
            } else {
                pcv3a.setError(null);
            }

            switch (rdo_pcv3) {
                case R.id.pcv3a:
                    var_pcv3 = "1";
                    break;
                case R.id.pcv3b:
                    var_pcv3 = "2";
                    break;
            }


            rdo_opv3 = opv3.getCheckedRadioButtonId();

            if (rdo_opv3 == -1) {
                opv3a.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.opv3), Toast.LENGTH_LONG).show();
                opv3a.requestFocus();
                return false;
            } else {
                opv3a.setError(null);
            }

            switch (rdo_opv3) {
                case R.id.opv3a:
                    var_opv3 = "1";
                    break;
                case R.id.opv3b:
                    var_opv3 = "2";
                    break;
            }


            rdo_ipv = ipv.getCheckedRadioButtonId();

            if (rdo_ipv == -1) {
                ipva.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.ipv), Toast.LENGTH_LONG).show();
                ipva.requestFocus();
                return false;
            } else {
                ipva.setError(null);
            }

            switch (rdo_ipv) {
                case R.id.ipva:
                    var_ipv = "1";
                    break;
                case R.id.ipvb:
                    var_ipv = "2";
                    break;
            }


            rdo_measles1 = measles1.getCheckedRadioButtonId();

            if (rdo_measles1 == -1) {
                measles1a.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.measles1), Toast.LENGTH_LONG).show();
                measles1a.requestFocus();
                return false;
            } else {
                measles1a.setError(null);
            }

            switch (rdo_measles1) {
                case R.id.measles1a:
                    var_measles1 = "1";
                    break;
                case R.id.measles1b:
                    var_measles1 = "2";
                    break;
            }


            rdo_measles2 = measles2.getCheckedRadioButtonId();

            if (rdo_measles2 == -1) {
                measles2a.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.measles2), Toast.LENGTH_LONG).show();
                measles2a.requestFocus();
                return false;
            } else {
                measles2a.setError(null);
            }

            switch (rdo_measles2) {
                case R.id.measles2a:
                    var_measles2 = "1";
                    break;
                case R.id.measles2b:
                    var_measles2 = "2";
                    break;
            }

        }

        rdo_mnd6 = mnd6.getCheckedRadioButtonId();

        if (rdo_mnd6 == -1) {
            mnd6a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnd6), Toast.LENGTH_LONG).show();
            mnd6a.requestFocus();
            return false;
        } else {
            mnd6a.setError(null);
        }

        switch (rdo_mnd6) {
            case R.id.mnd6a:
                var_mnd6 = "1";
                break;
            case R.id.mnd6b:
                var_mnd6 = "2";
                break;
            case R.id.mnd6c:
                var_mnd6 = "99";
                break;
        }


        rdo_mnd7 = mnd7.getCheckedRadioButtonId();

        if (rdo_mnd7 == -1) {
            mnd7a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnd7), Toast.LENGTH_LONG).show();
            mnd7a.requestFocus();
            return false;
        } else {
            mnd7a.setError(null);
        }

        switch (rdo_mnd7) {
            case R.id.mnd7a:
                var_mnd7 = "1";
                break;
            case R.id.mnd7b:
                var_mnd7 = "2";
                break;
            case R.id.mnd7c:
                var_mnd7 = "99";
                break;
        }


        if (mnd8.getText().toString().isEmpty() || mnd8.getText().toString() == null) {
            mnd8.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnd8), Toast.LENGTH_LONG).show();
            mnd8.requestFocus();
            return false;
        } else {
            mnd8.setError(null);
        }

        rdo_mnd9 = mnd9.getCheckedRadioButtonId();

        if (rdo_mnd9 == -1) {
            mnd9a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnd9), Toast.LENGTH_LONG).show();
            mnd9a.requestFocus();
            return false;
        } else {
            mnd9a.setError(null);
        }

        switch (rdo_mnd9) {
            case R.id.mnd9a:
                var_mnd9 = "1";
                break;
            case R.id.mnd9b:
                var_mnd9 = "2";
                break;
            case R.id.mnd9c:
                var_mnd9 = "99";
                break;
        }


        if (mnd10years.getText().toString().isEmpty() || mnd10years.getText().toString() == null) {
            mnd10years.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnd10), Toast.LENGTH_LONG).show();
            mnd10years.requestFocus();
            return false;
        } else {
            mnd10years.setError(null);
        }

        if (mnd10months.getText().toString().isEmpty() || mnd10months.getText().toString() == null) {
            mnd10months.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnd10), Toast.LENGTH_LONG).show();
            mnd10months.requestFocus();
            return false;
        } else {
            mnd10months.setError(null);
        }

        rdo_mnd11 = mnd11.getCheckedRadioButtonId();

        if (rdo_mnd11 == -1) {
            mnd11a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnd11), Toast.LENGTH_LONG).show();
            mnd11a.requestFocus();
            return false;
        } else {
            mnd11a.setError(null);
        }

        switch (rdo_mnd11) {
            case R.id.mnd11a:
                var_mnd11 = "1";
                break;
            case R.id.mnd11b:
                var_mnd11 = "2";
                break;
            case R.id.mnd11c:
                var_mnd11 = "3";
                break;
            case R.id.mnd11d:
                var_mnd11 = "4";
                break;
            case R.id.mnd11e:
                var_mnd11 = "88";
                break;
        }


        if (var_mnd11 == "88") {

            if (mnd11x.getText().toString().isEmpty() || mnd11x.getText().toString() == null) {
                mnd11x.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.others), Toast.LENGTH_LONG).show();
                mnd11x.requestFocus();
                return false;
            } else {
                mnd11x.setError(null);
            }

        }


        rdo_mnd12 = mnd12.getCheckedRadioButtonId();

        if (rdo_mnd12 == -1) {
            mnd12a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnd12), Toast.LENGTH_LONG).show();
            mnd12a.requestFocus();
            return false;
        } else {
            mnd12a.setError(null);
        }

        switch (rdo_mnd12) {
            case R.id.mnd12a:
                var_mnd12 = "1";
                break;
            case R.id.mnd12b:
                var_mnd12 = "2";
                break;
        }


        rdo_mnd13 = mnd13.getCheckedRadioButtonId();

        if (rdo_mnd13 == -1) {
            mnd13a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mnd13), Toast.LENGTH_LONG).show();
            mnd13a.requestFocus();
            return false;
        } else {
            mnd13a.setError(null);
        }

        switch (rdo_mnd13) {
            case R.id.mnd13a:
                var_mnd13 = "1";
                break;
            case R.id.mnd13b:
                var_mnd13 = "2";
                break;
            case R.id.mnd13c:
                var_mnd13 = "3";
                break;
            case R.id.mnd13d:
                var_mnd13 = "4";
                break;
        }

        return true;
    }
}