package com.example.learnandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataAdapterViewHolder> {

    private String[] data;

    public DataAdapter(String[] data) {
        this.data = data;
    }

    // create a view and store it
    @NonNull
    @Override
    public DataAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);
        return new DataAdapterViewHolder(view);
    }

    // data bind to view
    @Override
    public void onBindViewHolder(@NonNull DataAdapterViewHolder holder, int position) {
        String title = data[position];
        holder.txtTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class DataAdapterViewHolder extends RecyclerView.ViewHolder {
            TextView txtTitle;
            public DataAdapterViewHolder(View itemView) {
                super(itemView);
                txtTitle = (TextView) itemView.findViewById(R.id.textTitle);
            }
        }
}
