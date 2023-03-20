package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

public class Problem18 extends Problem {

    public Problem18() {
        super(18);
    }

    @Override
    public void solve() {
        try (FileReader f = new FileReader("src/main/resources/prob18.txt");
                BufferedReader reader = new BufferedReader(f);) {

            String line = null;
            Vector<Integer> bestPath = new Vector<>();
            bestPath.add(Integer.parseInt(reader.readLine()));

            while (null != (line = reader.readLine())) {
                Vector<Integer> currentLine = new Vector<>();
                for (String strNum : line.split(" ")) {
                    currentLine.add(Integer.parseInt(strNum));
                }
                for (int ctr = 0; ctr < currentLine.size(); ++ctr) {
                    int currentPath = Integer.MIN_VALUE;
                    if (ctr - 1 >= 0) {
                        currentPath = currentLine.get(ctr) + bestPath.get(ctr - 1);
                    }
                    if (ctr < bestPath.size()) {
                        currentPath = Math.max(currentPath, currentLine.get(ctr) + bestPath.get(ctr));
                    }
                    currentLine.set(ctr, currentPath);
                }
                bestPath = currentLine;

            }
            int finalbestPath = Integer.MIN_VALUE;
            for (int path : bestPath) {
                finalbestPath = Math.max(finalbestPath, path);
            }
            System.out.println(this + ":most expensive path costs " + finalbestPath);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
