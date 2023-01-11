package com.tinchop.pokemonbattle.pokemon;

public class Bulbasaur extends Pokemon {

    public Bulbasaur(Integer level) {
        super(level);
    }

    @Override
    public final String getName() {
        return "BULBASAUR";
    }

    @Override
    public final PokemonType getType() {
        return PokemonType.LEAF;
    }

}
