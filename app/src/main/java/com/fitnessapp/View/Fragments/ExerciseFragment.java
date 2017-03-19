package com.fitnessapp.View.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapp.Controll.MainController;
import com.fitnessapp.View.MainActivity;

import ownuse.fitnessapp.R;

public class ExerciseFragment extends Fragment{

    private MainController mainController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newexercise, container, false);

        mainController = MainActivity.mainController;


        return view;
    }

    //TODO: everything
}

