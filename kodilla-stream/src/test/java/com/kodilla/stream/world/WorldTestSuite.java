package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity(){
        //Given
        Set<Country> europeCountries = new HashSet<>();
        Set<Country> southAmericaCountries = new HashSet<>();
        Set<Country> asiaCountries = new HashSet<>();
        Country france = new Country(new BigDecimal("2456488"));
        Country germany = new Country(new BigDecimal("45564887"));
        Country spain = new Country(new BigDecimal("114587"));
        Country china = new Country(new BigDecimal("789787454"));
        Country india = new Country(new BigDecimal("465746548"));
        Country japan = new Country(new BigDecimal("45465687"));
        Country chile = new Country(new BigDecimal("1124531"));
        Country brazil = new Country(new BigDecimal("4487834"));
        Country ekwador = new Country(new BigDecimal("4654587"));
        //When
        europeCountries.add(france);
        europeCountries.add(germany);
        europeCountries.add(spain);
        asiaCountries.add(china);
        asiaCountries.add(japan);
        asiaCountries.add(india);
        southAmericaCountries.add(chile);
        southAmericaCountries.add(brazil);
        southAmericaCountries.add(ekwador);
        Continent europe = new Continent(europeCountries);
        Continent asia = new Continent(asiaCountries);
        Continent southAmerica = new Continent(southAmericaCountries);
        Set<Continent> worldContinents = new HashSet<>();
        worldContinents.add(europe);
        worldContinents.add(asia);
        worldContinents.add(southAmerica);
        World world = new World(worldContinents);

        //When
        BigDecimal quantityOfPeople = world.getPeopleQuantity();
        BigDecimal expected = new BigDecimal("1359402603");
        //then
        assertEquals(expected, quantityOfPeople);


    }

}
