package guitarStore;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.UIManager;


public class AvailableGuitarInventory extends JPanel {

	private static final long serialVersionUID = 9078795146893697627L;
	private static final String USER_NAME = "root";
	private static final String PASS_WORD = "root";
	private static final String CONNECTION_STR = "jdbc:mysql://localhost:3306/GuitarStoreDatabase";
	private static final String QUERY = "SELECT * FROM Inventory";
	private JTextField tableSearchField;
	private TableRowSorter<DefaultTableModel> sorter;


	/* constructor */

	public AvailableGuitarInventory() throws SQLException {	

		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {400};
		gridBagLayout.rowHeights = new int[] {60, 30, 50, 240, 40};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);


		/* Get inventory from database */

		Connection conn = null;
		try
		{	Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASS_WORD);

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(QUERY); 

		String columns[] = { "Product ID", "Product Name", "Price", "In stock"};
		String data[][] = new String[25][4];

		int i = 0;
		while (rs.next()) {
			String productID = rs.getString("ProductID");
			String productName = rs.getString("ProductName");
			String productPrice = rs.getString("ProductPrice");
			String quantity = rs.getString("StockQuantity");
			data[i][0] = productID;
			data[i][1] = productName;
			data[i][2] = productPrice;
			data[i][3] = quantity;
			i++;
		}


		/* Table formatting */

		DefaultTableModel model = new DefaultTableModel(data, columns);
		sorter = new TableRowSorter<>(model);
		JTable table = new JTable(model);
		table.setRowSorter(sorter);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);	
		table.getColumnModel().getColumn(3).setPreferredWidth(50);	 
		table.setDefaultEditor(Object.class, null);

		table.setFont(new Font("Roboto", Font.PLAIN, 14));
		table.setBackground(Color.WHITE);
		table.setForeground(new Color(34, 34, 34));
		table.setRowHeight(28);
		table.setShowGrid(false);
		table.setShowVerticalLines(false);
		table.getTableHeader().setFont(new Font("Roboto", Font.PLAIN, 13));
		JScrollPane pane = new JScrollPane(table);
		pane.getViewport().setBackground(Color.WHITE);




		/* Labels and search field */

		JLabel catalogLabel = new JLabel("Available products");
		catalogLabel.setFont(new Font("Roboto", Font.BOLD, 30));
		catalogLabel.setForeground(new Color(34, 34, 34));
		GridBagConstraints gbc_catalogLabel = new GridBagConstraints();
		gbc_catalogLabel.anchor = GridBagConstraints.WEST;
		gbc_catalogLabel.insets = new Insets(0, 0, 5, 0);
		gbc_catalogLabel.gridx = 0;
		gbc_catalogLabel.gridy = 0;
		add(catalogLabel, gbc_catalogLabel);

		JLabel searchLabel = new JLabel("SEARCH");
		searchLabel.setForeground(new Color(34, 34, 34));
		searchLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		GridBagConstraints gbc_searchLabel = new GridBagConstraints();
		gbc_searchLabel.insets = new Insets(0, 0, 5, 0);
		gbc_searchLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_searchLabel.gridx = 0;
		gbc_searchLabel.gridy = 1;
		add(searchLabel, gbc_searchLabel);

		JLabel step1Label = new JLabel("Step 1 of 5");
		step1Label.setForeground(new Color(34, 34, 34));
		step1Label.setFont(new Font("Roboto", Font.BOLD, 14));
		GridBagConstraints gbc_step1Label = new GridBagConstraints();
		gbc_step1Label.gridx = 0;
		gbc_step1Label.gridy = 4;
		add(step1Label, gbc_step1Label);

		tableSearchField = new JTextField();
		tableSearchField.setForeground(new Color(34, 34, 34));
		tableSearchField.setFont(new Font("Roboto", Font.PLAIN, 14));
		tableSearchField.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_tableSearchField = new GridBagConstraints();
		gbc_tableSearchField.insets = new Insets(0, 0, 5, 0);
		gbc_tableSearchField.fill = GridBagConstraints.BOTH;
		gbc_tableSearchField.gridx = 0;
		gbc_tableSearchField.gridy = 2;
		add(tableSearchField, gbc_tableSearchField);
		tableSearchField.setColumns(10);

		tableSearchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search(tableSearchField.getText());
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				search(tableSearchField.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				search(tableSearchField.getText());
			}
			public void search(String str) {
				if (str.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" +str));
				}
			}
		});
		GridBagConstraints gbc_pane = new GridBagConstraints();
		gbc_pane.insets = new Insets(0, 0, 5, 0);
		gbc_pane.fill = GridBagConstraints.HORIZONTAL;
		gbc_pane.anchor = GridBagConstraints.NORTHWEST;
		gbc_pane.gridx = 0;
		gbc_pane.gridy = 3;
		this.add(pane, gbc_pane);

		rs.close();
		conn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


	}

}



