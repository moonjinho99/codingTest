//비밀 코드는 1~n 까지의 정수 5개로 이루어진 배열
//m = q의 길이
//입혁한 정수들의 배열 q
//시스템 응답을 담은 배열 ans
//비밀 코드로 가능한 정수 조합 개수?
import java.util.*;

class Solution {
    private int answer = 0;
    private int[] combination = new int[5];
    private int n;
    private int[][] q;
    private int[] ans;
        
    public int solution(int n, int[][] q, int[] ans) {                
        this.n = n;
        this.q = q;
        this.ans = ans;
        generateCombination(1,0);
        return answer;
    }
    
    private void generateCombination(int start, int depth)
    {
        if(depth == 5){
            if(isValidCombination()){
                answer++;
            }
            return;
        }
        
        for(int i = start; i <= n; i++){
            combination[depth] = i;
            generateCombination(i+1, depth+1);
        }
        
    }
    
    private boolean isValidCombination(){
        for(int i=0; i<q.length; i++)
        {
            int matchCount = 0;
            for(int num : combination){
                for(int j=0; j<5; j++){
                    if(num == q[i][j]){
                        matchCount++;
                        break;
                    }
                }
            }
            
            if(matchCount != ans[i]){
                return false;
            }
        }
        return true;
    }
}