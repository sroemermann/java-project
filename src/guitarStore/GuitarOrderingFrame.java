package guitarStore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JLabel;


public class GuitarOrderingFrame extends JFrame {

	private static final long serialVersionUID = -5059681074134705782L;
	public JPanel contentPane;
	public JPanel middlePanel;
	public JPanel orderPanel;
	public AvailableGuitarInventory availableGuitars;
	public ShippingInfoPanel shippingInfoPanel;
	private JPanel paymentPanel;
	private JButton previousButton;
	private JButton nextButton;
	private JPanel summaryPanel;
	private JPanel loginPanel;
    private int currentCard = 0;
    
    private static final String[] cards = {"card1", "card2", "card3", "card4", "card5", "card6"}; 
    public static JLabel loggedInAsLabel;



	/* constructor */
	
	public GuitarOrderingFrame() throws SQLException, IOException {
		setTitle("Steve's Guitar Shop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setPreferredSize(new Dimension(1200, 800));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		/* ----- Middle panel ----- */

		middlePanel = new JPanel();
		middlePanel.setBackground(Color.WHITE);
		middlePanel.setPreferredSize(new Dimension(300, 600));
		contentPane.add(middlePanel, BorderLayout.CENTER);
		CardLayout cardLayout = new CardLayout();
		middlePanel.setLayout(cardLayout);
		
		loginPanel = new Login();
		middlePanel.add(loginPanel, "name_96631516116078");
		
		availableGuitars = new AvailableGuitarInventory();
		middlePanel.add(availableGuitars, "name_826430337561228");
		
		orderPanel = new OrderPanel();
		middlePanel.add(orderPanel, "name_840969744902115");
		
		shippingInfoPanel = new ShippingInfoPanel();
		middlePanel.add(shippingInfoPanel, "name_826430346779802");
		
		paymentPanel = new PaymentInfoPanel();
		middlePanel.add(paymentPanel, "name_841846409506699");
		
		summaryPanel = new OrderSummaryPanel();
		middlePanel.add(summaryPanel, "name_47918309228351");
		
		
		
		
		/* ----- Bottom panel ----- */
				
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.WHITE);
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_bottomPanel = new GridBagLayout();
		gbl_bottomPanel.columnWidths = new int[] {120, 400, 120};
		gbl_bottomPanel.rowHeights = new int[] {80};
		gbl_bottomPanel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_bottomPanel.rowWeights = new double[]{0.0};
		bottomPanel.setLayout(gbl_bottomPanel);
		
		
		/* Next button */
		
		nextButton = new JButton("NEXT");
		nextButton.setFont(new Font("Roboto", Font.BOLD, 13));
		nextButton.setOpaque(true);
		nextButton.setBorderPainted(false);
		nextButton.setForeground(Color.WHITE);
		nextButton.setBackground(new Color(34, 34, 34));
		nextButton.setPreferredSize(new Dimension(100, 40));
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                currentCard++;
                previousButton.setVisible(true);
                if(currentCard == cards.length - 1) {
                	nextButton.setText("EXIT");
    				cardLayout.next(middlePanel);
    				OrderSummaryPanel.updateSummaryPanels();
                } else if (currentCard >= cards.length) {
                		Main.frame.setVisible(false);
                    	Main.frame.dispose(); 
                } else {
    				cardLayout.next(middlePanel);
                }
			}
		});
		nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				nextButton.setForeground(new Color(34, 34, 34));
		    	nextButton.setBackground(Color.decode("#ffff33"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
				nextButton.setForeground(Color.WHITE);
		    	nextButton.setBackground(new Color(34, 34, 34));
		    }
		});
		
		
		/* login status label */
		
		loggedInAsLabel = new JLabel("Log in to place an order");
		loggedInAsLabel.setForeground(new Color(34, 34, 34));
		loggedInAsLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		GridBagConstraints gbc_loggedInAsLabel = new GridBagConstraints();
		gbc_loggedInAsLabel.insets = new Insets(0, 0, 0, 5);
		gbc_loggedInAsLabel.gridx = 1;
		gbc_loggedInAsLabel.gridy = 0;
		bottomPanel.add(loggedInAsLabel, gbc_loggedInAsLabel);
		GridBagConstraints gbc_nextButton = new GridBagConstraints();
		gbc_nextButton.anchor = GridBagConstraints.EAST;
		gbc_nextButton.gridx = 2;
		gbc_nextButton.gridy = 0;
		bottomPanel.add(nextButton, gbc_nextButton);
		
		
		/* Back button */
		
		previousButton = new JButton("BACK");
		previousButton.setFont(new Font("Roboto", Font.BOLD, 13));
		previousButton.setOpaque(true);
		previousButton.setBorderPainted(false);
		previousButton.setForeground(Color.WHITE);
		previousButton.setBackground(new Color(34, 34, 34));
		previousButton.setPreferredSize(new Dimension(100, 40));
		previousButton.setVisible(false);
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                currentCard--;
				if(currentCard == 0) previousButton.setVisible(false);
            	nextButton.setText("NEXT");
				cardLayout.previous(middlePanel);
			}
		});
		previousButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				previousButton.setForeground(new Color(34, 34, 34));
		    	previousButton.setBackground(Color.decode("#ffff33"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
				previousButton.setForeground(Color.WHITE);
				previousButton.setBackground(new Color(34, 34, 34));
		    }
		});
		
		GridBagConstraints gbc_previousButton = new GridBagConstraints();
		gbc_previousButton.anchor = GridBagConstraints.WEST;
		gbc_previousButton.insets = new Insets(0, 0, 0, 5);
		gbc_previousButton.gridx = 0;
		gbc_previousButton.gridy = 0;
		bottomPanel.add(previousButton, gbc_previousButton);


	}


}
