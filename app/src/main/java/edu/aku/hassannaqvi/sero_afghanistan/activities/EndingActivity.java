package edu.aku.hassannaqvi.sero_afghanistan.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;

public class EndingActivity extends Activity {

    private static final String TAG = EndingActivity.class.getSimpleName();

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;

    @BindView(R.id.iStatus)
    RadioGroup iStatus;
    @BindView(R.id.mna7a)
    RadioButton mna7a;
    @BindView(R.id.mna7b)
    RadioButton mna7b;
    @BindView(R.id.mna7c)
    RadioButton mna7c;
    @BindView(R.id.mna7d)
    RadioButton mna7d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);
        ButterKnife.bind(this);

//        mna7a.setEnabled(getIntent().getBooleanExtra("complete", true));

        Boolean check = getIntent().getBooleanExtra("complete", true);
        if (check) {
            mna7a.setEnabled(true);
            mna7b.setEnabled(false);
            mna7c.setEnabled(false);
            mna7d.setEnabled(false);
        } else {
            mna7a.setEnabled(false);
            mna7b.setEnabled(true);
            mna7c.setEnabled(true);
            mna7d.setEnabled(true);
        }

    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "Processing Closing Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                Toast.makeText(this, "Closing Form!", Toast.LENGTH_SHORT).show();
                Intent endSec = new Intent(this, MainActivity.class);
                //AppMain.mnb1 = "TEST";
                startActivity(endSec);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateEnd();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

//        switch (iStatus.getCheckedRadioButtonId()) {
//            case R.id.mna7a:
//                AppMain.fc.setIstatus("1");
//                break;
//            case R.id.mna7b:
//                AppMain.fc.setIstatus("2");
//                break;
//            case R.id.mna7c:
//                AppMain.fc.setIstatus("3");
//                break;
//            case R.id.mna7d:
//                AppMain.fc.setIstatus("4");
//                break;
//            default:
//                AppMain.fc.setIstatus("default");
//                break;

        AppMain.fc.setIstatus(mna7a.isChecked() ? "1" : mna7b.isChecked() ? "2" : mna7c.isChecked() ? "3" : mna7d.isChecked() ? "4" : "0");
//        }

    }

    private boolean formValidation() {
        Toast.makeText(this, "Validating Closing Section", Toast.LENGTH_SHORT).show();

        if (iStatus.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(not selected): " + getResources().getResourceTypeName(R.string.mna7), Toast.LENGTH_LONG).show();
            mna7d.setError("This data is Required!");
            Log.i(TAG, "mna7d: This data is Required!");
            return false;
        } else {
            mna7d.setError(null);
        }
        return true;
    }
}