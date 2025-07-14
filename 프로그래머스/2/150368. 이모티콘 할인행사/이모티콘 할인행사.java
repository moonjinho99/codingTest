import java.util.*;

class Solution {
    
    //우선순위
    //1. 플러스 가입자 증가
    //2. 이모티콘 판매액 증가
    
    //이모티콘 할인율은 10,20,30,40 
    
    //사용자들은 자신의 기준에 따라 이모티콘 구매
    //사용자들은 자신의 기준에 따라 이모티콘 구매 비용의 합이 일정 가격 이상 된다면 구매 취소 후 플러스 가입
    
    //최대의 목표를 달성하려면 이모티콘의 할인율을 조절해야함 
    
    private static int[][] users;
    private static int[] emoticons;
    private static int[] result = new int[2];
    private static int[] dcs = {10,20,30,40};
    
    public int[] solution(int[][] users, int[] emoticons) {       
        this.emoticons = emoticons;
        this.users = users;
        int[] emoDc = new int[emoticons.length];
        
        startDc(0, emoDc);
                       
        return result;
    }
    
    private void startDc(int index, int[] emoDc)
    {
        if(index == emoDc.length)
        {
            check(emoDc);
            return;
        } 
       
        for(int i=0; i<dcs.length; i++)
        {            
            emoDc[index] = dcs[i];
            startDc(index+1, emoDc);
        }
                        
    }
        
    private void check(int[] emoDc)
    {
        int plusCnt= 0;
        int total = 0;        
        
        for(int i=0; i<users.length; i++)
        {
            int userDc = users[i][0];
            int userLimited = users[i][1];
            int sum = 0;
            
            for(int j=0; j<emoticons.length; j++) {
                int dc = emoDc[j]; 

                if(userDc <= dc) {
                    int dcPrice = emoticons[j] * (100 - dc) / 100;

                    sum += dcPrice;
                }
            }    
            
            if(sum >= userLimited)
                plusCnt++;
            else
                total += sum;
        }
        
       if(plusCnt > result[0]){
           result[0] = plusCnt;
           result[1] = total;
       }
       else if(plusCnt == result[0])
       {
           if(total > result[1])
           {
               result[0] = plusCnt;
               result[1] = total;
           }            
       }            
    }
    
}