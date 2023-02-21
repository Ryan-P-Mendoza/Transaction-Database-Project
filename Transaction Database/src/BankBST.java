import java.io.*;
import java.util.Scanner;

public class BankBST {

	 BufferedReader fileReader; // using buffered reader we create fileReader
	 AccountBST<String> AccountBST;
	 AccountListBST<String> AccountListBST;// we create a BST
	 
	 public static void main(String[] args) {
		 BankBST test = new BankBST("transactions.txt");
		
		 Menu(test);
		 
		 test.AccountListBST.search("Ryan Mendoza");
		 test.AccountBST.search("111");
		 
	 }
	 
	 public static void Menu(BankBST bank) {
		 Scanner input = new Scanner(System.in);
		 System.out.println("Welcome to bank database!");
         System.out.println("Please make a selection: (1) View Account Transactions (2) AccountID finder (3) Exit");
         int selection = input.nextInt();
         while(selection != 3) {
        	 if(selection == 1) {
        		 System.out.print("Enter the accountID: ");
        		 String account = input.nextLine();
        		 bank.AccountBST.search(account);
         	}
        	if(selection == 2) {
        		 System.out.print("Enter the name on the account: \n");
        		 String name = input.nextLine();
        		 bank.AccountListBST.search(name);
         	}
        	System.out.println("Please make a selection: (1) View Account Transactions (2) AccountID finder (3) Exit");
        	selection = input.nextInt();
         }
		 
	 }
	 
	 public BankBST (String filename) {
		 
		 try {
			 AccountBST = new AccountBST<String>();
			 AccountListBST = new AccountListBST<String>();
			 fileReader = new BufferedReader (new FileReader(filename));
			 while(readNextRecord()) {}
		 }
		 catch(IOException e) {
			 e.printStackTrace();
		 }
	 }
	 
	 public boolean readNextRecord(){
	        // If there is no data file then we print out the error and return false to indicate to calling function that we are done reading
	    	if(fileReader == null){
	            System.out.println("Error: you must open the file first");
	            return false;
	        }
	        
	    	// If there is data to be read then we start reading in data
	        else {
	            try {
	                String data = fileReader.readLine(); // This creates the data to read the next line in file reader
	                // if the data is null that means we have no more data to read and to exit the reading method
	                if(data == null)
	                    return false;
	               String senderID = data;
	               String senderName = fileReader.readLine(); 
	               String receiverID = fileReader.readLine(); 
	               String receiverName = fileReader.readLine(); 
	               float amount = Float.parseFloat(fileReader.readLine()) ; 
	               String date = fileReader.readLine();
	               Transaction transaction = new Transaction(senderID, senderName, receiverName, receiverID, amount, date);
	               Account account = new Account(senderID, senderName);
	               Account account2 = new Account(receiverID, receiverName);
	              
	               AccountListBST.insert(senderName, account);
	               AccountListBST.insert(receiverName, account2);
	               AccountBST.insert(senderID, transaction);
	               
	               
	               
	               fileReader.readLine(); // then we read the next line for the next article
	            }
	            // these are for catching file reading errors
	            catch(NumberFormatException e){ // this one is for if we were supposed to read a number but didn't (e.x. missing numbers or not correctly formated data file)
	                System.out.println("Error: Number expected!");
	            }
	            catch (Exception e){ // next is just a more broad error catch and will not tell you exactly what went wrong
	                System.out.println("Fatal Error" + e);
	            }
	        }
	        return true; // return true to calling method to indicate there is more to be read from the data file
	    }
	 
	
}
