package com.example.mvvmtest.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmtest.models.NicePlace;
import com.example.mvvmtest.repositories.NicePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private final static String TAG = "MainActivityViewModel";

    private MutableLiveData<List<NicePlace>> mutableLiveDataPlace;
    private NicePlaceRepository nicePlaceRepository;

    public void init() {
        if (mutableLiveDataPlace != null) {
            return;
        }
        Log.d(TAG, "init: Called");
        nicePlaceRepository = NicePlaceRepository.getInstance();
        mutableLiveDataPlace = nicePlaceRepository.getNicePlace();

    }

    public LiveData<List<NicePlace>> getNicePlace() {
        return mutableLiveDataPlace;
    }

}
