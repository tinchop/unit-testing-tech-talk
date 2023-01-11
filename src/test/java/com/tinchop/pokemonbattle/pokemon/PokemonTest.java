package com.tinchop.pokemonbattle.pokemon;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonTest {

    @Test
    public void leaf_is_not_strong_against_fire() {
        //Arrange
        var bulbasaur = new Bulbasaur(10);
        var charmander = new Charmander(10);

        //Act
        boolean isStrongAgainst = bulbasaur.isStrongAgainst(charmander);

        //Assert
        assertFalse(isStrongAgainst);
    }

    @Test
    public void leaf_is_not_strong_against_leaf() {
        //Arrange
        var bulbasaur = new Bulbasaur(10);
        var bulbasaur2 = new Bulbasaur(10);

        //Act
        boolean isStrongAgainst = bulbasaur.isStrongAgainst(bulbasaur2);

        //Assert
        assertFalse(isStrongAgainst);
    }

    @Test
    public void leaf_is_not_weak_against_leaf() {
        //Arrange
        var bulbasaur = new Bulbasaur(10);
        var bulbasaur2 = new Bulbasaur(10);

        //Act
        boolean isWeakAgainst = bulbasaur.isWeakAgainst(bulbasaur2);

        //Assert
        assertFalse(isWeakAgainst);
    }

    @Test
    public void fire_is_strong_against_leaf() {
        //Arrange
        var bulbasaur = new Bulbasaur(10);
        var charmander = new Charmander(10);

        //Act
        boolean isStrongAgainst = charmander.isStrongAgainst(bulbasaur);

        //Assert
        assertTrue(isStrongAgainst);
    }

    @Test
    public void fire_is_not_strong_against_water() {
        //Arrange
        var charmander = new Charmander(10);
        var squirtle = new Squirtle(10);

        //Act
        boolean isStrongAgainst = charmander.isStrongAgainst(squirtle);

        //Assert
        assertFalse(isStrongAgainst);
    }

    @Test
    public void fire_is_not_strong_against_fire() {
        //Arrange
        var charmander = new Charmander(10);
        var charmander2 = new Charmander(10);

        //Act
        boolean isStrongAgainst = charmander.isStrongAgainst(charmander2);

        //Assert
        assertFalse(isStrongAgainst);
    }

    @Test
    public void water_is_strong_against_fire() {
        //Arrange
        var squirtle = new Squirtle(10);
        var charmander = new Charmander(10);

        //Act
        boolean isStrongAgainst = squirtle.isStrongAgainst(charmander);

        //Assert
        assertTrue(isStrongAgainst);
    }

    @Test
    public void water_is_not_strong_against_leaf() {
        //Arrange
        var squirtle = new Squirtle(10);
        var bulbasaur = new Bulbasaur(10);

        //Act
        boolean isStrongAgainst = squirtle.isStrongAgainst(bulbasaur);

        //Assert
        assertFalse(isStrongAgainst);
    }

    @Test
    public void water_is_not_strong_against_water() {
        //Arrange
        var squirtle = new Squirtle(10);
        var squirtle2 = new Squirtle(10);

        //Act
        boolean isStrongAgainst = squirtle.isStrongAgainst(squirtle2);

        //Assert
        assertFalse(isStrongAgainst);
    }

    @Test
    public void leaf_is_strong_against_water() {
        //Arrange
        var bulbasaur = new Bulbasaur(10);
        var squirtle = new Squirtle(10);

        //Act
        boolean isStrongAgainst = bulbasaur.isStrongAgainst(squirtle);

        //Assert
        assertTrue(isStrongAgainst);
    }

    @Test
    public void fire_is_not_weak_against_leaf() {
        //Arrange
        var bulbasaur = new Bulbasaur(10);
        var charmander = new Charmander(10);

        //Act
        boolean isWeakAgainst = charmander.isWeakAgainst(bulbasaur);

        //Assert
        assertFalse(isWeakAgainst);
    }

    @Test
    public void leaf_is_weak_against_fire() {
        //Arrange
        var bulbasaur = new Bulbasaur(10);
        var charmander = new Charmander(10);

        //Act
        boolean isWeakAgainst = bulbasaur.isWeakAgainst(charmander);

        //Assert
        assertTrue(isWeakAgainst);
    }

    @Test
    public void pokemon_faints() {
        //Arrange
        var squirtle = new Squirtle(100);
        var charmander = new Charmander(1);
        squirtle.attack(charmander);

        //Act
        boolean charmanderFainted = charmander.fainted();

        //Assert
        assertTrue(charmanderFainted);
    }

    @Test
    public void pokemon_does_not_faint() {
        //Arrange
        var squirtle = new Squirtle(100);
        var charmander = new Charmander(1);
        charmander.attack(squirtle);

        //Act
        boolean squirtleFainted = squirtle.fainted();

        //Assert
        assertFalse(squirtleFainted);
    }

    @Test
    public void pokemon_has_correct_level() {
        //Arrange
        int expectedLevel = 10 + (new Random().nextInt(90));

        //Act
        var bulbasaur = new Bulbasaur(expectedLevel);

        //Assert
        assertEquals(expectedLevel, bulbasaur.getLevel());
    }

    @Test
    public void pokemon_factory_creates_bulbasaur() {
        //Arrange
        int randomResult = 0;
        Random random = mock(Random.class);
        when(random.nextInt(3)).thenReturn(randomResult);
        PokemonFactory pokemonFactory = new RandomPokemonFactory(random);

        //Act
        Pokemon pokemon = pokemonFactory.createPokemon();

        //Assert
        assertNotNull(pokemon);
        assertEquals("BULBASAUR", pokemon.getName());
    }

    @Test
    public void pokemon_factory_creates_charmander() {
        //Arrange
        int randomResult = 1;
        Random random = mock(Random.class);
        when(random.nextInt(3)).thenReturn(randomResult);
        PokemonFactory pokemonFactory = new RandomPokemonFactory(random);

        //Act
        Pokemon pokemon = pokemonFactory.createPokemon();

        //Assert
        assertNotNull(pokemon);
        assertEquals("CHARMANDER", pokemon.getName());
    }

    @Test
    public void pokemon_factory_creates_squirtle() {
        //Arrange
        int randomResult = 2;
        Random random = mock(Random.class);
        when(random.nextInt(3)).thenReturn(randomResult);
        PokemonFactory pokemonFactory = new RandomPokemonFactory(random);

        //Act
        Pokemon pokemon = pokemonFactory.createPokemon();

        //Assert
        assertNotNull(pokemon);
        assertEquals("SQUIRTLE", pokemon.getName());
    }

    @Test
    public void pokemon_attacks_another_pokemon_of_same_type_and_level() {
        //Arrange
        var squirtle1 = new Squirtle(100);
        var squirtle2 = new Squirtle(100);

        //Act
        squirtle1.attack(squirtle2);

        //Assert
        assertEquals(500, squirtle2.getHp());
    }

    @Test
    public void pokemon_has_type_disadvantage_against_another_pokemon() {
        //Arrange
        var squirtle = new Squirtle(100);
        var charmander = new Charmander(100);

        //Act
        charmander.attack(squirtle);

        //Assert
        assertEquals(510, squirtle.getHp());
    }

    @Test
    public void pokemon_has_type_advantage_against_another_pokemon() {
        //Arrange
        var squirtle = new Squirtle(100);
        var charmander = new Charmander(100);

        //Act
        squirtle.attack(charmander);

        //Assert
        assertEquals(490, charmander.getHp());
    }

}
