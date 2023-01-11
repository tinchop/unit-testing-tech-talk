package com.tinchop.pokemonbattle.battle;

import com.tinchop.pokemonbattle.pokedex.Pokedex;
import com.tinchop.pokemonbattle.pokedex.PokedexException;
import com.tinchop.pokemonbattle.pokedex.PokedexResult;
import com.tinchop.pokemonbattle.pokemon.Pokemon;

public class Battle {

    private final Pokemon fighterA;
    private final Pokemon fighterB;
    private final Pokedex pokedex;

    public Battle(Pokemon fighterA, Pokemon fighterB, Pokedex pokedex) {
        this.fighterA = fighterA;
        this.fighterB = fighterB;
        this.pokedex = pokedex;
    }

    public void start() {
        Pokemon attacker = fighterA;
        Pokemon defender = fighterB;

        while (!(fighterA.fainted() || fighterB.fainted())) {
            attacker.attack(defender);

            Pokemon newAttacker = defender;
            defender = attacker;
            attacker = newAttacker;
        }

        if (fighterA.fainted()) {
            System.out.println(fighterA + " fainted!");
        } else if (fighterB.fainted()) {
            System.out.println(fighterB + " fainted!");
        }
    }

    public String getResult() {
        String result = null;
        Pokemon winner = null;
        if (fighterA.fainted()) {
            winner = fighterB;
        } else if (fighterB.fainted()) {
            winner = fighterA;
        }

        if (winner != null) {
            try {
                PokedexResult pokedexResult = pokedex.lookUp(winner.getName().toLowerCase());
                result = winner + " wins!!!\n\n" + pokedexResult.toString();
            } catch (PokedexException e) {
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

}
