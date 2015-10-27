package com.assertj.vs.hamcrest;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class OptionalAssertions {

    @Test
    public void shouldTestOptionalAssertJ() {
        // optional with value
        Optional<String> optional = Optional.of("Test");
        Assertions.assertThat(optional).isPresent()
                .contains("Test");
        // empty optional
        Optional<Object> emptyOptional = Optional.empty();
        Assertions.assertThat(emptyOptional).isEmpty();
    }

    @Test
    public void shouldTestOptionalHamcrest() {
        // optional with value
        Optional<String> optional = Optional.of("Test");
        MatcherAssert.assertThat(optional.isPresent(),
                Matchers.is(true));
        MatcherAssert.assertThat(optional.get(),
                Matchers.equalTo("Test"));

        // empty optional
        Optional<Object> emptyOptional = Optional.empty();
        MatcherAssert
                .assertThat(emptyOptional, Matchers
                        .equalTo(Optional.<Object> empty()));
    }

}
