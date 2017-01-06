package com.example.c4q.changingfragmentbackground.model;

/**
 * Created by C4Q on 1/4/17.
 */

public class Animal {
    private String name;
    private String textColor;
    private String background;

    public Animal() {
    }

    public Animal(String name, String textColor, String background) {
        this.name = name;
        this.textColor = textColor;
        this.background = background;
    }

    //getters

    public String getName() {
        return name;
    }

    public String getTextColor() {
        return textColor;
    }

    public String getBackground() {
        return background;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
