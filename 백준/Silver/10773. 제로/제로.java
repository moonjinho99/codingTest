import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		int sum = 0;
		List<Integer> numList = new ArrayList<Integer>();
		
		for(int i=0; i<cnt; i++)
		{
			int inputNum = Integer.parseInt(br.readLine());
			
			if(inputNum == 0)
			{
				numList.remove(numList.size()-1);
			}
			else {
				numList.add(inputNum);
			}
			
		}
		
		for(int num : numList)
		{
			sum += num;
		}
		
		bw.write(Integer.toString(sum));
		
		
		br.close();
		bw.close();
		
	}   
}