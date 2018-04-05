package binarySearchTree;

// Standard operations on binary search trees
////
//// Nodes contain just a single character in addition to the two
//// pointers to left and right child
//

public class binarySearchTree
{
    // Inner class for binary tree nodes with single-character data
    private class treeNode
    {
        String data;
        treeNode left, right;

        public treeNode(String value)
        {
            data = value;
            left = right = null;
        }

        void write()
        {
            System.out.print(data + " ");
        }
    }

    // Root of entire search tree
    private treeNode root;

    // Constructor, creates empty tree
    public void binarySearchTree()
    {
        root = null;
    }

    // Check for empty tree
    public boolean isEmpty()
    {
        return (root == null);
    }


    //
    // Insertion of new value into binary search tree
    // Trenger en variabel for å telle antall
    public void insert(String value)
    {
        treeNode newNode = new treeNode(value);
        int num = 1;

        // Create new root if tree is empty
        if (isEmpty())
        {
            root = newNode;
            return;
        }

        treeNode current = root;
        boolean finished = false;

        // Insert new node as a leaf in the tree
        while (!finished) {

            if (value.compareTo(current.data) == 0) {
                num++;
                finished = true;
            }
            else if (value.compareTo(current.data) < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    finished = true;
                } else
                    current = current.left;
            }
            else {
                if (current.right == null) {
                    current.right = newNode;
                    finished = true;
                } else
                    current = current.right;
            }
        }
    }




    //
    // Printout of inorder tree traversal, for demo purposes
    
    // Må gjøre om på denne slik at utskriften blir riktig
    public void inorder()
    {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println("\n");
    }

    private void inorder(treeNode t)
    {
        if (t != null)
        {
            inorder(t.left);
            t.write();
            inorder(t.right);
        }
    }
}
