package solutions;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Problem22 extends Problem {

    public Problem22() {
        super(22);
    }

    @Override
    public void solve() {
        FileReader f;
        try {
            f = new FileReader("src/resources/p022_names.txt");
            String rawNames = new String();
            char[] buffer = new char[1024];
            int amtRead = 0;
            while (0 < (amtRead = f.read(buffer))) {
                String chunk = String.copyValueOf(buffer, 0, amtRead);
                rawNames = rawNames.concat(chunk);
            }

            rawNames = rawNames.replace("\"", "");
            String[] names = rawNames.split(",");
            Arrays.sort(names);
            long sum = 0;
            for (int ctr = 0; ctr < names.length; ++ctr) {
                int wordSum = 0;
                String current = names[ctr];

                for (int letterCtr = 0; letterCtr < current.length(); ++letterCtr) {
                    wordSum += (current.charAt(letterCtr) - 'A') + 1;
                }

                sum += wordSum * (ctr + 1);

            }
            System.out.format("%s : summed up to %d\n", this, sum);

        } catch (IOException e) {
            Logger.getGlobal().log(Level.SEVERE, "Can work with resource", e);
        }
    }
}
