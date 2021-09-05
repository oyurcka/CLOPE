package main.java.model;

import java.util.*;

public class Cluster {

	private List<Transaction> transactions = new ArrayList<>();

	public Cluster(Transaction transaction) {
		this.transactions.add(transaction);
	}

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public void deleteTransaction(Transaction transaction) {
		transactions.remove(transaction);
	}

	public Map<String, Integer> getClusterMap() {
		Map<String, Integer> clusterMap = new HashMap<>();
		for (Transaction transaction : transactions) {
			for (String item : transaction.getTransactionItems()) {
				if (clusterMap.containsKey(item)) {
					clusterMap.put(item, clusterMap.get(item) + 1);
				} else {
					clusterMap.put(item, 1);
				}
			}
		}
		return clusterMap;
	}

	public double getHeight() {
		double height;
		height = 0;
		for (Integer h: getClusterMap().values()) {
			if (height < h) {
				height = h;
			}
		}
		return height;
	}

	public double getWidth() {
		return getClusterMap().size();
	}

	public double getTransactionsCount() {
		return transactions.size();
	}

	@Override
	public String toString() {
		return "Cluster: W = " + this.getWidth() + " , S = " + this.getWidth() * this.getHeight()
				+ "  {" + Arrays.toString(transactions.toArray()) + '}' + '\n';
	}
}
