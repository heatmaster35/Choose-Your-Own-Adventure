//############################
//# Name: Leo Gomez          #
//# CruzID: legomez          #
//# Class: CMPS-12B          #
//# Date: Nov 5, 2014        #
//# filename:dllistTest.java #
//# Details:allows me to test#
//#    my dllist.java file   #
//############################

// dllistTest.java
// Unit tests for dllist

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class RoomTest {
    /*
    @Test
	public void startsEmptyTest() 
    {
        Room lst = new Room();
        assertEquals(null, lst.name);
    }

    @Test
	public void secondTest()
    {
	Room lst = new Room();
	lst.insertOptions('a', "Hello");
	assertEquals('a' , lst.oC.input);
	assertEquals("Hello", lst.oC.choice);
    }
    
    @Test
	public void thirdTest()
    {
	Room lst = new Room();
	lst.insertOptions('a', "Hello");
	lst.insertOptions('b', "there");
	assertEquals('b' , lst.oC.input);
	assertEquals("there", lst.oC.choice);
	assertEquals('a' , lst.oI.input);
	assertEquals("Hello", lst.oI.choice);
	lst.printOpt();
    }
    
     @Test
	public void fourthTest()
    {
	Room lst = new Room();
	assertEquals(false, lst.optHasNext());
    }
    
    @Test
	public void fifthTest()
    {
	Room lst = new Room();
	lst.insertOptions('a', "Hello");
	lst.optNext();
	assertEquals(null, lst.oC);
    }

    @Test
	public void sixthTest()
    {
	Room lst = new Room();
	lst.insertOptions('a', "Hello");
	lst.insertOptions('b', "there");
	lst.optInitial();
	assertEquals('a' , lst.oC.input);
	assertEquals("Hello", lst.oC.choice);
	lst.optNext();
       	assertEquals('b' , lst.oC.input);
	assertEquals("there", lst.oC.choice);
    }
    */
    @Test
	public void seventhTest()
    {
	Room lst = new Room();
	lst.insertOptions('a', "Hello");
	lst.insertMoveTo("here1");
	lst.insertOptions('b', "there");
	lst.insertMoveTo("here2");
	lst.insertOptions('c', "yahll");
	lst.insertMoveTo("here3");
	lst.insertOptions('d', "it's");
	lst.insertMoveTo("here4");
	lst.insertOptions('e', "me");
	lst.insertMoveTo("here5");

	lst.printMoveTo();
    }
    
}
