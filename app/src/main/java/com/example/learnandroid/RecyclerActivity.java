package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView dataList = (RecyclerView) findViewById(R.id.dataList);
        dataList.setLayoutManager(new LinearLayoutManager(this));
        String[] languages = {"c", "java", "python", "c++", "javascript"};
        dataList.setAdapter(new DataAdapter(languages));
    }
}