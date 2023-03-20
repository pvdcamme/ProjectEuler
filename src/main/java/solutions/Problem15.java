package solutions;

import java.util.HashMap;

public class Problem15 extends Problem {

    public class Position {
        int x, y;

        public Position(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Position) {
                Position oth = (Position) obj;
                return oth.x == x && oth.y == y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return x << 16 + y;
        }
    }

    HashMap<Position, Long> mStorage;

    public Problem15() {
        super(15);
        mStorage = new HashMap<Problem15.Position, Long>();
    }

    public long latticePaths(int x, int y) {
        Position current = new Position(x, y);
        if (x == 0)
            return 1;
        else if (y == 0)
            return 1;
        else if (mStorage.containsKey(current)) {
            return mStorage.get(current);
        } else {
            long result = latticePaths(x - 1, y) + 0 + latticePaths(x, y - 1);
            mStorage.put(current, result);
            return result;
        }
    }

    @Override
    public void solve() {

        System.out.println(this + ": lattice paths for (20,20): " + latticePaths(20, 20));
    }
}
