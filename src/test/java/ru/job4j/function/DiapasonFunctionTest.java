package ru.job4j.function;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DiapasonFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        DiapasonFunction function = new DiapasonFunction();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        DiapasonFunction function = new DiapasonFunction();
        List<Double> result = function.diapason(5, 8, x -> 2 * Math.pow(x, 2));
        List<Double> expected = Arrays.asList(50D, 72D, 98D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenIndicativeFunctionThenIndicativeResults() {
        DiapasonFunction function = new DiapasonFunction();
        List<Double> result = function.diapason(5, 8, x -> 2 * Math.pow(4, x));
        List<Double> expected = Arrays.asList(2048D, 8192D, 32768D);
        assertThat(result, is(expected));
    }
}