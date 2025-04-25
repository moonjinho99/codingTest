import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	static List<Double> drink = new ArrayList<Double>();
	
	public static void main(String[] args) throws IOException
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] size = br.readLine().split(" ");
		
		for(int i=0; i<N; i++)
			drink.add(Double.parseDouble(size[i]));
		
		
		System.out.println(greedy());
		
		br.close();
	}	
	
	private static double greedy()
	{
		double result = 0;
		
		Collections.sort(drink);	
		Collections.reverse(drink);		
		
		int last = drink.size();
		for(int i=0; i<drink.size(); i++)
		{
			if(i == last-1)
				break;
			
			double case1 =  drink.get(i) + (drink.get(i+1)/2.0);
			double case2 = drink.get(i+1) + (drink.get(i)/2.0);
			
			if(case1 > case2)
			{
				result = case1;
				drink.set(i+1, case1);
			}
			else
			{
				result = case2;
				drink.set(i+1, case2);
			}
		}
		
		return result;
	}
	
			
}
