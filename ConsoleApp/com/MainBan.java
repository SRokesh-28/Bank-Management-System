package ConsoleApp.com;

import java.util.*;
import java.io.*;
public class MainBan {
public static void main(String[] args)  {
       boolean loop=true;
       Scanner s=new Scanner(System.in);
       try {
       while(loop) {
    	   System.out.println("Choose AnyOne \n 1. User \n 2. Admin  \n 3. Exit");
    	   int n=s.nextInt();
    	   switch(n) {
    	   case 1:
    		   User.userView();
    		   break;
    	   case 2:
    		   Admin.adminView();
    		   break;
    	   case 3:
    		   loop=false;
    		   break;
    	   default:
    		   System.out.println("Invaild Option");
    	   }
       }
       }
       catch(Exception e) {
    	   System.out.println(e.getMessage());
       }
}
}
