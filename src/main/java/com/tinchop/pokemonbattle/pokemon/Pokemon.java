package com.tinchop.pokemonbattle.pokemon;

import lombok.Getter;

@Getter
public abstract class Pokemon {

    public static final int HP_ATTACK_COEFFICIENT = 100;
    public static final float STRENGTH_MULTIPLIER = 1.1F;
    public static final float WEAKNESS_MULTIPLIER = 0.9F;
    public static final int MAX_LEVEL = 100;
    public static final int HP_MULTIPLIER = 5;
    public static final int BASE_HP = 100;

    private final Integer level;
    private Integer hp;

    public Pokemon(Integer level) {
        this.level = level;
        this.hp = BASE_HP + level * HP_MULTIPLIER;
    }

    public abstract String getName();

    public abstract PokemonType getType();

    public boolean isStrongAgainst(Pokemon anotherPokemon) {
        return getType().isStrongAgainst(anotherPokemon.getType());
    }

    public boolean isWeakAgainst(Pokemon anotherPokemon) {
        return getType().isWeakAgainst(anotherPokemon.getType());
    }

    public void attack(Pokemon anotherPokemon) {
        float multiplier = 1f;
        if (isStrongAgainst(anotherPokemon)) {
            multiplier = STRENGTH_MULTIPLIER;
        } else if (isWeakAgainst(anotherPokemon)) {
            multiplier = WEAKNESS_MULTIPLIER;
        }
        anotherPokemon.hp = (int) (anotherPokemon.hp - multiplier * HP_ATTACK_COEFFICIENT);
        System.out.println(this + " attacked " + anotherPokemon + "!");
    }

    public boolean fainted() {
        return hp < 1;
    }

    @Override
    public String toString() {
        return getName() + " Lvl " + level;
    }
}
