package algonquin.cst2335.group4finalproject.FlightTracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import algonquin.cst2335.group4finalproject.R;
import algonquin.cst2335.group4finalproject.databinding.ActivityFlightTrackerBinding;
import algonquin.cst2335.group4finalproject.databinding.FlightDetailsBinding;
import algonquin.cst2335.group4finalproject.databinding.FlightListBinding;


public class FlightTracker extends AppCompatActivity {

    private ActivityFlightTrackerBinding binding;
    private FlightTrackerViewModel flightModel;

    ArrayList<FlightDetails> flights = new ArrayList<>();
    private RecyclerView.Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFlightTrackerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        flightModel = new ViewModelProvider(this).get(FlightTrackerViewModel.class);
        flights = flightModel.flights;

        //EditText airportCode = binding.airportCodeText;
        Button flightListButton = binding.flightSearchButton;

        flightListButton.setOnClickListener( click ->{
            flights.add(new FlightDetails("test123","Ottawa","A1","1 hour", false));

            myAdapter.notifyDataSetChanged();
        });

        binding.recycleView.setAdapter(myAdapter = new RecyclerView.Adapter<MyRowHolder>() {
            @NonNull
            @Override
            public MyRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


                if(viewType == 0){


                    FlightListBinding binding = FlightListBinding.inflate(getLayoutInflater(), parent,true);
                    return new MyRowHolder( binding.getRoot() );
                }
                else{
                    FlightDetailsBinding binding = FlightDetailsBinding.inflate(getLayoutInflater(), parent,false);
                    return new MyRowHolder( binding.getRoot() );
                }
            }

            public int getItemViewType(int position){
                if(flights.get(position).isDetails == false){
                    return 0;
                }
                else
                    return 1;
            }

            @Override
            public void onBindViewHolder(@NonNull MyRowHolder holder, int position) {
                holder.flight.setText("");
                holder.destination.setText("");
                holder.gate.setText("");
                holder.delay.setText("");

                FlightDetails obj = flights.get(position);

                holder.flight.setText(obj.flightNo);
                holder.destination.setText(obj.destination);
                holder.gate.setText(obj.gate);
                holder.delay.setText(obj.delay);

            }

            @Override
            public int getItemCount() {
                return flights.size();
            }
        });
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    protected class MyRowHolder extends RecyclerView.ViewHolder{

        // flight, specifically the Destination, Terminal, Gate, and Delay for that specific flight
        TextView flight;
        TextView destination;
        TextView gate;
        TextView delay;

        public MyRowHolder(@NonNull View itemView) {
            super(itemView);
            flight = itemView.findViewById(R.id.flightNo);
            destination = itemView.findViewById(R.id.destination);
            gate = itemView.findViewById( R.id.gate );
            delay = itemView.findViewById(R.id.delay);


        }

    }
}