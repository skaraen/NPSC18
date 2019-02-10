package com.nitt.karaens.npsc18;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int MY_FINE_LOCATION_PERMISSION=101;
    LocationManager lm;
    LatLng userLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng dept = new LatLng(10.758848, 78.814679);
        LatLng barn = new LatLng(10.759283, 78.813216);
        LatLng audi = new LatLng(10.759110, 78.814690);
        LatLng sem = new LatLng(10.758920, 78.814757);
        LatLng a11 = new LatLng(10.758985, 78.813493);
        LatLng a12 = new LatLng(10.758988, 78.813555);
        LatLng a13 = new LatLng(10.759034, 78.813612);
        LatLng csg = new LatLng(10.760745, 78.814791);
        LatLng annexe = new LatLng(10.761143, 78.814674);
        LatLng mid = new LatLng(10.760223, 78.814194);

        BitmapDrawable bNor=(BitmapDrawable)getResources().getDrawable(R.drawable.norloc);
        Bitmap bN=bNor.getBitmap();
        Bitmap NMark = Bitmap.createScaledBitmap(bN, 75, 75, false);
        BitmapDrawable bDes=(BitmapDrawable)getResources().getDrawable(R.drawable.desloc);
        Bitmap bD=bDes.getBitmap();
        Bitmap DMark = Bitmap.createScaledBitmap(bD, 100, 100, false);

        switch (getIntent().getStringExtra("Loc")) {
            case "1":
                mMap.addMarker(new MarkerOptions().position(dept).title("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(DMark))).showInfoWindow();
                mMap.addMarker(new MarkerOptions().position(barn).title("BARN Hall").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(audi).title("EEE Auditorium").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(sem).title("EEE Seminar Hall").snippet("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a11).title("A11 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a12).title("A12 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a13).title("A13 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(csg).title("Computer Support Group(CSG)").snippet("Octagon").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(annexe).title("Octagon Annexure").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                break;
            case "2":
                mMap.addMarker(new MarkerOptions().position(dept).title("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(barn).title("BARN Hall").icon(BitmapDescriptorFactory.fromBitmap(DMark))).showInfoWindow();
                mMap.addMarker(new MarkerOptions().position(audi).title("EEE Auditorium").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(sem).title("EEE Seminar Hall").snippet("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a11).title("A11 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a12).title("A12 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a13).title("A13 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(csg).title("Computer Support Group(CSG)").snippet("Octagon").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(annexe).title("Octagon Annexure").icon(BitmapDescriptorFactory.fromBitmap(NMark)));                break;
            case "3":
                mMap.addMarker(new MarkerOptions().position(dept).title("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(barn).title("BARN Hall").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(audi).title("EEE Auditorium").icon(BitmapDescriptorFactory.fromBitmap(DMark))).showInfoWindow();
                mMap.addMarker(new MarkerOptions().position(sem).title("EEE Seminar Hall").snippet("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a11).title("A11 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a12).title("A12 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a13).title("A13 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(csg).title("Computer Support Group(CSG)").snippet("Octagon").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(annexe).title("Octagon Annexure").icon(BitmapDescriptorFactory.fromBitmap(NMark)));                break;
            case "4":
                mMap.addMarker(new MarkerOptions().position(dept).title("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(barn).title("BARN Hall").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(audi).title("EEE Auditorium").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(sem).title("EEE Seminar Hall").snippet("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a11).title("A11 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a12).title("A12 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a13).title("A13 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(DMark))).showInfoWindow();
                mMap.addMarker(new MarkerOptions().position(csg).title("Computer Support Group(CSG)").snippet("Octagon").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(annexe).title("Octagon Annexure").icon(BitmapDescriptorFactory.fromBitmap(NMark)));                break;
            case "5":
                mMap.addMarker(new MarkerOptions().position(dept).title("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(barn).title("BARN Hall").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(audi).title("EEE Auditorium").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(sem).title("EEE Seminar Hall").snippet("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(a11).title("A11 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(a12).title("A12 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(a13).title("A13 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(csg).title("Computer Support Group(CSG)").snippet("Octagon").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(annexe).title("Octagon Annexure").icon(BitmapDescriptorFactory.fromBitmap(NMark)));                break;
            case "6":
                mMap.addMarker(new MarkerOptions().position(dept).title("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(barn).title("BARN Hall").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(audi).title("EEE Auditorium").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(sem).title("EEE Seminar Hall").snippet("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(a11).title("A11 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(a12).title("A12 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(a13).title("A13 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(csg).title("Computer Support Group(CSG)").snippet("Octagon").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(annexe).title("Octagon Annexure").icon(BitmapDescriptorFactory.fromBitmap(NMark)));                break;
            case "7":
                mMap.addMarker(new MarkerOptions().position(dept).title("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(barn).title("BARN Hall").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(audi).title("EEE Auditorium").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(sem).title("EEE Seminar Hall").snippet("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a11).title("A11 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a12).title("A12 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a13).title("A13 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(csg).title("Computer Support Group(CSG)").snippet("Octagon").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(annexe).title("Octagon Annexure").icon(BitmapDescriptorFactory.fromBitmap(NMark)));                break;
            case "8":
                mMap.addMarker(new MarkerOptions().position(dept).title("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(barn).title("BARN Hall").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(audi).title("EEE Auditorium").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(sem).title("EEE Seminar Hall").snippet("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a11).title("A11 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a12).title("A12 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a13).title("A13 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(csg).title("Computer Support Group(CSG)").snippet("Octagon").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(annexe).title("Octagon Annexure").icon(BitmapDescriptorFactory.fromBitmap(DMark)));                break;
            case "9":
                mMap.addMarker(new MarkerOptions().position(dept).title("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(barn).title("BARN Hall").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(audi).title("EEE Auditorium").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(sem).title("EEE Seminar Hall").snippet("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(a11).title("A11 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(a12).title("A12 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(a13).title("A13 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(DMark)));
                mMap.addMarker(new MarkerOptions().position(csg).title("Computer Support Group(CSG)").snippet("Octagon").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(annexe).title("Octagon Annexure").icon(BitmapDescriptorFactory.fromBitmap(NMark)));                break;
            case "10":
                mMap.addMarker(new MarkerOptions().position(dept).title("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(barn).title("BARN Hall").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(audi).title("EEE Auditorium").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(sem).title("EEE Seminar Hall").snippet("Department of EEE").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a11).title("A11 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(DMark))).showInfoWindow();
                mMap.addMarker(new MarkerOptions().position(a12).title("A12 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(a13).title("A13 Hall").snippet("Admin Block").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(csg).title("Computer Support Group(CSG)").snippet("Octagon").icon(BitmapDescriptorFactory.fromBitmap(NMark)));
                mMap.addMarker(new MarkerOptions().position(annexe).title("Octagon Annexure").icon(BitmapDescriptorFactory.fromBitmap(NMark)));                break;

        }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mid,17.5f));

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            { /*lm= (LocationManager) getSystemService(LOCATION_SERVICE);
            if(lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
                lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        userLoc=new LatLng(location.getLatitude(),location.getLongitude());
                        BitmapDrawable bUser=(BitmapDrawable)getResources().getDrawable(R.drawable.desloc);
                        Bitmap bU=bUser.getBitmap();
                        Bitmap UMark = Bitmap.createScaledBitmap(bU, 100, 100, false);
                        mMap.addMarker(new MarkerOptions().position(userLoc).title("You're Here!").icon(BitmapDescriptorFactory.fromBitmap(UMark)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLoc,20.0f));
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
                });
            }
            else if(lm.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        userLoc=new LatLng(location.getLatitude(),location.getLongitude());
                        BitmapDrawable bUser=(BitmapDrawable)getResources().getDrawable(R.drawable.desloc);
                        Bitmap bU=bUser.getBitmap();
                        Bitmap UMark = Bitmap.createScaledBitmap(bU, 100, 100, false);
                        mMap.addMarker(new MarkerOptions().position(userLoc).title("You're Here!").icon(BitmapDescriptorFactory.fromBitmap(UMark)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLoc,20.0f));

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
                });
           }*/
                mMap.setMyLocationEnabled(true);
            }
            else{
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},MY_FINE_LOCATION_PERMISSION);
                }
                else
                    Toast.makeText(getApplicationContext(),"This service is not compatible in your phone !",Toast.LENGTH_LONG).show();

        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_FINE_LOCATION_PERMISSION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        /*lm= (LocationManager) getSystemService(LOCATION_SERVICE);
            if(lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
                lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        userLoc=new LatLng(location.getLatitude(),location.getLongitude());
                        BitmapDrawable bUser=(BitmapDrawable)getResources().getDrawable(R.drawable.desloc);
                        Bitmap bU=bUser.getBitmap();
                        Bitmap UMark = Bitmap.createScaledBitmap(bU, 100, 100, false);
                        mMap.addMarker(new MarkerOptions().position(userLoc).title("You're Here!").icon(BitmapDescriptorFactory.fromBitmap(UMark)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLoc,20.0f));
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
                });
            }
            else if(lm.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        userLoc=new LatLng(location.getLatitude(),location.getLongitude());
                        BitmapDrawable bUser=(BitmapDrawable)getResources().getDrawable(R.drawable.desloc);
                        Bitmap bU=bUser.getBitmap();
                        Bitmap UMark = Bitmap.createScaledBitmap(bU, 100, 100, false);
                        mMap.addMarker(new MarkerOptions().position(userLoc).title("You're Here!").icon(BitmapDescriptorFactory.fromBitmap(UMark)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLoc,20.0f));

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
                });
           }*/
                        mMap.setMyLocationEnabled(true);
                    } else {
                        Toast.makeText(getApplicationContext(), "This service needs location permission !", Toast.LENGTH_LONG).show();
                    }
                    break;
                }
        }
    }
}
