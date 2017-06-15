package edu.aku.hassannaqvi.sero_afghanistan.getclasses;

/**
 * Created by Hassan.naqvi on 3/18/2017.
 */

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

import edu.aku.hassannaqvi.sero_afghanistan.contracts.UCsContract.UcTable;
import edu.aku.hassannaqvi.sero_afghanistan.core.AppMain;
import edu.aku.hassannaqvi.sero_afghanistan.core.DatabaseHelper;

/**
 * Created by hassan.naqvi on 4/28/2016.
 */
public class GetUCs extends AsyncTask<String, String, String> {

    private final String TAG = "GetUCs()";
    HttpURLConnection urlConnection;
    private Context mContext;
    private ProgressDialog pd;

    public GetUCs(Context context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setTitle("Getting UCs");
        pd.setMessage("Preparing...");
        pd.show();
    }

    @Override
    protected String doInBackground(String... args) {

        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(AppMain.PROJECT_URI + UcTable.URI);
            Log.d(TAG, "doInBackground: " + url);
            urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //pd.show();

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line = "";
                while ((line = reader.readLine()) != null) {
                    //pd.show();
                    Log.i(TAG, "UCs In: " + line);
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
            //Log.d(TAG, result);
            DatabaseHelper db = new DatabaseHelper(mContext);
            try {
                //JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = new JSONArray(json);
                pd.setMessage("Received: " + jsonArray.length() + " UCs");
                pd.setTitle("Done... Synced UCs");
                db.syncUc(jsonArray);
            } catch (JSONException e) {
                e.printStackTrace();
                pd.setMessage("Received: 0 UCs");
                pd.setTitle("Error... Syncing UCs");
            }
            pd.show();
        }



/*        try {
            JSONObject obj = new JSONObject(json);
            Log.d("My App", obj.toString());
        } catch (Throwable t) {
            Log.e("My App", "Could not parse malformed JSON: \"" + json + "\"");
        }*/

//        ArrayList<String> listdata = new ArrayList<String>();
//        JSONArray jArray = (JSONArray)jsonObject;
//        if (jArray != null) {
//            for (int i=0;i<jArray.length();i++){
//                listdata.add(jArray.get(i).toString());
//            }
//        }

    }
}