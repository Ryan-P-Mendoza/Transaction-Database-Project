public class AccountBST<E extends Comparable<E>>{
   
	
	protected TreeNode<E> root; // create the root of the BST
    protected int size = 0; 

    public AccountBST() {
    }

    public boolean search(E e) {
        TreeNode<E> current = root; 

        while (current != null) {
        	
            if (e.compareTo(current.element) < 0) {
                current = current.left; // Go left
            }
            
           
            else if (e.compareTo(current.element) > 0) {
                current = current.right; // Go right
            }
            else {
                print(current);
                return true;
            }
        }
        
        // If we do not find the element in the BST then we print that it is not in the database and return false
        System.out.printf("Account %s does not exist in the bank database!\n", e);
        return false; // Element is not in the tree
    }

    
    public boolean insert(E e,Transaction a) {
        
    	// If there is no BST then create one and insert the keyword at the root and assign the article to the head of the linked list for that node
     	if (root == null) {
            root = createNewNode(e); // Create a new root
        }
     	
     	// If there is a root node then you will want to find the parent node for that article by searching the BST for the keyword node for that article
        else {
            
        	// Start off by initializing the parent to null and current node at the root
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            
            // This while loop will iterate through the BST as long as we have not hit a node with two children (leaf) indicating there is no matching keyword node
            while (current != null) {
            	// This is the exact same as the search method in this class which utilizes the compareTo function to compare the element (keyword) we are looking for
            	// to the current node we are at and will go left if the element we are looking for is less than, right if greater than, or stop if they are equal which 
            	// means we found the node we are looking for
            	if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else {
                    current.addFirst(a); // If we have found the keyword we are looking for then we insert the article at the head of the linked list using the addFirst function
                    return false; // We return false to indicate that we have not created a new BST node since there can be no duplicate nodes in a BST
                }
            }
            
            // If we do not find a matching node and have hit a leaf then we will create a new node and place it as the left or right child
            // depending on whether or not the keyword is less than or greater than the leaf node. This is done using compareTo function and then
            // placing the article at the head of the new linked list tied to that new node we just created using the addFirst function
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
                parent.left.addFirst(a);
            }
            else {
                parent.right = createNewNode(e);
                parent.right.addFirst(a);
            }
        }
        size++; // increase BST node amount by 1
        return true; // Element inserted successfully
    }

    // When we need to create a new BST node we just created a new tree node from the TreeNode class
    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    // This starts the inOrder printing of the BST to the user at the root
    public void inorder() {
        inorder(root);
    }

    // This function is what is used to print out the entire BST to the user
    protected void inorder(TreeNode<E> root) {
        
    	if (root == null) return; // if the current element we are at is null then that means we hit a leaf and we can start printing the tree
    	inorder(root.left); // since we are using inOrder method to print the tree we keep going left till we hit a leaf then begin printing L-P-R
    	
    	
        System.out.print(root.element + " "); // This will print the current node (keyword) we are at
        TransactionsNode<Transaction> artRec = root.head; // we will then start printing the linked list tied to that node at the head
        System.out.println("\t"); // print a new line and indent it so it looks nice
        
        // This while loop iterates through the linked list and prints each article on a line until it hits the tail
        while(artRec != null) {
            System.out.printf("%s", artRec); // print out the article string
            artRec = artRec.next; // set the article to the next linked list node
        }
        // once we are done with that node we then check to see if there is a right node and print that out and it's LL if it exists
        // this is because we are doing inOrder which prints the left nodes then the parent then the right child afterwards
        System.out.println();
        inorder(root.right);
    }

    // This method is for printing and individual BST node 
    protected void print(TreeNode<E> t){
        // check to see if there is a node, if there isn't then we leave the method
    	if(t == null)
            return;
    	
    	// print out the BST node element on a new line
        System.out.println("\nTransactions for account: " + t.element + " ");
        TransactionsNode<Transaction> artRec = t.head; // Then like the inOrder printing we start printing out articles starting at the head of the linked list
        System.out.println("\t"); // indenting to make sure they look nice
        // This while loop iterates through the linked list until it hits the tail which will be set to NULL
        while(artRec != null){
            System.out.printf("%s", artRec); // print out the article string
            artRec = artRec = artRec.next; // set the article to the next one in the linked list
        }
        System.out.println(); // print a new line for neatness
    }
}
