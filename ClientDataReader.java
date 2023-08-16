package processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ClientDataReader {
	public static ClientData read(File file) {
		ClientData clientData = null; 

		// syntax "try with resources" will automatically close the reader 
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = reader.readLine(); // read the first line
			int clientId = Integer.parseInt(line.split(" ")[1]);  
			clientData = new ClientData(clientId);

			while ((line = reader.readLine()) != null) { // continue line by line
				String itemName = line.split(" ")[0]; // split into String array
				clientData.addItemtoClient(itemName);
			}	
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		return clientData;
	}
}
