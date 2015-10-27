package com.assertj.vs.hamcrest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class IterablesAssertions {

	@Test
	public void shouldFilterAndAssertIterablesAssertJ() {
		TolkienCharacter sam = new TolkienCharacter("Sam", Race.HOBBIT);
		TolkienCharacter frodo = new TolkienCharacter("Frodo", Race.HOBBIT);
		TolkienCharacter pippin = new TolkienCharacter("Pippin", Race.HOBBIT);
		TolkienCharacter merry = new TolkienCharacter("Merry", Race.HOBBIT);
		TolkienCharacter aragorn = new TolkienCharacter("Aragorn", Race.MAN);
		TolkienCharacter boromir = new TolkienCharacter("Boromir", Race.MAN);

		List<TolkienCharacter> fellowshipOfTheRing = Arrays.asList(sam, frodo, pippin, merry, aragorn, boromir);

		// filter use introspection to get property/field
		// value
		Assertions.assertThat(fellowshipOfTheRing).filteredOn("race", Race.HOBBIT).containsOnly(sam, frodo, pippin,
				merry);

		// nested property are supported
		Assertions.assertThat(fellowshipOfTheRing).filteredOn("race.name", "Man").containsOnly(aragorn, boromir);

		// you can chain multiple filter criteria
		Assertions.assertThat(fellowshipOfTheRing).filteredOn("race", Race.MAN)
				.filteredOn("name", Assertions.not("Boromir")).containsOnly(aragorn);
	}

	@Test
	public void shouldFilterAndAssertIterablesHamcrest() {
		TolkienCharacter sam = new TolkienCharacter("Sam", Race.HOBBIT);
		TolkienCharacter frodo = new TolkienCharacter("Frodo", Race.HOBBIT);
		TolkienCharacter pippin = new TolkienCharacter("Pippin", Race.HOBBIT);
		TolkienCharacter merry = new TolkienCharacter("Merry", Race.HOBBIT);
		TolkienCharacter aragorn = new TolkienCharacter("Aragorn", Race.MAN);
		TolkienCharacter boromir = new TolkienCharacter("Boromir", Race.MAN);

		List<TolkienCharacter> fellowshipOfTheRing = Arrays.asList(sam, frodo, pippin, merry, aragorn, boromir);

		List<TolkienCharacter> fellowshipHobbits = fellowshipOfTheRing.stream()
				.filter(character -> character.getRace().equals(Race.HOBBIT)).collect(Collectors.toList());

		MatcherAssert.assertThat(fellowshipHobbits, Matchers.contains(sam, frodo, pippin, merry));
	}
}
