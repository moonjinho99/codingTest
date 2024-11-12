import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		Queue<Integer> card = new ArrayDeque<Integer>();
		int inputNum = Integer.parseInt(br.readLine());
		for(int i=1; i<=inputNum; i++)
			card.add(i);
		while(card.size() > 1)
		{
			card.poll();
			card.add(card.peek());
			card.poll();
		}
		
		bw.write(card.peek().toString());	
		
		bw.flush();
		bw.close();
	}   	
}