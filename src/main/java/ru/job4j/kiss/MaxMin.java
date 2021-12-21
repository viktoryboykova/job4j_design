package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    private <T> T getResult(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T resultValue = value.get(0);
        for (T valueFromList : value) {
            if (predicate.test(comparator.compare(resultValue, valueFromList))) {
                resultValue = valueFromList;
            }
        }
        return resultValue;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return getResult(value, comparator, x -> x < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return getResult(value, comparator, x -> x > 0);
    }

}
