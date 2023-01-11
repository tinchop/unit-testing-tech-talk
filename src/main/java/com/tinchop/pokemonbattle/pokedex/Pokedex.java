package com.tinchop.pokemonbattle.pokedex;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Pokedex {

    private final HttpClient httpClient;

    public Pokedex(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public PokedexResult lookUp(String pokemonName) throws PokedexException {
        var request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + pokemonName))
                .build();

        try {
            String json = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
            var gson = new Gson();

            return gson.fromJson(json, PokedexResult.class);
        } catch (InterruptedException | IOException e) {
            throw new PokedexException(e);
        }
    }

}
