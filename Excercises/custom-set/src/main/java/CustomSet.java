import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * An implementation for Set Interface
 * 
 * @author Gabriele La Greca
 * 
 */

public class CustomSet<T> implements Set<T> {
    private static int INITIAL_ARRAY_SIZE = 0xA;
    private static int DEFAULT_INCREASE_FACTOR = 0x2;

    private T[] elements;
    private int currentSize;
    private int currentMaxSize;

    @SuppressWarnings("unchecked")
    public CustomSet(Collection<T> items) {

        if (items == null) {
            throw new IllegalArgumentException();
        }
        
        this.elements = (T[]) new Object[INITIAL_ARRAY_SIZE];
        this.currentSize = 0;
        this.currentMaxSize = INITIAL_ARRAY_SIZE;

        for (T item : items) {
            int index = getPositionAndIncrease();
            elements[index] = item;
        }
    }

    public CustomSet() {
        this(Collections.emptyList());
    }

    @Override
    public boolean add(T item) {
        
        if (!contains(item)) {
            int index = getPositionAndIncrease();
            elements[index] = item;
            return true;
        }

        return false;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return (currentSize <= 0);
    }

    @Override
    public boolean contains(T item) {
        
        for (int i = 0; i < currentSize; i++) {
            if (elements[i].equals(item)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isSubset(Set<T> set) {
        
        for (T e : set) {
            if (!contains(e)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean isDisjoint(Set<T> set) {
        
        for (T e : set) {
            if (contains(e)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Set)) {
            return false;
        }

        try {
            @SuppressWarnings("unchecked")
            Set<T> set = (Set<T>)obj;

            if (set.size() != size()) {
                return false;
            }

            return isSubset(set);
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public Set<T> getUnion(Set<T> otherSet) {
        Set<T> set = new CustomSet<>();

        for (T e : this) {
            set.add(e);
        }

        for (T e : otherSet) {
            set.add(e);
        }

        return set;
    }

    @Override
    public Set<T> getIntersection(Set<T> otherSet) {
        Set<T> set = new CustomSet<>();
        Set<T> toIterate = (otherSet.size() < size()) ? otherSet : this;
        Set<T> toCheck = (toIterate == otherSet) ? this : otherSet;

        for (T e : toIterate) {
            if (toCheck.contains(e)) {
                set.add(e);
            }
        }

        return set;
    }

    @Override
    public Set<T> getDifference(Set<T> otherSet) {
        Set<T> set = new CustomSet<>();

        for (T e : this) {
            if (!otherSet.contains(e)) {
                set.add(e);
            }
        }

        return set;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomSetIterator();
    }

    private int getPositionAndIncrease() {

        if (currentSize >= currentMaxSize) {
            currentMaxSize *= DEFAULT_INCREASE_FACTOR;
            elements = Arrays.copyOf(elements, currentMaxSize);
        }

        return currentSize++;
    }

    private class CustomSetIterator implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return (cursor < currentSize);
        }

        @Override
        public T next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return elements[cursor++];
        }
    }
}