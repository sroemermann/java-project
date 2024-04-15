package guitarStore;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class OrderSummaryPanel extends JPanel {

	/* Panel properties */

	private static final long serialVersionUID = 2669192652120245559L;
	static JTextPane orderSummaryTextPane;
	static JTextPane shippingSummaryTextPane;
	JLabel orderSubmittedLabel;
	static JLabel cartTotalLabel;
	static JButton submitOrderButton;
	static JLabel paymentInfoLabel;
	private JLabel step5Label;


	/* methods */
	
	public synchronized void submitClicked() {
		try {
			Main.cart.updateShippingInfoTable();
			Main.cart.updatePaymentInfoTable();
			Main.cart.updateOrdersTable();
			Main.cart.updateOrderDetailsTable(Main.cart.shoppingCartItems);
			Main.cart.updateInventoryTable(Main.cart.shoppingCartItems);
			Main.cart.updateFile();
			orderSubmittedLabel.setText("Order submitted");
			submitOrderButton.setEnabled(false);
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	
	public static void updateSummaryPanels() {
		orderSummaryTextPane.setText(Main.cart.toString());
		shippingSummaryTextPane.setText(Main.cart.shippingSummary());
		cartTotalLabel.setText("Total: $" + Main.cart.calculateTotal().toString());
		if (Main.cart.getPaymentName() == null) {
			paymentInfoLabel.setText("You haven't entered payment info yet");
		} else {
			paymentInfoLabel.setText("");
		}
		if (((Main.cart.getShippingName() != null) && (Main.cart.getPaymentName() != null)) && !(Main.cart.shoppingCartItems.isEmpty()) && (User.getUserID() != 0))  {
			submitOrderButton.setEnabled(true);
		}

	}


	/* Constructor */

	public OrderSummaryPanel() {
		setBackground(Color.WHITE);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {340, 200};
		gridBagLayout.rowHeights = new int[] {50, 40, 120, 40, 120, 40, 50};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);


		/* ----- Labels ----- */

		JLabel orderSummaryLabel = new JLabel("Order Summary");
		orderSummaryLabel.setForeground(new Color(34, 34, 34));
		orderSummaryLabel.setFont(new Font("Roboto", Font.BOLD, 30));
		GridBagConstraints gbc_orderSummaryLabel = new GridBagConstraints();
		gbc_orderSummaryLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_orderSummaryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_orderSummaryLabel.gridx = 0;
		gbc_orderSummaryLabel.gridy = 0;
		add(orderSummaryLabel, gbc_orderSummaryLabel);

		JLabel itemsLabel = new JLabel("CART");
		itemsLabel.setForeground(new Color(34, 34, 34));
		itemsLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		GridBagConstraints gbc_itemsLabel = new GridBagConstraints();
		gbc_itemsLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_itemsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_itemsLabel.gridx = 0;
		gbc_itemsLabel.gridy = 1;
		add(itemsLabel, gbc_itemsLabel);

		cartTotalLabel = new JLabel("");
		cartTotalLabel.setForeground(new Color(34, 34, 34));
		cartTotalLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		GridBagConstraints gbc_cartTotalLabel = new GridBagConstraints();
		gbc_cartTotalLabel.anchor = GridBagConstraints.SOUTH;
		gbc_cartTotalLabel.insets = new Insets(0, 0, 5, 0);
		gbc_cartTotalLabel.gridx = 1;
		gbc_cartTotalLabel.gridy = 2;
		add(cartTotalLabel, gbc_cartTotalLabel);

		JLabel shippingSummaryLabel = new JLabel("SHIPPING INFO");
		shippingSummaryLabel.setForeground(new Color(34, 34, 34));
		shippingSummaryLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		GridBagConstraints gbc_shippingSummaryLabel = new GridBagConstraints();
		gbc_shippingSummaryLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_shippingSummaryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_shippingSummaryLabel.gridx = 0;
		gbc_shippingSummaryLabel.gridy = 3;
		add(shippingSummaryLabel, gbc_shippingSummaryLabel);

		paymentInfoLabel = new JLabel("");
		paymentInfoLabel.setForeground(new Color(34, 34, 34));
		paymentInfoLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		GridBagConstraints gbc_paymentInfoLabel = new GridBagConstraints();
		gbc_paymentInfoLabel.anchor = GridBagConstraints.WEST;
		gbc_paymentInfoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_paymentInfoLabel.gridx = 0;
		gbc_paymentInfoLabel.gridy = 5;
		add(paymentInfoLabel, gbc_paymentInfoLabel);
		
		orderSubmittedLabel = new JLabel("");
		orderSubmittedLabel.setForeground(new Color(34, 34, 34));
		orderSubmittedLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		GridBagConstraints gbc_orderSubmittedLabel = new GridBagConstraints();
		gbc_orderSubmittedLabel.insets = new Insets(0, 0, 5, 0);
		gbc_orderSubmittedLabel.gridx = 1;
		gbc_orderSubmittedLabel.gridy = 5;
		add(orderSubmittedLabel, gbc_orderSubmittedLabel);
		
		step5Label = new JLabel("Step 5 of 5");
		step5Label.setForeground(new Color(34, 34, 34));
		step5Label.setFont(new Font("Roboto", Font.BOLD, 14));
		GridBagConstraints gbc_step5Label = new GridBagConstraints();
		gbc_step5Label.gridwidth = 2;
		gbc_step5Label.insets = new Insets(0, 0, 0, 5);
		gbc_step5Label.gridx = 0;
		gbc_step5Label.gridy = 6;
		add(step5Label, gbc_step5Label);


		/* ----- Text panes ----- */

		orderSummaryTextPane = new JTextPane();
		orderSummaryTextPane.setBackground(UIManager.getColor("Button.background"));
		orderSummaryTextPane.setForeground(new Color(34, 34, 34));
		orderSummaryTextPane.setFont(new Font("Roboto", Font.PLAIN, 14));
		orderSummaryTextPane.setMargin(new Insets(10, 10, 0, 0));
		orderSummaryTextPane.setEditable(false);
		GridBagConstraints gbc_orderSummaryTextPane = new GridBagConstraints();
		gbc_orderSummaryTextPane.fill = GridBagConstraints.BOTH;
		gbc_orderSummaryTextPane.insets = new Insets(0, 0, 5, 5);
		gbc_orderSummaryTextPane.gridx = 0;
		gbc_orderSummaryTextPane.gridy = 2;
		add(orderSummaryTextPane, gbc_orderSummaryTextPane);

		shippingSummaryTextPane = new JTextPane();
		shippingSummaryTextPane.setBackground(UIManager.getColor("Button.background"));
		shippingSummaryTextPane.setForeground(new Color(34, 34, 34));
		shippingSummaryTextPane.setFont(new Font("Roboto", Font.PLAIN, 14));
		shippingSummaryTextPane.setMargin(new Insets(10, 10, 0, 0));
		shippingSummaryTextPane.setEditable(false);
		GridBagConstraints gbc_shippingSummaryTextPane = new GridBagConstraints();
		gbc_shippingSummaryTextPane.insets = new Insets(0, 0, 5, 5);
		gbc_shippingSummaryTextPane.fill = GridBagConstraints.BOTH;
		gbc_shippingSummaryTextPane.gridx = 0;
		gbc_shippingSummaryTextPane.gridy = 4;
		add(shippingSummaryTextPane, gbc_shippingSummaryTextPane);
		

		/* ----- Button ----- */

		submitOrderButton = new JButton("SUBMIT ORDER");
		submitOrderButton.setFont(new Font("Roboto", Font.BOLD, 14));
		submitOrderButton.setOpaque(true);
		submitOrderButton.setBorderPainted(false);
		submitOrderButton.setForeground(Color.WHITE);
		submitOrderButton.setBackground(new Color(34, 34, 34));
		submitOrderButton.setPreferredSize(new Dimension(144, 40));
		submitOrderButton.setEnabled(false);
		submitOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitClicked();
			}
		});
		submitOrderButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				submitOrderButton.setForeground(new Color(34, 34, 34));
				submitOrderButton.setBackground(Color.decode("#ffff33"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				submitOrderButton.setForeground(Color.WHITE);
				submitOrderButton.setBackground(new Color(34, 34, 34));
			}
		});
		GridBagConstraints gbc_submitOrderButton = new GridBagConstraints();
		gbc_submitOrderButton.anchor = GridBagConstraints.SOUTH;
		gbc_submitOrderButton.insets = new Insets(0, 0, 5, 0);
		gbc_submitOrderButton.gridx = 1;
		gbc_submitOrderButton.gridy = 4;
		add(submitOrderButton, gbc_submitOrderButton);
		



	}

}
