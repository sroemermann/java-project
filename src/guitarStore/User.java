package guitarStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {

	private static int userCount = 100;
	private static int userID;
	private static String userName;
	private char[] password;


	/* constructor */

	public User() {
		super();
	}


	/* getters and setters */

	public static int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		User.userID = userID;
	}
	public static String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		User.userName = userName;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public static int getUserCount() {
		return userCount;
	}


	/* User methods */

	private static final String USER_NAME = "root";
	private static final String PASS_WORD = "root";
	private static final String CONNECTION_STR = "jdbc:mysql://localhost:3306/GuitarStoreDatabase";

	String msg;

	public String validateUser(String u, String pw) {

		Connection conn = null;

		try
		{	Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASS_WORD);	

		String sql = "SELECT * FROM Users WHERE UserName = '" + u + "'"; 

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql); 

		if (rs.next()) {
			String existingUserID = rs.getString(1);
			String usernameAttempt = rs.getString(2);
			String passwordAttempt = rs.getString(3);

			if ((usernameAttempt.equals(u)) && (passwordAttempt.equals(pw))) {
				int num = Integer.parseInt(existingUserID);
				this.setUserID(num);
				this.setUserName(usernameAttempt);
				msg = "Login successful";
				GuitarOrderingFrame.loggedInAsLabel.setText("Logged in as " + User.getUserName());
			} else {
				msg = "Incorrect password";
			}		 			
		} else {
			msg = "There is no user by that name";
		}

		rs.close();
		conn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return msg;		
	}



	public String createNewUser(String u, String pw) {

		String msg2 = "";

		Connection conn = null;

		try
		{	Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASS_WORD);	

		String sql = "SELECT UserID FROM Users WHERE UserName = '" + u + "';";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);


		if (rs.next()) {
			msg2 = "That username is already taken";
			
		} else if (u.length() >= 50){
			msg2 = "That username is too long";

		} else {	

			try {

				String sql2 = "SELECT UserID FROM Users ORDER BY UserID DESC LIMIT 1;";

				Statement stmt2 = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
				ResultSet rs2 = stmt2.executeQuery(sql2); 

				if (rs2.next()) {
					String existingUserID = rs2.getString(1);
					int num = Integer.parseInt(existingUserID);
					num++;
					this.setUserID(num);
				} else {
					this.setUserID(1000);
				}

				char[] newPassword = new char[pw.length()];
				for (int i = 0; i < pw.length(); i++) {
					newPassword[i] = pw.charAt(i);
				}

				this.setPassword(newPassword);
				this.setUserName(u);

				try {					
					String sql3 = "INSERT INTO Users (UserID, UserName, UserPassword) VALUES (?, ?, ?)";

					PreparedStatement pstmt = conn.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);

					pstmt.setInt(1, userID);
					pstmt.setString(2, userName);
					pstmt.setString(3, new String(password));

					int rowAffected = pstmt.executeUpdate(); 
					if(rowAffected == 1) {
						msg2 = "New account created!";
						GuitarOrderingFrame.loggedInAsLabel.setText("Logged in as " + User.getUserName());
					} else {
						msg2 = "It didn't work this time";
					}

				} catch (SQLException e) {
					e.printStackTrace();
				} 

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 

		conn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return msg2;

	}

}
