//###########################################
//# Name: Anthony Lampi && Leo Gomez        #
//# CruzID: alampi && legomez               #
//# Class: CMPS-12B                         #
//# Date: Dec 8, 2014                       #
//# filename: Tree.java                     #
//# Details: to hold all the possible rooms #
//#     and options                         #
//###########################################

import java.io.*;
import java.util.*;               // for Stack class
////////////////////////////////////////////////////////////////

class Node
{
    public String iData;                                // data item (key)
    public List<String> dData = new ArrayList<String>();           // data item
    public Node leftChild;                              // this node's left child
    public Node rightChild;                             // this node's right child
    
    public void displayNode()      // display ourself
    {
	System.out.print('{');
	System.out.print(iData);
	System.out.print(", ");
	System.out.print(dData);
	System.out.print("} ");
    }
}  // end class Node
////////////////////////////////////////////////////////////////
class Tree
{
    private Node root;             // first node of tree
    
    // -------------------------------------------------------------
    public Tree()                  // constructor
    { root = null; }            // no nodes in tree yet
    // -------------------------------------------------------------
    public Node find(String key)      // find node with given key
    {                           // (assumes non-empty tree)
	Node current = root;               // start at root
	while(current.iData.compareTo(key) != 0)        // while no match,
	    {
		if(key.compareTo(current.iData) < 0)         // go left?
		    current = current.leftChild;
		else                            // or go right?
		    current = current.rightChild;
		if(current == null)             // if no child,
		    return null;                 // didn't find it
	    }
	return current;                    // found it
    }  // end find()
    
    public void insert(String id, String dd)
    {
	Node newNode = new Node();    // make new node
	newNode.iData = id;           // insert data
	newNode.dData.add(dd);
	if(root==null)                // no node in root
	    root = newNode;
	else                          // root occupied
	    {
		Node current = root;       // start at root
		Node parent;
		while(true)                // (exits internally)
		    {
			parent = current;
			if(id.compareTo(current.iData) < 0)  // go left?
			    {
				current = current.leftChild;
				if(current == null)  // if end of the line,
				    {                 // insert on left
					parent.leftChild = newNode;
					return;
				    }
			    }  // end if go left
			else                    // or go right?
			    {
				current = current.rightChild;
				if(current == null)  // if end of the line
				    {                 // insert on right
					parent.rightChild = newNode;
					return;
				    }
			    }  // end else go right
		    }  // end while
	    }  // end else not root
    }  // end insert()
}