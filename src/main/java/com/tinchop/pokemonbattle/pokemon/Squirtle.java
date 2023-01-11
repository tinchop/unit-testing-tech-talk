package com.tinchop.pokemonbattle.pokemon;

public class Squirtle extends Pokemon {

    public Squirtle(Integer level) {
        super(level);
    }

    @Override
    public final String getName() {
        return "SQUIRTLE";
    }

    @Override
    public final PokemonType getType() {
        return PokemonType.WATER;
    }

}
