package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenFindMax() {
        List<Integer> value = List.of(333, 7894, 46387, 378);
        Comparator<Integer> comparator = Integer::compareTo;
        MaxMin maxMin = new MaxMin();
        Assert.assertThat(46387, is(maxMin.max(value, comparator)));
    }

    @Test
    public void whenFindMin() {
        List<Integer> value = List.of(333, 7894, 46387, 378);
        Comparator<Integer> comparator = Integer::compareTo;
        MaxMin maxMin = new MaxMin();
        Assert.assertThat(333, is(maxMin.min(value, comparator)));
    }

}