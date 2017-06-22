import java.util.*;

public class cell{
	private String[] hold=new String[3];
	public String[] cellLoc(String side,int row,int column){
		char a=(char)(64+row);
		for(int i=0;i<3;i++){
			if(i>0){
				if(side.equals("top"))
					a=(char)(a-1);
				else if(side.equals("bottom"))
					a=(char)(a+1);
				else if(side.equals("left"))
					column-=1;
				else if(side.equals("right"))
					column+=1;
			}
			hold[i]=(String.valueOf(a)).concat(String.valueOf(column));			
		}
		return hold;
	}
}