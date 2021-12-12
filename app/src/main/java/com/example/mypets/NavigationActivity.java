package com.example.mypets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mypets.fragments.home;
import com.example.mypets.fragments.location;
import com.example.mypets.fragments.notes;
import com.example.mypets.fragments.pets;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new home()).commit();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.item1:
                        fragment = new home();
                        break;
                    case R.id.item2:
                        fragment = new pets();
                        break;
                    case R.id.item3:
                        fragment = new notes();
                        break;
                    case R.id.item4:
                        fragment = new location();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
                return true;
            }
        });
    }
}