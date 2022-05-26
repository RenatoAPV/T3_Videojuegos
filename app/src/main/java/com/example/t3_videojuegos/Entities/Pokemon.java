package com.example.t3_videojuegos.Entities;

public class Pokemon {
    public int id;
    public String number;
    public String name;
    public String type;
    public String region;
    public String link;

    public Pokemon() {
    }

    public Pokemon(int id, String number, String name, String type, String region, String link) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.type = type;
        this.region = region;
        this.link = link;
    }
}
