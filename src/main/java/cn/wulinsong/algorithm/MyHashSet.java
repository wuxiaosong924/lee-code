package cn.wulinsong.algorithm;

import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 */
public class MyHashSet {

    private static final int BASE = 769;
    private LinkedList<Integer>[] linkedLists;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        linkedLists = new LinkedList[BASE];
    }

    private int hash(int key) {
        return key % BASE;
    }

    public void add(int key) {
        int idx = hash(key);
        if (linkedLists[idx] == null) {
            linkedLists[idx] = new LinkedList<>();
        }
        for (int exist : linkedLists[idx]) {
            if (exist == key) {
                return;
            }
        }
        linkedLists[idx].add(key);
    }

    public void remove(int key) {
        int idx = hash(key);
        if (linkedLists[idx] == null) {
            return;
        }
        linkedLists[idx].removeIf(next -> next == key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = hash(key);
        if (linkedLists[idx] == null) {
            return false;
        }
        return linkedLists[idx].contains(key);
    }

    boolean[] nodes = new boolean[1000009];

    public void add1(int key) {
        nodes[key] = true;
    }

    public void remove1(int key) {
        nodes[key] = false;
    }

    public boolean contains1(int key) {
        return nodes[key];
    }
}
