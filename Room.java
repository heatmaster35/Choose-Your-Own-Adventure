import static java.lang.System.*;

public class Room {

    public String name;
  
    public class option {
        char input;
        String choice;
        String moveTo;
        option next;
    }
    public class newDescript {
        String descript;
        newDescript next;
    }
    
    public option oI = null;
    public option oC = null;
    public option oL = null;
    
    public newDescript dI = null;
    public newDescript dC = null;

    public void insertRoomDescript(String descript) {
	newDescript d = new newDescript();
        d.descript = descript;
        if(dC == null) {
            dC = d;
            dI = d;
	    dC.next = null;
        }
        else {
	    if(dI.next == null)
		dI.next = d;
            dC.next = d;
            dC = dC.next;
            dC.next = null;
	}
    }
    public void insertOptions(char input, String choice) {
        option o = new option();
        o.input = input;
        o.choice = choice;
        if(oI == null) {
            o.next = null;
	    oI = oC = oL = o;
	    oI.next = oC.next = oL.next = null;
	    
        }
        else {
            oC.next = o;
            oC = oC.next;
	    oL = oC;		    
        }
    }

    public boolean desHasNext()
    {
	return dC.next != null;
    }
    public void desNext()
    {
	dC = dC.next;
    }
    public void printDes()
    {
	for(desInitial();desHasNext();desNext())
	    {
		System.out.println(dC.descript);
		System.out.println();
	    }
	System.out.println(dC.descript);
	System.out.println();
    }
    public void insertMoveTo(String moveTo)
    {
	oC.moveTo = moveTo;
    }
    
    public void printMoveTo()
    {
	for(optInitial();optHasNext();optNext())
	    {
		System.out.print(oC.input+" - "+ oC.choice);
		System.out.println(" - "+oC.moveTo);
	    }
	System.out.print(oC.input+" - "+oC.choice);
	System.out.println(" - "+oC.moveTo);
    }

    public boolean optHasNext()
    {
	if(oC == null)
	    return false;
	if(oC.next != null)
	    return true;
	return false;
    }

    public void optNext()
    {
	oC = oC.next;
    }

    public void desInitial()
    {
	dC = dI;
    }

    public void optInitial()
    {
	oC = oI;
    }

    public void printOpt()
    {
	for(optInitial();optHasNext();optNext())
	    {
		System.out.print(oC.input + " - ");
		System.out.println(oC.choice);
	    }
	System.out.print(oC.input + " - ");
	System.out.println(oC.choice);
    }
}