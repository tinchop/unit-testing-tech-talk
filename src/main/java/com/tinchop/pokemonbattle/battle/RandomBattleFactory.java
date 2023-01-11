package com.tinchop.pokemonbattle.battle;

import com.tinchop.pokemonbattle.pokedex.Pokedex;
import com.tinchop.pokemonbattle.pokemon.PokemonFactory;
import com.tinchop.pokemonbattle.pokemon.RandomPokemonFactory;

import java.net.http.HttpClient;
import java.util.Random;

public class RandomBattleFactory implements BattleFactory {

    private final PokemonFactory pokemonFactory;
    private final Pokedex pokedex;

//    @Deprecated
//    public RandomBattleFactory() {
//        this.pokemonFactory = new RandomPokemonFactory(new Random());
//        this.pokedex = new Pokedex(HttpClient.newHttpClient());
//    }

    public RandomBattleFactory(RandomPokemonFactory pokemonFactory, Pokedex pokedex) {
        this.pokemonFactory = pokemonFactory;
        this.pokedex = pokedex;
    }

    @Override
    public Battle createBattle() {
        return new Battle(pokemonFactory.createPokemon(), pokemonFactory.createPokemon(), pokedex);
    }
}
