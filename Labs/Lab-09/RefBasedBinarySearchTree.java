import java.lang.Math;
/*
 * RefBasedBinarySearchTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinarySearchTree extends RefBasedBinaryTree {

    //need a new insert, and recursive helper function. this doesnt implement removals, so we wont need it right now. 
    //this list works only with ints as values, and therefore, we can use the int type.


    public RefBasedBinarySearchTree() {
        super();
    }

    public void insert(int value) {
        if (root==null) {
            root = new TreeNode(value);
        } else {
            insertRec(value, root);
        }
    }

    //NOTE: treenode does not implement a parent. 
    private void insertRec(int value, TreeNode cur){
        //if value is less than the current node, go left.
        if (value < cur.getValue()) {
            //if the "open space to the left" is null, insert the value there.
            if (cur.getLeft() == null) {
                cur.setLeft(new TreeNode(value));
            } else {
                //else, go left, and call the function recursively (to find the next open space)
                insertRec(value, cur.getLeft());
            }
        }
        //if value is greater than the current node, go right. 
        else {
            //if the "open space to the right" is null, insert the value there.
            if (cur.getRight() == null) {
                cur.setRight(new TreeNode(value));
            } else {
                //else, go right, and call the function recursively (to find the next open space)
                insertRec(value, cur.getRight());
            }
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
        return find(node.getLeft(), value) || find(node.getRight(), value); //if the value is found in either the left or the right subtree, return true. (percolate down until it is found. or return false. )
    }

    
    public int getMax() throws TreeEmptyException {
        if (root == null) {
            throw new TreeEmptyException();
        }
        return getMax(root);
    }

    private int getMax(TreeNode node) {
        if (node.getRight() == null) {
            return node.getValue();
        }
        return getMax(node.getRight()); //recall that the rightmost node is the largest, following the BST property. 
    }

    public static void main(String[] args) {
        // use these trees to test the methods you will implement
        RefBasedBinarySearchTree emptyTree = new RefBasedBinarySearchTree();
        RefBasedBinarySearchTree myTree = new RefBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);
        
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();
        
        System.out.println("toString\n" + myTree);
        System.out.println("sum: " + myTree.sum());

        System.out.println("find 5: " + myTree.find(5));
        System.out.println("find 3: " + myTree.find(3));

        try {
            System.out.println("max: " + myTree.getMax());
        } catch (TreeEmptyException e) {
            System.out.println("Tree is empty");
        }

        try {
            System.out.println("max: " + emptyTree.getMax());
        } catch (TreeEmptyException e) {
            System.out.println("Tree is empty");
        }


    }
}
