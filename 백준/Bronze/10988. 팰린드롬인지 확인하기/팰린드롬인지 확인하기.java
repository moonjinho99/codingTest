import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		
		int pd = 0;
		
		for(int i=0; i<word.length()/2; i++)
		{
			if(word.charAt(i) == word.charAt(word.length()-1-i))
			{
				pd++;
			}
		}
		
		if(pd == word.length()/2)
			System.out.println("1");
		else
			System.out.println("0");
									
	}

}
