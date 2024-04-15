package guitarStore;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Login extends JPanel {

	private static final long serialVersionUID = 5020674848455540219L;
	private JTextField userNameField;
	private JTextField newUserNameField;
	private JPasswordField newPasswordField;
	private JPasswordField passwordField;
	JLabel loginMessageLabel;
	JLabel newUserMessageLabel;
	JButton loginButton;
	JButton createNewUserButton;
    private BufferedImage image;
    Border border = BorderFactory.createLineBorder(Color.decode("#ffff33"));
    private JLabel createAccountLabel;

	
	

	/* constructor */
	
	public Login() {
		setPreferredSize(new Dimension(1200, 800));
	
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {240, 120, 240};
		gridBagLayout.rowHeights = new int[] {30, 40, 20, 30, 50, 30, 50, 60, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
	     URL resource = getClass().getResource("/lightning-bg.jpg");
	        try {
	            image = ImageIO.read(resource);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }



		
		/* ----- Login panel ----- */
		
		/* Labels */
		
		JLabel loginLabel = new JLabel("Login");
		GridBagConstraints gbc_loginLabel = new GridBagConstraints();
		gbc_loginLabel.gridheight = 2;
		gbc_loginLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_loginLabel.insets = new Insets(0, 0, 5, 5);
		gbc_loginLabel.gridx = 0;
		gbc_loginLabel.gridy = 1;
		add(loginLabel, gbc_loginLabel);
		loginLabel.setForeground(Color.WHITE);
		loginLabel.setFont(new Font("Roboto", Font.BOLD, 30));
		
		createAccountLabel = new JLabel("Create an account:");
		createAccountLabel.setForeground(Color.WHITE);
		createAccountLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		GridBagConstraints gbc_createAccountLabel = new GridBagConstraints();
		gbc_createAccountLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_createAccountLabel.insets = new Insets(0, 0, 5, 0);
		gbc_createAccountLabel.gridx = 2;
		gbc_createAccountLabel.gridy = 2;
		add(createAccountLabel, gbc_createAccountLabel);
		
		JLabel userNameLabel = new JLabel("USERNAME");
		GridBagConstraints gbc_userNameLabel = new GridBagConstraints();
		gbc_userNameLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_userNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userNameLabel.gridx = 0;
		gbc_userNameLabel.gridy = 3;
		add(userNameLabel, gbc_userNameLabel);
		userNameLabel.setForeground(Color.WHITE);
		userNameLabel.setFont(new Font("Roboto", Font.BOLD, 12));
		
		loginMessageLabel = new JLabel("");
		GridBagConstraints gbc_loginMessageLabel = new GridBagConstraints();
		gbc_loginMessageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_loginMessageLabel.gridx = 0;
		gbc_loginMessageLabel.gridy = 8;
		add(loginMessageLabel, gbc_loginMessageLabel);
		loginMessageLabel.setForeground(Color.WHITE);
		loginMessageLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 5;
		add(passwordLabel, gbc_passwordLabel);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Roboto", Font.BOLD, 12));
		
		
		/* Fields */
		
		userNameField = new JTextField();
		userNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				loginMessageLabel.setText("");
			}
		});
		GridBagConstraints gbc_userNameField = new GridBagConstraints();
		gbc_userNameField.fill = GridBagConstraints.BOTH;
		gbc_userNameField.insets = new Insets(0, 0, 5, 5);
		gbc_userNameField.gridx = 0;
		gbc_userNameField.gridy = 4;
		add(userNameField, gbc_userNameField);
		userNameField.setForeground(new Color(34, 34, 34));
		userNameField.setFont(new Font("Roboto", Font.PLAIN, 12));
		userNameField.setBackground(Color.WHITE);
		userNameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				loginMessageLabel.setText("");
			}
		});
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 6;
		add(passwordField, gbc_passwordField);
		passwordField.setForeground(new Color(34, 34, 34));
		passwordField.setFont(new Font("Roboto", Font.PLAIN, 12));
		passwordField.setBackground(Color.WHITE);
		

		
		
		/* Button */
		
		loginButton = new JButton("LOGIN");
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.anchor = GridBagConstraints.SOUTH;
		gbc_loginButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_loginButton.insets = new Insets(0, 0, 5, 5);
		gbc_loginButton.gridx = 0;
		gbc_loginButton.gridy = 7;
		add(loginButton, gbc_loginButton);
		loginButton.setFont(new Font("Roboto", Font.BOLD, 12));
		loginButton.setBorder(border);
		loginButton.setOpaque(true);
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(new Color(34, 34, 34));
		loginButton.setPreferredSize(new Dimension(90, 40));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((userNameField.getText().isEmpty()) || (passwordField.getPassword().length == 0)) {
					loginMessageLabel.setText("Fields cannot be blank");
				} else {
					User newUser = new User();
					String passText = new String(passwordField.getPassword());
					String msg = newUser.validateUser(userNameField.getText(), passText);
					loginMessageLabel.setText(msg);
				}
			}
		});
		loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				loginButton.setForeground(new Color(34, 34, 34));
		    	loginButton.setBackground(Color.decode("#ffff33"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
				loginButton.setForeground(Color.WHITE);
		    	loginButton.setBackground(new Color(34, 34, 34));
		    }
		});
		
		
		
		
		/* ----- New user section ----- */
		
		/* labels */
		
		JLabel newUserLabel = new JLabel("New user?");
		GridBagConstraints gbc_newUserLabel = new GridBagConstraints();
		gbc_newUserLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_newUserLabel.insets = new Insets(0, 0, 5, 0);
		gbc_newUserLabel.gridx = 2;
		gbc_newUserLabel.gridy = 1;
		add(newUserLabel, gbc_newUserLabel);
		newUserLabel.setForeground(Color.WHITE);
		newUserLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		
		JLabel newUserNameLabel = new JLabel("NEW USERNAME");
		GridBagConstraints gbc_newUserNameLabel = new GridBagConstraints();
		gbc_newUserNameLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_newUserNameLabel.insets = new Insets(0, 0, 5, 0);
		gbc_newUserNameLabel.gridx = 2;
		gbc_newUserNameLabel.gridy = 3;
		add(newUserNameLabel, gbc_newUserNameLabel);
		newUserNameLabel.setForeground(Color.WHITE);
		newUserNameLabel.setFont(new Font("Roboto", Font.BOLD, 12));
		
		JLabel createPasswordLabel = new JLabel("PASSWORD");
		GridBagConstraints gbc_createPasswordLabel = new GridBagConstraints();
		gbc_createPasswordLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_createPasswordLabel.insets = new Insets(0, 0, 5, 0);
		gbc_createPasswordLabel.gridx = 2;
		gbc_createPasswordLabel.gridy = 5;
		add(createPasswordLabel, gbc_createPasswordLabel);
		createPasswordLabel.setForeground(Color.WHITE);
		createPasswordLabel.setFont(new Font("Roboto", Font.BOLD, 12));
		
		newUserMessageLabel = new JLabel("");
		GridBagConstraints gbc_newUserMessageLabel = new GridBagConstraints();
		gbc_newUserMessageLabel.insets = new Insets(0, 0, 5, 0);
		gbc_newUserMessageLabel.gridx = 2;
		gbc_newUserMessageLabel.gridy = 8;
		add(newUserMessageLabel, gbc_newUserMessageLabel);
		newUserMessageLabel.setForeground(Color.WHITE);
		newUserMessageLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		
		
		/* fields */
		
		newUserNameField = new JTextField();
		newUserNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				newUserMessageLabel.setText("");
			}
		});
		GridBagConstraints gbc_newUserNameField = new GridBagConstraints();
		gbc_newUserNameField.fill = GridBagConstraints.BOTH;
		gbc_newUserNameField.insets = new Insets(0, 0, 5, 0);
		gbc_newUserNameField.gridx = 2;
		gbc_newUserNameField.gridy = 4;
		add(newUserNameField, gbc_newUserNameField);
		newUserNameField.setForeground(new Color(34, 34, 34));
		newUserNameField.setFont(new Font("Roboto", Font.PLAIN, 12));
		newUserNameField.setBackground(Color.WHITE);
		newUserNameField.setColumns(10);
		
		newPasswordField = new JPasswordField();
		newPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				newUserMessageLabel.setText("");
			}
		});
		GridBagConstraints gbc_newPasswordField = new GridBagConstraints();
		gbc_newPasswordField.fill = GridBagConstraints.BOTH;
		gbc_newPasswordField.insets = new Insets(0, 0, 5, 0);
		gbc_newPasswordField.gridx = 2;
		gbc_newPasswordField.gridy = 6;
		add(newPasswordField, gbc_newPasswordField);
		newPasswordField.setForeground(new Color(34, 34, 34));
		newPasswordField.setFont(new Font("Roboto", Font.PLAIN, 12));
		newPasswordField.setBackground(Color.WHITE);
		
		
		/* Button */
		
		createNewUserButton = new JButton("CREATE ACCOUNT");
		GridBagConstraints gbc_createNewUserButton = new GridBagConstraints();
		gbc_createNewUserButton.anchor = GridBagConstraints.SOUTH;
		gbc_createNewUserButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_createNewUserButton.insets = new Insets(0, 0, 5, 0);
		gbc_createNewUserButton.gridx = 2;
		gbc_createNewUserButton.gridy = 7;
		add(createNewUserButton, gbc_createNewUserButton);
		createNewUserButton.setFont(new Font("Roboto", Font.BOLD, 12));
		createNewUserButton.setOpaque(true);
		createNewUserButton.setBorder(border);
		createNewUserButton.setForeground(Color.WHITE);
		createNewUserButton.setBackground(new Color(34, 34, 34));
		createNewUserButton.setPreferredSize(new Dimension(150, 40));
		createNewUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((newUserNameField.getText().isEmpty()) || (newPasswordField.getPassword().length == 0)) {
					newUserMessageLabel.setText("Fields cannot be blank");
				} else {
					User newUser = new User(); 
					String passText2 = new String(newPasswordField.getPassword());
					String msg2 = newUser.createNewUser(newUserNameField.getText(), passText2);
					newUserMessageLabel.setText(msg2);
				}
			}
		});
		createNewUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				createNewUserButton.setForeground(new Color(34, 34, 34));
		    	createNewUserButton.setBackground(Color.decode("#ffff33"));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
				createNewUserButton.setForeground(Color.WHITE);
		    	createNewUserButton.setBackground(new Color(34, 34, 34));
		    }
		});
		

	}
	
		/* background image */
	
	   public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 3, 4, this);
	    }

}
