import java.lang.Math;
import java.util.LinkedList;
/*
 * RefBasedBinaryTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinaryTree implements BinaryTree {
    protected TreeNode root;
    
    public RefBasedBinaryTree() {
        this.root = null;
    }
    
    public void insert(Integer value){
        if (root==null) {
            root = new TreeNode(value);
        } else {
            insert(null, root, value);
		}
        
    }
    // not a balanced insert
    private void insert(TreeNode parent, TreeNode t, Integer value) {
        if (t==null) {
            if(parent.getLeft()==null) {
                parent.setLeft(new TreeNode(value));
			} else {
                parent.setRight(new TreeNode(value));
			}            
        }  else {
            int htLeft = height(t.getLeft());
            int htRight = height(t.getRight());
            if (htLeft>htRight) {
                insert(t, t.getRight(), value);
			} else {
                insert(t, t.getLeft(), value);
			}
        }
    }
    
    private int height(TreeNode t) {
        if (t==null) {
            return -1;
		} else {
            int highest = Math.max(height(t.getLeft()), height(t.getRight()));
            return 1 + highest;
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following an in-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following an in-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void inOrder(TreeNode t){
        if (t==null) {
            return;
        } else {
            inOrder(t.getLeft());
            System.out.print(t.getValue() + " ");
            inOrder(t.getRight());
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a pre-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a pre-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void preOrder(TreeNode t){
        if (t==null) {
            return;
        } else {
            System.out.print(t.getValue() + " ");
            preOrder(t.getLeft());
            preOrder(t.getRight());
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a post-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a post-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void postOrder(TreeNode t){
        if (t==null) {
            return;
        } else {
            postOrder(t.getLeft());
            postOrder(t.getRight());
            System.out.print(t.getValue() + " ");
        }
    }
    
    /*
     * Purpose: returns a String reprensentation of this BinaryTree
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        return toString(root);
    }
    
    private String toString(TreeNode t) {
        if(t==null) {
            return "";
        } else {
            String s = "";
            
            s += toString(t.getLeft());
            s += t.getValue() + " ";
            s += toString(t.getRight());
            
            return s;
        }
    }


     /* 
     * Method name: sum 
     * Purpose: computes the sum of all elements in this BinaryTree 
     * Parameters: none 
     * Returns: int – the sum 
     */
    //honestly, just perform a traversal and pass the sum along. 
    public int sum() {
        return sum(root);
    }

    private int sum(TreeNode node){
        if (node == null) {
            return 0;
        }
        return node.getValue() + sum(node.getLeft()) + sum(node.getRight());
    }

    public Boolean find(int value){
        return find(root, value);
    }
    private Boolean find(TreeNode node, int value){
        if (node == null) {
            return false;
        }
        if (node.getValue() == value) {
            return true;
        }
        return find(node.getLeft(), value) || find(node.getRight(), value);
    }

    public int getMax() throws TreeEmptyException {
        if (root == null) {
            throw new TreeEmptyException();
        }
        return getMax(root);
    }
    //not a binary search tree so I'll have to pass in the max value
    private int getMax(TreeNode node) {
        if (node == null){
            return 0;
        }
        //return the highest value of the three: the current node, the left subtree, or the right subtree. 
        return Math.max(node.getValue(), Math.max(getMax(node.getLeft()), getMax(node.getRight())));
    }

    
    
    
    
    public static void main(String[] args) {
        // use these trees to test the methods you will implement in Part II
        RefBasedBinaryTree emptyTree = new RefBasedBinaryTree();
        RefBasedBinaryTree myTree = new RefBasedBinaryTree();
        for(int i=2; i<8; i++) {
            myTree.insert(i);
        }
        System.out.println(myTree.find(0));//should return false
        System.out.println(myTree.find(2));//should return true

        System.out.println(myTree.sum()); //should return 27
        try {
            System.out.println(myTree.getMax()); //should return 7
        } catch (TreeEmptyException e) {
            System.out.println("Tree is empty");
        }
    }
    
}
