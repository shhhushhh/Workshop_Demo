package com.example.workshopdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.elevation.SurfaceColors;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        final Fragment feedFragment = new MainFragment();
        final Fragment pageFragment = new PageFragment();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_main:
                        fragment = feedFragment;
                        break;
                    case R.id.action_otherPage:
                        fragment = pageFragment;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
                fragmentManager.beginTransaction().replace(R.id.mainPageFrame, fragment).addToBackStack( "main_fragment" ).commit();
                return true;
            }
        });
        bottomNavigationView.setBackgroundColor(SurfaceColors.SURFACE_2.getColor(this));
    }
}