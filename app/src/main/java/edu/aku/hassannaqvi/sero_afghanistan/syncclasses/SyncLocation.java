package edu.aku.hassannaqvi.sero_afghanistan.syncclasses;

import android.os.AsyncTask;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import edu.aku.hassannaqvi.sero_afghanistan.contracts.LocationContract;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;

/**
 * Created by javed.khan on 9/20/2017.
 */

public class SyncLocation extends AsyncTask<Void, Void, String> {

    private static final String TAG = "SyncLocation";
    private Context mContext;
    private ProgressDialog pd;

    public SyncLocation(Context context) {
        mContext = context;
    }

    public static void longInfo(String str) {
        if (str.length() > 4000) {
            Log.i(TAG, str.substring(0, 4000));
            longInfo(str.substring(4000));
        } else
            Log.i("TAG: ", str);
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setTitle("Please wait... Processing Location");
        pd.show();
    }


    @Override
    protected String doInBackground(Void... params) {
        try {

            String url = AppMain.PROJECT_URI + LocationContract.LocationTable._URL;

            Log.d(TAG, "doInBackground: URL " + url);
            return downloadUrl(url);
        } catch (IOException e) {
            return "Unable to upload data. Server may be down.";
        }
    }

    private String downloadUrl(String myurl) throws IOException {
        String line = "No Response";
        DatabaseHelper db = new DatabaseHelper(mContext);
        Collection<LocationContract> Forms = db.getUnsyncedLocation();

        if (Forms.size() > 0) {
            HttpURLConnection connection = null;
            try {
                String request = myurl;
                //String request = "http://10.1.42.30:3000/Forms";

                URL url = new URL(request);
                connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setInstanceFollowRedirects(false);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("charset", "utf-8");
                connection.setUseCaches(false);
                connection.connect();


                JSONArray jsonSync = new JSONArray();

                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());


                Log.d(TAG, String.valueOf(Forms.size()));
//            pd.setMessage("Total Forms: " );

                for (LocationContract fc : Forms) {
                    //if (fc.getIstatus().equals("1")) {
                    jsonSync.put(fc.toJSONObject());
                    //}
                }
                wr.writeBytes(jsonSync.toString().replace("\uFEFF", "") + "\n");
                longInfo(jsonSync.toString().replace("\uFEFF", "") + "\n");
                wr.flush();
                int HttpResult = connection.getResponseCode();
                if (HttpResult == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            connection.getInputStream(), "utf-8"));
                    StringBuffer sb = new StringBuffer();

                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();

                    System.out.println("" + sb.toString());
                    return sb.toString();
                } else {
                    System.out.println(connection.getResponseMessage());
                    return connection.getResponseMessage();
                }
            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (connection != null)
                    connection.disconnect();
            }
        } else {
            return "No new records to sync";
        }
        return line;
            /*===================================================================*/
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        int sSynced = 0;
        String sSyncedError = "";
        JSONArray json = null;
        try {
            json = new JSONArray(result);
            DatabaseHelper db = new DatabaseHelper(mContext);
            for (int i = 0; i < json.length(); i++) {

                JSONObject jsonObject = new JSONObject(json.getString(i));
                if (jsonObject.getString("status").equals("1") && jsonObject.getString("error").equals("0")) {
                    db.updateForms(jsonObject.getString("id"));
                    sSynced++;
                } else {
                    sSyncedError += jsonObject.getString("message").toString() + "\n";
                }
            }

            Toast.makeText(mContext, sSynced + " Forms synced." + String.valueOf(json.length() - sSynced) + " Errors: " + sSyncedError, Toast.LENGTH_SHORT).show();

            pd.setMessage(sSynced + " Forms synced." + String.valueOf(json.length() - sSynced) + " Errors: " + sSyncedError);
            pd.setTitle("Done uploading Location data");
            pd.show();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "Failed Sync " + result, Toast.LENGTH_SHORT).show();

            pd.setMessage(result);
            pd.setTitle("Forms Sync Failed");
            pd.show();
        }
    }
}