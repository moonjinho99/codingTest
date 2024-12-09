import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();

        for(int i=0; i<N; i++)
        {
            String[] file = br.readLine().split("\\.");
            if(map.containsKey(file[1]))
            {
                int cnt = map.get(file[1]);
                cnt++;
                map.put(file[1],cnt);
            }
            else{
                map.put(file[1],1);
            }
        }
        List<String> key = new ArrayList(map.keySet());
        Collections.sort(key);

        for(String k : key)
        {
            bw.write(k+" "+map.get(k)+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}