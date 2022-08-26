package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserRecyclerActivity extends AppCompatActivity {

    private String URL = "https://api.github.com/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_recycler);
        RecyclerView userList = (RecyclerView) findViewById(R.id.userRecyclerView);
        userList.setLayoutManager(new LinearLayoutManager(this));

        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("CODE", response);

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                UserActivity[] users = gson.fromJson(response, UserActivity[].class);
                userList.setAdapter(new GithubDataAdapter(UserRecyclerActivity.this, users));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UserRecyclerActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);

    }
}