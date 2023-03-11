package solutions;

public class Problem28 extends Problem {

    public Problem28() {
        super(28);

    }

    class Position {
        int a, b;

        public Position(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public Position add(Position oth) {
            return new Position(a + oth.a, b + oth.b);
        }
    }

    @Override
    public void solve() {
        Position[] directions = { new Position(1, 0), new Position(0, -1), new Position(-1, 0), new Position(0, 1) };

        int maxSize = 1001;
        int sum = 0;
        Position current = new Position(0, 0);
        int maxCount = 1;
        int currentCount = 0;
        boolean turn = false;
        int dir = 0;
        int ctr = 1;
        while (current.a <= (maxSize / 2) && current.b <= (maxSize / 2)) {
            if (Math.abs(current.a) == Math.abs(current.b))
                sum += ctr;

            current = current.add(directions[dir]);
            currentCount++;
            if (currentCount == maxCount) {
                dir = (dir + 1) % directions.length;
                currentCount = 0;
                if (turn)
                    maxCount++;
                turn = !turn;
            }
            ctr++;
        }
        System.out.format("%s: : a %d by %d spiral sums to %d \n", this, maxSize, maxSize, sum);

    }
}
