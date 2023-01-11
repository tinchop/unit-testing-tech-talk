package com.tinchop.pokemonbattle;

import com.tinchop.pokemonbattle.battle.RandomBattleFactory;
import com.tinchop.pokemonbattle.pokedex.Pokedex;
import com.tinchop.pokemonbattle.pokemon.RandomPokemonFactory;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Random;

import static com.tinchop.pokemonbattle.TestUtils.mockedHttpResponse;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainTest {

//    @Test
//    public void main_runs_gracefully_deprecated() {
//
//        try {
//
//            //Arrange
//            var httpClient = mock(HttpClient.class);
//            when(httpClient.send(any(), eq(HttpResponse.BodyHandlers.ofString()))).thenReturn(mockedHttpResponse());
//            Main.battle = new RandomBattleFactory().createBattle();
//
//            //Act //Assert
//            assertDoesNotThrow(() -> Main.main(new String[]{}));
//
//        } catch (Exception e) {
//            fail(e);
//        }
//
//    }

    @Test
    public void main_runs_gracefully() {

        try {

            //Arrange
            var httpClient = mock(HttpClient.class);
            when(httpClient.send(any(), eq(HttpResponse.BodyHandlers.ofString()))).thenReturn(mockedHttpResponse());
            Main.battle = new RandomBattleFactory(new RandomPokemonFactory(new Random()), new Pokedex(httpClient))
                    .createBattle();

            //Act //Assert
            assertDoesNotThrow(() -> Main.main(new String[]{}));

        } catch (Exception e) {
            fail(e);
        }

    }

}
