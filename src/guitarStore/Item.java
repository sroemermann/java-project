package guitarStore;

import java.math.BigDecimal;

public class Item {
	
	
	//item properties
	
	private int productID;
	private String productName;
	private BigDecimal productPrice;
	private int stockQuantity;
	private int orderQuantity = 1;
	

	/* constructor */
	
	public Item() {
		super();
	}
	
	
	/* getters and setters */

	public int getProductID() {
		return productID;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getStockQuantity() {
		return stockQuantity;
	}
	
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	
	/* item methods */

	@Override
	public String toString() {
		return productName + " – $" + productPrice;
	}

	public String itemSummary() {
		return productName + " – $" + productPrice + ". Quantity: " + orderQuantity + "\n";
	}

	public BigDecimal getTotalProductPrice() {
		assert (getOrderQuantity() >= 1);
		return productPrice.multiply(new BigDecimal(orderQuantity));
	}

	public void increaseQuantity() {
		assert (getOrderQuantity() >= 0);
		orderQuantity++;
	}

	public void decreaseQuantity() {
		assert (getOrderQuantity() >= 1);
		orderQuantity--;
	}

}
