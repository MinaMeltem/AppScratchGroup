package com.example.c4q.changingfragmentbackground.model;

import java.util.List;

/**
 * Created by C4Q on 1/4/17.
 */

public class AnimalResponse {
    private boolean success;
    private List<Animal> animals;

    public AnimalResponse(boolean success, List<Animal> animals) {
        this.success = success;
        this.animals = animals;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
