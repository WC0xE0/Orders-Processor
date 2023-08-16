package processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ResultsWriter {
	
	public static void write(File file, Orders orders,
			Map<String, ItemData> itemsDatabase) {
		
		// try with resources will close whether stops normally or by exception
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			
			for (ClientData order : orders.getOrders()) {
				writer.write(order.toString(itemsDatabase));
			}
			writer.write(orders.getSummary(itemsDatabase));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
