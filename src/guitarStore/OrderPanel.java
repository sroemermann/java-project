package guitarStore;

import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.UIManager;



public class OrderPanel extends JPanel {

	private static final long serialVersionUID = 5086543187726835176L;
	private static final String USER_NAME = "root";
	private static final String PASS_WORD = "root";
	private static final String CONNECTION_STR = "jdbc:mysql://localhost:3306/GuitarStoreDatabase";
	private static final String QUERY = "SELECT * FROM Inventory";

	JLabel messageLabel;
	JTextPane itemListPane;
	JLabel cartTotalLabel;

	ArrayList<Item> availableItems = new ArrayList<Item> ();


	public OrderPanel() {
		setBackground(Color.WHITE);

		Connection conn = null;

		try
		{	Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASS_WORD);

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(QUERY); 

		while (rs.next()) {
			Item item = new Item();
			item.setProductID(rs.getInt(1));
			item.setProductName(rs.getString(2));
			item.setProductPrice(rs.getBigDecimal(3));
			item.setStockQuantity(rs.getInt(4));
			availableItems.add(item);				
		}

		rs.close();
		conn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {250, 250};
		gridBagLayout.rowHeights = new int[] {60, 40, 50, 40, 140, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);


		/* ComboBox */

		JComboBox<Item> productComboBox = new JComboBox<Item>();			
		productComboBox.setMaximumRowCount(26);
		productComboBox.setForeground(new Color(34, 34, 34));
		productComboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
		availableItems.forEach((i) -> productComboBox.addItem(i));	
		GridBagConstraints gbc_productComboBox = new GridBagConstraints();
		gbc_productComboBox.fill = GridBagConstraints.BOTH;
		gbc_productComboBox.gridwidth = 2;
		gbc_productComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_productComboBox.gridx = 0;
		gbc_productComboBox.gridy = 1;
		add(productComboBox, gbc_productComboBox);


		/* ----- Labels ----- */

		JLabel orderPanelLabel = new JLabel("Shopping cart");
		orderPanelLabel.setForeground(new Color(34, 34, 34));
		orderPanelLabel.setFont(new Font("Roboto", Font.BOLD, 30));
		GridBagConstraints gbc_orderPanelLabel = new GridBagConstraints();
		gbc_orderPanelLabel.anchor = GridBagConstraints.WEST;
		gbc_orderPanelLabel.insets = new Insets(0, 0, 5, 5);
		gbc_orderPanelLabel.gridx = 0;
		gbc_orderPanelLabel.gridy = 0;
		add(orderPanelLabel, gbc_orderPanelLabel);

		JLabel step2Label = new JLabel("Step 2 of 5");
		step2Label.setForeground(new Color(34, 34, 34));
		step2Label.setFont(new Font("Roboto", Font.BOLD, 14));
		GridBagConstraints gbc_step2Label = new GridBagConstraints();
		gbc_step2Label.gridwidth = 2;
		gbc_step2Label.gridx = 0;
		gbc_step2Label.gridy = 6;
		add(step2Label, gbc_step2Label);
		
		messageLabel = new JLabel("");
		messageLabel.setForeground(new Color(34, 34, 34));
		messageLabel.setFont(new Font("Roboto", Font.ITALIC, 12));
		messageLabel.setText(Main.cart.msg);
		GridBagConstraints gbc_messageLabel = new GridBagConstraints();
		gbc_messageLabel.gridwidth = 2;
		gbc_messageLabel.insets = new Insets(0, 0, 5, 0);
		gbc_messageLabel.gridx = 0;
		gbc_messageLabel.gridy = 3;
		add(messageLabel, gbc_messageLabel);

		cartTotalLabel = new JLabel("Total: $0.00");
		cartTotalLabel.setForeground(new Color(34, 34, 34));
		cartTotalLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		GridBagConstraints gbc_cartTotalLabel = new GridBagConstraints();
		gbc_cartTotalLabel.insets = new Insets(0, 0, 5, 0);
		gbc_cartTotalLabel.anchor = GridBagConstraints.EAST;
		gbc_cartTotalLabel.gridx = 1;
		gbc_cartTotalLabel.gridy = 5;
		add(cartTotalLabel, gbc_cartTotalLabel);


		/* Summary text pane */

		itemListPane = new JTextPane();
		itemListPane.setForeground(new Color(34, 34, 34));
		itemListPane.setFont(new Font("Roboto", Font.PLAIN, 14));
		itemListPane.setMargin(new Insets(10, 10, 0, 0));
		itemListPane.setBackground(UIManager.getColor("Button.background"));
		itemListPane.setEditable(false);
		GridBagConstraints gbc_itemListPane = new GridBagConstraints();
		gbc_itemListPane.gridwidth = 2;
		gbc_itemListPane.insets = new Insets(0, 0, 5, 0);
		gbc_itemListPane.fill = GridBagConstraints.BOTH;
		gbc_itemListPane.gridx = 0;
		gbc_itemListPane.gridy = 4;
		add(itemListPane, gbc_itemListPane);	



		/* ----- Buttons ----- */

		JButton addToCartButton = new JButton("ADD TO CART");
		addToCartButton.setFont(new Font("Roboto", Font.BOLD, 12));
		addToCartButton.setOpaque(true);
		addToCartButton.setBorderPainted(false);
		addToCartButton.setForeground(Color.WHITE);
		addToCartButton.setBackground(new Color(34, 34, 34));
		addToCartButton.setPreferredSize(new Dimension(120, 40));
		addToCartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.cart.addToCart((Item) productComboBox.getSelectedItem());
				messageLabel.setText(Main.cart.msg);
				itemListPane.setText(Main.cart.toString());
				cartTotalLabel.setText("Total: $" + Main.cart.calculateTotal().toString());
			}
		});
		addToCartButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				addToCartButton.setForeground(new Color(34, 34, 34));
				addToCartButton.setBackground(Color.decode("#ffff33"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				addToCartButton.setForeground(Color.WHITE);
				addToCartButton.setBackground(new Color(34, 34, 34));
			}
		});
		GridBagConstraints gbc_addToCartButton = new GridBagConstraints();
		gbc_addToCartButton.anchor = GridBagConstraints.EAST;
		gbc_addToCartButton.insets = new Insets(0, 0, 5, 0);
		gbc_addToCartButton.gridx = 1;
		gbc_addToCartButton.gridy = 2;
		add(addToCartButton, gbc_addToCartButton);


		JButton removeFromCartButton = new JButton("REMOVE");
		removeFromCartButton.setFont(new Font("Roboto", Font.BOLD, 12));
		removeFromCartButton.setOpaque(true);
		removeFromCartButton.setBorderPainted(false);
		removeFromCartButton.setForeground(Color.WHITE);
		removeFromCartButton.setBackground(new Color(34, 34, 34));
		removeFromCartButton.setPreferredSize(new Dimension(100, 40));
		removeFromCartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.cart.removeFromCart((Item) productComboBox.getSelectedItem());
				messageLabel.setText(Main.cart.msg);
				itemListPane.setText(Main.cart.toString());
				cartTotalLabel.setText("Total: $" + Main.cart.calculateTotal().toString());
			}
		});
		removeFromCartButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				removeFromCartButton.setForeground(new Color(34, 34, 34));
				removeFromCartButton.setBackground(Color.decode("#ffff33"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				removeFromCartButton.setForeground(Color.WHITE);
				removeFromCartButton.setBackground(new Color(34, 34, 34));
			}
		});
		GridBagConstraints gbc_removeFromCartButton = new GridBagConstraints();
		gbc_removeFromCartButton.anchor = GridBagConstraints.WEST;
		gbc_removeFromCartButton.insets = new Insets(0, 0, 5, 5);
		gbc_removeFromCartButton.gridx = 0;
		gbc_removeFromCartButton.gridy = 2;
		add(removeFromCartButton, gbc_removeFromCartButton);


	}

}
