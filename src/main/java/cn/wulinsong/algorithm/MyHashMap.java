package cn.wulinsong.algorithm;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 706. 设计哈希映射
 */
public class MyHashMap {

    private static class Pair {
        private final int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static final int BASE = 769;
    private final LinkedList<Pair>[] data;

    /** Initialize your data structure here. */
    @SuppressWarnings("unchecked")
    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        for (Pair pair : data[h]) {
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        data[h].add(new Pair(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        for (Pair pair : data[h]) {
            if (pair.getKey() == key) {
                return pair.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.key == key) {
                iterator.remove();
                return;
            }
        }
    }

    private static int hash(int key) {
        return key % BASE;
    }
}
