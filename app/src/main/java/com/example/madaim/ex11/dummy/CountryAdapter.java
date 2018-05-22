package com.example.madaim.ex11.dummy;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.madaim.ex11.R;

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
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.rawitem,parent,false);

        Country currCountry = getItem(position);
        int resId = parent.getResources().getIdentifier(currCountry.getFlag(), "drawable", getContext().getPackageName());

        ImageView image = (ImageView)listItem.findViewById(R.id.flag);
        image.setImageResource(resId);

        TextView name = (TextView) listItem.findViewById(R.id.text);
        name.setText(currCountry.getName());

        TextView release = (TextView) listItem.findViewById(R.id.text2);
        release.setText(currCountry.getShorty());
        listItem.setTag(currCountry.details);

        return listItem;
    }
    public void delete(int index){
        remove(getItem(index));
        allCountries.remove(index);

    }

}
