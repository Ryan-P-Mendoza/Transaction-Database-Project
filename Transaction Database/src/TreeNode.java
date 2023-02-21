
public class TreeNode<E> {
	protected E element; 
    protected TreeNode<E> left; 
    protected TreeNode<E> right; 
    protected TransactionsNode<Transaction> head; 

    public TreeNode(E e){
        element = e;
    }
	
    public void addFirst(Transaction a){
    	TransactionsNode<Transaction> newNode = new TransactionsNode<>(a); // create the new linked list node
        newNode.next = head; // link this node to where the head is pointing to/next node
        head = newNode; // set the head to this new node
    }
    
}
