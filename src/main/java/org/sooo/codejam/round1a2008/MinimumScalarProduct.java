package org.sooo.codejam.round1a2008;

import java.io.File;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class MinimumScalarProduct {

	public static void printResult(String inputFilePath) throws Exception {

		List<String> lines = Files.readLines(new File(inputFilePath),
				Charsets.UTF_8);
		int cases = Integer.parseInt(lines.get(0));
		for (int i = 0; i < cases; i++) {
			List<String> v1Str = Lists.newArrayList(Splitter.on(" ").split(
					lines.get((i * 3) + 2)));
			List<String> v2Str = Lists.newArrayList(Splitter.on(" ").split(
					lines.get((i * 3) + 3)));

			Function<String, Long> strToInt = new Function<String, Long>() {
				@Override
				public Long apply(String input) {
					return Long.parseLong(input);
				}
			};
			List<Long> v1 = Lists
					.newArrayList(Lists.transform(v1Str, strToInt));
			List<Long> v2 = Lists
					.newArrayList(Lists.transform(v2Str, strToInt));
			Collections.sort(v1);
			Collections.sort(v2);
			v2 = Lists.reverse(v2);
			long scalar = 0;
			for (int j = 0; j < v1.size(); j++)
				scalar += (v1.get(j) * v2.get(j));
			System.out.printf("Case #%d: %d\n", (i + 1), scalar);
		}

	}
}
