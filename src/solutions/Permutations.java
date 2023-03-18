package solutions;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Easy way to loop over all perumutations of an initial value.
 * 
 * For example:
 * for(Integer[] ex: new Permutations<Integer>(values)) {
 *    ...
 * }
 */
public class Permutations<T> implements Iterable<T[]> {
    private static class EndNode<T> implements Iterator<T[]> {
        boolean wasCalled = false;
        private final T[] val;

        public EndNode(T[] val) {
            this.val = val;
        }

        @Override
        public boolean hasNext() {
            return false == wasCalled;
        }

        @Override
        public T[] next() {
            wasCalled = true;
            return val;
        }
    }

    private static class Recursive<T> implements Iterator<T[]> {
        private T[] current;
        private int idx;
        private Iterator<T[]> recursive;

        public Recursive(T[] initial) {
            current = Arrays.copyOf(initial, initial.length);
            idx = initial.length - 1;
            recursive = makeIterator(Arrays.copyOf(initial, initial.length - 1));
        }

        @Override
        public boolean hasNext() {
            return recursive.hasNext() || idx > 0;
        }

        @Override
        public T[] next() {
            if (idx > 0 && !recursive.hasNext()) {
                idx--;
                T a = current[current.length - 1];
                current[current.length - 1] = current[idx];
                current[idx] = a;
                recursive = makeIterator(Arrays.copyOf(current, current.length - 1));
            }
            T[] smaller = recursive.next();
            T[] result = Arrays.copyOf(current, current.length);
            for (int copyCtr = 0; copyCtr < smaller.length; ++copyCtr) {
                result[copyCtr] = smaller[copyCtr];
            }
            return result;
        }
    }

    private static <T> Iterator<T[]> makeIterator(T[] start) {
        if (start.length == 1) {
            return new EndNode<T>(start);
        } else {
            return new Recursive<T>(start);
        }

    }

    private final T[] start;

    public Permutations(T[] initalValues) {
        start = Arrays.copyOf(initalValues, initalValues.length);
    }

    @Override
    public Iterator<T[]> iterator() {
        return makeIterator(start);
    }
}
