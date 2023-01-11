package com.tinchop.pokemonbattle.pokemon;

import java.util.Random;

import static com.tinchop.pokemonbattle.pokemon.Pokemon.MAX_LEVEL;

public class RandomPokemonFactory implements PokemonFactory {

    private final Random random;

    public RandomPokemonFactory(Random random) {
        this.random = random;
    }

    @Override
    public Pokemon createPokemon() {
        int randomInt = random.nextInt(3);
        int level = (int) (Math.random() * MAX_LEVEL);
        switch (randomInt) {
            case 0:
                return new Bulbasaur(level);
            case 1:
                return new Charmander(level);
            default:
                return new Squirtle(level);
        }
    }

}
