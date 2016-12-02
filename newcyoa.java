//converts the adventure file into a game.
import java.io.File;
import java.util.*;
import java.util.Scanner;
import java.lang.System.*;
import java.io.*;

class cyoa
{
    
    public static void main(String[] args)throws IOException
    {
	File InFile = new File(args[0]);
	Scanner scan = new Scanner(System.in);
	Stack StackX = new Stack();
	int advsize = 0;
        List<String> advfile = new ArrayList<String>();
	String input = "";
	char command;
	String info = "";
	String dummy = "";
	Scanner d = new Scanner(InFile);
	Scanner c = new Scanner(InFile);
	char userinput;
	char optionChar;
	String searchkey = "";
	boolean search = false;
	boolean quit = false;
	
//---------------------------------------------------------------------------------------------------------
	//Puts files into an array(advfile)
	while(d.hasNextLine())
	    {
		dummy = d.nextLine();
		advsize++;
	    }
	d.close();
	while(c.hasNextLine())
	    {
		String temp = c.nextLine();
		if(temp.compareTo("") == 0)
		    {
			advfile.add("$");
		    }
		else
		    {
			advfile.add(temp);
		    }
	    }
	c.close();
//------------------------------------------------------------------------------------------------------
	//searches for correct room
	searchkey = advfile.get(0);
	int a = 0;
	while(true)
	    {
		for(int i = 0;i < advsize; i++)
		    {
			input = advfile.get(i);
			if(searchkey.compareTo(input) == 0)
			    {
				search = true;
				a = i;
				break;
			    }
		    }
//--------------------------------------------------------------------------------------------------
		//if room is found...
		//run code to put items in their
		//respective position
		if(search)
		    {
			optionChar = 'a';
			while(input.compareTo("$") != 0)
			    {
				input = advfile.get(a);
				command = input.charAt(0);
				info = input.substring(2);
				switch(command)
				    {
				    case 'r': 
					StackX.push(info);
					break;
				    case 'd':
					StackX.current.insertRoomDescript(info);
					break;
				    case 'o': 
					StackX.current.insertOptions(optionChar, info);
					optionChar++;
					break;
				    case 't': 
					StackX.current.insertMoveTo(info);
					break;
				    default:
				    }
				a++;
			    }//end of while for blank space
			optionChar = 'a';
		    }//end of if search found
//----------------------------------------------------------------------------------------------------
		//once room is completed/created
		//print story and options
		//ask for user input
		while(true)
		    {
			optionChar = 'a';
			if(input.compareTo("$") == 0)
			    {
				System.out.println();
				StackX.current.printDes();
				StackX.current.printOpt();
				userinput = scan.next().charAt(0);
				if((userinput >= 'a') && (userinput <= StackX.current.oL.input))
				    {
					//searches for the userinput match of one of the options
					for(StackX.current.optInitial(); userinput != StackX.current.oC.input;
					    StackX.current.optNext())
					    {}
					System.out.println("[" + StackX.current.oC.choice + "]");
					//once found, searchkey will be refreshed
					searchkey = "r " + Stack.current.oC.moveTo;
					//then loops back into the original while loop(top of the code)
					break;
				    }
				else
				    {
					switch(userinput)
					    {
					    case 'q':
						System.out.println("[quit]");
						System.out.println();
						System.exit(0);
						break;
					    case 'z':
						//code to show pop(undo)
						StackX.pop();
						break;
					    case 'y':
						//code to show info of rooms and tags
						break;
					    case 'r':
						//StackX.restart();
						break;
					    default:
						System.out.println("[Invalid Choice]");
					    }//end of switch command
				    }//end of else user inputs
			    }//end of user input
		    }//end of userinput whileloop
	    }//end of main loop
    }//end of main
}//end of class