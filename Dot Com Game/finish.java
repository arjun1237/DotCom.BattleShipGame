import java.util.*;

public class finish{
	private int score;
	private String test;
	public void end(int counts,ArrayList<String> p,ArrayList<String> n,ArrayList<String> an){
			
		if (counts>=9 && counts<=108)
			score=100-(counts-9);
		if (counts>108)
			score=1;
		System.out.println("\n");
		System.out.println("      CONGRATS...!   The game has been successfully completed. Your score is :  **  "+score+" %  **\n");
		
		System.out.println("\n           Original GRID                                      GRID after DotCom sink\n");
		char a='A';
		for(int i=0;i<7;i++){
			System.out.print("        ");
			for(int j=0;j<7;j++){
				test=String.valueOf(a).concat(String.valueOf(j+1));
				System.out.print(test+" ");
			}
			System.out.print("                                  ");
			for(int j=0;j<7;j++){
				test=String.valueOf(a).concat(String.valueOf(j+1));
				if(  (p.contains(test)) || (n.contains(test)) || (an.contains(test)) )
					System.out.print("-- ");
				else
					System.out.print(test+" ");
			}
			a=(char)(a+1);
			System.out.println();
		}
		System.out.print("\n                                    Pet.Com:    ");
		for(String i:p)
			System.out.print(i+" ");
		System.out.println();
		
		System.out.print("                                    Nature.Com: ");
		for(String i:n)
			System.out.print(i+" ");
		System.out.println();
		
		System.out.print("                                    Animal.Com: ");
		for(String i:an)
			System.out.print(i+" ");
		System.out.println("\n");
		System.out.println(".....................................................THE END.................................................................");
	}
}