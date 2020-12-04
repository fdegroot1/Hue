package com.example.philipshuestudent.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.philipshuestudent.R;
import com.example.philipshuestudent.model.Lamp;
import com.example.philipshuestudent.model.LampAdapter;
import com.example.philipshuestudent.service.ApiListener;
import com.example.philipshuestudent.service.impl.ApiManager;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements ApiListener {

    private RecyclerView recyclerView;
    private ArrayList<Lamp> lampen;
    private LampAdapter adapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new LampAdapter();
        recyclerView.setAdapter(adapter);





        // Inflate the layout for this fragment
        ApiManager apiManager = new ApiManager(this.getContext(), this);
        apiManager.getLights();
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });*/
    }

    @Override
    public void onAvailable(Lamp lamp) {
        this.lampen.add(lamp);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Error error) {
        Log.e(FirstFragment.class.getName(), "Error: " + error.toString());
    }
}