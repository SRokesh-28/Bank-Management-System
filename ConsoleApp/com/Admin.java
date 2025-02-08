package ConsoleApp.com;

import java.util.Scanner;

import DBconnection.AdminDB;

public class Admin {
	
	public static void adminView() {
		final String AdminUN="AdmiN&999";
	    final String AdminPW="999&AdmiN";
	
	    Scanner s=new Scanner(System.in);
	    
	    System.out.println("Enter the USERNAME :");
     	 String Aname=s.next();
     	 System.out.println("Enter the PASSWORD :");
     	 String Apass=s.next();
     	 if(AdminDB.checkAdmin(Aname,Apass)) {
     		 System.out.println("Admin DashBoard");
     		 System.out.println("-----------------------");
     		 boolean loop1=true;
     		 while(loop1) {
     		 System.out.println("Choose AnyOne \n 1. Account Details \n 2. Delet Account  \n 3. Exit");
     		 int n=s.nextInt();
     		 switch(n) {
     		 case 1:
     			 AdminDB.displayDet();
     			 break;
     		 case 2:
     			 System.out.println("Enter Remove ID");
     	    	  int id=s.nextInt();
				   if(AdminDB.removeAcc(id)){
					   System.out.println("Account Remove Sccessfully...");
				   }
				   else {
					   System.out.println("ID Not exsist");

				   }
     			 break;
     		 case 3:
     			 loop1=false;
     			 break;
     		 }
     		 }
     	 }
     	 else {
     		 System.out.println("UserName or PassWord is Worng");
     	 }
	
	}

}
