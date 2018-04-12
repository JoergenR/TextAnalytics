package binarySearchTree;

public class binarySearchTree
{
    // Indre klasse for treet
    private class treeNode
    {
        String data;
        treeNode left, right;
        int num;

        // Konstruktør
        public treeNode(String value)
        {
            data = value;
            left = right = null;
            num = 1;
        }

        void write()
        {
            System.out.println("\n" + data + " Antall: " + num);
        }
    }

    // Root
    private treeNode root;

    // Constructor, oppretter nytt tre
    public void binarySearchTree()
    {
        root = null;
    }

    // Sjekker etter tomt tre
    public boolean isEmpty()
    {
        return (root == null);
    }

    // Setter inn ny verdi i treet
    public void insert(String value)
    {
        treeNode newNode = new treeNode(value);


        // Create new root if tree is empty
        if (isEmpty())
        {
            root = newNode;
            return;
        }

        treeNode current = root;
        boolean finished = false;

        // Setter inn ny node i treet, sammenligningen er lik så oppdateres
        // variabelen num som holder på antall av ett ord, ellers så opprettes en ny node
        // Lagres alfabetisk
        while (!finished) {

            if (value.compareTo(current.data) == 0) {
                current.num++;
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


    // Printmetode

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
