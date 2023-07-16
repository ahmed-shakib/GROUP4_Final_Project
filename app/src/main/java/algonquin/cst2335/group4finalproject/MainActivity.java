package algonquin.cst2335.group4finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import algonquin.cst2335.group4finalproject.FlightTracker.FlightTracker;
import algonquin.cst2335.group4finalproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the view model
        model = new ViewModelProvider(this).get(MainActivityViewModel.class);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Binding the button from the activity_main.xml file
        Button flightTrackerButton = binding.flightTrackerLaunchButton;

        flightTrackerButton.setOnClickListener(( v ) ->{
            Toast.makeText(this,"Flight Tracker is launching...", Toast.LENGTH_LONG).show();
            Intent flightTrackerPage = new Intent( this, FlightTracker.class);
            startActivity(flightTrackerPage);
        });
    }
}