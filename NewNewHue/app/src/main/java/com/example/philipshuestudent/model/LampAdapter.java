package com.example.philipshuestudent.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.philipshuestudent.R;

import java.util.ArrayList;

public class LampAdapter extends RecyclerView.Adapter<LampAdapter.ViewHolder> {

    private ArrayList<Lamp> lampen;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getNaamView().setText("Test");
        holder.getKleurView().setText("Test");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView naamView;
        private TextView kleurView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            naamView = itemView.findViewById(R.id.naam);
            kleurView = itemView.findViewById(R.id.kleur);
            itemView.setOnClickListener(this);
        }

        public TextView getNaamView(){
            return naamView;
        }

        public TextView getKleurView(){
            return kleurView;
        }

        @Override
        public void onClick(View view) {
            int positie = getLayoutPosition();

        }
    }

}


