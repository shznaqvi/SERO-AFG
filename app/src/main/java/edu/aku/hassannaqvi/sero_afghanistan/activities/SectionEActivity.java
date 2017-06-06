package edu.aku.hassannaqvi.sero_afghanistan.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
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
import edu.aku.hassannaqvi.sero_afghanistan.contracts.FormsContract;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;

public class SectionEActivity extends Activity {

    @BindView(R.id.mne1)
    RadioGroup mne1;
    @BindView(R.id.mne1a)
    RadioButton mne1a;
    @BindView(R.id.mne1b)
    RadioButton mne1b;
    @BindView(R.id.mne2)
    RadioGroup mne2;
    @BindView(R.id.mne2a)
    RadioButton mne2a;
    @BindView(R.id.mne2b)
    RadioButton mne2b;
    @BindView(R.id.mne3)
    RadioGroup mne3;
    @BindView(R.id.mne3a)
    RadioButton mne3a;
    @BindView(R.id.mne3b)
    RadioButton mne3b;
    @BindView(R.id.mne4)
    RadioGroup mne4;
    @BindView(R.id.mne4a)
    RadioButton mne4a;
    @BindView(R.id.mne4b)
    RadioButton mne4b;
    @BindView(R.id.mne5a)
    CheckBox mne5a;
    @BindView(R.id.mne5b)
    CheckBox mne5b;
    @BindView(R.id.mne5c)
    CheckBox mne5c;
    @BindView(R.id.mne5d)
    CheckBox mne5d;
    @BindView(R.id.mne5e)
    CheckBox mne5e;
    @BindView(R.id.mne5f)
    CheckBox mne5f;
    @BindView(R.id.mne5g)
    CheckBox mne5g;
    @BindView(R.id.mne5h)
    CheckBox mne5h;
    @BindView(R.id.mne5i)
    CheckBox mne5i;
    @BindView(R.id.mne588)
    CheckBox mne588;
    @BindView(R.id.mne599)
    CheckBox mne599;

    @BindView(R.id.mne5x)
    EditText mne5x;

    @BindView(R.id.fldGrpmne5)
    LinearLayout fldGrpmne5;

    int rdo_mne1;
    String var_mne1;

    int rdo_mne2;
    String var_mne2;

    int rdo_mne3;
    String var_mne3;

    int rdo_mne4;
    String var_mne4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_e);
        ButterKnife.bind(this);

        mne588.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (mne588.isChecked()) {
                    fldGrpmne5.setVisibility(View.VISIBLE);
                    mne5x.requestFocus();
                } else {
                    mne5x.setText(null);
                    fldGrpmne5.setVisibility(View.GONE);
                }
            }
        });


        mne5a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mne5a.isChecked()) {
                    mne599.setChecked(false);
                }
            }
        });

        mne5b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mne5b.isChecked()) {
                    mne599.setChecked(false);
                }
            }
        });

        mne5c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mne5c.isChecked()) {
                    mne599.setChecked(false);
                }
            }
        });


        mne5d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mne5d.isChecked()) {
                    mne599.setChecked(false);
                }
            }
        });

        mne5e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mne5e.isChecked()) {
                    mne599.setChecked(false);
                }
            }
        });


        mne5f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mne5f.isChecked()) {
                    mne599.setChecked(false);
                }
            }
        });

        mne5g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mne5g.isChecked()) {
                    mne599.setChecked(false);
                }
            }
        });

        mne5h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mne5h.isChecked()) {
                    mne599.setChecked(false);
                }
            }
        });

        mne5i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mne5i.isChecked()) {
                    mne599.setChecked(false);
                }
            }
        });


        mne599.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (mne599.isChecked()) {

                    mne5a.setChecked(false);
                    mne5b.setChecked(false);
                    mne5c.setChecked(false);
                    mne5d.setChecked(false);
                    mne5e.setChecked(false);
                    mne5f.setChecked(false);
                    mne5g.setChecked(false);
                    mne5h.setChecked(false);
                    mne5i.setChecked(false);
                    mne588.setChecked(false);
                }
            }
        });
    }

    @OnClick(R.id.btnNext)
    public void SaveData() {
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException ex) {
                ex.printStackTrace();
            }

            if (UpdateDB()) {
                Toast.makeText(this, "Starting Section F", Toast.LENGTH_SHORT).show();

                Intent secF = new Intent(this, SectionFActivity.class);
                startActivity(secF);
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
        db.updateSectionsE();
        return true;

        /*} else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

    }


    private boolean SaveDraft() throws JSONException {

        Toast.makeText(this, "Validating Section E", Toast.LENGTH_SHORT).show();

        JSONObject sE = new JSONObject();

        rdo_mne1 = mne1.getCheckedRadioButtonId();

        switch (rdo_mne1) {
            case R.id.mne1a:
                var_mne1 = "1";
                break;
            case R.id.mne1b:
                var_mne1 = "2";
                break;
            case R.id.mne1c:
                var_mne1 = "99";
                break;
        }

        rdo_mne2 = mne2.getCheckedRadioButtonId();

        switch (rdo_mne2) {
            case R.id.mne2a:
                var_mne2 = "1";
                break;
            case R.id.mne2b:
                var_mne2 = "2";
                break;
            case R.id.mne2c:
                var_mne2 = "99";
                break;
        }


        rdo_mne3 = mne3.getCheckedRadioButtonId();

        switch (rdo_mne3) {
            case R.id.mne3a:
                var_mne3 = "1";
                break;
            case R.id.mne3b:
                var_mne3 = "2";
                break;
            case R.id.mne3c:
                var_mne3 = "99";
                break;
        }


        rdo_mne4 = mne4.getCheckedRadioButtonId();


        switch (rdo_mne4) {
            case R.id.mne4a:
                var_mne4 = "1";
                break;
            case R.id.mne4b:
                var_mne4 = "2";
                break;
            case R.id.mne4c:
                var_mne4 = "99";
                break;
        }

        sE.put("mne1", var_mne1);
        sE.put("mne2", var_mne2);
        sE.put("mne3", var_mne3);
        sE.put("mne4", var_mne4);


        sE.put("mne5a", mne5a.isChecked() ? "1" : "0");
        sE.put("mne5b", mne5b.isChecked() ? "2" : "0");
        sE.put("mne5c", mne5c.isChecked() ? "3" : "0");
        sE.put("mne5d", mne5d.isChecked() ? "4" : "0");
        sE.put("mne5e", mne5e.isChecked() ? "5" : "0");
        sE.put("mne5f", mne5f.isChecked() ? "6" : "0");
        sE.put("mne5g", mne5g.isChecked() ? "7" : "0");
        sE.put("mne5h", mne5h.isChecked() ? "8" : "0");
        sE.put("mne5i", mne5i.isChecked() ? "9" : "0");
        sE.put("mne588", mne588.isChecked() ? "10" : "0");
        sE.put("mne599", mne599.isChecked() ? "11" : "0");

        sE.put("mne5x", mne5x.getText().toString());


        AppMain.fc.setsE(String.valueOf(sE));

        Toast.makeText(this, "Saving Draft... Successful!", Toast.LENGTH_SHORT).show();

        return true;
    }

    private boolean ValidateForm() {

        rdo_mne1 = mne1.getCheckedRadioButtonId();

        if (rdo_mne1 == -1) {
            mne1a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mne1), Toast.LENGTH_LONG).show();
            mne1.requestFocus();
            return false;
        } else {
            mne1a.setError(null);
        }

        switch (rdo_mne1) {
            case R.id.mne1a:
                var_mne1 = "1";
                break;
            case R.id.mne1b:
                var_mne1 = "2";
                break;
            case R.id.mne1c:
                var_mne1 = "99";
                break;
        }


        rdo_mne2 = mne2.getCheckedRadioButtonId();

        if (rdo_mne2 == -1) {
            mne2a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mne2), Toast.LENGTH_LONG).show();
            mne2.requestFocus();
            return false;
        } else {
            mne2a.setError(null);
        }

        switch (rdo_mne2) {
            case R.id.mne2a:
                var_mne2 = "1";
                break;
            case R.id.mne2b:
                var_mne2 = "2";
                break;
            case R.id.mne2c:
                var_mne2 = "99";
                break;
        }


        rdo_mne3 = mne3.getCheckedRadioButtonId();

        if (rdo_mne3 == -1) {
            mne3a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mne3), Toast.LENGTH_LONG).show();
            mne3.requestFocus();
            return false;
        } else {
            mne3a.setError(null);
        }

        switch (rdo_mne3) {
            case R.id.mne3a:
                var_mne3 = "1";
                break;
            case R.id.mne3b:
                var_mne3 = "2";
                break;
            case R.id.mne3c:
                var_mne3 = "99";
                break;
        }


        rdo_mne4 = mne4.getCheckedRadioButtonId();

        if (rdo_mne4 == -1) {
            mne4a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mne4), Toast.LENGTH_LONG).show();
            mne4.requestFocus();
            return false;
        } else {
            mne4a.setError(null);
        }

        switch (rdo_mne4) {
            case R.id.mne4a:
                var_mne4 = "1";
                break;
            case R.id.mne4b:
                var_mne4 = "2";
                break;
            case R.id.mne4c:
                var_mne4 = "99";
                break;
        }


        if (!mne5a.isChecked() &&
                !mne5b.isChecked() &&
                !mne5c.isChecked() &&
                !mne5d.isChecked() &&
                !mne5e.isChecked() &&
                !mne5f.isChecked() &&
                !mne5g.isChecked() &&
                !mne5h.isChecked() &&
                !mne5i.isChecked() &&
                !mne588.isChecked() &&
                !mne599.isChecked()) {

            mne5a.setError(getString(R.string.rdoerr));
            Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.mne5), Toast.LENGTH_LONG).show();
            mne5a.requestFocus();
            return false;

        } else {
            mne5a.setError(null);
        }


        if (mne588.isChecked()) {

            if (mne5x.getText().toString().isEmpty() || mne5x.getText().toString() == null) {

                mne5x.setError(getString(R.string.rdoerr));
                Toast.makeText(getApplicationContext(), "ERROR(invalid): " + getString(R.string.others), Toast.LENGTH_LONG).show();
                mne5x.requestFocus();
                return false;

            } else {
                mne5x.setError(null);
            }
        }

        return true;
    }
}