package org.sooo.codejam.round1a2008;

import org.junit.Test;

public class MilkshakesTest {

	@Test
	public void testWithSample() throws Exception {
		Milkshakes.printResult("src/test/resources/B-sample.in");
	}

	@Test
	public void testWithSmallInput() throws Exception {
		Milkshakes.printResult("src/main/resources/B-small.in");
	}

	@Test
	public void testWithLargeInput() throws Exception {
		Milkshakes.printResult("src/main/resources/B-large.in");
	}
}
