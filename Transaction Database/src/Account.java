
public class Account {
	
	
	String AccountID;
	String AccountName;
	
	public Account(String id, String n){
		AccountID = id;
		AccountName = n;
   
	}
	
	public String toString(){
        return String.format("\t %s(%s) \n", AccountID, AccountName);
 }
}
