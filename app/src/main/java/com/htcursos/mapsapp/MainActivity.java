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

/**
 * Created by Virmerson on 06/08/15.
 */
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {


    Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Acessando mapa pelo Gerenciador de Fragmentos

        MapFragment map = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        map.getMapAsync(this);

    }

    /**
     * Ao Carregar o Mapa
     * @param googleMap
     */
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        googleMap.setMyLocationEnabled(true);
        googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                if(marker!=null){
                    //Removendo o antigo
                    marker.remove();
                }

                //Acessando localizacao
                LatLng local = new LatLng(location.getLatitude(), location.getLongitude());

                //Adicionando um marcador com a posicao
                marker= googleMap.addMarker(new MarkerOptions().position(local));


            }
        });
    }


}
