import java.io.*;
import java.util.*;

public class GameHelp{
	public String getInput(String prompt){
		String inputLine=null;
		System.out.print(prompt);
		try{
			BufferedReader is=new BufferedReader(new InputStreamReader(System.in));
			inputLine=is.readLine();
			if(inputLine.length()==0)
				return null;
		}
		catch(IOException e){
			System.out.println("IOEception: "+e);
		}
		return inputLine.toUpperCase();
	}
}