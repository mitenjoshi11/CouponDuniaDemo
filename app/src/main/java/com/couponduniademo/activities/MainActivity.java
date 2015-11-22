package com.couponduniademo.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.couponduniademo.R;
import com.couponduniademo.adapters.RestaurantAdapter;
import com.couponduniademo.entities.Response;
import com.couponduniademo.util.Utility;
import com.couponduniademo.webservices.GetRestaurantsData;


public class MainActivity extends ActionBarActivity implements LocationListener {

    private static final String TAG = "CouponDuniaDemo";

    private RecyclerView mRecyclerView;

    private RestaurantAdapter adapter;

    private LocationManager locationManager;

    // CurrentLocation latitude & Longitude
    private double sourcelatitude;
    private double sourcelong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /* Initialize recyclerview */
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage(getString(R.string.gps_message));
            dialog.setPositiveButton(getString(R.string.allow), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(myIntent);
                }
            });
            dialog.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    paramDialogInterface.cancel();
                }
            });
            dialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Call AsyncTask for Getting the restaurants data from Webservice
        if (Utility.isNetworkAvailable(this)) {//  Check internet is available
            new RestaurantsData().execute();
        } else {
            Toast.makeText(this, getString(R.string.internet_connection_not_available), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLocationChanged(Location location) {
        sourcelatitude = location.getLatitude();
        sourcelong = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    private class RestaurantsData extends AsyncTask<Void, Void, Response> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage(getString(R.string.loading));
            progressDialog.show();
            progressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected Response doInBackground(Void... params) {
            Response response = GetRestaurantsData.get();

            return response;
        }

        @Override
        protected void onPostExecute(Response result) {
            super.onPostExecute(result);

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

            /* Response complete. Lets update UI */
            adapter = new RestaurantAdapter(MainActivity.this, result.getData(), sourcelatitude, sourcelong);
            mRecyclerView.setAdapter(adapter);

        }
    }

}
