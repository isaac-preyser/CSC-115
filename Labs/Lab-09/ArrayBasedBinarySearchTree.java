public class ArrayBasedBinarySearchTree extends ArrayBasedBinaryTree{

//we will need to override the insert method to ensure the binary search tree property is maintained
//so, we will need to make a bubbleUp method, which will be called in the insert method. 


    public ArrayBasedBinarySearchTree() {
        super();
    }

    public void insert(int value) {
        insertRec(value, super.root);
    }

    private void insertRec(int value, int currentIndex){
        //base case: if the current index is null, insert the value there
        if (super.data[currentIndex] == null) {
            super.data[currentIndex] = value;
            return;
        } else{
            //if the value is less than the current index, go left
            if (value < super.data[currentIndex]) {
                insertRec(value, getLeft(currentIndex));
            } else {
                //else, go right. 
                insertRec(value, getRight(currentIndex));
            }
        
        }
    }
 
    
    public static void main(String[] args) {
        ArrayBasedBinarySearchTree emptyTree = new ArrayBasedBinarySearchTree();
        
        ArrayBasedBinarySearchTree myTree = new ArrayBasedBinarySearchTree();
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
