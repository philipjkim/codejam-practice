package org.sooo.codejam.round1a2008;

import org.junit.Test;

public class NumbersTest {

	@Test
	public void printResultWithSample() throws Exception {
		Numbers.printResult("src/test/resources/C-sample.in");
	}

	@Test
	public void printResultWithSmallInput() throws Exception {
		Numbers.printResult("src/main/resources/C-small.in");
	}

	@Test
	public void printResultWithLargeInput() throws Exception {
		Numbers.printResult("src/main/resources/C-large.in");
	}

	@Test
	public void printMatrix() {
		long[][] m = Numbers.createMatrix(3, 5, 1, 3);
		Numbers.printMatrix(m);
		Numbers.printMatrix(Numbers.multiplyMatrices(m, m));
		Numbers.printMatrix(Numbers.fastExponential(m, 10));
	}
}
