package com.tinchop.pokemonbattle.pokedex;

import lombok.Setter;

@Setter
public class PokedexResultMove {

    private String name;

    @Override
    public String toString() {
        return name;
    }

}
