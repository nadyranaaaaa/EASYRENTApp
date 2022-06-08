package com.application.easyrentapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListIklanActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager mLinearLayoutManager;
    Button addbtn, backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_iklan);

    }
}