import java.util.*;

class Solution {
    
    public int solution(int n, int k) {
        int answer = -1;     
        String nstr = Long.toString(n,k);
        
        answer = countPrime(nstr);
        
        return answer;
    }
    
    private int countPrime(String nstr)
    {        
        int cnt = 0;
        String completeNum = "";
        
        //진수 변환시 0이 없을 때
        if(!nstr.contains("0"))
        {
            if(checkPrime(Long.parseLong(nstr)))
            {
                cnt++;
            } 
            
            return cnt;
        }
        
        String nArray[] = nstr.split("0");
        
        for(String str : nArray)
        {
            if(!str.equals(""))
                if(checkPrime(Long.parseLong(str)))
                    cnt++;
        }
        
       return cnt;
    }
        
    private boolean checkPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false; 

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}