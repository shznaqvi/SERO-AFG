package edu.aku.hassannaqvi.sero_afghanistan.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.FormsContract;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.HFacilitiesContract;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.LHWsContract;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.ProvinceContract;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.TehsilsContract;
import edu.aku.hassannaqvi.sero_afghanistan.core.AndroidDatabaseManager;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;
import edu.aku.hassannaqvi.sero_afghanistan.getclasses.GetDistricts;
import edu.aku.hassannaqvi.sero_afghanistan.getclasses.GetHFacilities;
import edu.aku.hassannaqvi.sero_afghanistan.getclasses.GetLHWs;
import edu.aku.hassannaqvi.sero_afghanistan.getclasses.GetProvince;
import edu.aku.hassannaqvi.sero_afghanistan.getclasses.GetUCs;
import edu.aku.hassannaqvi.sero_afghanistan.getclasses.GetUsers;
import edu.aku.hassannaqvi.sero_afghanistan.syncclasses.SyncForms;

public class MainActivity extends Activity {

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

    public void recordSummary(){

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
        if (sharedPref.getString("tagName", null) != "" && sharedPref.getString("tagName", null) != null) {
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

    }

    public void openA(View v) {
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
        Intent iD = new Intent(this, SectionDActivity.class);
        startActivity(iD);
    }

    public void openE(View v) {
        Intent iE = new Intent(this, SectionEActivity.class);
        startActivity(iE);
    }

    public void openF(View v) {
        Intent iF = new Intent(this, SectionFActivity.class);
        startActivity(iF);
    }

   /* public void openIM(View v) {
        Intent iIM = new Intent(this, SectionIMActivity.class);
        startActivity(iIM);
    }*/

    public void openG(View v) {
        Intent iG = new Intent(this, SectionGActivity.class);
        startActivity(iG);
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