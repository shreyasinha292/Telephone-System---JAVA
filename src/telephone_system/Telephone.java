package telephone_system;

import java.util.Scanner;
import java.util.*;
import java.lang.*;



public class Telephone {

	//method for validation of numbers
	
	static void validate(String num){  
		
		int i = 0, flag = 0;
		System.out.println("validation started"); 
		int len = num.length();
		while(i < len){
			
			//System.out.println("in while"); 
			if(!(Character.isDigit(num.charAt(i)))) {
				flag = 1;
				System.out.println("flag");
				throw new ArithmeticException("invalid number: number should contain numeric values only");
				
			}
			
			i++;
		}
	        
	    if(flag == 0)  
	      System.out.println("Calling ...." + num); 
	    
	    
	 }  

	
	static HashMap<String,String> contacts = new HashMap<String,String>();
	static Stack<String> call_history = new Stack<String>();
	
	
	//for the calling functionality
	public void call(String num) {
		try {
			 
			validate(num);
			call_history.push(num);
			
		}
		catch(Exception e) {
			System.out.println("Exception occurred!!"+e);
		}
		
	}
	
	//checking call history
	public void check_call_history() {
		if(call_history.empty()) {
			
			System.out.println("Call History is Empty");
		}
		
		else {
			
			System.out.println("Call History List:");
			
			for(int i=call_history.size()-1; i>=0;i--)  
				System.out.println(call_history.get(i));
		}
	}
	
	
	//adding contacts
	public void add_contacts(String name, String num) {
		try {
			validate(num);
			contacts.put(name, num);
			System.out.println(contacts.get(name)+" has been added to you contacts");
		}
		catch(Exception e) {
			System.out.println("Exception occurred!!"+e);
		}
	}
	

	public static void main(String[] args) {
		
		Telephone button1 = new Telephone();
		Telephone button2 = new Mobile();
		
		System.out.println("Enter your choice:");
		System.out.println("1 - call");
		System.out.println("2 - check call history");
		System.out.println("3 - add contacts");
		
		System.out.println("0 - quit");
		
		 Scanner sc=new Scanner(System.in);
		 int option ;
		 option = sc.nextInt();
		 while(option != -1) {
			 
			 switch(option) {
			 case 1 :
				 System.out.println("call by number(a) or call by name(b)?");
				 String op = sc.next();
				 if(op.equals("a")) {
					 
					 System.out.println("Enter the number:");
					 //sc.next();
					 String number = new String();
					 number = sc.next();
					 System.out.println("The number is = " + number);
					 button1.call(number);
				 }
				 
				 else {
					 System.out.println("Enter the name:");
					 
					 String name = new String();
					 name = sc.next();
					 System.out.println("the entered name is " + name);
					 button2.call(name);
				 }
				 break;
			 case 2 :
				 button1.check_call_history();
			 	 break;
			 case 3 :
				 String new_name = new String();
				 String new_number = new String();
				 System.out.print("enter the name");
				 
				 new_name = sc.next();
				 System.out.print("enter the number");
				 
				 new_number = sc.next();
				 System.out.println("the entered name is " + new_name);
				 System.out.println("the entered name is " + new_number);
				 button1.add_contacts(new_name, new_number);
				 break;
				 
			 case 0:
				 System.exit(1);
			 
			 default :
				 System.out.println("Invalid option");
			 }
			 
			 System.out.println("");
			 System.out.println("Enter your choice:");
			 System.out.println("1 - call");
			 System.out.println("2 - check call history");
			 System.out.println("3 - add contacts");
			 System.out.println("0 - quit");
			 option = sc.nextInt();
			 
		 	}
		 
		 

		
		sc.close();

	}
}

/* Mobile class is a child of Telephone class which is overriding the 
call function to add the call by name functionality.*/

class Mobile extends Telephone{
	
	public void call(String name) {
		
		System.out.println("Retrieving the number from contacts");
		call_history.push(name);
		try {
			String number = contacts.get(name);
			System.out.println("Retrieved the number "+ number + " for the name "+ name);
			System.out.println("Calling... " + name);
			call_history.push(name);
		}
		
		catch(NullPointerException e) {
			
			System.out.println("Contact not Found" + e);
		}
		
	
		
	}
	
}


/*
 
	*/
