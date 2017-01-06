package com.example.c4q.changingfragmentbackground;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.c4q.changingfragmentbackground.model.Animal;
import com.example.c4q.changingfragmentbackground.model.AnimalResponse;
import com.example.c4q.changingfragmentbackground.network.AnimalApi;
import com.example.c4q.changingfragmentbackground.network.AnimalClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by C4Q on 1/4/17.
 */

public class AnimalFragment extends Fragment {

    private static final String TAG = AnimalFragment.class.getSimpleName();

    RecyclerView recyclerView;
    AnimalAdapter animalAdapter ;
    FrameLayout  rootLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_layout, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view_rv);
        rootLayout = (FrameLayout)root.findViewById(R.id.rcyc_container_fl);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL , false);
//        recyclerView.setLayoutManager(linearLayoutManager);
        animalAdapter = new AnimalAdapter(this);
        recyclerView.setAdapter(animalAdapter);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AnimalApi api = AnimalClient.createService(AnimalApi.class); // get instance of the api
        Call<AnimalResponse> call = api.getAnimalResponse();
        call.enqueue(new Callback<AnimalResponse>() {
            @Override
            public void onResponse(Call<AnimalResponse> call, Response<AnimalResponse> response) {

                AnimalResponse myResponse = response.body(); // how we get the data
                List<Animal> animalList = myResponse.getAnimals();
                animalAdapter.setData(animalList);

            }

            @Override
            public void onFailure(Call<AnimalResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void changeBackgroundColor(String color){
        int bgColor = Color.parseColor(color);
        rootLayout.setBackgroundColor(bgColor);


    }
}
