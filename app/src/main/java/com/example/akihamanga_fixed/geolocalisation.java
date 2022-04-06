package com.example.akihamanga_fixed;

import android.Manifest;
import android.app.FragmentManager;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class geolocalisation extends AppCompatActivity implements LocationListener {

    private static final int PERMS_CALL_ID = 1;
    private LocationManager lm;
    private MapFragment mapFragment;
    private GoogleMap googleMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geolocalisation);

        /** RECUP DU FRAGMENT (layout) **/
        FragmentManager fragmentManager = getFragmentManager();
        mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.map);

        /** RECUP DE LA CARTE **/

    }

    @Override
    //@SuppressWarnings( "MissingPermission ")
    protected void onResume() {
        super.onResume();
        checkPermissions();
    }

    private void checkPermissions()
    {
        /*** ON VERIFIE QU'ON A BIEN LES PERMISSIONS (manifest) ***/
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, PERMS_CALL_ID);
            return;
        }
        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) //SI ON A BIEN UN CAPTEUR DE TYPE GPS QUI EST ACTIVE
        {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, this); //On récuppère les informations de localisation
        }

        if (lm.isProviderEnabled(LocationManager.PASSIVE_PROVIDER))
        {
            lm.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 1000, 0, this);
        }

        if (lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
        {
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, this);
        }

        //On charge la map une fois qu'on est sûr d'avoir les permissions
        loadMap();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMS_CALL_ID)
        {
            checkPermissions();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if( lm!=null)
        {
            lm.removeUpdates(this);
        }
    }

    @SuppressWarnings("MissingPermission")
    private void loadMap()
    {
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                /**On récuppère la google map **/
                geolocalisation.this.googleMap = googleMap;
                googleMap.moveCamera(CameraUpdateFactory.zoomBy( 15 ));  /**On déplace la caméra au niveau de la géolocalisation**/
                googleMap.setMyLocationEnabled( true );
                googleMap.addMarker(new MarkerOptions().position( new LatLng(43.48645, -1.49140))
                                                        .title("Fnac Bayonne")
                                                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
            }
        });
    }
    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        LocationListener.super.onStatusChanged(provider, status, extras);

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        double latitude = 43.48645;
        double longitude = -1.49140;

        //A CHAQUE FOIS QU'ON RECOIT UNE INFO DE POSITIONNEMENT, ON MET A JOUR LA MAP
        if (googleMap != null)
        {
            LatLng googleLocation = new LatLng( latitude, longitude);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(googleLocation));
        }
    }
}
