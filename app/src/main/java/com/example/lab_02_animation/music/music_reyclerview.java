package com.example.lab_02_animation.music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lab_02_animation.R;

import java.util.LinkedList;

public class music_reyclerview extends AppCompatActivity {
    RecyclerView recyclerView;
    MusicRecycleAdapter adapter;
    LinkedList<Person> persons = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_reyclerview);



        recyclerView = findViewById(R.id.list_music_recycle);
        persons.add(new Person("Taylor Swift", "Love Story", R.drawable.taylorswift));
        persons.add(new Person("Taylor Swift", "Love Story", R.drawable.taylorswift));
        persons.add(new Person("Taylor Swift", "Love Story", R.drawable.taylorswift));
        persons.add(new Person("Taylor Swift", "Love Story", R.drawable.taylorswift));

        adapter = new MusicRecycleAdapter(persons, this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


    }
}