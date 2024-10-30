import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		String pattern = sc.next();
		String[] patSplit = pattern.split("\\*");
		
		String f_pattern = patSplit[0];
		String b_pattern = patSplit[patSplit.length-1];
			
		String[] inputString = new String[cnt];
		List<String> result = new ArrayList<>();
				
		for(int i=0; i<cnt; i++)
		{
			inputString[i] = sc.next();
			int size = inputString[i].length();
			
			if(size < f_pattern.length() + b_pattern.length())
			{
				result.add("NE");
				continue;
			}
									
			if(inputString[i].substring(0, f_pattern.length()).equals(f_pattern) && inputString[i].substring(size - b_pattern.length(),size).equals(b_pattern))
			{
				result.add("DA");
			}
			else {
				result.add("NE");
			}
			
		}
		
		for(String res : result)
		{
			System.out.println(res);
		}

		
	}
}
