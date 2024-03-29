import java.util.*;

/*
 * An implementation of a binary search tree. This tree stores 
 * both keys and values associated with those keys.
 *
 * More information about binary search trees can be found here:
 * http://en.wikipedia.org/wiki/Binary_search_tree
 */
//suppressing rawtypes warning because we are using raw types in the BSTNode class
@SuppressWarnings("rawtypes")
 
class BinarySearchTree <K extends Comparable<K>, V>  {

	public static final int BST_PREORDER  = 1;
	public static final int BST_POSTORDER = 2;
	public static final int BST_INORDER   = 3;

	// These are package friendly for the TreeView class
	BSTNode<K,V> root;
	int	count;

	public BinarySearchTree () {
		root = null;
		count = 0;
	}

	
	/* Purpose: Insert a new key-value element into the tree.  
	 *          If the key already exists in the tree, update 
	 *          the value stored at that node with the new value.
	 * Parameters: K key - the key for which the BST is ordered
     *	 		   V value - the value to associate with the key
	 * Returns: nothing
	 * Pre-Conditions: the tree is a valid binary search tree
	 */
	public void insert (K key, V value) {
		//allocate memory for new entry
		BSTNode<K,V> insertNode = new BSTNode<K,V>(key, value);
		if (root == null){
			//insert the key/val pair here
			root = insertNode; 
			count++;
		}
		else{
			//call insertRec helper. 
			insertRec(root, insertNode);
		}
	}

	private void insertRec(BSTNode cur, BSTNode insert) {
		//root is occupied, so we need to find the appropriate space for our new entry. 
		//values implement compareTo(). 
		//if the current node is null, we have found our spot. (I don't think this should ever run, as we catch this in the prev iteration, but this protects the program from crashing.)
		if (cur == null) {
			cur = insert;
			count++;
			return;
		}
		//catch edge case. (if we have an identical key, assume we are updating the value.)
		if (insert.key.compareTo(cur.key) == 0) {
			cur.value = insert.value;
			return;
		} else if (insert.key.compareTo(cur.key) < 0) {
			//if the key is less than the current node, we need to go left. 
			if (cur.left == null) {
				//if the left node is empty, insert here. 
				cur.left = insert;
				count++;
			} else {
				//otherwise, keep going left. 
				insertRec(cur.left, insert);
			}
		} else {
			//if the key is greater than the current node, we need to go right. 
			if (cur.right == null) {
				//if the right node is empty, insert here. 
				cur.right = insert;
				count++;
			} else {
				//otherwise, keep going right. 
				insertRec(cur.right, insert);
			}
		}
	}

	/* 	
	 * Purpose: Get the value of the given key. 
	 * Parameters: K key - the key to search for
	 * Returns: V - the value associated with the key
	 * Pre-conditions: the tree is a valid binary search tree
	 * Throws: KeyNotFoundException if key isn't in the tree
	 */
	public V find (K key) throws KeyNotFoundException {
		//if the tree is empty, throw an exception.
		if (root == null) {
			throw new KeyNotFoundException();
		}
		//call findRec helper.
		return findRec(root, key);
	}

	private V findRec(BSTNode cur, K key) throws KeyNotFoundException{
		//if the current node is null, throw an exception. 
		if (cur == null) {
			throw new KeyNotFoundException();
		}
		//if the key is equal to the current node, return the value. 
		if (key.compareTo((K) cur.key) == 0) {
			return (V) cur.value;
		} else if (key.compareTo((K) cur.key) < 0) {
			//if the key is less than the current node, go left. 
			return findRec(cur.left, key);
		} else {
			//if the key is greater than the current node, go right. 
			return findRec(cur.right, key);
		}
	}

	/* 	
	 * Purpose: Get the number of nodes in the tree.
	 * Parameters: none
	 * Returns: int - the number of nodes in the tree. 
	 */
	public int size() {
		return count; 
	}

	/*
	 * Purpose: Remove all nodes from the tree.
	 * Parameters: none
	 * Returns: nothing
	 */
	public void clear() {
		root = null;
		count = 0;
	}

	/* 
	 * Purpose: Get the height of the tree. 
	 * Parameters: none
	 * Returns: int - the height of the tree
	 * Example: We define height as being the number of 
	 * arrows that need to be followed on the path from 
	 * the root to the deepest leaf node. This means that 
	 * a tree with one node (just the root) has height 0,
	 * and an empty tree (root is null) has height -1.
	 *
	 * See the assignment PDF and the test program for examples.
	 */
	public int height() {
		return heightRec(root, -1);
	}

	private int heightRec(BSTNode cur, int h) {
	if (cur == null) {
		return h;
	}
	else{
		return Math.max(heightRec(cur.left, h + 1), heightRec(cur.right, h + 1));
	}
	
	}

	/* 
	 * Purpose: Return a list of all the key-value Entry elements 
	 *          stored in the tree using a level-order traversal.
	 * Parameters: None
	 * Returns: List<Entry<K,V>> - a list of key-value entries
	 *
	 * Example: A level order traversal of a tree cannot be done 
	 *          without the help of a secondary data structure.
	 *
	 *          It is commonly implemented using a queue of nodes 
	 *          as the secondary data structure. You will still be 
	 *          adding the "visited" elements to l as you do in the 
	 *          other traversal methods but you will create an 
	 *          additional q to hold nodes still to visit. This is
	 *          similar to what we did in the worksheet on tree traversals.
	 *
	 * From wikipedia (they call it breadth-first), the algorithm 
	 * for level order is:
	 *
	 *  levelorder()
	 *      q = empty queue
	 *      q.enqueue(root)
	 *      while not q.empty do
	 *          node := q.dequeue()
	 *          visit(node)
	 *          if node.left != null then
	 *                q.enqueue(node.left)
	 *          if node.right != null then
	 *                q.enqueue(node.right)
	 *
	 * Note that you can use the Java LinkedList as a Queue
	 * and then use only the removeFirst() and addLast() methods on q
	 */
	public List<Entry<K,V>>	entryList() {
		// list to add all the nodes to
		List<Entry<K,V> > l = new LinkedList<Entry<K,V>>();
		
		// queue of nodes that need to be added
		LinkedList<BSTNode<K,V>> q = new LinkedList<BSTNode<K,V> >(); // q = empty queue
		
		//enqueue the root
		q.addLast(root);
		//while the queue is not empty (while not q.empty do)
		while (!q.isEmpty()) {
			//dequeue the node (node := q.dequeue()
			BSTNode<K,V> node = q.removeFirst();
			//add the node to the list (visit(node)
			l.add(new Entry<K,V>(node.key, node.value));
			//if the left node is not null, enqueue it (if node.left != null then q.enqueue(node.left)
			if (node.left != null) {
				q.addLast(node.left);
			}
			//if the right node is not null, enqueue it (if node.right != null then q.enqueue(node.right)
			if (node.right != null) {
				q.addLast(node.right);
			}
		}



		return l;
	}

	/* 	
	 * Purpose: Get a list of all the key-value entries stored in the tree
	 * Parameters: int whichTraversal - the type of traversal to perform:
	 * Returns: List<Entry<K,V>> - a list of key-value entries
	 * Example: The list will be constructed by performing a traversal
	 * specified by the parameter whichTraversal.
	 * 
	 * If whichTraversal is:
	 *	 BST_PREORDER	perform a pre-order traversal
	 *	 BST_POSTORDER	perform a post-order traversal
	 *	 BST_INORDER	perform an in-order traversal
	 */
	public List<Entry<K,V> > entryList (int which) {
		List<Entry<K,V> > entries = new LinkedList<Entry<K,V> >();

		if (which == BST_PREORDER) {
			preOrderRec(root, entries);
		}
		else if (which == BST_INORDER) {
			inOrderRec(root, entries);
		}
		else if (which == BST_POSTORDER) {
			postOrderRec(root, entries);
		}
		return entries;
	}

	private void inOrderRec (BSTNode<K,V> n, List <Entry<K,V>> entries) {
		// TODO: implement this so it adds all of the elements in
		// the tree to the entries list with an in-order traversal
		if (n == null) {
			return;
		}
		inOrderRec(n.left, entries); //recur on left child
		entries.add(new Entry<K,V>(n.key, n.value)); //add current node
		inOrderRec(n.right, entries); //recur on right child
	}

	private void preOrderRec (BSTNode<K,V> n, List <Entry<K,V>> entries) {
		// TODO: implement this so it adds all of the elements in
		// the tree to the entries list with a pre-order traversal
		if (n == null) {
			return;
		}
		entries.add(new Entry<K,V>(n.key, n.value)); //add current node
		preOrderRec(n.left, entries); //recur on left child
		preOrderRec(n.right, entries); //recur on right child
	}

	private void postOrderRec (BSTNode<K,V> n, List <Entry<K,V>> entries) {
		// TODO: implement this so it adds all of the elements in
		// the tree to the entries list with a post-order traversal
		if (n == null) {
			return;
		}
		postOrderRec(n.left, entries); //recur on left child
		postOrderRec(n.right, entries); //recur on right child
		entries.add(new Entry<K,V>(n.key, n.value)); //add current node
	}
}