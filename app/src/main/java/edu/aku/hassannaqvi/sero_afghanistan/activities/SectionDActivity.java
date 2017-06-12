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

    @BindView(R.id.fldGrpBcgM) LinearLayout fldGrpBcgM;
    @BindView(R.id.bcgM) RadioGroup bcgM;
    @BindView(R.id.bcgM01) RadioButton bcgM01;
    @BindView(R.id.bcgM02) RadioButton bcgM02;
    @BindView(R.id.fldGrpBcgC) LinearLayout fldGrpBcgC;
    @BindView(R.id.bcgC) RadioGroup bcgC;
    @BindView(R.id.bcgC01) RadioButton bcgC01;
    @BindView(R.id.bcgC02) RadioButton bcgC02;
    @BindView(R.id.fldGrpOpv0M) LinearLayout fldGrpOpv0M;
    @BindView(R.id.opv0M) RadioGroup opv0M;
    @BindView(R.id.opv0M01) RadioButton opv0M01;
    @BindView(R.id.opv0M02) RadioButton opv0M02;
    @BindView(R.id.fldGrpopv0C) LinearLayout fldGrpopv0C;
    @BindView(R.id.opv0C) RadioGroup opv0C;
    @BindView(R.id.opv0C01) RadioButton opv0C01;
    @BindView(R.id.opv0C02) RadioButton opv0C02;
    @BindView(R.id.fldGrpPenta1M) LinearLayout fldGrpPenta1M;
    @BindView(R.id.penta1M) RadioGroup penta1M;
    @BindView(R.id.penta1M01) RadioButton penta1M01;
    @BindView(R.id.Penta1M02) RadioButton penta1M02;
    @BindView(R.id.fldGrpPenta1C) LinearLayout fldGrpPenta1C;
    @BindView(R.id.penta1C) RadioGroup penta1C;
    @BindView(R.id.penta1C01) RadioButton penta1C01;
    @BindView(R.id.penta1C02) RadioButton penta1C02;
    @BindView(R.id.fldGrppcv1M) LinearLayout fldGrppcv1M;
    @BindView(R.id.pcv1M) RadioGroup pcv1M;
    @BindView(R.id.pcv1M01) RadioButton pcv1M01;
    @BindView(R.id.pcv1M02) RadioButton pcv1M02;
    @BindView(R.id.fldGrppcv1C) LinearLayout fldGrppcv1C;
    @BindView(R.id.pcv1C) RadioGroup pcv1C;
    @BindView(R.id.pcv1C01) RadioButton pcv1C01;
    @BindView(R.id.pcv1C02) RadioButton pcv1C02;
    @BindView(R.id.fldGrpopv1M) LinearLayout fldGrpopv1M;
    @BindView(R.id.opv1M) RadioGroup opv1M;
    @BindView(R.id.opv1M01) RadioButton opv1M01;
    @BindView(R.id.opv1M02) RadioButton opv1M02;
    @BindView(R.id.fldGrpopv1C) LinearLayout fldGrpopv1C;
    @BindView(R.id.opv1C) RadioGroup opv1C;
    @BindView(R.id.opv1C01) RadioButton opv1C01;
    @BindView(R.id.opv1C02) RadioButton opv1C02;
    @BindView(R.id.fldGrppenta2M) LinearLayout fldGrppenta2M;
    @BindView(R.id.penta2M) RadioGroup penta2M;
    @BindView(R.id.penta2M01) RadioButton penta2M01;
    @BindView(R.id.penta2M02) RadioButton penta2M02;
    @BindView(R.id.fldGrppenta2C) LinearLayout fldGrppenta2C;
    @BindView(R.id.penta2C) RadioGroup penta2C;
    @BindView(R.id.penta2C01) RadioButton penta2C01;
    @BindView(R.id.penta2C02) RadioButton penta2C02;
    @BindView(R.id.fldGrppcv2M) LinearLayout fldGrppcv2M;
    @BindView(R.id.pcv2M) RadioGroup pcv2M;
    @BindView(R.id.pcv2M01) RadioButton pcv2M01;
    @BindView(R.id.pcv2M02) RadioButton pcv2M02;
    @BindView(R.id.fldGrppcv2C) LinearLayout fldGrppcv2C;
    @BindView(R.id.pcv2C) RadioGroup pcv2C;
    @BindView(R.id.pcv2C01) RadioButton pcv2C01;
    @BindView(R.id.pcv2C02) RadioButton pcv2C02;
    @BindView(R.id.fldGrpopv2M) LinearLayout fldGrpopv2M;
    @BindView(R.id.opv2M) RadioGroup opv2M;
    @BindView(R.id.opv2M01) RadioButton opv2M01;
    @BindView(R.id.opv2M02) RadioButton opv2M02;
    @BindView(R.id.fldGrpopv2C) LinearLayout fldGrpopv2C;
    @BindView(R.id.opv2C) RadioGroup opv2C;
    @BindView(R.id.opv2C01) RadioButton opv2C01;
    @BindView(R.id.opv2C02) RadioButton opv2C02;
    @BindView(R.id.fldGrpPenta3M) LinearLayout fldGrpPenta3M;
    @BindView(R.id.penta3M) RadioGroup penta3M;
    @BindView(R.id.penta3M01) RadioButton penta3M01;
    @BindView(R.id.penta3M02) RadioButton penta3M02;
    @BindView(R.id.fldGrpenta3C) LinearLayout fldGrpenta3C;
    @BindView(R.id.penta3C) RadioGroup penta3C;
    @BindView(R.id.penta3C01) RadioButton penta3C01;
    @BindView(R.id.penta3C02) RadioButton penta3C02;
    @BindView(R.id.fldGrppcv3M) LinearLayout fldGrppcv3M;
    @BindView(R.id.pcv3M) RadioGroup pcv3M;
    @BindView(R.id.pcv3M01) RadioButton pcv3M01;
    @BindView(R.id.pcv3M02) RadioButton pcv3M02;
    @BindView(R.id.fldGrppcv3C) LinearLayout fldGrppcv3C;
    @BindView(R.id.pcv3C) RadioGroup pcv3C;
    @BindView(R.id.pcv3C01) RadioButton pcv3C01;
    @BindView(R.id.pcv3C02) RadioButton pcv3C02;
    @BindView(R.id.fldGrpopv3M) LinearLayout fldGrpopv3M;
    @BindView(R.id.opv3M) RadioGroup opv3M;
    @BindView(R.id.opv3M01) RadioButton opv3M01;
    @BindView(R.id.opv3M02) RadioButton opv3M02;
    @BindView(R.id.fldGrpopv3C) LinearLayout fldGrpopv3C;
    @BindView(R.id.opv3C) RadioGroup opv3C;
    @BindView(R.id.opv3C01) RadioButton opv3C01;
    @BindView(R.id.opv3C02) RadioButton opv3C02;
    @BindView(R.id.fldGrpipvM) LinearLayout fldGrpipvM;
    @BindView(R.id.ipvM) RadioGroup ipvM;
    @BindView(R.id.ipvM01) RadioButton ipvM01;
    @BindView(R.id.ipvM02) RadioButton ipvM02;
    @BindView(R.id.fldGrpipvC) LinearLayout fldGrpipvC;
    @BindView(R.id.ipvC) RadioGroup ipvC;
    @BindView(R.id.ipvC01) RadioButton ipvC01;
    @BindView(R.id.ipvC02) RadioButton ipvC02;
    @BindView(R.id.fldGrpMeasles1M) LinearLayout fldGrpMeasles1M;
    @BindView(R.id.measles1M) RadioGroup measles1M;
    @BindView(R.id.measles1M01) RadioButton measles1M01;
    @BindView(R.id.measles1M02) RadioButton measles1M02;
    @BindView(R.id.fldGrpmeasles1C) LinearLayout fldGrpmeasles1C;
    @BindView(R.id.measles1C) RadioGroup measles1C;
    @BindView(R.id.measles1C01) RadioButton measles1C01;
    @BindView(R.id.measles1C02) RadioButton measles1C02;
    @BindView(R.id.fldGrpMeasles2M) LinearLayout fldGrpMeasles2M;
    @BindView(R.id.measles2M) RadioGroup measles2M;
    @BindView(R.id.measles2M01) RadioButton measles2M01;
    @BindView(R.id.measles2M02) RadioButton measles2M02;
    @BindView(R.id.fldGrpmeasles2C) LinearLayout fldGrpmeasles2C;
    @BindView(R.id.measles2C) RadioGroup measles2C;
    @BindView(R.id.measles2C01) RadioButton measles2C01;
    @BindView(R.id.measles2C02) RadioButton measles2C02;


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

        mnd2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(mnd2a.isChecked())
                {
                    fldGrpBcgC.setVisibility(View.VISIBLE);
                    fldGrpBcgM.setVisibility(View.VISIBLE);
                    fldGrpopv0C.setVisibility(View.VISIBLE);
                    fldGrpOpv0M.setVisibility(View.VISIBLE);
                    fldGrpPenta1C.setVisibility(View.VISIBLE);
                    fldGrpPenta1M.setVisibility(View.VISIBLE);
                    fldGrppcv1C.setVisibility(View.VISIBLE);
                    fldGrppcv1M.setVisibility(View.VISIBLE);
                    fldGrpopv1C.setVisibility(View.VISIBLE);
                    fldGrpopv1M.setVisibility(View.VISIBLE);
                    fldGrppenta2C.setVisibility(View.VISIBLE);
                    fldGrppenta2M.setVisibility(View.VISIBLE);
                    fldGrppcv2C.setVisibility(View.VISIBLE);
                    fldGrppcv2M.setVisibility(View.VISIBLE);
                    fldGrpopv2C.setVisibility(View.VISIBLE);
                    fldGrpopv2M.setVisibility(View.VISIBLE);
                    fldGrpenta3C.setVisibility(View.VISIBLE);
                    fldGrpPenta3M.setVisibility(View.VISIBLE);
                    fldGrppcv3C.setVisibility(View.VISIBLE);
                    fldGrppcv3M.setVisibility(View.VISIBLE);
                    fldGrpopv3C.setVisibility(View.VISIBLE);
                    fldGrpopv3M.setVisibility(View.VISIBLE);
                    fldGrpipvC.setVisibility(View.VISIBLE);
                    fldGrpipvM.setVisibility(View.VISIBLE);
                    fldGrpmeasles1C.setVisibility(View.VISIBLE);
                    fldGrpMeasles1M.setVisibility(View.VISIBLE);
                    fldGrpmeasles2C.setVisibility(View.VISIBLE);
                    fldGrpMeasles2M.setVisibility(View.VISIBLE);
                }else{
                    fldGrpBcgC.setVisibility(View.GONE);
                    fldGrpBcgM.setVisibility(View.VISIBLE);
                    bcgC.clearCheck();
                    fldGrpopv0C.setVisibility(View.GONE);
                    fldGrpOpv0M.setVisibility(View.VISIBLE);
                    opv0C.clearCheck();
                    fldGrpPenta1C.setVisibility(View.GONE);
                    fldGrpPenta1M.setVisibility(View.VISIBLE);
                    penta1C.clearCheck();
                    fldGrppcv1C.setVisibility(View.GONE);
                    fldGrppcv1M.setVisibility(View.VISIBLE);
                    pcv1C.clearCheck();
                    fldGrpopv1C.setVisibility(View.GONE);
                    fldGrpopv1M.setVisibility(View.VISIBLE);
                    opv1C.clearCheck();
                    fldGrppenta2C.setVisibility(View.GONE);
                    fldGrppenta2M.setVisibility(View.VISIBLE);
                    penta2C.clearCheck();
                    fldGrppcv2C.setVisibility(View.GONE);
                    fldGrppcv2M.setVisibility(View.VISIBLE);
                    pcv2C.clearCheck();
                    fldGrpopv2C.setVisibility(View.GONE);
                    fldGrpopv2M.setVisibility(View.VISIBLE);
                    opv2C.clearCheck();
                    fldGrpenta3C.setVisibility(View.GONE);
                    fldGrpPenta3M.setVisibility(View.VISIBLE);
                    penta3C.clearCheck();
                    fldGrppcv3C.setVisibility(View.GONE);
                    fldGrppcv3M.setVisibility(View.VISIBLE);
                    pcv3C.clearCheck();
                    fldGrpopv3C.setVisibility(View.GONE);
                    fldGrpopv3M.setVisibility(View.VISIBLE);
                    opv3C.clearCheck();
                    fldGrpipvC.setVisibility(View.GONE);
                    fldGrpipvM.setVisibility(View.VISIBLE);
                    ipvC.clearCheck();
                    fldGrpmeasles1C.setVisibility(View.GONE);
                    fldGrpMeasles1M.setVisibility(View.VISIBLE);
                    measles1C.clearCheck();
                    fldGrpmeasles2C.setVisibility(View.GONE);
                    fldGrpMeasles2M.setVisibility(View.VISIBLE);
                    measles2C.clearCheck();
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
        sD.put("bcgM", bcgM01.isChecked() ? "1" : bcgM02.isChecked() ? "2" : "0");
        sD.put("bcgC", bcgC01.isChecked() ? "1" : bcgC02.isChecked() ? "2" : "0");
        // BCG At Birth
        sD.put("opv0M", opv0M01.isChecked() ? "1" : opv0M02.isChecked() ? "2" : "0");
        sD.put("opv0C", opv0C01.isChecked() ? "1" : opv0C02.isChecked() ? "2" : "0");
        //Polio At Birth
        sD.put("penta1M", penta1M01.isChecked() ? "1" : penta1M02.isChecked() ? "2" : "0");
        sD.put("penta1C", penta1C01.isChecked() ? "1" : penta1C02.isChecked() ? "2" : "0");
        // Penta 1 at 6 weeks
        sD.put("pcv1M", pcv1M01.isChecked() ? "1" : pcv1M02.isChecked() ? "2" : "0");
        sD.put("pcv1C", pcv1C01.isChecked() ? "1" : pcv1C02.isChecked() ? "2" : "0");
        //PCV 1 at 6 weeks
        sD.put("opv1M", opv1M01.isChecked() ? "1" : opv1M02.isChecked() ? "2" : "0");
        sD.put("opv1C", opv1C01.isChecked() ? "1" : opv1C02.isChecked() ? "2" : "0");
        // OPV 1 at 6 weeks
        sD.put("penta2M", penta2M01.isChecked() ? "1" : penta2M02.isChecked() ? "2" : "0");
        sD.put("penta2C", penta2C01.isChecked() ? "1" : penta2C02.isChecked() ? "2" : "0");
        // Penta 2 at 10 weeks
        sD.put("pcv2M", pcv2M01.isChecked() ? "1" : pcv2M02.isChecked() ? "2" : "0");
        sD.put("pcv2C", pcv2C01.isChecked() ? "1" : pcv2C02.isChecked() ? "2" : "0");
        sD.put("opvv2M", opv2M01.isChecked() ? "1" : opv2M02.isChecked() ? "2" : "0");
        sD.put("opvv2C", opv2C01.isChecked() ? "1" : opv2C02.isChecked() ? "2" : "0");
        // PCV 2 at 6 weeks
        sD.put("penta3M", penta3M01.isChecked() ? "1" : penta3M02.isChecked() ? "2" : "0");
        sD.put("penta3C", penta3C01.isChecked() ? "1" : penta3C02.isChecked() ? "2" : "0");
        // OPV 2 at 6 weeks
        sD.put("pcv3M", pcv3M01.isChecked() ? "1" : pcv3M02.isChecked() ? "2" : "0");
        sD.put("pcv3C", pcv3C01.isChecked() ? "1" : pcv3C02.isChecked() ? "2" : "0");
        // Penta 3 at 14 weeks
        sD.put("opv3M", opv3M01.isChecked() ? "1" : opv3M02.isChecked() ? "2" : "0");
        sD.put("opv3C", opv3C01.isChecked() ? "1" : opv3C02.isChecked() ? "2" : "0");
        // PCV 3 at 14 weeks
        sD.put("ipvM", ipvM01.isChecked() ? "1" : ipvM02.isChecked() ? "2" : "0");
        sD.put("ipvC", ipvC02.isChecked() ? "1" : ipvC02.isChecked() ? "2" : "0");
        // OPV 3 at 14 weeks
        sD.put("measles1M", measles1M01.isChecked() ? "1" : measles1M02.isChecked() ? "2" : "0");
        sD.put("measles1C", measles1C01.isChecked() ? "1" : measles1C02.isChecked() ? "2" : "0");
        // IPV at 14 weeks
        sD.put("measles2M", measles2M01.isChecked() ? "1" : measles2M02.isChecked() ? "2" : "0");
        sD.put("measles2C", measles2C01.isChecked() ? "1" : measles2C02.isChecked() ? "2" : "0");

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


        if(mnd3a.isChecked())
        {
            //============ BCG / Card Present ==========
            if (bcgC.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bcg), Toast.LENGTH_SHORT).show();
                bcgC02.setError("This data is Required!");
                Log.i(TAG, "bcgC: This data is Required!");
                return false;
            } else {
                bcgC02.setError(null);
            }

            //============ Polio 0 / Card Present ==========
            if (opv0C.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv0), Toast.LENGTH_SHORT).show();
                opv0C02.setError("This data is Required!");
                Log.i(TAG, "opv0C: This data is Required!");
                return false;
            } else {
                opv0C02.setError(null);
            }

            //============ Penta 1 / Card Present ==========
            if (penta1C.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta1), Toast.LENGTH_SHORT).show();
                penta1C02.setError("This data is Required!");
                Log.i(TAG, "penta1C: This data is Required!");
                return false;
            } else {
                penta1C02.setError(null);
            }

            //============ PCV 1 / Card Present ==========
            if (pcv1C.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv1), Toast.LENGTH_SHORT).show();
                pcv1C02.setError("This data is Required!");
                Log.i(TAG, "pcv1C: This data is Required!");
                return false;
            } else {
                pcv1C02.setError(null);
            }

            //============ OPV 1 / Card Present ==========
            if (opv1C.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv1), Toast.LENGTH_SHORT).show();
                opv1C02.setError("This data is Required!");
                Log.i(TAG, "opv1C: This data is Required!");
                return false;
            } else {
                opv1C02.setError(null);
            }

            //============ Penta 2 / Card Present ==========
            if (penta2C.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta2), Toast.LENGTH_SHORT).show();
                penta2C02.setError("This data is Required!");
                Log.i(TAG, "penta2C: This data is Required!");
                return false;
            } else {
                penta2C02.setError(null);
            }

            //============ PCV 2 / Card Present ==========
            if (pcv2C.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv2), Toast.LENGTH_SHORT).show();
                pcv2C02.setError("This data is Required!");
                Log.i(TAG, "pcv2C: This data is Required!");
                return false;
            } else {
                pcv2C02.setError(null);
            }

            //============ OPV 2 / Card Present ==========
            if (opv2C.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv2), Toast.LENGTH_SHORT).show();
                opv2C02.setError("This data is Required!");
                Log.i(TAG, "opv2C: This data is Required!");
                return false;
            } else {
                opv2C02.setError(null);
            }

            //============ Penta 3 / Card Present ==========
            if (penta3C.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta3), Toast.LENGTH_SHORT).show();
                penta3C02.setError("This data is Required!");
                Log.i(TAG, "penta3C: This data is Required!");
                return false;
            } else {
                penta3C02.setError(null);
            }

            //============ PCV 3 / Card Present ==========
            if (pcv3C.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv3), Toast.LENGTH_SHORT).show();
                pcv3C02.setError("This data is Required!");
                Log.i(TAG, "pcv3C: This data is Required!");
                return false;
            } else {
                pcv3C02.setError(null);
            }


            //============ OPV 3 / Card Present ==========
            if (opv3C.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv3), Toast.LENGTH_SHORT).show();
                opv3C02.setError("This data is Required!");
                Log.i(TAG, "opv3C: This data is Required!");
                return false;
            } else {
                opv3C02.setError(null);
            }

            //============ IPV / Card Present ==========
            if (ipvC.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ipv), Toast.LENGTH_SHORT).show();
                ipvC02.setError("This data is Required!");
                Log.i(TAG, "ipvC: This data is Required!");
                return false;
            } else {
                ipvC02.setError(null);
            }

            //============ measles1 / Card Present ==========
            if (measles1C.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles1), Toast.LENGTH_SHORT).show();
                measles1C02.setError("This data is Required!");
                Log.i(TAG, "measles1C: This data is Required!");
                return false;
            } else {
                measles1C02.setError(null);
            }

            //============ measles2 / Card Present ==========
            if (measles2C.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles2), Toast.LENGTH_SHORT).show();
                measles2C02.setError("This data is Required!");
                Log.i(TAG, "measles2C: This data is Required!");
                return false;
            } else {
                measles2C02.setError(null);
            }


        }
        //============ BCG / Mother ==========
        if (bcgM.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.bcg), Toast.LENGTH_SHORT).show();
            bcgM02.setError("This data is Required!");
            Log.i(TAG, "bcgM: This data is Required!");
            return false;
        } else {
            bcgM02.setError(null);
        }

        //============ Polio 0 / Mother ==========
        if (opv0M.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv0), Toast.LENGTH_SHORT).show();
            opv0M02.setError("This data is Required!");
            Log.i(TAG, "opv0M: This data is Required!");
            return false;
        } else {
            opv0M02.setError(null);
        }

        //============ Penta 1 / Mother ==========
        if (penta1M.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta1), Toast.LENGTH_SHORT).show();
            penta1M02.setError("This data is Required!");
            Log.i(TAG, "penta1M: This data is Required!");
            return false;
        } else {
            penta1M02.setError(null);
        }

        //============ PCV 1 / Mother ==========
        if (pcv1M.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv1), Toast.LENGTH_SHORT).show();
            pcv1M02.setError("This data is Required!");
            Log.i(TAG, "pcv1M: This data is Required!");
            return false;
        } else {
            pcv1M02.setError(null);
        }

        //============ OPV 1 / Mother ==========
        if (opv1M.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv1), Toast.LENGTH_SHORT).show();
            opv1M02.setError("This data is Required!");
            Log.i(TAG, "opv1M: This data is Required!");
            return false;
        } else {
            opv1M02.setError(null);
        }

        //============ Penta 2 / Mother ==========
        if (penta2M.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta2), Toast.LENGTH_SHORT).show();
            penta2M02.setError("This data is Required!");
            Log.i(TAG, "penta2M: This data is Required!");
            return false;
        } else {
            penta2M02.setError(null);
        }

        //============ PCV 2 / Mother ==========
        if (pcv2M.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv2), Toast.LENGTH_SHORT).show();
            pcv2M02.setError("This data is Required!");
            Log.i(TAG, "pcv2M: This data is Required!");
            return false;
        } else {
            pcv2M02.setError(null);
        }

        //============ OPV 2 / Mother ==========
        if (opv2M.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv2), Toast.LENGTH_SHORT).show();
            opv2M02.setError("This data is Required!");
            Log.i(TAG, "opv2M: This data is Required!");
            return false;
        } else {
            opv2M02.setError(null);
        }

        //============ Penta 3 / Mother ==========
        if (penta3M.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta3), Toast.LENGTH_SHORT).show();
            penta3M02.setError("This data is Required!");
            Log.i(TAG, "penta3M: This data is Required!");
            return false;
        } else {
            penta3M02.setError(null);
        }

        //============ PCV / Mother ==========
        if (pcv3M.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv3), Toast.LENGTH_SHORT).show();
            pcv3M02.setError("This data is Required!");
            Log.i(TAG, "pcv3M: This data is Required!");
            return false;
        } else {
            pcv3M02.setError(null);
        }


        //============ OPV 3 / Mother ==========
        if (opv3M.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv3), Toast.LENGTH_SHORT).show();
            opv3M02.setError("This data is Required!");
            Log.i(TAG, "opv3M: This data is Required!");
            return false;
        } else {
            opv3M02.setError(null);
        }

        //============ IPV / Mother ==========
        if (ipvM.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ipv), Toast.LENGTH_SHORT).show();
            ipvM02.setError("This data is Required!");
            Log.i(TAG, "ipvM: This data is Required!");
            return false;
        } else {
            ipvM02.setError(null);
        }

        //============ measles1 / Mother ==========
        if (measles1M.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles1), Toast.LENGTH_SHORT).show();
            measles1M02.setError("This data is Required!");
            Log.i(TAG, "measles1M: This data is Required!");
            return false;
        } else {
            measles1M02.setError(null);
        }

        //============ measles2 / Mother ==========
        if (measles2M.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles2), Toast.LENGTH_SHORT).show();
            measles2M02.setError("This data is Required!");
            Log.i(TAG, "measles2M: This data is Required!");
            return false;
        } else {
            measles2M02.setError(null);
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


        if (mnd10years.getText().toString() != "2016" || mnd10years.getText().toString() != "2017") {
            mnd10years.setError("Year must be 2016 or 2017");
            Toast.makeText(getApplicationContext(), "ERROR(invalid): Year must be 2016 or 2017 ", Toast.LENGTH_LONG).show();
            mnd10years.requestFocus();
            return false;
        } else {
            mnd10years.setError(null);
        }


        if (Integer.parseInt(mnd10months.getText().toString()) < 0 || Integer.parseInt(mnd10months.getText().toString()) > 12) {
            mnd10months.setError("Month must be 1 - 12");
            Toast.makeText(getApplicationContext(), "ERROR(invalid): Month must be 1 - 12", Toast.LENGTH_LONG).show();
            mnd10months.requestFocus();
            return false;
        } else {
            mnd10months.setError(null);
        }

        return true;
    }
}