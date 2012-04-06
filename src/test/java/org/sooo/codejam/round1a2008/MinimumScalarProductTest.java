package org.sooo.codejam.round1a2008;

import org.junit.Test;

public class MinimumScalarProductTest {

	@Test
	public void testWithSample() throws Exception {
		MinimumScalarProduct.printResult("src/test/resources/A-sample.in");
	}

	@Test
	public void testWithSmallInput() throws Exception {
		MinimumScalarProduct.printResult("src/main/resources/A-small.in");
	}

	@Test
	public void testWithLargeInput() throws Exception {
		MinimumScalarProduct.printResult("src/main/resources/A-large.in");
	}
}
