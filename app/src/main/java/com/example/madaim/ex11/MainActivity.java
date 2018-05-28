package com.example.madaim.ex11;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tb = (Toolbar) findViewById(R.id.tb);
        setActionBar(tb);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        String input = settings.getString("edit_text_preference_1", "guest");
        Toast.makeText(getApplicationContext(),"Welcome "+input,Toast.LENGTH_SHORT).show();
        boolean salah=settings.getBoolean("Savelist",false);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }



    public static class MyPreferences extends PreferenceFragment{
        @Override
        public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
            View view= super.onCreateView(inflater, container, savedInstanceState);
            view.setBackgroundColor(getResources().getColor(android.R.color.white));
            return view;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         switch (item.getItemId()) {
            case R.id.settings:
                getFragmentManager().beginTransaction().add(android.R.id.content,new MyPreferences()).addToBackStack(null).commit();

                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}

