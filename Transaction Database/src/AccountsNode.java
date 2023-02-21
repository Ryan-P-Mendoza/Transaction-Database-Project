public class AccountsNode<E> {

	E element;
	AccountsNode<E> next;
	
	 public AccountsNode(E e){
		 element = e;
	 }
	    
	    // convert it toString 
	 public String toString(){
		 return "" + element;
	 }
	 
	 
	
}