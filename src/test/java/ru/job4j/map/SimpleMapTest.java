package ru.job4j.map;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenAddTrue() {
        Map<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(1, "string 1"));
        assertTrue(map.put(2, "string 2"));
    }

    @Test
    public void whenAddTrueAndFalse() {
        Map<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(1, "string 1"));
        assertTrue(map.put(2, "string 2"));
        assertTrue(map.put(3, "string 3"));
        assertTrue(map.put(4, "string 4"));
        assertTrue(map.put(5, "string 5"));
        assertTrue(map.put(6, "string 6"));
        assertTrue(map.put(7, "string 7"));
        assertTrue(map.put(8, "string 8"));
        assertFalse(map.put(9, "string 9"));
    }

    @Test
    public void whenIteratorOne() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "string 1");
        map.put(2, "string 2");
        map.put(3, "string 3");
        Iterator<Integer> it = map.iterator();
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(1));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(2));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(3));
        assertThat(it.hasNext(), Is.is(false));
    }

    @Test
    public void whenRemove() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "string 1");
        map.put(2, "string 2");
        map.put(3, "string 3");
        map.remove(2);
        Iterator<Integer> it = map.iterator();
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(1));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(3));
        assertNull(map.get(2));

    }

    @Test
    public void whenGet() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "string 1");
        map.put(2, "string 2");
        map.put(3, "string 3");
        assertThat(map.get(3), Is.is("string 3"));
    }
}