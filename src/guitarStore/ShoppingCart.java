package guitarStore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.util.ArrayList;
import java.util.*;
import java.io.*;



public class ShoppingCart {

	private static final String USER_NAME = "root";
	private static final String PASS_WORD = "root";
	private static final String CONNECTION_STR = "jdbc:mysql://localhost:3306/GuitarStoreDatabase";


	/* constructor */ 

	public ShoppingCart() {
		super();
	}


	/* cart details properties */

	private int orderID;	
	private BigDecimal cartTotal;
	private String paymentName;
	private LocalDateTime orderDate;
	private int customerID;
	private int paymentID;


	/* shipping info properties */

	private int shippingID;
	private String shippingName;
	private String shippingAddress;
	private String city;
	private String postalCode;
	private String province;
	private String shippingPhone;
	private String shippingEmail;


	/* getters and setters */

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public BigDecimal getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(BigDecimal cartTotal) {
		this.cartTotal = cartTotal;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getShippingPhone() {
		return shippingPhone;
	}

	public void setShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
	}

	public String getShippingEmail() {
		return shippingEmail;
	}

	public void setShippingEmail(String shippingEmail) {
		this.shippingEmail = shippingEmail;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getShippingID() {
		return shippingID;
	}

	public void setShippingID(int shippingID) {
		this.shippingID = shippingID;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}



	/* ArrayList of Items in cart */

	ArrayList<Item> shoppingCartItems = new ArrayList<Item>();


	/* Shopping cart methods */	

	String msg = new String("");

	public void addToCart(Item item) {
		assert (item.getOrderQuantity() >= 0);
		assert (item.getStockQuantity() > 0);
		if (shoppingCartItems.contains(item)) {
			if  (item.getOrderQuantity() < item.getStockQuantity()) {
				item.increaseQuantity();
				msg = item.getProductName() + " added to cart";
			} else {
				msg = item.getProductName() + " exceeds stock quantity of " + item.getStockQuantity() + ". Not added to cart";
			} 	
		} else if (item.getStockQuantity() == 0) {
			msg = "Sorry, " + item.getProductName() + " is out of stock";
		} else {
			shoppingCartItems.add(0, item);
			msg = item.getProductName() + " added to cart";
		}
	}


	public void removeFromCart(Item item) {	
		if (shoppingCartItems.contains(item)) {
			if (item.getOrderQuantity() == 1) {
				shoppingCartItems.remove(item);
				msg = item.getProductName() + " removed from cart";
			} else {
				item.decreaseQuantity();
				msg = item.getProductName() + " removed from cart";
			}		
		} else { msg = "You don't have a " + item.getProductName() + " in your cart";

		}
	}

	
	public BigDecimal calculateTotal() {

		ArrayList<BigDecimal> totals = new ArrayList<BigDecimal>();
		shoppingCartItems.forEach((i) -> totals.add(i.getTotalProductPrice()));

		BigDecimal sum = totals.stream()
				.map(a -> a)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		BigDecimal sum2 = sum.setScale(2, RoundingMode.HALF_UP);
		this.setCartTotal(sum2);
		return sum2;

	}


	@Override
	public String toString() {
		StringBuilder result  = new StringBuilder() ;
		if (!shoppingCartItems.isEmpty()){
			for(int i = shoppingCartItems.size()-1; i>0; i--){
				result.append(shoppingCartItems.get(i).itemSummary());
			}
			result.append(shoppingCartItems.get(0).itemSummary());
			return result.toString();
		} else {
			return "Your cart is empty";
		}
	}



	public String shippingSummary() {

		if (shippingAddress == null) {
			return "You haven't entered shipping info yet";
		} else {
			return (shippingName + "\n" + shippingAddress + "\n" + city + ", " + province + ", " + postalCode + "\n" + shippingPhone + "\n" + shippingEmail);
		}
	}




	/* ---- Insert into database tables methods ----- */

	public void updateShippingInfoTable() throws SQLException, ClassNotFoundException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASS_WORD);

			String sql = "SELECT ShippingID FROM ShippingInfo ORDER BY ShippingID DESC LIMIT 1;";

			Statement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.executeQuery(sql); 

			if (rs.next()) {

				String existingShippingID = rs.getString(1);
				int num = Integer.parseInt(existingShippingID);
				num++;
				this.setShippingID(num);

			} else {
				this.setShippingID(1000);
			}

			try {		

				String sql2 = "INSERT INTO ShippingInfo(ShippingID, ShippingName, Address, City, Province, PostalCode, Phone, Email) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement pstmt = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

				pstmt.setInt(1, shippingID);
				pstmt.setString(2, shippingName);
				pstmt.setString(3, shippingAddress);
				pstmt.setString(4, city);
				pstmt.setString(5, province);
				pstmt.setString(6, postalCode);
				pstmt.setString(7, shippingPhone);
				pstmt.setString(8, shippingEmail);

				pstmt.executeUpdate();

				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();

			} 

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}



	public void updatePaymentInfoTable () throws SQLException, ClassNotFoundException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASS_WORD);

			String sql = "SELECT PaymentID FROM PaymentInfo ORDER BY PaymentID DESC LIMIT 1;";

			Statement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.executeQuery(sql); 

			if (rs.next()) {

				String existingPaymentID = rs.getString(1);
				int num = Integer.parseInt(existingPaymentID);
				num++;
				this.setPaymentID(num);

			} else {
				this.setPaymentID(1000);
			}


			try {		
				String sql2 = "INSERT INTO PaymentInfo(PaymentID, UserID, PaymentName) "
						+ "VALUES (?, ?, ?)";

				PreparedStatement pstmt = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

				pstmt.setLong(1, paymentID);
				pstmt.setLong(2, User.getUserID());
				pstmt.setString(3, paymentName);

				pstmt.executeUpdate();

				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}



	public void updateOrdersTable() throws SQLException, ClassNotFoundException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASS_WORD);

			String sql = "SELECT OrderID FROM Orders ORDER BY OrderID DESC LIMIT 1;";

			Statement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.executeQuery(sql); 

			if (rs.next()) {

				String existingOrderID = rs.getString(1);
				int num = Integer.parseInt(existingOrderID);
				num++;
				this.setOrderID(num);

			} else { 
				this.setOrderID(1000);
			}

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				String orderTotal = this.calculateTotal().toString();

				String sql2 = "INSERT INTO Orders(UserID, OrderID, OrderDate, PaymentID, ShippingID, OrderTotal, OrderStatus) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement pstmt = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

				Date date = Date.valueOf(LocalDate.now());

				pstmt.setLong(1, User.getUserID());
				pstmt.setLong(2, orderID);
				pstmt.setDate(3, date);
				pstmt.setLong(4, paymentID);
				pstmt.setInt(5, shippingID);
				pstmt.setString(6, orderTotal);
				pstmt.setString(7, "Order submitted");

				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}



	public void updateOrderDetailsTable(ArrayList<Item> shoppingCartItems) throws SQLException, ClassNotFoundException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASS_WORD);						

			for (Item i : shoppingCartItems) {

				String sql = "INSERT INTO OrderDetails(OrderID, ProductID, Quantity) "
						+ "VALUES (?, ?, ?)";

				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				pstmt.setLong(1, orderID);
				pstmt.setLong(2, i.getProductID());
				pstmt.setLong(3, i.getOrderQuantity());

				pstmt.executeUpdate();
			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}



	public void updateInventoryTable(ArrayList<Item> shoppingCartItems) throws SQLException, ClassNotFoundException {
		Connection conn = null;


		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASS_WORD);	

			for (Item i : shoppingCartItems) {


				String sql = "UPDATE Inventory SET StockQuantity = StockQuantity - ? WHERE ProductID = ?;";

				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				pstmt.setLong(1, i.getOrderQuantity());
				pstmt.setLong(2, i.getProductID()); 

				pstmt.executeUpdate();

			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}


	/* ----- update text file method ----- */

	public void updateFile() throws IOException {
		Date date = Date.valueOf(LocalDate.now());

		String str = "orderID = " + orderID + "\n"
				+ "customerID = " + customerID + "\n"
				+ "cartTotal = " + cartTotal + "\n"
				+ "orderDate = " + date + "\n"
				+ "shippingID = " + shippingID + "\n"
				+ "paymentID = " + paymentID;

		BufferedWriter writer = new BufferedWriter(new FileWriter("guitarStoreFile.txt", true));
		writer.append("\n \n");
		writer.append(str);

		writer.close();

	}

}




