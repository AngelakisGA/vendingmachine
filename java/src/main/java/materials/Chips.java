package materials;

public class Chips implements Sellables {	
	
	private String code;
	private String name;
	private double price;
	private int quantity;
	private String message;
	
	public Chips(String code, String name, double price) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.quantity = 5;
		this.message = "Munch Munch, Yum!";
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}
	
	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return this.quantity;
	}

	public String getMessage() {
		return message;
	}
}
