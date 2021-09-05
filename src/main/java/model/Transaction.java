package main.java.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Transaction {

	private List<String> transactionItems = new ArrayList<>();

	public Transaction(String[] transactionItems) {
		Collections.addAll(this.transactionItems, transactionItems);
	}

	public List<String> getTransactionItems() {
		return transactionItems;
	}

	@Override
	public String toString() {
		return Arrays.toString(transactionItems.toArray());
	}
}
