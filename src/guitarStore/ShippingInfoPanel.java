package guitarStore;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ShippingInfoPanel extends JPanel {


	private static final long serialVersionUID = 6011791850789623063L;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField cityField;
	private JTextField postalField;
	private JTextField phoneField;
	private JTextField emailField;
	private JComboBox<String> provinceComboBox;
	JLabel shippingConfirmationLabel;
	private JButton shippingEnterButton;
	private JLabel step3Label;




	/* constructor */

	public ShippingInfoPanel() {

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(513, 653));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {250, 250};
		gridBagLayout.rowHeights = new int[] {60, 30, 50, 30, 50, 30, 50, 30, 50, 30, 50, 30, 50, 40};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);


		/* ----- Labels ----- */

		JLabel shippingLabel = new JLabel("Shipping information");
		shippingLabel.setFont(new Font("Roboto", Font.BOLD, 30));
		shippingLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_shippingLabel = new GridBagConstraints();
		gbc_shippingLabel.anchor = GridBagConstraints.WEST;
		gbc_shippingLabel.gridwidth = 2;
		gbc_shippingLabel.insets = new Insets(0, 0, 5, 0);
		gbc_shippingLabel.gridx = 0;
		gbc_shippingLabel.gridy = 0;
		add(shippingLabel, gbc_shippingLabel);

		JLabel name = new JLabel("FULL NAME");
		name.setFont(new Font("Roboto", Font.PLAIN, 12));
		name.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.anchor = GridBagConstraints.SOUTH;
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 0;
		gbc_name.gridy = 1;
		add(name, gbc_name);

		JLabel addressLabel = new JLabel("STREET ADDRESS");
		addressLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		addressLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.anchor = GridBagConstraints.SOUTH;
		gbc_addressLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addressLabel.gridx = 0;
		gbc_addressLabel.gridy = 3;
		add(addressLabel, gbc_addressLabel);

		JLabel cityLabel = new JLabel("CITY");
		cityLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		cityLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_cityLabel = new GridBagConstraints();
		gbc_cityLabel.anchor = GridBagConstraints.SOUTH;
		gbc_cityLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_cityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cityLabel.gridx = 0;
		gbc_cityLabel.gridy = 5;
		add(cityLabel, gbc_cityLabel);

		JLabel provinceLabel = new JLabel("PROVINCE");
		provinceLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		provinceLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_provinceLabel = new GridBagConstraints();
		gbc_provinceLabel.anchor = GridBagConstraints.SOUTH;
		gbc_provinceLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_provinceLabel.insets = new Insets(0, 0, 5, 0);
		gbc_provinceLabel.gridx = 1;
		gbc_provinceLabel.gridy = 5;
		add(provinceLabel, gbc_provinceLabel);

		JLabel postalLabel = new JLabel("POSTAL CODE");
		postalLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		postalLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_postalLabel = new GridBagConstraints();
		gbc_postalLabel.anchor = GridBagConstraints.SOUTH;
		gbc_postalLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_postalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_postalLabel.gridx = 0;
		gbc_postalLabel.gridy = 7;
		add(postalLabel, gbc_postalLabel);

		JLabel phoneLabel = new JLabel("PHONE");
		phoneLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		phoneLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
		gbc_phoneLabel.anchor = GridBagConstraints.SOUTH;
		gbc_phoneLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_phoneLabel.gridx = 1;
		gbc_phoneLabel.gridy = 7;
		add(phoneLabel, gbc_phoneLabel);

		JLabel emailLabel = new JLabel("EMAIL");
		emailLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		emailLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.SOUTH;
		gbc_emailLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 9;
		add(emailLabel, gbc_emailLabel);

		shippingConfirmationLabel = new JLabel("");
		shippingConfirmationLabel.setFont(new Font("Roboto", Font.ITALIC, 12));
		shippingConfirmationLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_shippingConfirmationLabel = new GridBagConstraints();
		gbc_shippingConfirmationLabel.gridwidth = 3;
		gbc_shippingConfirmationLabel.insets = new Insets(0, 0, 5, 0);
		gbc_shippingConfirmationLabel.gridx = 0;
		gbc_shippingConfirmationLabel.gridy = 11;
		add(shippingConfirmationLabel, gbc_shippingConfirmationLabel);

		step3Label = new JLabel("Step 3 of 5");
		step3Label.setForeground(new Color(34, 34, 34));
		step3Label.setFont(new Font("Roboto", Font.BOLD, 14));
		GridBagConstraints gbc_step3Label = new GridBagConstraints();
		gbc_step3Label.gridwidth = 3;
		gbc_step3Label.gridx = 0;
		gbc_step3Label.gridy = 13;
		add(step3Label, gbc_step3Label);




		/* ----- Fields ----- */

		nameField = new JTextField();
		nameField.setForeground(new Color(34, 34, 34));
		nameField.setFont(new Font("Roboto", Font.PLAIN, 14));
		nameField.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.gridwidth = 2;
		gbc_nameField.fill = GridBagConstraints.BOTH;
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.gridx = 0;
		gbc_nameField.gridy = 2;
		add(nameField, gbc_nameField);
		nameField.setColumns(10);

		addressField = new JTextField();
		addressField.setForeground(new Color(34, 34, 34));
		addressField.setFont(new Font("Roboto", Font.PLAIN, 14));
		addressField.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_addressField = new GridBagConstraints();
		gbc_addressField.gridwidth = 2;
		gbc_addressField.fill = GridBagConstraints.BOTH;
		gbc_addressField.insets = new Insets(0, 0, 5, 0);
		gbc_addressField.gridx = 0;
		gbc_addressField.gridy = 4;
		add(addressField, gbc_addressField);
		addressField.setColumns(10);

		cityField = new JTextField();
		cityField.setForeground(new Color(34, 34, 34));
		cityField.setFont(new Font("Roboto", Font.PLAIN, 14));
		cityField.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_cityField = new GridBagConstraints();
		gbc_cityField.fill = GridBagConstraints.BOTH;
		gbc_cityField.insets = new Insets(0, 0, 5, 5);
		gbc_cityField.gridx = 0;
		gbc_cityField.gridy = 6;
		add(cityField, gbc_cityField);
		cityField.setColumns(10);

		postalField = new JTextField();
		postalField.setForeground(new Color(34, 34, 34));
		postalField.setFont(new Font("Roboto", Font.PLAIN, 14));
		postalField.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_postalField = new GridBagConstraints();
		gbc_postalField.fill = GridBagConstraints.BOTH;
		gbc_postalField.insets = new Insets(0, 0, 5, 5);
		gbc_postalField.gridx = 0;
		gbc_postalField.gridy = 8;
		add(postalField, gbc_postalField);
		postalField.setColumns(10);

		provinceComboBox = new JComboBox<>();
		provinceComboBox.setForeground(new Color(34, 34, 34));
		provinceComboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
		provinceComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"AB", "BC", "MB", "NB", "NL", "NT", "NS", "NU", "ON", "PE", "QC", "SK", "YT"}));
		GridBagConstraints gbc_provinceComboBox = new GridBagConstraints();
		gbc_provinceComboBox.fill = GridBagConstraints.BOTH;
		gbc_provinceComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_provinceComboBox.gridx = 1;
		gbc_provinceComboBox.gridy = 6;
		add(provinceComboBox, gbc_provinceComboBox);

		phoneField = new JTextField();
		phoneField.setForeground(new Color(34, 34, 34));
		phoneField.setFont(new Font("Roboto", Font.PLAIN, 14));
		phoneField.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_phoneField = new GridBagConstraints();
		gbc_phoneField.fill = GridBagConstraints.BOTH;
		gbc_phoneField.insets = new Insets(0, 0, 5, 0);
		gbc_phoneField.gridx = 1;
		gbc_phoneField.gridy = 8;
		add(phoneField, gbc_phoneField);
		phoneField.setColumns(10);

		emailField = new JTextField();
		emailField.setForeground(new Color(34, 34, 34));
		emailField.setFont(new Font("Roboto", Font.PLAIN, 14));
		emailField.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.gridwidth = 2;
		gbc_emailField.fill = GridBagConstraints.BOTH;
		gbc_emailField.insets = new Insets(0, 0, 5, 0);
		gbc_emailField.gridx = 0;
		gbc_emailField.gridy = 10;
		add(emailField, gbc_emailField);
		emailField.setColumns(10);


		/* ----- Button ----- */

		shippingEnterButton = new JButton("ENTER");
		shippingEnterButton.setFont(new Font("Roboto", Font.BOLD, 12));
		shippingEnterButton.setOpaque(true);
		shippingEnterButton.setBorderPainted(false);
		shippingEnterButton.setForeground(Color.WHITE);
		shippingEnterButton.setBackground(new Color(34, 34, 34));
		shippingEnterButton.setPreferredSize(new Dimension(100, 40));
		shippingEnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((nameField.getText().isEmpty()) || (addressField.getText().isEmpty()) || (emailField.getText().isEmpty()) || (phoneField.getText().isEmpty()) || (cityField.getText().isEmpty()) || (postalField.getText().isEmpty()) ) {
					shippingConfirmationLabel.setText("Fields cannot be blank");
				} else {
					Main.cart.setShippingName(nameField.getText());
					Main.cart.setShippingAddress(addressField.getText());
					Main.cart.setCity(cityField.getText());
					Main.cart.setPostalCode(postalField.getText());
					Main.cart.setShippingPhone(phoneField.getText());
					Main.cart.setShippingEmail(emailField.getText());
					Main.cart.setProvince(provinceComboBox.getSelectedItem().toString());
					shippingConfirmationLabel.setText("Shipping info submitted");
				}

			}
		});
		shippingEnterButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				shippingEnterButton.setForeground(new Color(34, 34, 34));
				shippingEnterButton.setBackground(Color.decode("#ffff33"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				shippingEnterButton.setForeground(Color.WHITE);
				shippingEnterButton.setBackground(new Color(34, 34, 34));
			}
		});

		GridBagConstraints gbc_shippingEnterButton = new GridBagConstraints();
		gbc_shippingEnterButton.insets = new Insets(0, 0, 5, 0);
		gbc_shippingEnterButton.gridwidth = 3;
		gbc_shippingEnterButton.gridx = 0;
		gbc_shippingEnterButton.gridy = 12;
		add(shippingEnterButton, gbc_shippingEnterButton);



	}

}
