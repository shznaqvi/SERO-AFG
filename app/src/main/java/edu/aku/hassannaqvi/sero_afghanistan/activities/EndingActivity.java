package edu.aku.hassannaqvi.sero_afghanistan.activities;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;

public class EndingActivity extends Activity {

    private static final String TAG = EndingActivity.class.getSimpleName();

    Timer timer;
    MyTimerTask myTimerTask;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);
        ButterKnife.bind(this);


        if (!AppMain.flag) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }


//        mna7a.setEnabled(getIntent().getBooleanExtra("complete", true));

        Boolean check = getIntent().getBooleanExtra("complete", true);
        if (check) {
            mna7a.setEnabled(true);
            mna7b.setEnabled(false);
            mna7c.setEnabled(false);

        } else {
            mna7a.setEnabled(false);
            mna7b.setEnabled(true);
            mna7c.setEnabled(true);

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

                onResume();
                AppMain.IsDataSaveend = true;
                AppMain.IsDataSaveMainActivity = false;

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

        AppMain.fc.setIstatus(mna7a.isChecked() ? "1" : mna7b.isChecked() ? "2" : mna7c.isChecked() ? "3" : "0");
//        }

    }

    private boolean formValidation() {
        Toast.makeText(this, "Validating Closing Section", Toast.LENGTH_SHORT).show();

        if (iStatus.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(not selected): " + getResources().getResourceTypeName(R.string.mna7), Toast.LENGTH_LONG).show();
            mna7c.setError("This data is Required!");
            Log.i(TAG, "mna7d: This data is Required!");
            return false;
        } else {
            mna7c.setError(null);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onResume() {
        super.onResume();

        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    @Override
    protected void onPause() {
        if (timer == null) {
            myTimerTask = new MyTimerTask();
            timer = new Timer();
            timer.schedule(myTimerTask, 500, 500);
        }

        super.onPause();
    }

    private void bringApplicationToFront() {
        KeyguardManager myKeyManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        if (myKeyManager.inKeyguardRestrictedInputMode())
            return;

        Log.d("TAG", "====Bringging Application to Front====");

        Intent notificationIntent = new Intent(this, EndingActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);


        try {
            pendingIntent.send();
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }


    class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            if (!AppMain.IsDataSaveend) {
                bringApplicationToFront();
            }
        }
    }

}