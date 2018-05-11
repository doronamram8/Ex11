package com.example.madaim.ex11.dummy;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Madaim on 11/05/2018.
 */

public class CountryAdapter extends ArrayAdapter<Country> {
        ArrayList<Country> allCountries;
    public CountryAdapter( Context context) {
        super(context,android.R.layout.simple_list_item_1);
        InputStream inputStream=openAssetDataStream(context);
        allCountries=XMLParser.parseFromStream(inputStream);
        for(Country country:allCountries){
            add(country);
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static InputStream openAssetDataStream(Context context){
        AssetManager assetManager = context.getAssets();
        InputStream in =null;
        try {
            in = assetManager.open("countries.xml");
        } catch (IOException e) {e.printStackTrace();}
        return in;
    }


}
