package com.airline.model;

public class Passenger {

    private String name;
    private double luggageWeightKg;

    public Passenger(String name, double luggageWeightKg){
        this.name = name;
        setLuggageWeightKg(luggageWeightKg);
    }

    public String getName(){return this.name;}
    public double getLuggageWeightKg(){return this.luggageWeightKg;}

    public void setLuggageWeightKg(double weight){
        if (weight < 0.0){
            this.luggageWeightKg = 0.0;
        } else{
            this.luggageWeightKg = weight;}
    }
}
