
public class AccountNode<E> {

	protected E element; 
    protected AccountNode<E> left; 
    protected AccountNode<E> right; 
    protected AccountsNode<Account> head; 

    public AccountNode(E e){
        element = e;
    }
	
    public void addFirst(Account a){
    	AccountsNode<Account> newNode = new AccountsNode<>(a); // create the new linked list node
        newNode.next = head; // link this node to where the head is pointing to/next node
        head = newNode; 
    }
}
