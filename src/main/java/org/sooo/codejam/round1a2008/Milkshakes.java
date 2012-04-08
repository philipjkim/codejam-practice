package org.sooo.codejam.round1a2008;

import java.io.File;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class Milkshakes {

	public static void printResult(String inputFilePath) throws Exception {
		List<String> lines = Files.readLines(new File(inputFilePath),
				Charsets.UTF_8);
		int numCase = Integer.parseInt(lines.get(0));
		int lineNo = 1;
		for (int i = 0; i < numCase; i++) {
			int numFlavor = Integer.parseInt(lines.get(lineNo++));
			int numCustomer = Integer.parseInt(lines.get(lineNo++));

			boolean[][] canUse = new boolean[numCustomer][numFlavor];
			int[] malted = new int[numCustomer]; // value = flavor
			int[] numCanUse = new int[numCustomer];
			boolean[] visited = new boolean[numCustomer];
			boolean[] choice = new boolean[numFlavor];

			for (int customer = 0; customer < numCustomer; customer++) {
				malted[customer] = -1;
				numCanUse[customer] = 0;
				visited[customer] = false;
				for (int k = 0; k < numFlavor; k++)
					canUse[customer][k] = false;

				String raw = lines.get(lineNo++);
				List<String> tokens = Lists.newArrayList(Splitter.on(" ")
						.split(raw.substring(raw.indexOf(" ") + 1)));
				for (int k = 0; k < tokens.size(); k = k + 2) {
					int flavor = Integer.parseInt(tokens.get(k)) - 1;
					int malt = Integer.parseInt(tokens.get(k + 1));
					if (malt == 1)
						malted[customer] = flavor;
					else {
						canUse[customer][flavor] = true;
						numCanUse[customer]++;
					}
				}
			}

			for (int flavor = 0; flavor < numFlavor; flavor++)
				choice[flavor] = false;

			boolean possible = true;
			while (true) {
				boolean found = false;
				for (int customer = 0; customer < numCustomer; customer++) {
					if (numCanUse[customer] == 0 && !visited[customer]) {
						visited[customer] = true;
						found = true;
						if (malted[customer] == -1) {
							possible = false;
							break;
						} else {
							choice[malted[customer]] = true;
							for (int k = 0; k < numCustomer; k++) {
								if (canUse[k][malted[customer]] == true) {
									numCanUse[k]--;
									canUse[k][malted[customer]] = false;
								}
							}
						}
					}
				}
				if (!found)
					break;
				if (!possible)
					break;
			}

			System.out.printf("Case #%d:", i + 1);
			if (possible) {
				for (int f = 0; f < numFlavor; f++)
					System.out.printf(" %d", choice[f] ? 1 : 0);
			} else
				System.out.print(" IMPOSSIBLE");
			System.out.println();
		}
	}
}
