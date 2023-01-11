package com.tinchop.pokemonbattle.pokemon;

public enum PokemonType {
    LEAF, FIRE, WATER;

    public boolean isStrongAgainst(PokemonType anotherType) {
        return (this.equals(LEAF) && WATER.equals(anotherType))
                || (this.equals(FIRE) && LEAF.equals(anotherType))
                || (this.equals(WATER) && FIRE.equals(anotherType));
    }

    public boolean isWeakAgainst(PokemonType anotherType) {
        return (this.equals(LEAF) && FIRE.equals(anotherType))
                || (this.equals(FIRE) && WATER.equals(anotherType))
                || (this.equals(WATER) && LEAF.equals(anotherType));
    }

}
