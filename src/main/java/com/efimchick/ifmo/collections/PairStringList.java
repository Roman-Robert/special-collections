package com.efimchick.ifmo.collections;


import java.util.*;

class PairStringList implements List<String> {

    private List<String> list = new ArrayList<>();


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(String s) {
        list.add(s);
        list.add(s);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        list.remove(o);
        list.remove(o);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.contains(c);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        for (String string : c) {
            add(string);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        for (String string : c) {
            add(correctIndex(index), string);
            index += 2;
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String get(int index) {
        return list.get(index);
    }

    @Override
    public String set(int index, String element) {
        list.set(index, element);
        return list.set(nextIndex(index), element);
    }

    @Override
    public void add(int index, String element) {
        list.add(correctIndex(index), element);
        list.add(correctIndex(index), element);
    }

    @Override
    public String remove(int index) {
        list.remove(index);
        return list.remove(nextIndex(index));
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<String> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    private int nextIndex(int index) {
        if (index % 2 == 0) {
            return ++index;
        } else {
            return --index;
        }
    }

    private int correctIndex(int index) {
        if (index % 2 != 0) {
            return ++index;
        } else {
            return index;
        }
    }
}

