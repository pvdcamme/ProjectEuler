package solutions;

import java.io.FileReader;
import java.io.IOException;

public class Problem42 extends Problem {

	public Problem42() {
		super(42);
	}

	int triangle(int n) {
		return (n * (n + 1)) / 2;
	}

	int wordValue(String str) {
		int value = 0;
		for (int ctr = 0; ctr < str.length(); ++ctr) {
			value += (str.charAt(ctr) - 'A') + 1;
		}
		return value;
	}

	@Override
	public void solve() {
		boolean[] isTriangle = new boolean[100000];

		for (int n = 1; triangle(n) < isTriangle.length; ++n) {
			isTriangle[triangle(n)] = true;
		}

		int triangleWordCount = 0;
		try {
			FileReader f = new FileReader("src/resources/p042_words.txt");
			StringBuilder rawWords = new StringBuilder();
			char[] buffer = new char[1024];
			int amtRead = 0;
			while (0 < (amtRead = f.read(buffer))) {
				String chunk = String.copyValueOf(buffer, 0, amtRead);
				rawWords = rawWords.append(chunk);
			}
			f.close();

			String strwords = rawWords.toString();
			strwords = strwords.replace("\"", "");
			String[] words = strwords.split(",");
			for (String w : words) {
				if (isTriangle[wordValue(w)])
					triangleWordCount++;
			}
		} catch (IOException e) {
			System.err.println(this + ": could not open/read words file");
		}

		System.out.format("%s: counted %d triangle words\n", this, triangleWordCount);

	}
}
