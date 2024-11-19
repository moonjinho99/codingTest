import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		List<Integer> list = new ArrayList<Integer>();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		int cnt = Integer.parseInt(br.readLine());
		String [] command = br.readLine().split(" ");
		
		for(int i=1; i<=cnt; i++)
		{
			list.add(i);
		}
				
		for(int i=0; i<cnt; i++)
		{		 
			int cardNum = list.get(i);
			
			switch(command[cnt-(i+1)]) {
				case "1":
					deque.addFirst(cardNum);
					break;
				case "2":
					if(deque.isEmpty())
						deque.addFirst(cardNum);
					else
					{
						int secondTemp = deque.pollFirst();
						deque.addFirst(cardNum);
						deque.addFirst(secondTemp);
					}
					break;
				case "3":
					deque.addLast(cardNum);
					break;
					
			}
		}
		
		while(!deque.isEmpty())
			bw.write(deque.poll()+" ");
				
		bw.flush();
		br.close();		
		bw.close();
	}			
}
