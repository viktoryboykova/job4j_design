package ru.job4j.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count < capacity) {
            MapEntry<K, V> mapEntry = new MapEntry<>(key, value);
            table[indexFor(hash(key.hashCode()))] = mapEntry;
            count++;
            modCount++;
            return true;
        }
        return false;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> table.length);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        MapEntry<K, V>[] old = table;
        table = new MapEntry[table.length * 2];
        count = 0;
        for (MapEntry<K, V> mapEntry : old) {
           put(mapEntry.key, mapEntry.value);
        }
    }

    @Override
    public V get(K key) {
        MapEntry<K, V> mapEntry = table[indexFor(hash(key.hashCode()))];
        return mapEntry == null ? null : mapEntry.value;
    }

    @Override
    public boolean remove(K key) {
        MapEntry<K, V> mapEntry = table[indexFor(hash(key.hashCode()))];
        if (mapEntry != null) {
            table[indexFor(hash(key.hashCode()))] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int expectedModCount = modCount;
            int index = 0;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = index; i < table.length; i++) {
                    if (table[i] != null) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public K next() {
                if (hasNext()) {
                    for (int i = index; i < table.length; i++) {
                        if (table[i] != null) {
                            index = i + 1;
                            return table[i].key;
                        }
                    }
                }
                throw new NoSuchElementException();
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
