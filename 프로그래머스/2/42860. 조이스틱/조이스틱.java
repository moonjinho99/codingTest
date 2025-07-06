import java.util.*;

class Solution {
    
    private int answer = 0;
    
    public int solution(String name) {
             
        int next = 0;
        int move = name.length()-1;
        
        for(int i=0; i<name.length(); i++)
        {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
//             char c = name.charAt(i);
            
//             if(c == 'A')
//             {
//                 continue;
//             }
//             else{
//                 moveAlpha(c);
//             }
            
            next = i+1;
            
            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            
            move = Math.min(move, i*2+name.length()-next);
            move = Math.min(move, (name.length()-next)*2 + i);          
        }
        
        answer += move;
                       
        return answer;
    }
    
    private void moveAlpha(char c)
    {
        //알파벳이 Z랑 A중 어느쪽에 가까운지 체크
        int sub1 = ('Z' - c) + 1; //시작이 A이기 때문에 +1을 해줘야 함
        int sub2 = c - 'A';

        //Z랑 가까움
        if(sub1 < sub2)
        {
            answer += sub1;
        }
        //A랑 가까움
        else {
            answer += sub2;
        }               
    }
    
}