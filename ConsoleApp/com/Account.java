package ConsoleApp.com;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Account {
	private int Customer_id;
	private String Name;
	private String Pass_Word;
	private int AccountNo;
	private String Aadhear;
	private int Age;
	private String PhoneNO;
	private String Email;
	private int Balance=1000;
	
	
 	public int getAccountNO() {
		return AccountNo;
	}
	public void setAccountNo(int accountNo) {
		AccountNo=accountNo;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public String getPass_Word() {
		return Pass_Word;
	}
	public void setPass_Word(String pass_Word) {
		Pass_Word = pass_Word;
	}
	public int getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAadhear() {
		return Aadhear;
	}
	public void setAadhear(String aadhear) {
		Aadhear = aadhear;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getPhoneNO() {
		return PhoneNO;
	}
	public void setPhoneNO(String phoneNO) {
		PhoneNO = phoneNO;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}



	public String toString() {
		return  "[ "+"Customer_ID: "+Customer_id+", Name: "+Name+", PassWord: "+Pass_Word+", AccountNo: "+getAccountNO()+", Aadher: "+Aadhear+
				", Age: "+Age+", PhoneNo: "+PhoneNO+", Email: "+Email+" ]";
		
	}
	public static void Details(Account a) {
		System.out.println("USER_ID: "+a.Customer_id);
		System.out.println("ACCOUNT_NO: "+a.getAccountNO());
		System.out.println("USER_NAME: "+a.Name);
		System.out.println("POSS_WORD: "+a.Pass_Word);
		System.out.println("AADHER: "+a.Aadhear);
		System.out.println("PHONE_NO: "+a.PhoneNO);
		System.out.println("AGE: "+a.Age);
		System.out.println("E-MAIL: "+a.Email);
		System.out.println("BALANCE: "+a.getBalance());
		
	}

}
