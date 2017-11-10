package edu.aku.hassannaqvi.sero_afghanistan.core;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by javed.khan on 11/7/2017.
 */

public class CVars extends AppCompatActivity {

    static final String HFACILITY = "scoreText";
    static final String USER = "";


    public static String hfacility = "";
    public static String user = "";

    public static String getHFacility() {
        return hfacility;
    }

    public static String setHFacility(String hf) {
        return hfacility = hf;
    }

    public static String getUser() {
        return user;
    }

    public static String setUser(String usr) {
        return user = usr;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(HFACILITY, AppMain.hfacility);
        savedInstanceState.putString(USER, AppMain.username);

        Toast.makeText(this, savedInstanceState.getString(USER), Toast.LENGTH_SHORT).show();

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        CVars.setHFacility(savedInstanceState.getString(HFACILITY));
        CVars.setUser(savedInstanceState.getString(USER));

        Toast.makeText(this, CVars.getUser() + " - " + CVars.getHFacility(), Toast.LENGTH_SHORT).show();

        /*String cLimit = limitText.getText().toString();

        if ((counter >= 0) && (counter == Integer.parseInt(cLimit))) {
            scoreText.setTextColor(Color.RED);
            btn1.setClickable(false);
        }*/

    }
}