package guitarStore;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class PaymentInfoPanel extends JPanel implements KeyListener {

	private static final long serialVersionUID = -8414496622854954900L;
	private JTextField paymentNameField;
	private JTextField creditCardNumberField;
	private JLabel creditCardType;
	JLabel paymentInfoSubmittedLabel;
	
	public PaymentInfoPanel() {
		

		
		setBackground(Color.WHITE);
		GridBagLayout gbl_paymentPanel = new GridBagLayout();
		gbl_paymentPanel.columnWidths = new int[] {250, 250};
		gbl_paymentPanel.rowHeights = new int[] {60, 30, 50, 30, 50, 30, 50, 40, 50, 40};
		gbl_paymentPanel.columnWeights = new double[]{0.0, 0.0};
		gbl_paymentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gbl_paymentPanel);
		
		
		/* ----- Labels ----- */
		
		JLabel paymentInfoLabel = new JLabel("Payment information");
		paymentInfoLabel.setFont(new Font("Roboto", Font.BOLD, 30));
		paymentInfoLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_paymentInfoLabel = new GridBagConstraints();
		gbc_paymentInfoLabel.anchor = GridBagConstraints.WEST;
		gbc_paymentInfoLabel.gridwidth = 2;
		gbc_paymentInfoLabel.insets = new Insets(0, 0, 5, 0);
		gbc_paymentInfoLabel.gridx = 0;
		gbc_paymentInfoLabel.gridy = 0;
		add(paymentInfoLabel, gbc_paymentInfoLabel);
		
		JLabel paymentNameLabel = new JLabel("FULL NAME");
		paymentNameLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		paymentNameLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_paymentNameLabel = new GridBagConstraints();
		gbc_paymentNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_paymentNameLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_paymentNameLabel.gridx = 0;
		gbc_paymentNameLabel.gridy = 1;
		add(paymentNameLabel, gbc_paymentNameLabel);
		
		JLabel creditCardNumberLabel = new JLabel("CREDIT CARD NUMBER");
		creditCardNumberLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		creditCardNumberLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_creditCardNumberLabel = new GridBagConstraints();
		gbc_creditCardNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_creditCardNumberLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_creditCardNumberLabel.gridx = 0;
		gbc_creditCardNumberLabel.gridy = 3;
		add(creditCardNumberLabel, gbc_creditCardNumberLabel);
		
		JLabel cvvLabel = new JLabel("CVV");
		cvvLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		cvvLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_cvvLabel = new GridBagConstraints();
		gbc_cvvLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cvvLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_cvvLabel.gridx = 0;
		gbc_cvvLabel.gridy = 5;
		add(cvvLabel, gbc_cvvLabel);
		
		JLabel expiryLabel = new JLabel("EXPIRY");
		expiryLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		expiryLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_expiryLabel = new GridBagConstraints();
		gbc_expiryLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_expiryLabel.insets = new Insets(0, 0, 5, 0);
		gbc_expiryLabel.gridx = 1;
		gbc_expiryLabel.gridy = 5;
		add(expiryLabel, gbc_expiryLabel);
		
		paymentInfoSubmittedLabel = new JLabel("");
		paymentInfoSubmittedLabel.setFont(new Font("Roboto", Font.ITALIC, 12));
		paymentInfoSubmittedLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_paymentInfoSubmittedLabel = new GridBagConstraints();
		gbc_paymentInfoSubmittedLabel.gridwidth = 2;
		gbc_paymentInfoSubmittedLabel.insets = new Insets(0, 0, 5, 0);
		gbc_paymentInfoSubmittedLabel.gridx = 0;
		gbc_paymentInfoSubmittedLabel.gridy = 7;
		add(paymentInfoSubmittedLabel, gbc_paymentInfoSubmittedLabel);
		
		creditCardType = new JLabel("");
		creditCardType.setFont(new Font("Roboto", Font.PLAIN, 14));
		creditCardType.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_creditCardType = new GridBagConstraints();
		gbc_creditCardType.anchor = GridBagConstraints.SOUTHEAST;
		gbc_creditCardType.insets = new Insets(0, 0, 5, 0);
		gbc_creditCardType.gridx = 1;
		gbc_creditCardType.gridy = 3;
		add(creditCardType, gbc_creditCardType);
		
		JLabel step4Label = new JLabel("Step 4 of 5");
		step4Label.setForeground(new Color(34, 34, 34));
		step4Label.setFont(new Font("Roboto", Font.BOLD, 14));
		GridBagConstraints gbc_step4Label = new GridBagConstraints();
		gbc_step4Label.gridwidth = 2;
		gbc_step4Label.insets = new Insets(0, 0, 0, 5);
		gbc_step4Label.gridx = 0;
		gbc_step4Label.gridy = 9;
		add(step4Label, gbc_step4Label);
		
		
		/* ----- Fields ----- */
		
		paymentNameField = new JTextField();
		paymentNameField.setForeground(new Color(34, 34, 34));
		paymentNameField.setFont(new Font("Roboto", Font.PLAIN, 14));
		paymentNameField.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_paymentNameField = new GridBagConstraints();
		gbc_paymentNameField.gridwidth = 2;
		gbc_paymentNameField.insets = new Insets(0, 0, 5, 0);
		gbc_paymentNameField.fill = GridBagConstraints.BOTH;
		gbc_paymentNameField.gridx = 0;
		gbc_paymentNameField.gridy = 2;
		add(paymentNameField, gbc_paymentNameField);
		paymentNameField.setColumns(10);
		
		creditCardNumberField = new JTextField();
		creditCardNumberField.setForeground(new Color(34, 34, 34));
		creditCardNumberField.setFont(new Font("Roboto", Font.PLAIN, 14));
		creditCardNumberField.setBackground(UIManager.getColor("Button.background"));
		creditCardNumberField.addKeyListener(this);
		GridBagConstraints gbc_creditCardNumberField = new GridBagConstraints();
		gbc_creditCardNumberField.gridwidth = 2;
		gbc_creditCardNumberField.insets = new Insets(0, 0, 5, 0);
		gbc_creditCardNumberField.fill = GridBagConstraints.BOTH;
		gbc_creditCardNumberField.gridx = 0;
		gbc_creditCardNumberField.gridy = 4;
		add(creditCardNumberField, gbc_creditCardNumberField);
		creditCardNumberField.setColumns(10);
		
		JTextField cvvField = new JTextField();
		cvvField.setForeground(new Color(34, 34, 34));
		cvvField.setFont(new Font("Roboto", Font.PLAIN, 14));
		cvvField.setBackground(SystemColor.window);
		GridBagConstraints gbc_cvvField = new GridBagConstraints();
		gbc_cvvField.insets = new Insets(0, 0, 5, 5);
		gbc_cvvField.fill = GridBagConstraints.BOTH;
		gbc_cvvField.gridx = 0;
		gbc_cvvField.gridy = 6;
		add(cvvField, gbc_cvvField);
		cvvField.setColumns(10);
		
		JTextField expiryField = new JTextField();
		expiryField.setForeground(new Color(34, 34, 34));
		expiryField.setFont(new Font("Roboto", Font.PLAIN, 14));
		expiryField.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_expiryField = new GridBagConstraints();
		gbc_expiryField.insets = new Insets(0, 0, 5, 0);
		gbc_expiryField.fill = GridBagConstraints.BOTH;
		gbc_expiryField.gridx = 1;
		gbc_expiryField.gridy = 6;
		add(expiryField, gbc_expiryField);
		expiryField.setColumns(10);
		
		
		/* ----- Buttons ----- */
		
		JButton paymentEnterButton = new JButton("ENTER");
		paymentEnterButton.setFont(new Font("Roboto", Font.BOLD, 12));
		paymentEnterButton.setOpaque(true);
		paymentEnterButton.setBorderPainted(false);
		paymentEnterButton.setForeground(Color.WHITE);
		paymentEnterButton.setBackground(new Color(34, 34, 34));
		paymentEnterButton.setPreferredSize(new Dimension(100, 40));
		paymentEnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((paymentNameField.getText().isEmpty()) || (creditCardNumberField.getText().isEmpty()) || (cvvField.getText().isEmpty()) || (expiryField.getText().isEmpty()) ) {
					paymentInfoSubmittedLabel.setText("Fields cannot be blank");
				} else {
					Main.cart.setPaymentName(paymentNameField.getText());
					paymentInfoSubmittedLabel.setText("Payment info submitted");
				}
			}
			});
		paymentEnterButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				paymentEnterButton.setForeground(new Color(34, 34, 34));
				paymentEnterButton.setBackground(Color.decode("#ffff33"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
				paymentEnterButton.setForeground(Color.WHITE);
				paymentEnterButton.setBackground(new Color(34, 34, 34));
		    }
		});
	
		GridBagConstraints gbc_paymentEnterButton = new GridBagConstraints();
		gbc_paymentEnterButton.insets = new Insets(0, 0, 5, 0);
		gbc_paymentEnterButton.gridwidth = 2;
		gbc_paymentEnterButton.gridx = 0;
		gbc_paymentEnterButton.gridy = 8;
		add(paymentEnterButton, gbc_paymentEnterButton);
		
	}
	
	/* Credit card type method */
	
	@Override
	public void keyTyped(KeyEvent e) {	
		String content = creditCardNumberField.getText();
		if(content.startsWith("2")) {
			creditCardType.setText("MASTERCARD");
		} else if (content.startsWith("5")) {
			creditCardType.setText("MASTERCARD");
		} else if (content.startsWith("4")) {
			creditCardType.setText("VISA");		
		} else if (content.startsWith("3")) {
			creditCardType.setText("AMEX");
		} else {
			creditCardType.setText(" ");					
		}		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub	
	}





}


