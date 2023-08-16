package processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ItemsDataReader {
	public static Map<String, ItemData> read(File file) {
		Map<String, ItemData> itemsDatabase = new HashMap<>();
		
		// syntax "try with resources" will automatically close the reader 
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] array = line.split(" ");
				String itemName = array[0];
				String price = array[1];
				ItemData itemData = new ItemData(itemName, price);
				itemsDatabase.put(itemName, itemData);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		return itemsDatabase;
	}
}
