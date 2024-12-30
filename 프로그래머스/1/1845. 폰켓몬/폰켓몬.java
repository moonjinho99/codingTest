import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int getCnt = nums.length / 2;
        Set<Integer> set = new HashSet<Integer>();        
        
        for(int i : nums)
        {
            set.add(i);
        }
        
        answer = set.size();
        
        while(answer > getCnt)
        {
            answer--;
        }        
                
        return answer;
    }
}