package DBconnection;

import java.sql.*;

import ConsoleApp.com.Account;

public class UserDB {
	
	Account accountBook=new Account();
	
	public static void dbConnection(Account accountBook) {
    String query="insert into customer (Name,Pass_Word,Email,AccountNO,Aadhear,Balance,Age,PhoneNO) values (?,?,?,?,?,?,?,?)";
    String query1 = "SELECT id FROM customer WHERE Name='" + accountBook.getName() + "' AND Pass_Word='" + accountBook.getPass_Word() + "';";
    String accNo = "";
   try {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   
	   Connection conn=ConnectionDB.getConnection();
	   PreparedStatement pst=conn.prepareStatement(query);
	   Statement st=conn.createStatement();
	   
	   pst.setString(1, accountBook.getName());
	   pst.setString(2, accountBook.getPass_Word());
	   pst.setString(3, accountBook.getEmail());
	   pst.setInt(4, accountBook.getAccountNO());
	   pst.setString(5, accountBook.getAadhear());
	   pst.setInt(6, accountBook.getBalance());
	   pst.setInt(7, accountBook.getAge());
	   pst.setString(8, accountBook.getPhoneNO());
       int row= pst.executeUpdate();
       ResultSet rs=st.executeQuery(query1);
       if(row>0) {
    	   while(rs.next()) {
    		   accNo=rs.getString(1);
    	   }
       }
	   if(row>0) {
		   
		   System.out.println("Account Created Successfully...!");
		   System.out.println("-----------------------------------");

		   System.out.printf("| %-15s : %-12s |\n", "Your ID", String.valueOf(accNo));
		   System.out.printf("| %-15s : %-12s |\n", "Account No", String.valueOf(accountBook.getAccountNO()));
		   System.out.printf("| %-15s : %-12s |\n", "User Name", accountBook.getName());
		   System.out.printf("| %-15s : %-12s |\n", "Password", accountBook.getPass_Word());

		   System.out.println("-----------------------------------");

//		System.out.println("--------------------------------------------");
//		System.out.println("| Your ID is :"+ accNo+       "                     |");
//		System.out.println("| Your Account no :"+ accountBook.getAccountNO()+"   |");
//		System.out.println("| Your UserName   :"+ accountBook.getName()+"       |");
//		System.out.println("| Your Password   :"+ accountBook.getPass_Word()+"    |");
//		System.out.println("--------------------------------------------");
	   }
	   else {
		   System.out.println("Something went Wrong");
	   }
      
	   }
   catch(Exception e){
	   System.out.println(e.getMessage());
   }
	}
	public static String balance(String Username,String passWord) {
		String query="select Balance from customer where Name= ? and Pass_Word= ?";
		try {
			Connection conn=ConnectionDB.getConnection();
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1, Username);
			pst.setString(2, passWord);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			else {
				System.out.println("Invailed Username or Password");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public static String balance(int ac1) {
		String query="select Balance from customer where AccountNO= ?";
		try {
			Connection conn=ConnectionDB.getConnection();
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1, ac1);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			else {
				System.out.println("Invailed Username or Password");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public static String deposite(int balance ,String Username, String passWord) {
		String query="update customer set Balance=? where Name=? and Pass_Word=?";
		try {
			Connection conn=ConnectionDB.getConnection();
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1, balance);
			pst.setString(2, Username);
			pst.setString(3, passWord);
			int row=pst.executeUpdate();
			if(row>0) {
				return "Success";
			}
			else {
				return "Failer";
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
       return null;
	}
	
	public static void userDetail(int id) {
		String query="select * from customer where id=?";
		try {
			Connection conn=ConnectionDB.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				System.out.println("------------------------");
				System.out.printf(" | %-15s : %-15s |\n","Your ID :",rs.getString(1));
				System.out.printf(" | %-15s : %-15s |\n","UserName :",rs.getString(2));
				System.out.printf(" | %-15s : %-15s |\n","PassWord :",rs.getString(3));
				System.out.printf(" | %-15s : %-15s |\n","Email :",rs.getString(4));
				System.out.printf(" | %-15s : %-15s |\n","Account NO :",rs.getString(5));
				System.out.printf(" | %-15s : %-15s |\n","Aadher :",rs.getString(6));
				System.out.printf(" | %-15s : %-15s |\n","Balance :",rs.getString(7));
				System.out.printf(" | %-15s : %-15s |\n","Age :",rs.getString(8));
				System.out.printf(" | %-15s : %-15s |\n","Phone No :",rs.getString(9));
				System.out.println("-------------------------");
			}
			if(rs.next()==false) {
				System.out.println("Your ID is not Exsist...");
			}
		}
		catch(Exception e) {
			
		}
	}
	public static void updateBal(String userName, String passWord,int balance) {
		String query="update customer set Balance=? where Name= ? and Pass_Word= ?";
		try {
			Connection conn=ConnectionDB.getConnection();
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1, balance);
			pst.setString(2, userName);
			pst.setString(3, passWord);
			int row=pst.executeUpdate();
			if(row>0) {
			System.out.println("Your Current Balance is :"+	balance(userName,passWord));
			}
			else {
				System.out.println("Something went Worng");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void moneyTran(int ac1, int ac2,int amt,int balan) {
		String q1="update customer set Balance=? where AccountNO=?";
		String q2="update customer set Balance=? where AccountNO=?";
		try {
			Connection conn=ConnectionDB.getConnection();
			PreparedStatement pst=conn.prepareStatement(q1);
			pst.setInt(1, (balan-amt));
			pst.setInt(2, ac1);
			int row1=pst.executeUpdate();
			PreparedStatement ps=conn.prepareStatement(q2);
			ps.setInt(1, (amt+(Integer.parseInt(balance(ac2)))));
			ps.setInt(2, ac2);
			int row2=ps.executeUpdate();
			
			if(row1>0&&row2>0) {
			System.out.println("Amount Transfer Succesfully...!");
			}
			else {
				System.out.println("Something went Worng");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
	}
}
