package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Clope {

	private List<Cluster> clusters = new ArrayList<>();

	public double evaluateProfit(List<Cluster> clusters, double repulsion) {
		double topProfit = 0;
		double botProfit = 0;
		for (Cluster cluster : clusters) {
			topProfit += cluster.getHeight() * cluster.getWidth()
						/ Math.pow(cluster.getWidth(), repulsion) * cluster.getTransactionsCount();
			botProfit += cluster.getTransactionsCount();
		}
		return topProfit / botProfit;
	}

	public List<Cluster> getClusters(List<Transaction> transactions, double repulsion) {
		for (Transaction transaction : transactions) { 				// Для всех транзакций
			double newClusterProfit;
			double maxProfit;
			Cluster newCluster = new Cluster(transaction);			// создаем новый кластер с текущей транзакцией
			clusters.add(newCluster);
			newClusterProfit = evaluateProfit(clusters, repulsion); // высчитываем профит от добавления этого кластера
			maxProfit = newClusterProfit;							// и берем его за максимальный
			clusters.remove(newCluster);							// пока удаляем новый кластер

			for (Cluster cluster : clusters) {						// Для всех кластеров
				double profit;
				cluster.addTransaction(transaction);				// добавляем транзакцию
				profit = evaluateProfit(clusters, repulsion);		// и считаем профит
				if (maxProfit <= profit) {
					maxProfit = profit;
				} else {
					cluster.deleteTransaction(transaction);
				}
			}
			if (maxProfit == newClusterProfit) {
				clusters.add(newCluster);							// считаем, что транзакция "не подошла" ни одному
			}														// из кластеров, и оставляем ее в новом отдельном
		}
		return clusters;
	}

}
