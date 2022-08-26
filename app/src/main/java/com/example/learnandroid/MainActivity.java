package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

//    private String URL = "https://api.github.com/users";
    ImageButton btnMathPlay;
    Button recyclerDemo;
    Button userDetailDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMathPlay = (ImageButton) findViewById(R.id.play);
        recyclerDemo = (Button) findViewById(R.id.recycleViewDemo);
        userDetailDemo = (Button) findViewById(R.id.userButton);

        btnMathPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 *  Example of Explicit Intent
                 *  When you click Play Button on the screen
                 *  Game Activity will be started
                 */

                Intent i = new Intent(MainActivity.this,GameActivity.class);
                startActivity(i);
            }
        });

//        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.d("CODE", response);
//
//                GsonBuilder gsonBuilder = new GsonBuilder();
//                Gson gson = gsonBuilder.create();
//                UserActivity[] users = gson.fromJson(response, UserActivity[].class);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
//            }
//        });

        recyclerDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(i);
            }
        });

        userDetailDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, UserRecyclerActivity.class);
                startActivity(i);
            }
        });

//        RequestQueue queue = Volley.newRequestQueue(this);
//        queue.add(request);
    }
}