package com.assertj.vs.hamcrest;

import com.google.common.base.MoreObjects;

public class TolkienCharacter {

	private String name;

	private Race race;

	public TolkienCharacter(String name, Race race) {
		this.name = name;
		this.race = race;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Race getRace() {
		return this.race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("name", this.getName()).add("race", this.getRace()).toString();
	}

}
