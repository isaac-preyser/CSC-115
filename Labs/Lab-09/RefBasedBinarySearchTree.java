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
    }
}
