package com.example.mvvmtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.mvvmtest.adapters.RecycleViewAdapter;
import com.example.mvvmtest.models.NicePlace;
import com.example.mvvmtest.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    private Button fetchData;
    private NicePlace nicePlace;
    private RecyclerView recyclerView;
    private MainActivityViewModel mainActivityViewModel;
    private  RecycleViewAdapter recycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchData=findViewById(R.id.fetch_data);
        recyclerView = findViewById(R.id.recycle_view);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

         // Deprecated
      //  mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();
        mainActivityViewModel.getNicePlace().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                recycleViewAdapter.notifyDataSetChanged();
            }
        });



        Log.d(TAG, "onCreate: started");
        initRecycleView();
    }


    private void initRecycleView() {
        Log.d(TAG, "initRecycleView: called");
         recycleViewAdapter = new RecycleViewAdapter(this, mainActivityViewModel.getNicePlace().getValue());
        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
