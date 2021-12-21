package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {

    @Test
    public void whenJobIsCorrect() {
        String template = "I am a ${name}, I love ${subject}!";
        Map<String, String> values = new HashMap<>();
        values.put("name", "Vika");
        values.put("subject", "cats");
        Generator generator = new GeneratorTemplate();
        assertThat("I am a Vika, I love cats!", is(generator.produce(template, values)));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenKeysIsNotInMap() {
        String template = "I am a ${name}, I love ${subject}!";
        Map<String, String> values = new HashMap<>();
        values.put("name", "Vika");
        Generator generator = new GeneratorTemplate();
        generator.produce(template, values);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenExtraKeysInMap() {
        String template = "I am a ${name}, I love ${subject}!";
        Map<String, String> values = new HashMap<>();
        values.put("name", "Vika");
        values.put("subject", "cats");
        values.put("weather", "cold");
        Generator generator = new GeneratorTemplate();
        generator.produce(template, values);
    }

}