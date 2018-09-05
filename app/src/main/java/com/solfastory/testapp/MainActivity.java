package com.solfastory.testapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.solfastory.testapp.fragment.ListItemFragment;
import com.solfastory.testapp.fragment.ProfilFragment;
import com.solfastory.testapp.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout viewContainer;
    FragmentManager manager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    manager.beginTransaction().replace(R.id.container_fragment, new ListItemFragment()).commit();
                    setTitle("HOME");
                    break;
                case R.id.navigation_dashboard:
                    manager.beginTransaction().replace(R.id.container_fragment, new ProfilFragment()).commit();
                    setTitle("PROFIL");
                  break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("HOME");

        viewContainer = (LinearLayout)  findViewById(R.id.container_fragment);

        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.container_fragment, new ListItemFragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
