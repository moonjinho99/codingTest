import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> map = new HashMap<>();
        int cnt = Integer.parseInt(br.readLine());

        for(int i=0; i<cnt; i++)
        {
            String name = br.readLine();

            if(map.get(name) == null){
                map.put(name,0);
            }
            map.put(name,map.get(name)+1);
        }

        for(int i=0; i<cnt-1; i++){
            String name = br.readLine();

            map.put(name,map.get(name)-1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();

            if(value == 1)
                System.out.println(key);
        }
        br.close();
    }

}