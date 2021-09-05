package main.java;

import main.java.model.Clope;
import main.java.reader.Reader;

public class Runner {

	private static final double REPULSION = 2.9;
	private static final String TEST_FILE = "src/main/data/test.data";

	public static void main(String[] args) {
		StringBuilder result = new StringBuilder();
		Reader reader = new Reader(TEST_FILE);
		Clope clope = new Clope();
		result.append(clope.getClusters(reader.readFile(), REPULSION).toString());
		System.out.println(result);
	}
}