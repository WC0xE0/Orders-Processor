package processor;

import java.io.File;

public class ProcessOrderTask implements Runnable {
	
	private File file;
	private Orders orders;
	
	public ProcessOrderTask(File file, Orders orders) {
		this.file = file;
		this.orders = orders;
	}
	
	@Override
	public void run() {
		ClientData clientData = ClientDataReader.read(file);
		orders.add(clientData);
	}
}
