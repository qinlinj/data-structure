package org.qinlinj.nonlinear.highlevel.heap;

import org.qinlinj.linear.arraylist.ArrayList;

public class MaxHeap<E extends Comparable<E>> {
    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        this.data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        this.data = new ArrayList<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 does not have parent");
        }
        return (index - 1) / 2;
    }

    private int lastNonLeafIndex() {
        int lastLeafIndex = data.getSize() - 1;
        return parent(lastLeafIndex);
    }

    private void siftUp(int index) {
        E e = data.get(index);

        while (index > 0) {
            E parentNode = data.get(parent(index));

            if (e.compareTo(parentNode) <= 0) break;

            data.set(index, parentNode);
            
            index = parent(index);
        }
        data.set(index, e);
    }
}
