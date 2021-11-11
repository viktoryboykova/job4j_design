package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> arrayList = new SimpleArrayList<>();

    @Override
    public boolean add(T value) {
        if (contains(value)) {
            return false;
        }
        arrayList.add(value);
        return true;
    }

    @Override
    public boolean contains(T value) {
        Iterator<T> i = arrayList.iterator();
        while (i.hasNext()) {
            T in = i.next();
            if ((in == null && value == null) || (in != null && in.equals(value))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return arrayList.iterator();
    }
}
