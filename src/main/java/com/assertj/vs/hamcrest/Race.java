package com.assertj.vs.hamcrest;

public enum Race {

    HOBBIT("Hobbit"), MAN("Man");

    private String name;

    private Race(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
