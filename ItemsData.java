package processor;

public class ItemData {
	
	private String name;
	private double price;
	
	public ItemData(String name, String price) {
		this.name = name;
		this.price = Double.valueOf(price);
	}

	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
}
