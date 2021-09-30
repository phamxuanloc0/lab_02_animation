package com.example.lab_02_animation.music;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_02_animation.R;

import java.util.LinkedList;

public class MusicRecycleAdapter extends RecyclerView.Adapter<MusicRecycleAdapter.MusicRecycleHolder> {

    private LinkedList<Person> persons;
    private LayoutInflater inflater;
    private Context context;
    private Activity activity;

    public MusicRecycleAdapter(LinkedList<Person> persons, Context context, Activity activity) {
        this.persons = persons;
        this.context = context;
        this.activity = activity;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MusicRecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_music,parent,false);
        return new MusicRecycleHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicRecycleHolder holder, int position) {
        Person person = persons.get(position);
        holder.tvNamePerson.setText(person.getNamePerson());
        holder.tvNameSong.setText(person.getNameSong());
        holder.img.setImageResource(person.getImage());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class MusicRecycleHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private MusicRecycleAdapter adapter;
        ImageView img;
        TextView tvNamePerson, tvNameSong;

        public MusicRecycleHolder(@NonNull View itemView, MusicRecycleAdapter adapter) {
            super(itemView);

            tvNamePerson = itemView.findViewById(R.id.tvNamePerson);
            tvNameSong = itemView.findViewById(R.id.tvNameSong);
            img = itemView.findViewById(R.id.img_person);

            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, music_layout1.class);

            context.startActivity(intent);
            activity.overridePendingTransition(R.anim.enter_x, R.anim.exit_x);
        }
    }
}