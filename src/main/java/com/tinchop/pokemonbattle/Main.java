package com.tinchop.pokemonbattle;

import com.tinchop.pokemonbattle.battle.Battle;
import com.tinchop.pokemonbattle.battle.RandomBattleFactory;
import com.tinchop.pokemonbattle.pokedex.Pokedex;
import com.tinchop.pokemonbattle.pokemon.RandomPokemonFactory;

import java.net.http.HttpClient;
import java.util.Random;

public class Main {

    static Battle battle = new RandomBattleFactory(
            new RandomPokemonFactory(new Random()),
            new Pokedex(HttpClient.newHttpClient())
    ).createBattle();

    public static void main(String[] args) {

        battle.start();
        System.out.println(battle.getResult());

    }

}
