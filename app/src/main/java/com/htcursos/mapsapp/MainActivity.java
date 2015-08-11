package com.htcursos.mapsapp;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Virmerson on 11/08/15.
 */
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    Marker marker;
    List<LatLng> locais = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
          ButterKnife.bind(this);

        MapFragment map = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        map.getMapAsync(this);

        Localizador localizador = new Localizador(MainActivity.this);

        LatLng end1 = localizador.getCoordenada("Av. Noroeste 10624, Campo Grande, MS");
        LatLng end2 = localizador.getCoordenada("João Rosa Pires 1001, Campo Grande, MS");
        LatLng end3 = localizador.getCoordenada("Av. Afonso Pena 1000, Campo Grande, MS");

        locais.add(end1);
        locais.add(end2);
        locais.add(end3);

    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        googleMap.setMyLocationEnabled(true);
        googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                if(marker!=null){
                    marker.remove();
                }


                LatLng local = new LatLng(location.getLatitude(), location.getLongitude());
                marker =  googleMap.addMarker(new MarkerOptions().position(local));
            }
        });

        //Preencher com enderecos

        for (LatLng l: locais){
            googleMap.addMarker(new MarkerOptions().position(l));
        }


    }
}
