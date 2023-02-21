
public class TransactionsNode<E> {

	E element;
	TransactionsNode<E> next;
	
	 public TransactionsNode(E e){
		 element = e;
	 }
	    
	    // convert it toString 
	 public String toString(){
		 return "" + element;
	 }
	
}
