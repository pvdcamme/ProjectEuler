package solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Easy way to loop over all permutations of an array.
 * 
 * For example:
 * for(Integer[] ex: new Permutations<Integer>(values)) {
 *    ...
 * }
 */
public class Permutations<T> implements Iterable<T[]> {
    private static interface Resettable<T> extends Iterator<T>{
        public void reset();
    }
    /** The base case, the permutations of an array with only a single element. 
     */
    private final static class EndNode<T> implements  Resettable<T[]> {
        private boolean wasCalled = false;
        private final T[] val;

        public EndNode(T[] val) {
            this.val = val;
        }

        @Override
        public boolean hasNext() {
            return !wasCalled;
        }
        @Override
        public void reset() {
            wasCalled = false;            
        }

        @Override
        public T[] next() {
            wasCalled = true;
            return val;
        }
    }

    /** The other cases, delegates most of the work recursively.  
     */
    private final static class Recursive<T> implements Resettable<T[]> {
        private final T[] current;
        private int idx;
        private final Resettable<T[]> recursive;
        private final int length;
        

        public Recursive(T[] initial, int length) {
            current = initial;
            this.length = length;
            idx = length - 1;
            recursive = makeIterator(initial, length - 1);
        }

        @Override
        public boolean hasNext() {
            return idx > 0 || recursive.hasNext();
        }

        @Override
        public T[] next() {
            if (idx > 0 && !recursive.hasNext()) {
                idx--;
                T a = current[length - 1];
                current[length - 1] = current[idx];
                current[idx] = a;
                recursive.reset();// = makeIterator(current, length - 1);
            }
            recursive.next();
            return current;
        }

        @Override
        public void reset() {
            idx = length -1;            
        }
    }

    /** using a factory method to make it easier to provide different implementations based on size.
     * 
     */
    private static <T> Resettable<T[]> makeIterator(T[] start, int length) {
        if (length > 1) {
            return new Recursive<T>(start, length);            
        } else {
            return new EndNode<T>(start);
        }
    }

    private final T[] start;

    public Permutations(T[] initalValues) {
        start = Arrays.copyOf(initalValues, initalValues.length);
    }

    @Override
    public Iterator<T[]> iterator() {
        T[] initial = Arrays.copyOf(start, start.length);
        return makeIterator(initial, initial.length);
    }
}
