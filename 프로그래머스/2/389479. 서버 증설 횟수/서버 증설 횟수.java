import java.util.*;

class Solution {
    
    public int solution(int[] players, int m, int k) {
        Queue<int[]> currentServer = new LinkedList<>();
        int answer = 0;   
        int aliveServer = 0; 
        
        for(int i=0; i<players.length; i++) {
            
            while(!currentServer.isEmpty() && currentServer.peek()[0] <= i) {
                aliveServer -= currentServer.peek()[1];  
                currentServer.poll();
            }
            
            int needServer = players[i] / m;

            if(needServer <= aliveServer) 
                continue;
            
            int addServer = needServer - aliveServer;
            answer += addServer;
            aliveServer += addServer;
            currentServer.offer(new int[]{i + k, addServer});  
        }

        return answer;
    }
}
