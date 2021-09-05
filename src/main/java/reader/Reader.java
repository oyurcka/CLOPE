package main.java.reader;

import main.java.model.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

	private String filePath;

	public Reader(String filePath) {
		this.filePath = filePath;
	}

	public List<Transaction> readFile() {
		List<Transaction> transactions = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = reader.readLine()) != null) {
				transactions.add(new Transaction(line.split("")));
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return transactions;
	}
}
