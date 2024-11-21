import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int cnt = 0;
		
		String[] command = br.readLine().split(" ");
		int size = Integer.parseInt(command[0]);
		int outputCnt = Integer.parseInt(command[1]);
		
		String[] outputNum = br.readLine().split(" ");
		int[] outputNumArray = new int[outputCnt];
		
		for(int i=0; i<size; i++)
		{
			deque.offer(i+1);
			if(i<outputCnt)
				outputNumArray[i] = Integer.parseInt(outputNum[i]);
		}		
		int i=0;	
		int middleIndex = deque.size()/2;
		int findIndex = new ArrayList<>(deque).indexOf(outputNumArray[0]);
		while(!(size-outputCnt == deque.size()))
		{			
			if(outputNumArray[i] == deque.getFirst())
			{
				i++;
				deque.pollFirst();
				if(i >= outputNumArray.length)
					break;
				middleIndex = deque.size()/2;
				findIndex = new ArrayList<>(deque).indexOf(outputNumArray[i]);
				continue;
			}
						
			if(middleIndex >= findIndex)
				deque.addLast(deque.pollFirst());
			
			if(middleIndex < findIndex)
				deque.addFirst(deque.pollLast());

			cnt++;			
		}
		
		bw.write(Integer.toString(cnt));								
		bw.flush();
		br.close();		
		bw.close();
	}						
}