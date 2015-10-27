package com.assertj.vs.hamcrest;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class DateAndTimeAssertions {

    @Test
    public void shoudTestLocalDateAssertJ() {
        final LocalDate firstOfJanuary2000 = LocalDate
                .parse("2000-01-01");

        // AssertJ converts String parameters to LocalDate
        // to ease writing expected LocalDate
        Assertions.assertThat(firstOfJanuary2000)
                .isEqualTo("2000-01-01");

        Assertions.assertThat(firstOfJanuary2000)
                .isAfter("1999-12-31")
                .isAfterOrEqualTo("1999-12-31")
                .isAfterOrEqualTo("2000-01-01");
    }

    @Test
    public void shouldTestLocalDateHamcrest() {
        final LocalDate firstOfJanuary2000 = LocalDate
                .parse("2000-01-01");

        MatcherAssert.assertThat(firstOfJanuary2000,
                Matchers.equalTo(LocalDate
                        .parse("2000-01-01")));
        MatcherAssert.assertThat(firstOfJanuary2000,
                LocalDateMatchers.after(LocalDate
                        .parse("1999-12-31")));
        // No afterOrEqual matcher
    }

}
