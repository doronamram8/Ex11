package com.example.madaim.ex11;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView lv=getListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getContext(), view.getTag().toString(), Toast.LENGTH_SHORT).show();

            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long arg3) {


                Toast.makeText(getContext(),"deleted",Toast.LENGTH_SHORT).show();
                 adapter.delete(position);
                return false;
             }

        });
    }
}
