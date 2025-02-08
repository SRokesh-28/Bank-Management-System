package DBconnection;
import java.sql.*;
public class AdminDB {

	public static boolean checkAdmin(String username,String password) {
		String query="select * from admin where username=? and password=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=ConnectionDB.getConnection();
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public static void displayDet() {
		String query="select * from customer";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=ConnectionDB.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.printf("| %-10s | %-10s | %-10s | %-18s | %-15s | %-15s | %-10s | %-10s | %-10s |\n", 
			                 "Column1", "Column2", "Column3", "Column4", "Column5", "Column6", "Column7", "Column8", "Column9");
			System.out.println("-----------------------------------------------------------------------------------------------------");

			while (rs.next()) {
			    System.out.printf("| %-10s | %-10s | %-10s | %-18s | %-15s | %-15s | %-10s | %-10s | %-10s |\n", 
			                     rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
			                     rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			    System.out.println("-------------------------------------------------------------------------------------------------");
			}

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static boolean removeAcc(int id) {
		String query="delete from customer where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=ConnectionDB.getConnection();
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1, id);
			int row=st.executeUpdate();
			if(row>0) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
