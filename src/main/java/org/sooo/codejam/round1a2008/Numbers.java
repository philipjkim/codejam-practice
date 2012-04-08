package org.sooo.codejam.round1a2008;

import java.io.File;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class Numbers {

	public static long[][] multiplyMatrices(long[][] a, long[][] b) {
		long[][] result = new long[2][2];
		result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % 1000;
		result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % 1000;
		result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % 1000;
		result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % 1000;
		return result;
	}

	public static long[][] fastExponential(long[][] matrix, long power) {
		if (power == 1)
			return matrix;
		else if (power % 2 == 0) {
			long[][] m2 = fastExponential(matrix, power / 2);
			return multiplyMatrices(m2, m2);
		} else {
			return multiplyMatrices(matrix, fastExponential(matrix, power - 1));
		}
	}

	public static long[][] createMatrix(long e00, long e01, long e10, long e11) {
		long[][] result = new long[2][2];
		result[0][0] = e00;
		result[0][1] = e01;
		result[1][0] = e10;
		result[1][1] = e11;
		return result;
	}

	public static void printMatrix(long[][] matrix) {
		System.out.printf("%5d %5d\n", matrix[0][0], matrix[0][1]);
		System.out.printf("%5d %5d\n", matrix[1][0], matrix[1][1]);
	}

	public static void printResult(String inputFilePath) throws Exception {
		List<String> lines = Files.readLines(new File(inputFilePath),
				Charsets.UTF_8);
		int numCase = Integer.parseInt(lines.get(0));
		for (int i = 1; i <= numCase; i++) {
			long power = Long.parseLong(lines.get(i));
			long[][] matrix = createMatrix(3, 5, 1, 3);
			long result = ((fastExponential(matrix, power)[0][0] * 2) - 1) % 1000;
			System.out.printf("Case #%d: %03d\n", i, result);
		}
	}
}
