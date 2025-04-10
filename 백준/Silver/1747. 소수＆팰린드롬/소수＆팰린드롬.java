import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		while(true)
		{
			if(findPalindrome(num))
				if(findDecimal(num))
				{
					System.out.println(num);
					break;
				}
				else
					num++;
			else
				num++;			
		}				
		
	}		
	
	private static boolean findPalindrome(int num)
	{
		String numString = Integer.toString(num);
		String originNum = "";
	    String reverseNum = "";
		
		for(int i=0; i<numString.length(); i++)
		{
			originNum += numString.charAt(i);
			reverseNum += numString.charAt((numString.length()-1)-i);
		}
		
		return originNum.equals(reverseNum);		
	}	
	
	private static boolean findDecimal(int num)
	{
		boolean decimalChk = true; 
		
		if(num == 1)
		{
			return false;
		}
		
		for(int i=2; i<num; i++)
		{			
			if(num % i == 0)
			{
				decimalChk = false;
				break;
			}
		}
	
		return decimalChk;
	}		
}
