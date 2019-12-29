package com.example.mvvmtest.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmtest.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepository {
    private final static String TAG = "NicePlaceRepository";

    private static NicePlaceRepository nicePlaceRepositoryInstance;
    private ArrayList<NicePlace> nicePlaceArrayList = new ArrayList<>();

    public static NicePlaceRepository getInstance() {

        if (nicePlaceRepositoryInstance == null) {
            nicePlaceRepositoryInstance = new NicePlaceRepository();
        }
        Log.d(TAG,"NicePlaceRepository: called");
        return nicePlaceRepositoryInstance;
    }

    public MutableLiveData getNicePlace() {
        updateNicePlace();

        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(nicePlaceArrayList);

        return data;
    }

    private void updateNicePlace() {
        Log.d(TAG,"updateNicePlace: called");
        nicePlaceArrayList.add(new NicePlace("https://homepages.cae.wisc.edu/~ece533/images/airplane.png", "AirPlane"));
        nicePlaceArrayList.add(new NicePlace("https://homepages.cae.wisc.edu/~ece533/images/airplane.png", "AirPlane"));

    }

}
