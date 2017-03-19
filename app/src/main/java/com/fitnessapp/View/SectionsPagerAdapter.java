package com.fitnessapp.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fitnessapp.View.Fragments.OverviewFragment;
import com.fitnessapp.View.Fragments.ExerciseFragment;
import com.fitnessapp.View.Fragments.TrainDayFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter{

    private OverviewFragment overviewFragment = new OverviewFragment();
    private ExerciseFragment exerciseFragment = new ExerciseFragment();
    private TrainDayFragment trainDayFragment = new TrainDayFragment();

    private int ov_pos = 0, new_pra = 1, new_day = 2, fragmentCount = 3;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount(){
        return fragmentCount;
    }

    @Override
    public Fragment getItem(int pos){

        switch(pos) {
            case (0):
                return this.overviewFragment;
            case (1):
                return this.exerciseFragment;
            case (2):
                return this.trainDayFragment;
        }
        return null;
    }

    public int getOverviewPos(){
        return this.ov_pos;
    }

    public int getNewExercisePos(){
        return this.new_pra;
    }

    public int getTrainDayPos(){
        return this.new_day;
    }
}
