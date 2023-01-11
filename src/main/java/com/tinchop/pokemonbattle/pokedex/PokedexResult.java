package com.tinchop.pokemonbattle.pokedex;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
public class PokedexResult {

    private int id;
    @Getter
    private String name;
    private int weight;
    private int height;
    private List<PokedexResultMoveWrapper> moves;

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Name: " + name.toUpperCase() + "\n" +
                "Weight: " + (weight / 10) + " kg" + "\n" +
                "Height: " + (height * 10) + " cm" + "\n" +
                "Moves: " + moves;
    }

}
