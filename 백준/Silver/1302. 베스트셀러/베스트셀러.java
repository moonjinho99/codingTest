import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
		
		int N = Integer.parseInt(br.readLine());
		Map<String,Integer> book = new HashMap<String, Integer>();
		int max = 0;
		
		
		for(int i=0; i<N; i++)
		{
			String sell = br.readLine();
			 
			if(book.get(sell) != null)
			{
				int cnt = book.get(sell);
				cnt++;
				book.put(sell,cnt);
				
				if(cnt > max)
					max = cnt;
			}
			else {
				book.put(sell, 1);
				if(max < 1)
					max = 1;
			}

		}
		
		Set<String> keySet = book.keySet();
		Iterator<String> iterator = keySet.iterator();
		List<String> keyList = new ArrayList<String>();
		while(iterator.hasNext())
		{
			String key = iterator.next();
		
			if(max != book.get(key))
			{
				iterator.remove();
			}
			else {
				keyList.add(key);
			}
		}
		
		Collections.sort(keyList);
		
		bw.write(keyList.get(0));
		
		bw.flush();
		br.close();		
		bw.close();
	}				
}