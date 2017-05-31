package edu.aku.hassannaqvi.sero_afghanistan.getclasses;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import edu.aku.hassannaqvi.sero_afghanistan.R;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.TehsilsContract;
import edu.aku.hassannaqvi.sero_afghanistan.contracts.TehsilsContract.TehsilTable;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;

/**
 * Created by javed.khan on 1/2/2017.
 */

public class GetTehsil extends AsyncTask<String, String, String> {

    private final String TAG = "GetTehsil()";
    HttpURLConnection urlConnection;
    private Context mContext;
    private ProgressDialog pd;

    public GetTehsil(Context context) {
        mContext = context;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext, R.style.AlertDialogStyle);
        pd.setTitle("Getting Tehsil");
        pd.setMessage("Preparing...");
        pd.show();
    }

    @Override
    protected String doInBackground(String... args) {

        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(AppMain.PROJECT_URI + TehsilTable.URI);

            urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //pd.show();

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    Log.i(TAG, "Tehsil In: " + line);
                    result.append(line);
                }
            } else {
                result.append("URL not found");
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            urlConnection.disconnect();
        }


        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {

        //Do something with the JSON string
        if (result != "URL not found") {
            String json = result;
            //json = json.replaceAll("\\[", "").replaceAll("\\]","");
            Log.d(TAG, result);
            ArrayList<TehsilsContract> tehsilArrayList;
            DatabaseHelper db = new DatabaseHelper(mContext);
            try {
                //JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = new JSONArray(json);
                db.syncTehsil(jsonArray);

                pd.setMessage("Received: " + jsonArray.length() + " Tehsil");
                pd.setTitle("Done... Synced Tehsil");

            } catch (JSONException e) {
                e.printStackTrace();
                pd.setMessage("Received: 0 Tehsil");
                pd.setTitle("Error... Syncing Tehsil");
            }
            db.getAllTehsil();
            pd.show();
        }
    }
}