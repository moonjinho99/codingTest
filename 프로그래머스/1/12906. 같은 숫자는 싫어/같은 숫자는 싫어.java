import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        int backupNum = -1;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++)
        {
            if(backupNum != arr[i])
            {
                list.add(arr[i]);
            }           
            backupNum = arr[i];
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++)
        {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}