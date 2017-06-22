import java.io.*;
import java.util.*;

public class instill{
	private int num=3;	
	private GameHelp helper=new GameHelp();
	private ArrayList<String> CompleteDT=new ArrayList<String>();
	private ArrayList<String> PetDotCom=new ArrayList<String>();
	private ArrayList<String> NatureDotCom=new ArrayList<String>();
	private ArrayList<String> AnimalDotCom=new ArrayList<String>();
	private int finalResult;
	private int sinkDot;
	
	public void engine(){	
		
		instill d1=new instill();
		finish f=new finish();
				
		display();
		System.out.println();
		
		PetDotCom=d1.doIt();
		NatureDotCom=d1.doIt();
		AnimalDotCom=d1.doIt();
		
		String PetDot[]=new String[PetDotCom.size()];
		String NatureDot[]=new String[NatureDotCom.size()];
		String AnimalDot[]=new String[AnimalDotCom.size()];
		
		PetDotCom.toArray(PetDot);
		NatureDotCom.toArray(NatureDot);
		AnimalDotCom.toArray(AnimalDot);
		
		finalResult= ask(d1.CompleteDT,PetDotCom,NatureDotCom,AnimalDotCom);
		
		ArrayList<String> pet=new ArrayList<String>(Arrays.asList(PetDot));
		ArrayList<String> nature=new ArrayList<String>(Arrays.asList(NatureDot));
		ArrayList<String> animal=new ArrayList<String>(Arrays.asList(AnimalDot));

		f.end(finalResult,pet,nature,animal);
				
	}


	
	public ArrayList<String> doIt(){
		String a[]=new String[num];
		locator l=new locator();
		boolean pass=true;		
		boolean ntComplete=true;
		
		//System.out.print("CompleteDT: ");
		//for(int i=0;i<CompleteDT.size();i++)
		//	System.out.print(CompleteDT.get(i)+" ");
		//System.out.println();
		
		while(ntComplete){
			a=l.locate();
			ntComplete=false;
			for(int i=0;i<a.length;i++){
				//System.out.println(a[i]);
				if(CompleteDT.contains(a[i])){
					ntComplete=true;
					//System.out.println("***no. REPEAT***");
				}
			}
			//System.out.println();
		}
		ArrayList<String> clone=new ArrayList<String>();
		for(int i=0;i<a.length;i++){
			clone.add(a[i]);
			CompleteDT.add(a[i]);
		}
		
		//System.out.println("\nCompleteDT Size: "+CompleteDT.size()+"\n");
			
		//System.out.print("CompleteDT: ");
		//for(int i=0;i<CompleteDT.size();i++)
		//	System.out.print(CompleteDT.get(i)+" ");
		//System.out.println();
		
		//System.out.print("Clone: ");
		//for(int i=0;i<clone.size();i++)
		//	System.out.print(clone.get(i)+" ");
		//System.out.println("\nEND\n\n");
		
		
		return clone;
	}


	
	public void display(){
				
		System.out.println("\n                                        The GRID\n");
		char a='A';
		for(int i=0;i<7;i++){
			System.out.print("                                  ");
			for(int j=0;j<7;j++){
				System.out.print((String.valueOf(a)).concat(String.valueOf(j+1))+" ");
			}
			a=(char)(a+1);
			System.out.println();
		}
		System.out.println("\n           There are 3 DotComs hidden in the GRID, each in 3 consecutive cell.");
		System.out.println("                               Try your luck! Search them.");
	} 
	
	public int ask(ArrayList<String> check,ArrayList<String> Pet,ArrayList<String> Nature,ArrayList<String> Animal){
		ArrayList<String> repeat=new ArrayList<String>();
		int numOfCounts=0;
		boolean ch1=true;
		boolean ch2=true;
		boolean ch3=true;
		int index=0;
		
		while(!check.isEmpty()){
			numOfCounts++;
			String result="Miss";		
		    String askGuess=helper.getInput("Enter your Guess:    ");
				
			if(repeat.contains(askGuess)){
				result="You have repeated a \"HIT\" word. Keep Trying...!";
			}
			else if(check.contains(askGuess)){
				
				repeat.add(askGuess);
				index=check.indexOf(askGuess);
				check.remove(index);
				result="Hit";
				if(check.isEmpty())
					result="Kill";
			}
			if(ch1){			
				if(Pet.contains(askGuess)){
					index=Pet.indexOf(askGuess);
					Pet.remove(index);
					if(Pet.isEmpty()){
						sinkDot++;
						System.out.println("Congrats! You just sank .com #"+sinkDot+":  Pet.com");
						ch1=false;
					}
				}
			}
			if(ch2){			
				if(Nature.contains(askGuess)){
					index=Nature.indexOf(askGuess);
					Nature.remove(index);
					if(Nature.isEmpty()){
						sinkDot++;
						System.out.println("Congrats! You just sank .com #"+sinkDot+":  Nature.com");
						ch2=false;
					}
				}
			}
			if(ch3){			
				if(Animal.contains(askGuess)){
					index=Animal.indexOf(askGuess);
					Animal.remove(index);
					if(Animal.isEmpty()){
						sinkDot++;
						System.out.println("Congrats! You just sank .com #"+sinkDot+":  Animal.com");
						ch3=false;
					}
				}
			}
			System.out.println(result);
		}
		return numOfCounts;
	}

}
















