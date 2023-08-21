package processor;

import java.util.Collection;
import java.util.Map;
import java.util.TreeSet;

public class Orders {
	private Collection<ClientData> ordersCollection;
	private ClientData summary;
	
	public Orders() {
		// shared data structure, need to prevent data races:
		ordersCollection = new TreeSet<ClientData>();
		summary = new ClientData();
	}
	
	public Collection<ClientData> getOrders() {
		return ordersCollection;
	}
	
	public void add(ClientData order) {
		synchronized(ordersCollection) {
			ordersCollection.add(order);
		}
		synchronized(summary) {
			summary.merge(order);
		}
	}

	public String getSummary(Map<String, ItemData> itemsDatabase) {
		return summary.toSummaryString(itemsDatabase);
	}	
}
