//###########################################
//# Name: Anthony Lampi && Leo Gomez        #
//# CruzID: alampi && legomez               #
//# Class: CMPS-12B                         #
//# Date: Dec 8, 2014                       #
//# filename: Stack.java                    #
//# Details: Creates a stack to hold in     #
//#   all the rooms.                        #
//###########################################

public class Stack {
    private int total;
    private int top;
    private Room[] stack;
    
    // Constructor
    public Stack() 
    {
	total = 50;
	stack = new Room[total];
	top = -1;
    }
    public static Room current = null;

    // Push a Room
    
    public void push(String x) 
    {
	top++;
	Room d = new Room();
	d.name = x;
	stack[top] = d;
	current = d;
    }
    
    // Pop top Room (removes)
    public Room pop() 
    {
	if(top < 0)
	    throw new RuntimeException();
	else
	    {
		Room tmp = stack[top];
		top--;
		current = stack[top];
		return tmp;
	    }
    }
    public boolean isEmpty()
    {
	if(top < 0)
	    return true;
	return false;
    }

    public void restart()
    {
	
    }
}