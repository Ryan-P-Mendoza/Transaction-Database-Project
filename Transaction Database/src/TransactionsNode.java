
public class TransactionsNode<E> {

	E element;
	TransactionsNode<E> next;
	
	 public TransactionsNode(E e){
		 element = e;
	 }
	    
	    
	 public String toString(){
		 return "" + element;
	 }
	
}
