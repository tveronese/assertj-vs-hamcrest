package com.assertj.vs.hamcrest.got;

public class WesterosHouse {

    private String name;
    private String saying;

    public WesterosHouse(String name, String saying) {
        this.name = name;
        this.saying = saying;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String sayTheWords() {
        return this.saying;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

}
