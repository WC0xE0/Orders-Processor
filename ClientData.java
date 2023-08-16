package processor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ClientData implements Comparable<ClientData> {
	private int id;
	private static final int DUMMY_CLIENT_ID = -1;
	private Map<String, Integer> mapItemNameToQuantity;
	
	public ClientData() {
		this(DUMMY_CLIENT_ID); // for the summary
	}
	
	public ClientData(int id) {
		this.id = id;
		this.mapItemNameToQuantity = new HashMap<String, Integer>();
	}
	
	public void addItemtoClient(String itemName) {
		addItemtoClient(itemName, 1);
	}
	
	private void addItemtoClient(String itemName, int quantity) {
		Integer existingQuantity = mapItemNameToQuantity.get(itemName);
		
		if (existingQuantity != null) {
			mapItemNameToQuantity.put(itemName, existingQuantity + quantity);
		} else {
			mapItemNameToQuantity.put(itemName, quantity);
		}
	}

	public int getClientId() {
		return id;
	}
	
	private int getQuantity(String itemName) {
		return mapItemNameToQuantity.get(itemName);
	}
	
	public void merge(ClientData other) {
		id = DUMMY_CLIENT_ID; // !! 
		for (String itemName : other.mapItemNameToQuantity.keySet()) {
			int quantity = other.mapItemNameToQuantity.get(itemName);
			
			addItemtoClient(itemName, quantity);
		}
	}
	
	public String toString(Map<String, ItemData> itemsDatabase) {
		double totalCost = 0.0;
		StringBuilder sb = new StringBuilder();
		Set<String> items = new TreeSet<>(mapItemNameToQuantity.keySet());
	
		sb.append("----- Order details for client with Id: ");
		sb.append(id).append(" -----\n");
		
		for (String item : items) {
			int quantity = getQuantity(item);
			double price = itemsDatabase.get(item).getPrice();
			double cost = price * quantity;
			
			totalCost += cost;
			sb.append("Item's name: ").append(item).append(", ");
			sb.append("Cost per item: $").append(String.format("%,.2f", price)).append(", ");
			sb.append("Quantity: ").append(quantity).append(", ");
			sb.append("Cost: $").append(String.format("%,.2f", cost)).append("\n");
		}
		sb.append("Order Total: $").append(String.format("%,.2f", totalCost)).append("\n");
		
		return sb.toString();
		
	}
	
	public String toSummaryString(Map<String, ItemData> itemsDatabase) {
		double totalCost = 0.0;
		StringBuilder sb = new StringBuilder();
		Set<String> items = new TreeSet<>(mapItemNameToQuantity.keySet());

		sb.append("***** Summary of all orders *****\n");
		
		for (String item : items) {
			int quantity = getQuantity(item);
			double price = itemsDatabase.get(item).getPrice();
			double cost = price * quantity;
			totalCost += cost;

			sb.append("Summary - Item's name: ").append(item).append(", ");
			sb.append("Cost per item: $").append(String.format("%,.2f", price)).append(", ");
			sb.append("Number sold: ").append(quantity).append(", ");
			sb.append("Item's Total: $").append(String.format("%,.2f", cost)).append("\n");
		}
		sb.append("Summary Grand Total: $").append(String.format("%,.2f", totalCost)).append("\n");

		return sb.toString();
	}

	@Override
	public int compareTo(ClientData other) {
		return id - other.getClientId();
	}
}
