package com.tcorp.watchshorts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.tcorp.watchshorts.fragments.MainPageFragment;
import com.tcorp.watchshorts.fragments.SettingsFragment;
import com.tcorp.watchshorts.fragments.ShortsFragment;

public class MainActivity extends AppCompatActivity {


    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.startButton);





        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigatePage();
            }
        });
    }

    void navigatePage(){

        Intent intent = new Intent(MainActivity.this,HomeNavigatorActivity.class);

        startActivity(intent);
    }
}