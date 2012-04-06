package org.sooo.codejam.round1a2008;

import java.io.File;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class Milkshakes {

	class MilkShake {
		Integer flavor;
		boolean malted;

		public MilkShake(Integer flavor, Integer malted) {
			this.flavor = flavor;
			this.malted = (malted == 1);
		}
	}

	public static void printResult(String inputFilePath) throws Exception {
		List<String> lines = Files.readLines(new File(inputFilePath),
				Charsets.UTF_8);
		int cases = Integer.parseInt(lines.get(0));
		int lineNo = 1;
		for (int i = 0; i < cases; i++) {
			boolean possible = true;
			int numShakes = Integer.parseInt(lines.get(lineNo++));
			List<Integer> output = Lists.newArrayList();
			for (int j = 0; j < numShakes; j++)
				output.add(-1);

			int numCustomers = Integer.parseInt(lines.get(lineNo));
			for (int j = 1; j <= numCustomers; j++) {
				String raw = lines.get(lineNo + j);
				List<String> custInfo = Lists.newArrayList(Splitter.on(" ")
						.split(raw.substring(raw.indexOf(" ") + 1)));
				boolean taken = false;
				for (int k = 0; k < custInfo.size(); k = k + 2) {
					int flavor = Integer.parseInt(custInfo.get(k));
					int malted = Integer.parseInt(custInfo.get(k + 1));
					if (output.get(flavor - 1) == malted)
						taken = true;
					else if (output.get(flavor - 1) == -1) {
						if (malted == 0) {
							output.set(flavor - 1, 0);
							taken = true;
						} else if (malted == 1 && !output.contains(1)) {
							output.set(flavor - 1, 1);
							taken = true;
						}
					}
				}
				if (!taken) {
					possible = false;
					break;
				}
			}
			for (int j = 0; j < output.size(); j++) {
				if (output.get(j) == -1)
					output.set(j, 0);
			}
			String result = possible ? Joiner.on(" ").join(output)
					: "IMPOSSIBLE";
			System.out.printf("Case #%d: %s\n", (i + 1), result);

			lineNo += (numCustomers + 1);
		}
	}
}
