package bank;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.mail.NoSuchProviderException;

public class Customer {
	String name;
	String address;
	String contact;
	int balance;
	int depositAmount;
	int withdrawAmount;
	String acType;
	String email;
	int account;
	
//	public Customer() throws NoSuchProviderException {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Welcome to Bank Management System");
//		System.out.println("*******************************************");
//		System.out.println("1: Press 1 to create new bank account \n2: Press 2 to deposit cash \n3: Press 3 to withdraw cash\n4:View your bank status");
//		int service =sc.nextInt();
//		switch(service) {
//		case 1:
//			createAc();
//			break;
//		case 2:
//			deposit();
//			break;
//		case 3:
//			withdraw();
//			break;
//		case 4:
//			viewInfo();
//			break;
//		default:
//			System.out.println("Invalid Input: Please Try Again");
//			break;
//		}
//	}
	
	//Method to create new account:
	public void createAc() {
		this.account=172020;
		System.out.println("Please Fill the form below to create new bank account:");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter full name:");
		name=sc.nextLine();
		System.out.print("Enter Contact number:");
		contact=sc.nextLine();
		System.out.print("Enter your Email Address:");
		email=sc.nextLine();
		System.out.print("Enter your address:");
		address=sc.nextLine();
		System.out.println("Enter Account type:\n 1.Saving Account \n2.Fixed Deposit \n3.Current Account");
		System.out.print("Type here:");
		int value =sc.nextInt();
		
		switch(value) {
		case 1:
			this.acType="Saving";
			break;
		case 2:
			this.acType="Fixed";
			break;
		case 3:
			this.acType="Current";
			break;
		default:
			System.out.println("Invalid Input");
			break;
		}
		
		System.out.println("Enter the amount to deposit:(If you don't want or depost right now, put 0)");
		depositAmount=sc.nextInt();
		balance=balance+depositAmount;
		withdrawAmount=0;
		
		try{
            String sql="insert into customers"
            +"(name,account_number,address,contact,email,ac_type,balance,last_deposited,last_withdraw)"
            +"Values(?,?,?,?,?,?,?,?,?)";
          Connection con= DriverManager.getConnection("JDBC:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
          PreparedStatement pst =con.prepareStatement(sql);
       
           pst.setString(1,name);
           pst.setInt(2,account);
           pst.setString(3,address);
           pst.setString(4,contact);
           pst.setString(5, email);
           pst.setString(6,acType);
           pst.setInt(7,balance);
           pst.setInt(8,depositAmount);
           pst.setInt(9,withdrawAmount);
           
           pst.executeUpdate();
		}
		catch (SQLException ex) {
       
		}  	
		account++;
		System.out.println("Account Created Successfully.......");
	}

	//Deposit Cash
	public void deposit(int id) throws NoSuchProviderException {
		Scanner sc = new Scanner(System.in);
		System.out.println("How much amount you want to deposit:");
		depositAmount=sc.nextInt();
		try{
          String sql="update customers set balance=balance+?, last_deposited=? where id=?";
          Connection con= DriverManager.getConnection("JDBC:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
          PreparedStatement pst =con.prepareStatement(sql);
          int checkId=id;
          pst.setInt(3,checkId);
          pst.setInt(1,depositAmount);
          pst.setInt(2, depositAmount);
          pst.executeUpdate();
          //depositMsg.main(depositAmount,checkId);
		}
		catch (SQLException ex) {
		}  
		
		System.out.println("Cash Deposited Sucessfully.......");
	}
	
	//Withdraw Cash
	public void withdraw(int id, int balance) throws NoSuchProviderException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Amount:");
		int Amount=sc.nextInt();
		if(balance<Amount) {
			System.out.println("Insufficint balance");
		}
		else {
		
		try{
		 Connection con= DriverManager.getConnection("JDBC:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");  
          String sql="update customers set balance=balance-?, last_withdraw=? where id=?";
          PreparedStatement pst =con.prepareStatement(sql);
          pst.setInt(3, id);
          pst.setInt(1,Amount);
          pst.setInt(2,Amount);
          pst.executeUpdate();
          // withdrawMsg.main(withdrawAmount,checkId);
		}
		catch (SQLException ex) {
		}  
		System.out.println("Cash Withdrawn Sucessfully.......");
		}

	}
	
	
	//
	public void checkWithdraw() {
	   int checked = 0;
	   int check = 0;
	   try { 
		Connection con= DriverManager.getConnection("JDBC:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");  
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your account number:");
		int num=sc.nextInt();
		String checkSql="Select *from customers";
	     PreparedStatement checkPst=con.prepareStatement(checkSql);
	     ResultSet checkRs=checkPst.executeQuery();
	     
	     while(checkRs.next()) {
	    	 if(checkRs.getInt("id")==num) {
	    		  checked=num;
	    		  check=checkRs.getInt("balance");
	    		  break;
	    	 }
	     }
	   }catch(SQLException ex) {}
		   try {
			withdraw(checked,check);
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void checkDeposit() {
		int checked = 0;
		   try { 
			Connection con= DriverManager.getConnection("JDBC:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");  
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your account number:");
			int num=sc.nextInt();
			String checkSql="Select id from customers";
		     PreparedStatement checkPst=con.prepareStatement(checkSql);
		     ResultSet checkRs=checkPst.executeQuery();
		     
		     while(checkRs.next()) {
		    	 if(checkRs.getInt("id")==num) {
		    		  checked=num;
		    		  break;
		    	 }
		     }
		   }catch(SQLException ex) {}
		 try {
			deposit(checked);
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//View Info
	public void viewInfo() {
		System.out.println("Here is your account detail:");
		System.out.println("------------------------------------------");
		
		 try {    
		      Connection con= DriverManager.getConnection("JDBC:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");  
		    		 String sql= "select * from customers where id=?";
		    		 PreparedStatement pst = con.prepareStatement(sql);  
		    		//  pst.setInt(1,checkUser());
				       ResultSet rs = pst.executeQuery();  
				       while (rs.next()) {  
				    	 int id =rs.getInt(1);
				         String name = rs.getString(2);  
				         String address=rs.getString(3);
				         String acType = rs.getString(4); 
				         int balance = rs.getInt(5);
				         int deposit=rs.getInt(6);
				         int withdraw=rs.getInt(7); 
				         
				        System.out.println("Account Number:"+id);//Printing all customers data 1 by 1 in loop.
				 		System.out.println("Name:"+name);
				 		System.out.println("Address"+address);
						System.out.println("Account type:"+acType);
						System.out.println("Balance:"+balance);
						System.out.println("Last Deposit:"+deposit);
						System.out.println("Last Withdraw:"+withdraw);
						System.out.println("-----------------------------------");
				       }
		     } catch (SQLException ex) {    
		     }  
	}
	
	
}

