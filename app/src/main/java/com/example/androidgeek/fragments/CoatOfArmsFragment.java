package com.example.androidgeek.fragments;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.androidgeek.CoatContainer;
import com.example.androidgeek.R;

import java.util.Objects;

public class CoatOfArmsFragment extends Fragment {
    static CoatOfArmsFragment create(CoatContainer container) {
        CoatOfArmsFragment fragment = new CoatOfArmsFragment();

        Bundle args = new Bundle();
        args.putSerializable("index", container);
        fragment.setArguments(args);
        return fragment;
    }

    int getIndex() {
        CoatContainer coatContainer = (CoatContainer) (Objects.requireNonNull(getArguments())
                .getSerializable("index"));

        try {
            return coatContainer.position;
        } catch (Exception e) {
            return 0;
        }
    }

    String getCityName() {
        CoatContainer coatContainer = (CoatContainer) (Objects.requireNonNull(getArguments())
                .getSerializable("index"));

        try {
            return coatContainer.cityName;
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    @SuppressLint("Recycle")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView cityNameTextView = new TextView(getContext());
        cityNameTextView.setGravity (Gravity.CENTER);
        String cityName = getCityName();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            cityNameTextView.setTextSize ( 20 );
            cityNameTextView.setText(cityName);
        }
        TextView weatherInTheCity = new TextView(getContext());
        weatherInTheCity.setGravity (Gravity.END);
        weatherInTheCity.setPadding ( 0,200,250,0 );
        weatherInTheCity.setText ( R.string.weather);

        layout.addView(cityNameTextView);
        layout.addView (weatherInTheCity);

        return layout;
    }
}
