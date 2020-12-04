package com.example.philipshuestudent.ui;

import android.os.Bundle;

import com.example.philipshuestudent.R;
import com.example.philipshuestudent.model.Lamp;
import com.example.philipshuestudent.model.LampAdapter;
import com.example.philipshuestudent.service.ApiListener;
import com.example.philipshuestudent.service.impl.ApiManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements ApiListener{

    private RecyclerView recyclerView;
    private ArrayList<Lamp> lampen;
    private LampAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = this.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        lampen = new ArrayList<>();
        adapter = new LampAdapter(getApplicationContext()   , lampen);
        recyclerView.setAdapter(adapter);

        ApiManager apiManager = new ApiManager(getApplicationContext(), this);
        apiManager.getLights();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAvailable(Lamp lamp) {
        this.lampen.add(lamp);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Error error) {
        Log.e(MainActivity.class.getName(), "Error: " + error.getMessage());
    }
}