package com.example.philipshuestudent.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.philipshuestudent.R;
import com.example.philipshuestudent.ui.SecondFragment;

import java.util.ArrayList;

public class LampAdapter extends RecyclerView.Adapter<LampAdapter.ViewHolder> {

    private ArrayList<Lamp> lampList;
    private LayoutInflater inflater;

    public LampAdapter(Context context, ArrayList<Lamp> lampList) {
        this.inflater = LayoutInflater.from(context);
        this.lampList = lampList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lamp lamp = this.lampList.get(position);
        holder.getNaamView().setText(lamp.getName());
        holder.getKleurView().setText("#" + lamp.getState().getHue());
    }

    @Override
    public int getItemCount() {
        return lampList.size();
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

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            Lamp lamp = lampList.get(position);
            Intent intent = new Intent(itemView.getContext(), SecondFragment.class);
            itemView.getContext().startActivity(intent);
        }

        public TextView getNaamView() {
            return naamView;
        }

        public TextView getKleurView() {
            return kleurView;
        }

    }

}


