package it.unibo.inner.test.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import it.unibo.inner.api.IterableWithPolicy;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    private T[] elements;
    private int current = 0;
    private Predicate<T> filter;

    public IterableWithPolicyImpl(T[] elements) {
        this(elements, new Predicate<T>() {

            @Override
            public boolean test(T arg0) {
                return true;
            }
            
        });        
        this.elements = elements;
    }

    public IterableWithPolicyImpl(T[] elements, Predicate<T> filter) {
        this.elements = elements;
        this.filter = filter;
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.filter = filter;
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
