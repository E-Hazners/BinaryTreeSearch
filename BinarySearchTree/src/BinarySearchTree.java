import java.util.Scanner;

public class BinarySearchTree{
	public class Node {
        //instance variable of Node class
        public int data;
        public Node left;
        public Node right;

        //constructor
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        public int cardinality() {
        	boolean isRight = false;
        	boolean isLeft = false;
    		if(this.left == null && this.right == null) {
    			return 0;
    		} else {
    			if(this.right != null) {
    				isRight = true;
    			}
    			if(this.left != null) {
    				isLeft = true;
    			}
    			if(isLeft && isRight) {
    				if(right.cardinality() + 1 > left.cardinality() + 1) {
    					return right.cardinality() + 1;
    				} else {
    					return left.cardinality() + 1;
    				}
    			} else if (isRight) {
    				return 1 + right.cardinality();
    			} else {
    				return 1 + left.cardinality();
    			}
    		}
    	}

    }
    // instance variable
    public Node root;

    // constructor for initialise the root to null BY DEFAULT
    public BinarySearchTree() {
        this.root = null;
    }
    
    // insert method to insert the new Date
    public void insert(int newData) {
        this.root = insert(root, newData);
    }

    public Node insert(Node root, int newData) {
        // Base Case: root is null or not
        if (root == null) {
            // Insert the new data, if root is null.
            root = new Node(newData);
            // return the current root to his sub tree
            return root;
        }
        // Here checking for root data is greater or equal to newData or not
        else if (root.data >= newData) {
            // if current root data is greater than the new data then now process the left sub-tree
            root.left = insert(root.left, newData);
        } else {
            // if current root data is less than the new data then now process the right sub-tree
            root.right = insert(root.right, newData);
        }
        return root;
    }
    public int cardinality() {
		if(root.left.cardinality() > root.right.cardinality()) {
			return 1 + root.left.cardinality();
		} else {
			return 1 + root.right.cardinality();
		}
	}

    //Traversal
    public void preorder() {
        preorder(root);
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }
	
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       BinarySearchTree bst = new BinarySearchTree();
       for(int i = 0; i < n; i++) {
    	   bst.insert(scanner.nextInt());
    	   
       }
       System.out.println(bst.cardinality());
    } 
}

