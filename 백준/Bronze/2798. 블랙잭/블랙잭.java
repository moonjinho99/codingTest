import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{		
		Scanner sc=  new Scanner(System.in);
		int cnt = sc.nextInt();
		int num = sc.nextInt();
		int numArray[] = new int[cnt];
		int min = 100001;
		int result = 0;
				
		for(int i=0; i<cnt; i++)
		{
			numArray[i] = sc.nextInt();
		}
		
		for(int i=0; i<numArray.length; i++)
		{
			for(int j=i+1; j<numArray.length; j++)
			{
				for(int k=j+1; k<numArray.length; k++)
				{
					int numArraySum = numArray[i] + numArray[j] + numArray[k];
					int numArraySub = num - numArraySum;
					
					if(numArraySum > num)
						continue;
					
					if(min > numArraySub)
					{
						min = numArraySub;
						result = numArraySum;
					}
				}
			}
		}	
		System.out.println(result);
		
	}   
}