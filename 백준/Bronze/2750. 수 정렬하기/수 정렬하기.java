import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int numArray[] = new int[cnt];
		int result[] = new int[cnt];
		
		for(int i=0; i<cnt; i++)
		{
			numArray[i] = sc.nextInt();
		}
		
		int j=0;
		int min = 0;
		int minIndex = 0;
				
		while(true)
		{
			
			if(j == numArray.length)
				break;
			
			min = 1000000;
			
			for(int i=j; i<numArray.length; i++)
			{				
				if(numArray[i] < min)
				{
					min = numArray[i];
					minIndex = i;
				}				
			}			
			int temp = numArray[j];
			numArray[j] = min;
			numArray[minIndex] = temp;
			j++;
		}			
		for(int res : numArray)
			System.out.println(res);								
	}
}
