package com.fitnessapp.View;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.fitnessapp.Controll.MainController;

import ownuse.fitnessapp.R;

public class MainActivity extends AppCompatActivity {

    public static MainController mainController;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // TrainingSet up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mainController = new MainController(this);
    }

    public void setOnOverivew() {
        mViewPager.setCurrentItem(mSectionsPagerAdapter.getOverviewPos());
    }

    public void setOnNewExercise() {
        mViewPager.setCurrentItem(mSectionsPagerAdapter.getNewExercisePos());
    }

    public void setOneNewTrainDay() {
        mViewPager.setCurrentItem(mSectionsPagerAdapter.getTrainDayPos());
    }
}
