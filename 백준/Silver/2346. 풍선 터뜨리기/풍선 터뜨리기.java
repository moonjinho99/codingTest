import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
		Deque<Balloon> deque = new ArrayDeque<Balloon>();
		
		int cnt = Integer.parseInt(br.readLine());
		String[] balloons = br.readLine().split(" ");
		
		bw.write("1 ");
		int moveValue = Integer.parseInt(balloons[0]);
		
		for(int i=1; i<cnt; i++)
		{
			deque.offer(new Balloon(i+1,Integer.parseInt(balloons[i])));
		}
		
		while(!deque.isEmpty())
		{				
			
			if(moveValue > 0)
			{	
				for(int i=1; i<moveValue; i++)
				{
					deque.offer(deque.poll());
				}
									
				Balloon next = deque.poll();
				moveValue = next.numValue;
				bw.write(next.index+" ");
			}
			else {
								
				for(int i=1; i<-moveValue; i++)
				{
					deque.offerFirst(deque.pollLast());
				}
				
				Balloon next = deque.pollLast();
				moveValue = next.numValue;
				bw.write(next.index+" ");
			}	
		}									
		bw.flush();
		br.close();		
		bw.close();
	}				
}

class Balloon{
	int index;
	int numValue;
	
	public Balloon(int index, int numValue) {
		this.index = index;
		this.numValue = numValue;
	}
}
