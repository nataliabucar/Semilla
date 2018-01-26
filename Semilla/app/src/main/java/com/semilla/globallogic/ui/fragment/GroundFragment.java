package com.semilla.globallogic.ui.fragment;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.semilla.globallogic.R;
import com.semilla.globallogic.ui.activity.WizardActivity;

import butterknife.OnClick;

public class GroundFragment extends BaseFragment implements OnMapReadyCallback,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks{
    private GoogleMap mMap;

    private GoogleApiClient apiClient;

    private static final int PETICION_PERMISO_LOCALIZACION = 101;

    public static Fragment newInstance() {

        return new GroundFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




        apiClient = new GoogleApiClient.Builder(getContext())
                .enableAutoManage(getActivity(), this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
    }



    @Override
    protected int makeLayoutResourceId() {
        return R.layout.ground_fragment;
    }

    @OnClick({R.id.tv_next, R.id.tv_cancel})
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_next:
                ((WizardActivity)getActivity()).setNextFragment(GroundSizeFragment.newInstance());
                break;
            case R.id.tv_cancel:
                getActivity().finish();
                break;
            default:
                Log.w(this.getTag(), "Not Defined Option");
                break;
        }
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PETICION_PERMISO_LOCALIZACION);
        } else {

            Location lastLocation =
                    LocationServices.FusedLocationApi.getLastLocation(apiClient);

            updateUI(lastLocation);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PETICION_PERMISO_LOCALIZACION) {
            if (grantResults.length == 1
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                //Permiso concedido

                @SuppressWarnings("MissingPermission")
                Location lastLocation =
                        LocationServices.FusedLocationApi.getLastLocation(apiClient);

                updateUI(lastLocation);

            } else {


                Log.e("MainActivity", "Permiso denegado");
            }
        }
    }

    private void updateUI(Location loc) {
        if (loc != null) {
            CameraUpdate center=
                    CameraUpdateFactory.newLatLng(new LatLng(loc.getLatitude(),
                            loc.getLongitude()));
            CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);

            mMap.moveCamera(center);
            mMap.animateCamera(zoom);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        CameraUpdate center=
                CameraUpdateFactory.newLatLng(new LatLng(-34.928846,
                        -57.932563));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);

        mMap.moveCamera(center);
        mMap.animateCamera(zoom);

    }
}
