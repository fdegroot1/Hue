package com.example.philipshuestudent.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.philipshuestudent.R;
import com.example.philipshuestudent.model.Lamp;

import top.defaults.colorpicker.ColorObserver;
import top.defaults.colorpicker.ColorPickerView;

public class DetailActivity extends AppCompatActivity {

    private ColorPickerView colorPickerView;
    private Lamp lamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        lamp = (Lamp)getIntent().getSerializableExtra("Lamp");
        ((TextView)findViewById(R.id.naam)).setText(lamp.getName());
        ((TextView)findViewById(R.id.id)).setText(lamp.getModelID());
        ((TextView)findViewById(R.id.hue)).setText(lamp.getState().getHue());

        colorPickerView = this.findViewById(R.id.colorPickerView);
        colorPickerView.subscribe((color, fromUser, shouldPropagate) -> {
            //TODO api manager callen
        });
    }
}