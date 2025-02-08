package ConsoleApp.com;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

import DBconnection.UserDB;

import java.io.Console;

public class User {
	public static void userView() throws Exception {
		Random random = new Random();
		Account account=new Account();
		boolean loop = true;
		String UserName;
		String passWord;
		String AadherNO = "";
		Scanner s = new Scanner(System.in);
		Console console = System.console();
		while (loop) {
			System.out.println("Choose AnyOne \n 1. Create Account  \n 2. Check Balance  \n 3. Deposit   \n 4. Withdraw \n 5. UserLogin  \n 6. Transfer_Amount \n 7. Exit");
			int Num = s.nextInt();
			try {
				switch (Num) {
					case 1:
						System.out.println("Enter the Name :");
						String name = s.next();
						String Pass_word;
						if (console != null) {
							Pass_word = new String(console.readPassword("Create the PassWord :"));
						} else {
							System.out.println("Create the PassWord (input will be visible):");
							Pass_word = s.next();
						}
						System.out.println("Enter the Aadhar No :");
						AadherNO = s.next();
						System.out.println("Enter the Age :");
						int age = s.nextInt();
						System.out.println("Enter the PhoneNO :");
						String phoneNO = s.next();
						String email;
						while (true) {
							System.out.println("Enter the Email :");
							email = s.next();
							if (isValidEmail(email) && email.contains("gmail")) {
								break;
							} else {
								System.out.println("Invalid email format. Please try again.");
							}
						}
				        int accountNo = (100000000 + random.nextInt(90000000));
						BookingAcc.accHolder(name, Pass_word, accountNo, AadherNO, age, phoneNO, email);
						break;
					case 2:
						System.out.println("Enter your userName :");
						UserName = s.next();
						passWord = getPassword(console, s, "Enter your Password :");
						System.out.println(UserDB.balance(UserName,passWord));
						break;
					case 3:
						System.out.println("Enter the Deposite Amount :");
						int balance=s.nextInt();
						System.out.println("Enter your Username :");
						UserName = s.next();
						passWord = getPassword(console, s, "Enter the PassWord:");
						account.setBalance(balance+account.getBalance());
						System.out.println( UserDB.deposite(account.getBalance(),UserName,passWord));
						break;
					case 4:
						System.out.println("Enter the Withdrwal Amount :");
						int withdra=s.nextInt();
						System.out.println("Enter your Username :");
						UserName = s.next();
						passWord = getPassword(console, s, "Enter the PassWord:");
						String lastbalance=UserDB.balance(UserName,passWord);
						
						if(withdra<Integer.parseInt(lastbalance)) {
							UserDB.updateBal(UserName,passWord,Integer.parseInt(lastbalance)-withdra);
							System.out.println("Amount Withdra Successfully");
						}
						else {
							System.out.println("Insficient Balance...");;
							break;
						}
						break;
					case 5:
						System.out.println("Enter your Customer ID");
				        int id=s.nextInt();
				        UserDB.userDetail(id);
						break;
					case 6:
						System.out.println("Enter your Account_No :");
						int ac1=s.nextInt();
						System.out.println("Enter money Transfer Accoun_No :");
						int ac2=s.nextInt();
						System.out.println("Enter the transfer Amount :");
						int amt=s.nextInt();
						int balan=Integer.parseInt(UserDB.balance(ac1));
						System.out.println(balan);
						if(balan>amt) {
							UserDB.moneyTran(ac1,ac2,amt,balan);
						}
						else {
							System.out.println("Insifficient Balance");
						}
						break;
					case 7:
						loop = false;
						break;
					default:
						System.out.println("Invalid Option");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(emailRegex);
		return pattern.matcher(email).matches();
	}
	private static String getPassword(Console console, Scanner s, String prompt) {
		if (console != null) {
			return new String(console.readPassword(prompt));
		} else {
			System.out.println(prompt + " (input will be visible):");
			return s.next();
		}
	}
//	private static void checkBalance(String UserName, String passWord) {
//		for (Account a : BookingAcc.accHol) {
//			if (a.getName().equals(UserName) && a.getPass_Word().equals(passWord)) {
//				System.out.println("Your Balance is :" + a.getBalance());
//				return;
//			}
//		}
//		System.out.println("Your UserName or Password is Wrong");
//	}
//
//	private static void depositAmount(String UserName, String passWord, Scanner s) {
//		for (Account a : BookingAcc.accHol) {
//			if (a.getName().equals(UserName) && a.getPass_Word().equals(passWord)) {
//				System.out.println("Enter the deposit Amount :");
//				int deposit = s.nextInt();
//				a.setBalance(deposit + a.getBalance());
//				System.out.println(deposit + " Credited to Your Account");
//				return;
//			}
//		}
//		System.out.println("Your UserName or Password is Wrong");
//	}

//	private static void withdrawAmount(String UserName, String passWord, Scanner s) {
//		for (Account a : BookingAcc.accHol) {
//			if (a.getName().equals(UserName) && a.getPass_Word().equals(passWord)) {
//				System.out.println("Enter the Withdraw Amount :");
//				int withdraw = s.nextInt();
//				if (a.getBalance() > withdraw) {
//					a.setBalance(a.getBalance() - withdraw);
//					System.out.println(withdraw + " Debited from Your Account");
//				} else {
//					System.out.println("Insufficient Balance...");
//				}
//				return;
//			}
//		}
//		System.out.println("Your UserName or Password is Wrong");
//	}

//	private static void userLogin(String UserName, String passWord) {
//		for (Account a : BookingAcc.accHol) {
//			if (a.getName().equals(UserName) && a.getPass_Word().equals(passWord)) {
//				System.out.println(a.getName() + " Your Details :");
//				System.out.println("--------------------");
//				Account.Details(a);
//				return;
//			}
//		}
//		System.out.println("Your UserName or Password is Wrong");
//	}
}
