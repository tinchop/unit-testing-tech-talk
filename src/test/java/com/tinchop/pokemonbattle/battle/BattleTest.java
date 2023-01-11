package com.tinchop.pokemonbattle.battle;

import com.tinchop.pokemonbattle.pokedex.Pokedex;
import com.tinchop.pokemonbattle.pokedex.PokedexException;
import com.tinchop.pokemonbattle.pokedex.PokedexResult;
import com.tinchop.pokemonbattle.pokedex.PokedexResultMove;
import com.tinchop.pokemonbattle.pokedex.PokedexResultMoveWrapper;
import com.tinchop.pokemonbattle.pokemon.RandomPokemonFactory;
import com.tinchop.pokemonbattle.pokemon.Squirtle;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BattleTest {

    @Test
    public void battle_result_is_printed_successfully() {

        try {

            //Arrange
            Pokedex pokedex = mock(Pokedex.class);
            var moveName = "solar beam";
            var move = new PokedexResultMove();
            move.setName(moveName);
            var moveWrapper = new PokedexResultMoveWrapper();
            moveWrapper.setMove(move);
            var pokedexResult = new PokedexResult();
            pokedexResult.setId(1);
            pokedexResult.setName("bulbasaur");
            pokedexResult.setWeight(60);
            pokedexResult.setHeight(5);
            pokedexResult.setMoves(List.of(moveWrapper));
            when(pokedex.lookUp(any())).thenReturn(pokedexResult);
            var pokemonFactory = new RandomPokemonFactory(new Random());
            BattleFactory battleFactory = new RandomBattleFactory(pokemonFactory, pokedex);
            Battle battle = battleFactory.createBattle();
            battle.start();

            var pokedexResultString = "Id: 1\n" +
                    "Name: BULBASAUR\n" +
                    "Weight: 6 kg" + "\n" +
                    "Height: 50 cm" + "\n" +
                    "Moves: [solar beam]";

            //Act
            String result = battle.getResult();

            //Assert
            assertNotNull(result);
            assertTrue(result.contains(pokedexResultString));

        } catch (Exception e) {
            fail(e);
        }

    }

    @Test
    public void fighter_a_beats_fighter_b() {

        try {

            //Arrange
            var fighterA = new Squirtle(100);
            var fighterB = new Squirtle(1);
            Battle battle = new Battle(fighterA, fighterB, null);

            //Act //Assert
            assertDoesNotThrow(battle::start);

        } catch (Exception e) {
            fail(e);
        }

    }

    @Test
    public void fighter_a_victory_prints_correctly() {

        try {

            //Arrange
            var fighterA = new Squirtle(100);
            var fighterB = new Squirtle(1);

            Pokedex pokedex = mock(Pokedex.class);
            var pokedexResult = new PokedexResult();
            pokedexResult.setId(7);
            pokedexResult.setName("squirtle");
            pokedexResult.setWeight(60);
            pokedexResult.setHeight(5);
            pokedexResult.setMoves(List.of());
            when(pokedex.lookUp(any())).thenReturn(pokedexResult);

            Battle battle = new Battle(fighterA, fighterB, pokedex);
            battle.start();

            //Act
            String result = battle.getResult();

            // Assert
            assertNotNull(result);
            assertTrue(result.contains("SQUIRTLE Lvl 100 wins!!!"));

        } catch (Exception e) {
            fail(e);
        }

    }

    @Test
    public void fighter_b_beats_fighter_a() {

        try {

            //Arrange
            var fighterA = new Squirtle(1);
            var fighterB = new Squirtle(100);
            Battle battle = new Battle(fighterA, fighterB, null);

            //Act //Assert
            assertDoesNotThrow(battle::start);

        } catch (Exception e) {
            fail(e);
        }

    }

    @Test
    public void fighter_b_victory_prints_correctly() {

        try {

            //Arrange
            var fighterA = new Squirtle(1);
            var fighterB = new Squirtle(100);

            Pokedex pokedex = mock(Pokedex.class);
            var pokedexResult = new PokedexResult();
            pokedexResult.setId(7);
            pokedexResult.setName("squirtle");
            pokedexResult.setWeight(60);
            pokedexResult.setHeight(5);
            pokedexResult.setMoves(List.of());
            when(pokedex.lookUp(any())).thenReturn(pokedexResult);

            Battle battle = new Battle(fighterA, fighterB, pokedex);
            battle.start();

            //Act
            String result = battle.getResult();

            // Assert
            assertNotNull(result);
            assertTrue(result.contains("SQUIRTLE Lvl 100 wins!!!"));

        } catch (Exception e) {
            fail(e);
        }

    }

    @Test
    public void pokedex_fails_to_retrieve_winner_info() {

        try {

            //Arrange
            var fighterA = new Squirtle(100);
            var fighterB = new Squirtle(100);

            Pokedex pokedex = mock(Pokedex.class);
            when(pokedex.lookUp(any())).thenThrow(new PokedexException(new RuntimeException()));

            Battle battle = new Battle(fighterA, fighterB, pokedex);
            battle.start();

            //Act
            String result = battle.getResult();

            // Assert
            assertNull(result);

        } catch (Exception e) {
            fail(e);
        }

    }

}
