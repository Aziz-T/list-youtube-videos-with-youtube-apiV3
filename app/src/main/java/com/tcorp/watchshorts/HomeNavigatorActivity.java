package com.tcorp.watchshorts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.tcorp.watchshorts.fragments.MainPageFragment;
import com.tcorp.watchshorts.fragments.SettingsFragment;
import com.tcorp.watchshorts.fragments.ShortsFragment;

public class HomeNavigatorActivity extends AppCompatActivity {
    String apiKey = "AIzaSyCqqV1dh0YSlhAMnXkKLHSfpzdEoJv1Dhg";
    String url = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=25&q=shorts&key="+apiKey;
    private ApiClass apiClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_navigator);
        apiClass = new ApiClass(this);
        apiClass.fetchData(url);
        loadFragment(new MainPageFragment(apiClass.videoModelList));
        BottomNavigationView navView = findViewById(R.id.nav_view);




        navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragment = new MainPageFragment(apiClass.videoModelList);
                        break;
                    case R.id.navigation_shorts:
                        fragment = new ShortsFragment(apiClass.videoModelList.get(0).getId());
                        break;
                    case R.id.navigation_settings:
                        fragment = new SettingsFragment();
                        break;
                }
                return loadFragment(fragment);
            }
        });

        navView.setItemIconTintList(null);
    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}