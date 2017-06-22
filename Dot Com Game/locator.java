import java.util.*;

public class locator{
	private int system=7;
	private int systSize=system*system;
	private int rowLoc;
	private int columnLoc;
	private int selectSide;
	private int firstLoc;
	private String side;
	
	public String[] locate(){
		
		ArrayList<String> locHolder=new ArrayList<String>();
		locHolder.add("top");
		locHolder.add("bottom");
		locHolder.add("right");
		locHolder.add("left");
		
		random r =new random();
		cell c=new cell();
		
		firstLoc= r.calc(systSize);
		firstLoc++;
		
		if(firstLoc%system==0){
			rowLoc=(firstLoc/system);
			columnLoc=7;
		}
		else{
			rowLoc=(firstLoc/system)+1;
			columnLoc=(firstLoc%system);
		}
		
		//System.out.println(firstLoc);
		
		if(rowLoc<3)
			locHolder.remove("top");
		if(rowLoc>5)
			locHolder.remove("bottom");
		if(columnLoc<3)
			locHolder.remove("left");
		if(columnLoc>5)
			locHolder.remove("right");
		
		//System.out.println(locHolder.size());
		
		//for(String i:locHolder)
		//	System.out.println(i);
		
		
		
		selectSide=r.calc(locHolder.size());
		//System.out.println("selectSide: "+selectSide);
		
		side=locHolder.get(selectSide);
		//System.out.println("side: "+side);
		
		String[] DotLoc=c.cellLoc(side,rowLoc,columnLoc);		
		
		return DotLoc;

	}
}