package com.assertj.vs.hamcrest;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("Tests created to show the difference of errors messages between AssertJ and Hamcrest")
public class TestFailureMessagesTest {

    @Test
    public void testAssertJFailureMessagesString() {
        Assertions.assertThat("The quick brown fox jump over the lazy dog").isEqualTo(
                "The quick brown fox jumps over the lazy dog");
    }

    @Test
    public void testHamcrestFailureMessagesString() {
        MatcherAssert.assertThat("The quick brown fox jump over the lazy dog",
                Matchers.equalTo("The quick brown fox jumps over the lazy dog"));
    }

    @Test
    public void testAssertJFailureMessagesList() {
        Assertions.assertThat(Arrays.asList(1, 2, 3, 4, 5)).contains(5, 7);
    }

    @Test
    public void testHamcrestFailureMessagesList() {
        MatcherAssert.assertThat(Arrays.asList(1, 2, 3, 4, 5), Matchers.hasItems(5, 7));
    }

}
