package com.example.learnandroid;

import static java.util.Objects.requireNonNull;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Objects;
import java.util.zip.Inflater;

public class GithubDataAdapter extends RecyclerView.Adapter<GithubDataAdapter.GithubViewHolder> {

    private Context context;
    private UserActivity[] data;

    public GithubDataAdapter(Context context, UserActivity[] data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_user_layout, parent, false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder holder, int position) {
        UserActivity user = data[position];
        holder.textView.setText(user.getLogin());
        Glide.with(holder.imageView.getContext()).load(user.getAvatarUrl()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, user.getLogin() + " was clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public GithubViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageUser);
            textView = (TextView) itemView.findViewById(R.id.textUser);
        }
    }
}
