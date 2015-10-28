package com.assertj.vs.hamcrest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import com.assertj.vs.hamcrest.got.WesterosHouse;
import com.assertj.vs.hamcrest.lotr.Race;
import com.assertj.vs.hamcrest.lotr.TolkienCharacter;

public class IterablesAssertions {

    private final TolkienCharacter sam = new TolkienCharacter("Sam", Race.HOBBIT);
    private final TolkienCharacter frodo = new TolkienCharacter("Frodo", Race.HOBBIT);
    private final TolkienCharacter pippin = new TolkienCharacter("Pippin", Race.HOBBIT);
    private final TolkienCharacter merry = new TolkienCharacter("Merry", Race.HOBBIT);
    private final TolkienCharacter aragorn = new TolkienCharacter("Aragorn", Race.MAN);
    private final TolkienCharacter boromir = new TolkienCharacter("Boromir", Race.MAN);

    private final List<TolkienCharacter> fellowshipOfTheRing = Arrays.asList(this.sam, this.frodo, this.pippin,
            this.merry, this.aragorn, this.boromir);

    @Test
    public void shouldFilterAndAssertIterablesAssertJ() {
        // filter uses introspection to get property/field value
        Assertions.assertThat(this.fellowshipOfTheRing).filteredOn("race", Race.HOBBIT)
                .containsOnly(this.sam, this.frodo, this.pippin, this.merry);

        // nested properties are supported
        Assertions.assertThat(this.fellowshipOfTheRing).filteredOn("race.name", "Man")
                .containsOnly(this.aragorn, this.boromir);

        // you can chain multiple filter criteria
        Assertions.assertThat(this.fellowshipOfTheRing).filteredOn("race", Race.MAN)
                .filteredOn("name", Assertions.not("Boromir")).containsOnly(this.aragorn);
    }

    @Test
    public void shouldFilterAndAssertIterablesHamcrest() {
        List<TolkienCharacter> fellowshipHobbits = this.fellowshipOfTheRing.stream()
                .filter(character -> character.getRace().equals(Race.HOBBIT)).collect(Collectors.toList());

        MatcherAssert.assertThat(fellowshipHobbits, Matchers.contains(this.sam, this.frodo, this.pippin, this.merry));
    }

    @Test
    public void shouldAssertResultsOfMethodCallsOnIterable() {
        // WesterosHouse class has a method: public String sayTheWords()
        List<WesterosHouse> greatHouses = new ArrayList<>();
        greatHouses.add(new WesterosHouse("Stark", "Winter is Comming"));
        greatHouses.add(new WesterosHouse("Lannister", "Hear Me Roar"));
        greatHouses.add(new WesterosHouse("Greyjoy", "We Do Not Sow"));
        greatHouses.add(new WesterosHouse("Baratheon", "Our is the Fury"));
        greatHouses.add(new WesterosHouse("Martell", "Unbowed, Unbent, Unbroken"));
        greatHouses.add(new WesterosHouse("Tyrell", "Growing Strong"));

        // let's verify the words of great houses in Westeros:
        Assertions.assertThat(greatHouses).extractingResultOf("sayTheWords")
                .contains("Winter is Comming", "We Do Not Sow", "Hear Me Roar")
                .doesNotContain("Lannisters always pay their debts");
    }

}
