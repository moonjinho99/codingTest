import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String word;
	static boolean firstA = false;
	
	public static void main(String[] args) throws IOException
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<cnt; i++)
		{
			word = br.readLine();
			if(checkFirst())
			{
				if(checkA())
				{					
					if(checkF())
					{						
						if(checkC())
						{
							if(checkLast())
							{
								System.out.println("Infected!");
							}
							else {
								System.out.println("Good");
								continue;
							}							
						}else {
							System.out.println("Good");
							continue;
						}
						
					}else {
						System.out.println("Good");
						continue;
					}
				}
				else {
					System.out.println("Good");
					continue;
				}
			}
			else {
				System.out.println("Good");
				continue;
			}
		}
						
		br.close();
	}	
				
	private static boolean checkFirst()
	{
		String first = "ABCDEF";

		if(!first.contains(Character.toString(word.charAt(0))))
		{
			return false;
		}
		
		if(first.charAt(0) == 'A')
			firstA = true;
		
		word = subStringFirst(word);
		
					
		return true;
	}
	
	private static boolean checkA()
	{
		if(word.charAt(0) != 'A') {
			if(firstA)
				return true;
			else
				return false;
		}
		
		word = subStringFirst(word);
		
		if(word.equals(""))
			return true;
		
		if(word.charAt(0) == 'A')
			checkA();
				
		return true;
	}
	
	private static boolean checkF()
	{
		if(word.charAt(0) != 'F') {			
				return false;
		}
		
		word = subStringFirst(word);
		
		if(word.equals(""))
			return true;
		
		if(word.charAt(0) == 'F')
			checkF();
				
		return true;
	}
	
	private static boolean checkC()
	{
		if(word.charAt(0) != 'C') {			
			return false;
		}
		
		word = subStringFirst(word);
		
		if(word.equals(""))
			return true;
		
		if(word.charAt(0) == 'C')
			checkC();
				
		return true;
	}
	
	private static boolean checkLast()
	{
		String last = "ABCDEF";
		
		if(word.equals(""))
			return true;
		
		if(!last.contains(Character.toString(word.charAt(0))))
		{
			return false;
		}
				
		return true;
	}
	
	private static String subStringFirst(String word)
	{
		if(word.length() == 1)
			return "";
		
		return word.substring(1,word.length());
	}
		
}
