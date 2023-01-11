package com.tinchop.pokemonbattle.pokedex;

import lombok.Setter;

@Setter
public class PokedexResultMoveWrapper {

    private PokedexResultMove move;

    @Override
    public String toString() {
        return move.toString();
    }

}
