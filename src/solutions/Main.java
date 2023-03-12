package solutions;

public class Main {

    public static void main(String[] args) {

        Problem[] solved = { new Problem1(), new Problem2(), new Problem3(), new Problem4(), new Problem5(),
                new Problem6(), new Problem7(), new Problem8(), new Problem9(), new Problem10(), new Problem11(),
                new Problem12(), new Problem13(), new Problem14(), new Problem15(), new Problem16(), new Problem18(),
                new Problem19(), new Problem20(), new Problem21(), new Problem22(), new Problem23(), new Problem24(),
                new Problem25(), new Problem26(), new Problem27(), new Problem28(), new Problem29(), new Problem30(),
                new Problem31(), new Problem32(), new Problem33(), new Problem34(), new Problem35(), new Problem36(),
                new Problem37(), new Problem38(), new Problem39(), new Problem40(), new Problem41(), new Problem42(),
                new Problem43(), new Problem44(), new Problem45(), new Problem46(), new Problem47(), new Problem48(),
                new Problem49() };
        long now = System.currentTimeMillis();
        for (Problem prob : solved)
            prob.solve();
        System.out.format("Solved %d problems in %f s %n", solved.length, (System.currentTimeMillis() - now) / 1e3);
    }
}
