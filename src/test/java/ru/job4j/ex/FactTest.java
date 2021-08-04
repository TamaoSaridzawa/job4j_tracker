package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calc() {
      new Fact().calc(-2);
    }

    @Test
    public void when2Then2() {
      int rsl = new Fact().calc(2);
      assertThat(rsl, is(2));
    }
}