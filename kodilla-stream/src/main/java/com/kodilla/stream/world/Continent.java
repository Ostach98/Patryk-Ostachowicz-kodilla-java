package com.kodilla.stream.world;

import java.util.Set;

public final class Continent {
    private final Set<Country> setOfCountries;

    public Continent(Set<Country> setOfCountries) {
        this.setOfCountries = setOfCountries;
    }

    public Set<Country> getListOfCountries() {
        return setOfCountries;
    }
}