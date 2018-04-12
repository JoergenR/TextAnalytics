package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import binarySearchTree.binarySearchTree;

public class Main {

    
    public static void main(String[] args)
    {
        String in = null;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer input = new StreamTokenizer(r);
        binarySearchTree bst = new binarySearchTree();

        // Henter text fra user input og deler opp i ord
        // Sender ordene til insert metoden i det binære søketreet

        System.out.println("Enter text: | Type exitInput at the end to stop input..");
        try
        {
            int x = input.nextToken();
            while (x != input.TT_EOF)
            {
                if (input.ttype == input.TT_WORD) {
                    if(input.sval.equals("exitInput"))
                        break;
                    bst.insert(input.sval.toUpperCase().replaceAll("[^a-zA-Z0-9]", ""));
                }
                x = input.nextToken ();


            }
            // Kaller printmetoden slik at treet blir skrevet ut alfabetisk og med antall av hvert ord
            bst.inorder();
        }
        catch (IOException e) {};
    }
}
