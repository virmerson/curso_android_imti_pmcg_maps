package com.htcursos.mapsapp;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

/**
 * Created by Virmerson on 11/08/15.
 */
public class Localizador {

    private Context context;

    public Localizador(Context context) {
        this.context = context;
    }

    public LatLng getCoordenada(String endereco) {
        Geocoder geocoder = new Geocoder(context);
        try {
            List<Address> enderecos = geocoder.getFromLocationName(endereco, 1);
            if (!enderecos.isEmpty()) {
                Address enderecoLocalizado = enderecos.get(0);
                double latitude = enderecoLocalizado.getLatitude();
                double longitude = enderecoLocalizado.getLongitude();
                return new LatLng(latitude, longitude);
            }else{
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }
}

