package com.efimchick.ifmo.collections;

import java.util.*;

class MedianQueue implements Queue<Integer> {
    private LinkedList<Integer> queue = new LinkedList<>();

    @Override
    public boolean add(Integer integer) {
        return queue.add(integer);
    }

    @Override
    public boolean offer(Integer integer) {
        queue.offer(integer);
        sortingQueue();
        return true;
    }

    @Override
    public Integer remove() {
        Integer removed = queue.remove();
        sortingQueue();
        return removed;
    }

    @Override
    public Integer poll() {
        Integer removed = queue.poll();
        sortingQueue();
        return removed;
    }

    @Override
    public Integer element() {
        return queue.element();
    }

    @Override
    public Integer peek() {
        return queue.peek();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean remove(Object o) {
        if (queue.remove(o)) {
            sortingQueue();
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return queue.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return queue.iterator();
    }

    @Override
    public Object[] toArray() {
        return queue.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] a) {
        return queue.toArray(a);
    }


    @Override
    public boolean containsAll(final Collection<?> c) {
        return queue.containsAll(c);
    }

    @Override
    public boolean addAll(final Collection<? extends Integer> c) {
        queue.addAll(c);
        sortingQueue();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (queue.removeAll(c)) {
            sortingQueue();
            return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return queue.retainAll(c);
    }

    @Override
    public void clear() {
        queue.clear();
    }



    private void sortingQueue() {

        LinkedList<Integer> sortedQueue = new LinkedList<>(queue);

        Collections.sort(sortedQueue);
        queue.clear();

        int size = sortedQueue.size();

        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) queue.addFirst(sortedQueue.pollLast());
            else queue.addFirst(sortedQueue.pollFirst());
        }
    }
}