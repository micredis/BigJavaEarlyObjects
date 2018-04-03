/* Suppose you received a loyalty promotion that lets you purchase one item, valued
up to $100, from an online catalog. You want to make the best of the offer. You have
a list of all items for sale, some of which are less than $100, some more. Write an
algorithm to produce the item that is closest to $100. If there is more than one such
item, list them all. Remember that a computer will inspect one item at a time––it
can’t just glance at a list and find the best one.
*/

import java.util.*;

public class ClosestFromTheLeft {
	private static final Map<String, Double> DEFAULT_CATALOG;
	static {
		Map<String, Double> map = new HashMap<>();
		map.put("Robot Mower", 89.50);
		map.put("Robot Mower Mark II", 99.90);
		map.put("Robot Windows Counter", 24.99);
		map.put("Mazebot", 74.99);
		map.put("A Maze Bot - 22", 85.55);
		map.put("Robot Windows Counter Gen 3", 49.99);
		map.put("Duster Bot", 85.55);
		map.put("Duster Bot Gen 2", 99.90);
		map.put("Iron Gardner", 48.80);
		map.put("Fullerene Gardner", 58.85);
		DEFAULT_CATALOG = Collections.unmodifiableMap(map);
	}
	
	public static void main(String[] args) {
		new ClosestFromTheLeft().go();
	}

	public void go() {
		Map<String, Double> bargains = findBargains(ClosestFromTheLeft.DEFAULT_CATALOG);
		printMap(bargains);
	}

	private Map<String, Double> findBargains(Map<String, Double> catalog) {
		Map<String, Double> bargains = new HashMap<>();
		double bestPrice = 0;
		for (Map.Entry<String, Double> item : catalog.entrySet()) {
			double price = item.getValue();
			if (price >= bestPrice && price <= 100 &&
				!bargains.containsValue(price)) {
				bestPrice = price;
				bargains.clear();
				bargains.put(item.getKey(), price);
			} else if (price >= bestPrice && price <= 100) {
				bargains.put(item.getKey(), price);
			}
		}
		return bargains;
	}

	private void printMap(Map<String, Double> map) {
		System.out.println("Item(s) that is/are closest to $100.00:");
		System.out.println("----------------------------------------");
		for (Map.Entry<String, Double> entry : map.entrySet()) {
			System.out.format("%-30s | $%.2f%n", entry.getKey(), entry.getValue());
		}
	}
}