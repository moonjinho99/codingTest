import java.util.*;

class Solution {
    
    public int[] solution(String today, String[] terms, String[] privacies) {       
        List<Integer> answerList = new ArrayList<Integer>();
        int seq = 1;
        int n=0;
        Map<String,Integer> termsMap = new HashMap<String,Integer>();
       
        for(String t : terms)
        {
            String tArray[] = t.split(" ");
            termsMap.put(tArray[0],Integer.parseInt(tArray[1])); 
        }
        
        for(String privacy : privacies)
        {
            String pArray[] = privacy.split(" ");
            if(compareToday(today,pArray[0],termsMap.get(pArray[1])))
            {
                answerList.add(seq);
                n++;
            }                
            seq++;
        }
                        
        int[] answer = new int[n];  
        for(int i =0; i<n; i++)
        {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    private boolean compareToday(String today, String privacy, int term)
    {                
        String todays[] = today.split("\\.");
        int toYYYY = Integer.parseInt(todays[0]);
        int toMM = Integer.parseInt(todays[1]);
        int toDD = Integer.parseInt(todays[2]);
        
        String privacyDay[] = privacy.split("\\.");
        int prYYYY = Integer.parseInt(privacyDay[0]);
        int prMM = Integer.parseInt(privacyDay[1]);
        int prDD = Integer.parseInt(privacyDay[2]);
        
        if(prMM+term > 12)
        {
            prYYYY += (prMM+term) / 12;
            prMM = (prMM+term) % 12;
            
            if(prMM == 0)
            {
                prYYYY--;
                prMM = 12;
            }
                
        }
        else{
            prMM+=term;
        }
        
        if(toYYYY == prYYYY)
        {
            if(toMM == prMM)
            {
                if(toDD < prDD)
                {
                    return false;
                }
                else{
                    return true;
                }                
            }
            else if(toMM > prMM)
            {
                return true;
            }
            else if(toMM < prMM)
            {
                return false;
            }
        }
        else if(toYYYY > prYYYY)
        {
            return true;
        }
        else if(toYYYY < prYYYY)
        {
            return false;
        }      
        
        return false;
    }
    
    
}