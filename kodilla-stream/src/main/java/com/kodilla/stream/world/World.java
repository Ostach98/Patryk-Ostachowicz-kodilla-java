package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Set;

public class World {
    private final Set<Continent> setOfContinents;

    public World(Set<Continent> setOfContinents) {
        this.setOfContinents = setOfContinents;
    }

    public BigDecimal getPeopleQuantity(){
        return setOfContinents.stream()
                .flatMap(continent -> continent.getListOfCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
