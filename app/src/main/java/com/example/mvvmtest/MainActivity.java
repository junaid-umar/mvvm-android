package com.example.mvvmtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    private ArrayList<String> userName = new ArrayList<>();
    private ArrayList<String> userImage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");
        initImageBitmaps();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "intiImageBitmap: called");
        userImage.add("https://homepages.cae.wisc.edu/~ece533/images/airplane.png");
        userName.add("Airplane");
        initRecycleView();
    }

    private void initRecycleView() {
        Log.d(TAG, "initRecycleView: called");
        RecyclerView recyclerView=findViewById(R.id.recycle_view);
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(this, userImage,userName);
        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
