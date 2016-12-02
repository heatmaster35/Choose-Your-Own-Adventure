//#####################################
//# Name: Anthony Lampi && Leo Gomez  #
//# CruzID: alampi && legomez         #
//# Class: CMPS-12B                   #
//# Date: Dec 8, 2014                 #
//# filename: cyoa.java               #
//# Details: converts the adventure   #
//#   file into a game.               #
//#####################################

//converts the adventure file into a game.
import java.io.File;
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
	Tree hithere = new Tree();
	int advsize = 0;
	String[] advfile;
	String input = "";
	char command;
	String info = "";
	String lineon = "";
	String dummy = "";
	Scanner d = new Scanner(InFile);
	Scanner c = new Scanner(InFile);
	char userinput;
	char optionChar;
	String searchkey = "";
	boolean search = false;
	boolean quit = false;
	
	
	//Puts files into an array(advfile)
	while(d.hasNextLine())
	    {
		dummy = d.nextLine();
		advsize++;
	    }
	d.close();
	advfile = new String[advsize+2];
	for(int i = 0; i < advsize; i++)
	    {
		advfile[i] = c.nextLine();
		if(i == advsize)
		    {
			advfile[i+1] = "";
			advfile[i+2] = "EOF"; 
		    }
	    }
	c.close();
	searchkey = advfile[0];
	int a = 0;
	while(true)
	    {
		optionChar = 'a';
		while(true)
		    {			
			if((a >= advsize)||(a <= -1))
			    a = 0;
			input = advfile[a];
			if(input.compareTo("") != 0)
			    {
				command = input.charAt(0);
				info = input.substring(2);

				//put something here
				if((search)&&(searchkey.compareTo(advfile[a]) != 0)&&(command == 'r'))
				    {
					for(int i = 0;i < advsize;i++)
					    {			
						if(searchkey.compareTo(advfile[a]) == 0)
						    {
							command = input.charAt(0);
							info = input.substring(2);
							a = i;
							break;
						    }
					    }
				    }
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
			    }else
			    {
				break;
			    }
			if(a >= advsize)
			    a = -1;
			a++;
		    }
		if(input.compareTo("") == 0)
		    {
			while(true)
			    {
				System.out.println();
				StackX.current.printDes();
				StackX.current.printOpt();
				System.out.println();
				userinput = scan.next().charAt(0);
				if((userinput >= 'a') && (userinput <= StackX.current.oL.input))
				    {
					StackX.current.optInitial();
					while(userinput != (StackX.current.oC.input))
					    {
						StackX.current.optNext();
					    }
					System.out.println("["+ StackX.current.oC.choice + "]");
					searchkey = "r "+StackX.current.oC.moveTo;
					search = true;
					break;
					
				    }else if((userinput == 'q')||(userinput == 'z')||(userinput == 'y')||(userinput == 'r'))
				    {
					switch(userinput)
					    {
					    case 'q':
						System.out.println("[quit]");
						System.out.println();
						quit = true;
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
					    }
				    }else
				    {
					System.out.println("[Invalid Command]");
				    }
				if(quit)
				    break;
			    }
			if(quit)
			    break;
			if((a >= advsize)||(a < -1))
			    a = -1;
			a++;
			
		    }	
		if(quit)
		    break;

	    }
	scan.close();
    }
}
