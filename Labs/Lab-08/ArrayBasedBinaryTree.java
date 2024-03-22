/*
 * ArrayBasedBinaryTree.java
 *
 * An array-based BinaryTree meant to store values of type Integer
 */
public class ArrayBasedBinaryTree implements BinaryTree {
    private static final int CAPACITY = 5;
    protected Integer[] data;
    protected int root;
    protected int size;
    
	public ArrayBasedBinaryTree() {
		// TODO...
		// allocate space for data array.
		data = new Integer[CAPACITY];
		// What index are you choosing the root to be? 
		root = 0; 

		// initialize your size as the number of elements in the empty tree
		size = 0;
	}

	/*
	 * Purpose: inserts the given value into data at next available
	 *  position in a level-order traversal
	 *  The tree remains complete after insertion.
	 * Parameters: Integer value - value to insert
	 * Returns: nothing
	 */
	public void insert(Integer value) {
		//using this info we can insert the value at the next available position. (we will do a level-order traversal)
		//if the array is full, we need to expand it.
		if(size == data.length) {
			expandAndCopy(); 
		} 
		
		//put it at the end of  the array
		data[size] = value;
	
		//increment the size
		size++;
		


		// NOTE: The underlying data structure is an array,
		//  but we are just USING the array to store the data.
		//  The way we traverse the data will expose its binary tree structure
	}

	protected void expandAndCopy() {
		Integer[] newData = new Integer[data.length*2];
		for(int i=0; i<data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	/*
	 * Purpose: calculates and returns the index of t's left child
	 * Parameters: int t - index of current element in this ArrayBasedBinaryTree
	 * Returns: int - index of left child
	 */

	//assuming root is at index 0
	protected int getLeft(int t) {
		//find the index of the left child. 
		
	

		return 2*t + 1;
	}

	/*
	 * Purpose: calculates and returns the index of t's right child
	 * Parameters: int t - index of current element in this ArrayBasedBinaryTree
	 * Returns: int - index of right child
	 */
	protected int getRight(int t) {
		

		

		return 2*t + 2;
	}


	public void inOrder(){
		//print out left subtree, then the root, then the right subtree
		inOrderRec(root);
		System.out.println();

	}

	protected void inOrderRec(int t) {
		//print out left subtree, then the root, then the right subtree
		//if the next t is 
		//left, then root, then right 
		if (t > size || data[t] == null){
			return; 
		}
		inOrderRec(getLeft(t));
		System.out.print(data[t] + " ");
		inOrderRec(getRight(t));
	}


	public void preOrder(){
		// print root node
		preOrderRec(root);
		System.out.println();
	}

	protected void preOrderRec(int t){
		if (t > size || data[t] == null){
			return; 
		}
		System.out.print(data[t] + " ");
		preOrderRec(getLeft(t));
		preOrderRec(getRight(t));
	}


	public void postOrder(){
		// left -> right -> root
		postOrderRec(root);
		System.out.println();
	}

	protected void postOrderRec(int t ){
		if (t > size || data[t] == null){
			return; 
		}
		postOrderRec(getLeft(t));
		postOrderRec(getRight(t));
		System.out.print(data[t] + " ");
	}


	public int height() {
		return height(root);
	}

	/*
	 * Purpose: computes and returns the height of a 
	 *          binary tree rooted at index t 
	 * Parameters: TreeNode t - the BinaryTree
	 * Returns: int - the height
	 * NOTE: a BinaryTree with no nodes is height -1
	 *       a BinaryTree with just a root is height 0
	 *
	 *       the height of a node in a tree is equal to 
	 *       1 + the height of its largest subtree
	 */
	protected int height(int t) {
		if (t >= size || t == -1) {
            return 0;
        } 		
		return 1 + Math.max(height(getLeft(t)), height(getRight(t)));
		 
	}
	

	/*
	 * Purpose: returns a String reprensentation of a in-order traversal
	 *     of this ArrayBasedBinaryTree
	 * Parameters: none
	 * Returns: String - the representation
	 */
	// written for you - do not change
	// NOTICE: we use the helper methods to get the index of the left/right
	//   children of the current position in the tree.
	// This method will not work until you have completed those methods correctly.
	public String toString() {
		return toString(root);
	}

	private String toString(int t) {
        if (t >= size) {
            return "";
        } 
        String s = "";
        s += toString(getLeft(t));
        s += data[t] + " ";
        s += toString(getRight(t));

        return s;
	}

	public static void main(String[] args) {
		
		ArrayBasedBinaryTree myTree = new ArrayBasedBinaryTree();
		for(int i=2; i<8; i++) {
			myTree.insert(i);
		}

		System.out.println("height: " + myTree.height());




		System.out.println("in");
		myTree.inOrder();
		System.out.println("pre");
		myTree.preOrder();
		System.out.println("post");
		myTree.postOrder();
		
		System.out.println("toString\n" + myTree);
	}
    
}


