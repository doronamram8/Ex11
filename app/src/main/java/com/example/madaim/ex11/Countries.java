package com.example.madaim.ex11;

import android.app.ListFragment;
import android.content.Context;

import com.example.madaim.ex11.dummy.CountryAdapter;

/**
 * Created by Madaim on 11/05/2018.
 */

public class Countries extends ListFragment {
    CountryAdapter adapter;
    public Countries(){
        super();

    }

    @Override
    public void onAttach(Context context) {
       adapter=new CountryAdapter(context);
       setListAdapter(adapter);
        super.onAttach(context);
    }
}
