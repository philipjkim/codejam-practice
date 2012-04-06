package org.sooo.codejam.round1a2008;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class Milkshakes {

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
			List<String> custInfos = Lists.newArrayList();
			for (int j = 1; j <= numCustomers; j++) {
				String raw = lines.get(lineNo + j);
				custInfos.add(raw);
			}
			Collections.sort(custInfos, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.length() - o2.length();
				}
			});

			for (String raw : custInfos) {
				List<String> custInfo = Lists.newArrayList(Splitter.on(" ")
						.split(raw.substring(raw.indexOf(" ") + 1)));
				boolean taken = false;

				List<Milkshake> shakes = Lists.newArrayList();
				for (int k = 0; k < custInfo.size(); k = k + 2) {
					Integer flavor = Integer.parseInt(custInfo.get(k));
					Integer malted = Integer.parseInt(custInfo.get(k + 1));
					shakes.add(new Milkshake(flavor, malted));
				}
				Collections.sort(shakes, new Comparator<Milkshake>() {
					@Override
					public int compare(Milkshake o1, Milkshake o2) {
						return o1.flavor - o2.flavor;
					}
				});
				for (Milkshake shake : shakes) {
					if (output.get(shake.flavor - 1) == shake.malted)
						taken = true;
					else if (output.get(shake.flavor - 1) == -1) {
						if (shake.malted == 0) {
							output.set(shake.flavor - 1, 0);
							taken = true;
						} else if (shake.malted == 1 && !output.contains(1)) {
							output.set(shake.flavor - 1, 1);
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
