
public class Transaction {

	String senderID;
	String senderName;
	String receiverName;
	String receiverID;
	float amount;
	String date;
	
	 public Transaction(String i, String sn, String rn, String r, float b, String d){
	        senderID = i;
	        senderName = sn;
	        receiverName = rn;
	        receiverID = r;
	        amount = b;
	        date = d;
	 }
	 
	 
	 public String toString(){
	        return String.format("\t %s -- %s(%s) --> %s(%s) | $%.2f \n", date,senderName, senderID,receiverName,receiverID,amount);
	 }
	
	
}
