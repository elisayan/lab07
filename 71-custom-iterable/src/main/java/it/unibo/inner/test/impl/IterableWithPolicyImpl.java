package it.unibo.inner.test.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import it.unibo.inner.api.IterableWithPolicy;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy{

    private T[] elements;
    private int current = 0;

    public IterableWithPolicyImpl(T[] elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }

    @Override
    public void setIterationPolicy(Predicate filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }
    
    private class InnerIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return current < elements.length;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T currentElement = elements[current];
                current++;
                return currentElement;
            }
            throw new NoSuchElementException();
        }

    }
}
