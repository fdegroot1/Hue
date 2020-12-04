package com.example.philipshuestudent.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.philipshuestudent.R;

import top.defaults.colorpicker.ColorObserver;
import top.defaults.colorpicker.ColorPickerView;

public class DetailActivity extends AppCompatActivity {

    private ColorPickerView colorPickerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        colorPickerView = this.findViewById(R.id.colorPickerView);
        colorPickerView.subscribe((color, fromUser, shouldPropagate) -> {
            //TODO api manager callen
        });
    }
}