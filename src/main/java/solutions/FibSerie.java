package solutions;

import java.util.Iterator;

public class FibSerie implements Iterator<Long> {

    private long a;
    private long b;

    public FibSerie() {
        a = 0;
        b = 1;
    }

    public long current() {
        return a + b;
    }

    public Long next() {
        long result = a + b;
        a = b;
        b = result;
        return result;
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
