package com.tinchop.pokemonbattle.pokemon;

public class Charmander extends Pokemon {

    public Charmander(Integer level) {
        super(level);
    }

    @Override
    public final String getName() {
        return "CHARMANDER";
    }

    @Override
    public final PokemonType getType() {
        return PokemonType.FIRE;
    }

}
