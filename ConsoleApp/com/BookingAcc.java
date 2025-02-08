package ConsoleApp.com;

import java.util.*;

import DBconnection.UserDB;
public class BookingAcc {
	 //static ArrayList<Account> accHol=new ArrayList<Account>();
	 //static int accountLimit=10;
	 static int idGenerator=1;
	public static void accHolder(String name,String Pass_Word,int accountNo,String AadherNO,int age,String phoneNO,String email) throws Exception {
		Account accountBook=new Account();
			accountBook.setName(name);
			accountBook.setPass_Word(Pass_Word);
			accountBook.setAadhear(AadherNO);
			accountBook.setAge(age);
			accountBook.setPhoneNO(phoneNO);
			accountBook.setEmail(email);
			accountBook.setAccountNo(accountNo);
			accountBook.setCustomer_id(idGenerator++);
			accountBook.setBalance(accountBook.getBalance());
			UserDB.dbConnection(accountBook);
		
		
	}
//	public static void display() {
//		for(Account A:accHol) {
//			System.out.println(A.toString());
//		}
//		System.out.println();
//	}
}
