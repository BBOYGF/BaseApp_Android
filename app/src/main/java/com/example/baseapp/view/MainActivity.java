package com.example.baseapp.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.baseapp.R;
import com.example.baseapp.view_model.MainViewModel;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private AppBarConfiguration mAppBarConfiguration;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);

        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.fragment_setting, R.id.choice_directory).setOpenableLayout(drawerLayout).build();
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        getLifecycle().addObserver(mainViewModel);
        Log.i("TAG", "onCreate: " + mainViewModel.number);
        mainViewModel.liveData.observe(this, integer -> {

        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }

}