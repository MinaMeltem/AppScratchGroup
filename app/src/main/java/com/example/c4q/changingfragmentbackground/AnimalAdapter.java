package com.example.c4q.changingfragmentbackground;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.changingfragmentbackground.model.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by C4Q on 1/4/17.
 */
public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {



    private List<Animal> animalList;
    private AnimalFragment fragment;


    public AnimalAdapter(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public AnimalAdapter (AnimalFragment fragment){
        animalList = new ArrayList<>();
        this.fragment = fragment;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.animal_item_layout , parent , false);
        AnimalViewHolder animalItem = new AnimalViewHolder(itemView);
        return animalItem;
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {

        final Animal singleAnimal = animalList.get(position);
        holder.setAnimalName(singleAnimal.getName());
        holder.SetTextColor(singleAnimal.getTextColor());
        holder.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.changeBackgroundColor(singleAnimal.getBackground());
            }
        });


    }

    public void setData(List <Animal>  animalList){
        this.animalList = animalList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }


}

