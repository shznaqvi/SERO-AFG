package edu.aku.hassannaqvi.sero_afghanistan.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.FormsContract;
import edu.aku.hassannaqvi.sero_afghanistan.core.AndroidDatabaseManager;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;
import edu.aku.hassannaqvi.sero_afghanistan.getclasses.GetDistricts;
import edu.aku.hassannaqvi.sero_afghanistan.getclasses.GetProvince;
import edu.aku.hassannaqvi.sero_afghanistan.getclasses.GetUsers;
import edu.aku.hassannaqvi.sero_afghanistan.syncclasses.SyncForms;
import edu.aku.hassannaqvi.sero_afghanistan.syncclasses.SyncLocation;

public class MainActivity extends Activity {

    Timer timer;
    MyTimerTask myTimerTask;

    public static String TAG = MainActivity.class.getSimpleName();
    public List<String> lhwName;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    @BindView(R.id.adminsec)
    LinearLayout adminsec;
    @BindView(R.id.recordSummary)
    TextView recordSummary;
    @BindView(R.id.clusterNo)
    EditText clusterNo;
    @BindView(R.id.MN01)
    Spinner mN01;
    @BindView(R.id.MN02)
    Spinner mN02;
    @BindView(R.id.MN03)
    Spinner mN03;
    Map<String, String> provinces, dist;
    DatabaseHelper db;
    List<String> hfCodes;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    AlertDialog.Builder builder;
    String m_Text = "";
    private String rSumText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        editor = sharedPref.edit();

        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Tag Name");

        final EditText input = new EditText(MainActivity.this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                if (!m_Text.equals("")) {
                    editor.putString("tagName", m_Text);
                    editor.commit();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        if (sharedPref.getString("tagName", null) == "" || sharedPref.getString("tagName", null) == null) {
            builder.show();
        }

//        View Record Summary

        recordSummary();

    }

    public void recordSummary() {

        rSumText = "";

        DatabaseHelper db = new DatabaseHelper(this);
        Collection<FormsContract> todaysForms = db.getTodayForms();
        Collection<FormsContract> unsyncedForms = db.getUnsyncedForms();

        rSumText += "TODAY'S RECORDS SUMMARY\r\n";

        rSumText += "=======================\r\n";
        rSumText += "\r\n";
        rSumText += "Total Forms Today: " + todaysForms.size() + "\r\n";
        rSumText += "\r\n";
        if (todaysForms.size() > 0) {
            rSumText += "\tFORMS' LIST: \r\n";
            String iStatus;
            rSumText += "--------------------------------------------------\r\n";
            rSumText += "[ STUDY_ID ] \t[Form Status] \t[Sync Status]----------\r\n";
            rSumText += "--------------------------------------------------\r\n";

            for (FormsContract fc : todaysForms) {

                if (fc.getIstatus() != null) {

                    switch (fc.getIstatus()) {
                        case "1":
                            iStatus = "\tComplete";
                            break;
                        case "2":
                            iStatus = "\tIncomplete";
                            break;
                        case "3":
                            iStatus = "\tRefused";
                            break;
                        case "4":
                            iStatus = "\tRefused";
                            break;
                        default:
                            iStatus = "\t";
                    }
                } else {
                    iStatus = "\tN/A";
                }

                rSumText += fc.getstudyid();

                rSumText += " " + iStatus + " ";

                rSumText += (fc.getSynced().equals("") ? "\t\tNot Synced" : "\t\tSynced");
                rSumText += "\r\n";
                rSumText += "--------------------------------------------------\r\n";

            }
        }


        if (AppMain.admin) {
            adminsec.setVisibility(View.VISIBLE);
            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            rSumText += "Last Data Download: \t" + syncPref.getString("LastDownSyncServer", "Never Updated");
            rSumText += "\r\n";
            rSumText += "Last Data Upload: \t" + syncPref.getString("LastUpSyncServer", "Never Synced");
            rSumText += "\r\n";
            rSumText += "\r\n";
            rSumText += "Unsynced Forms: \t" + unsyncedForms.size();
            rSumText += "\r\n";
        }
        Log.d(TAG, "onCreate: " + rSumText);
        recordSummary.setText(rSumText);
    }

    public void openForm(View v) {

        if (AppMain.username != null && AppMain.hfacility != null && AppMain.username != "" && AppMain.hfacility != "") {

            if (sharedPref.getString("tagName", null) != "" && sharedPref.getString("tagName", null) != null) {
            /*Set Boolean for checking*/
                AppMain.flag = true;

                onResume();
                AppMain.IsDataSaveMainActivity = true;
                AppMain.IsDataSaveend = false;

                finish();

                startActivity(new Intent(MainActivity.this, SectionAActivity.class));

            } else {

                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Tag Name");

                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = input.getText().toString();
                        if (!m_Text.equals("")) {
                            editor.putString("tagName", m_Text);
                            editor.commit();

                        /*Set Boolean for checking*/
                            AppMain.flag = true;

                            onResume();
                            AppMain.IsDataSaveMainActivity = true;
                            AppMain.IsDataSaveend = false;

                            startActivity(new Intent(MainActivity.this, SectionAActivity.class));
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }

        } else {

            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
        }
    }

    public void openA(View v) {
        /*Set Boolean for checking*/

//        finish();

        AppMain.flag = false;

        Intent iA = new Intent(this, SectionAActivity.class);
        startActivity(iA);
    }

    public void openB(View v) {
       /* Intent iB = new Intent(this, SectionBActivity.class);
        startActivity(iB);*/
    }

    /*public void openC(View v) {
        Intent iC = new Intent(this, SectionCActivity.class);
        startActivity(iC);
    }*/

    public void openD(View v) {
//        finish();
                /*Set Boolean for checking*/
        AppMain.flag = false;
        Intent iD = new Intent(this, SectionDActivity.class);
        startActivity(iD);
    }

    public void openE(View v) {
//        finish();
                /*Set Boolean for checking*/
        AppMain.flag = false;
        Intent iE = new Intent(this, SectionEActivity.class);
        startActivity(iE);
    }

    public void openF(View v) {
//        finish();
                /*Set Boolean for checking*/
        AppMain.flag = false;
        Intent iF = new Intent(this, SectionFActivity.class);
        startActivity(iF);
    }

   /* public void openIM(View v) {
        Intent iIM = new Intent(this, SectionIMActivity.class);
        startActivity(iIM);
    }*/

    public void openG(View v) {
//        finish();
                /*Set Boolean for checking*/
        AppMain.flag = false;
        Intent iG = new Intent(this, SectionGActivity.class);
        startActivity(iG);
    }

    public void openH(View v) {
//        finish();
                /*Set Boolean for checking*/
        AppMain.flag = false;
        Intent iH = new Intent(this, SectionHActivity.class);
        startActivity(iH);
    }

    public void openEnd(View v) {
        Intent iEnd = new Intent(this, EndingActivity.class);
        startActivity(iEnd);
    }

    public void openDB(View v) {
        Intent dbmanager = new Intent(getApplicationContext(), AndroidDatabaseManager.class);
        startActivity(dbmanager);
    }

    /*public void CheckCluster(View v) {
        Intent cluster_list = new Intent(getApplicationContext(), FormsList.class);
        cluster_list.putExtra("clusterno", clusterNo.getText().toString());
        startActivity(cluster_list);

    }*/

    public void syncServer(View view) {

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
            new SyncForms(this).execute();

            new SyncLocation(this).execute();

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastSyncServer", dtToday);

            editor.apply();

            recordSummary();

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }

    }

    public void syncDevice(View view) {
        if (isNetworkAvailable()) {

            syncData sync = new syncData(this);
            sync.execute();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
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
        if (timer == null && !AppMain.IsDataSaveMainActivity) {
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

        Intent notificationIntent = new Intent(this, MainActivity.class);
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
            if (!AppMain.IsDataSaveMainActivity) {
                bringApplicationToFront();
            }
        }
    }


    public class syncData extends AsyncTask<String, String, String> {

        private Context mContext;

        public syncData(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    GetUsers us = new GetUsers(mContext);
                    Toast.makeText(mContext, "Syncing Users", Toast.LENGTH_SHORT).show();
                    us.execute();

                    GetProvince gt = new GetProvince(mContext);
                    Toast.makeText(mContext, "Syncing Provinces", Toast.LENGTH_SHORT).show();
                    gt.execute();

                    GetDistricts gv = new GetDistricts(mContext);
                    Toast.makeText(mContext, "Syncing Districts", Toast.LENGTH_SHORT).show();
                    gv.execute();

                    /*GetUCs gu = new GetUCs(mContext);
                    Toast.makeText(mContext, "Syncing Ucs", Toast.LENGTH_SHORT).show();
                    gu.execute();*/

                    /*GetHFacilities gh = new GetHFacilities(mContext);
                    Toast.makeText(mContext, "Syncing Health Facilities", Toast.LENGTH_SHORT).show();
                    gh.execute();
*/
                    /*GetLHWs gp = new GetLHWs(mContext);
                    Toast.makeText(mContext, "Syncing LHWs", Toast.LENGTH_SHORT).show();
                    gp.execute();*/

                    SharedPreferences syncPref = getSharedPreferences("SyncInfo(DOWN)", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = syncPref.edit();

                    editor.putString("LastSyncDevice", dtToday);

                    editor.apply();
                }
            });


            return null;
        }
    }
}