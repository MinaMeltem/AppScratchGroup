package com.example.c4q.changingfragmentbackground;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by C4Q on 1/4/17.
 */
public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public AnimalViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.animal_names_tv);
    }

    public void setAnimalName(String name){
        textView.setText(name);
    }

    public void setOnclickListener(View.OnClickListener listener){

        textView.setOnClickListener(listener);

    }

    public void SetTextColor(String color){
        int animalColor = Color.parseColor(color);
        textView.setTextColor(animalColor);


    }
}

