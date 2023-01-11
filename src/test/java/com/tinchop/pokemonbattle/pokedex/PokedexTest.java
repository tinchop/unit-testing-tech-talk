package com.tinchop.pokemonbattle.pokedex;

import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;

import static com.tinchop.pokemonbattle.TestUtils.mockedHttpResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokedexTest {

    @Test
    public void pokedex_lookup_fails() {

        try {

            //Arrange
            var pokemonName = "bulbasaur";
            HttpClient httpClient = mock(HttpClient.class);
            when(httpClient.send(any(), any())).thenThrow(new InterruptedException());
            var pokedex = new Pokedex(httpClient);

            //Act //Assert
            assertThrows(PokedexException.class, () -> pokedex.lookUp(pokemonName));

        } catch (Exception e) {
            fail(e);
        }

    }

    @Test
    public void pokedex_lookup_succeeds() {

        try {

            //Arrange
            var pokemonName = "bulbasaur";

            HttpClient httpClient = mock(HttpClient.class);
            when(httpClient.send(any(), eq(HttpResponse.BodyHandlers.ofString()))).thenReturn(mockedHttpResponse());
            var pokedex = new Pokedex(httpClient);

            //Act
            PokedexResult pokedexResult = pokedex.lookUp(pokemonName);

            //Assert
            assertNotNull(pokedexResult);
            assertEquals(pokemonName, pokedexResult.getName());

        } catch (Exception e) {
            fail(e);
        }

    }

    @Test
    public void pokedex_result_is_printed_correctly() {
        //Arrange
        var moveName = "solar beam";
        var move = new PokedexResultMove();
        move.setName(moveName);
        var moveWrapper = new PokedexResultMoveWrapper();
        moveWrapper.setMove(move);

        var pokedexResult = new PokedexResult();
        pokedexResult.setId(1);
        pokedexResult.setName("bulbasaur");
        pokedexResult.setMoves(List.of(moveWrapper));
        pokedexResult.setWeight(60);
        pokedexResult.setHeight(5);

        var expectedResult = "Id: 1\n" +
                "Name: BULBASAUR\n" +
                "Weight: 6 kg" + "\n" +
                "Height: 50 cm" + "\n" +
                "Moves: [solar beam]";

        //Act
        String result = pokedexResult.toString();

        //Assert
        assertEquals(expectedResult, result);
    }

}
