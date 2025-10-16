import java.util.*;

//출근 : 출근 희망 시각 + 10 
//토,일은 이벤트 영향 X
//시 * 100 + 분
//10시 13분 - 1013 , 09시 58분 - 958

//출근 희망 시각과 출근한 기록을 바탕으로 상품을 받을 직원이 몇 명인지?

//schedules - 직원 n명이 설정한 출근 희망 시각
//timelogs - 직원들이 일주일 동안 출근한 시각
//startday - 이벤트 시작한 요일을 의미

//문제
//오늘부터 일주일 동안 설정한 출근 희망 시각에 늦지 않고 출근한 직원들에게 상품
//상품을 받을 직원의 수?

//1. startday로 주말이 몇번째 인덱스인지 찾기
//2. schedules의 값과 timelogs의 값을 비교하여 timelogs값이 크면 두 수의 차가 10이하인지 확인

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int setIdx = 6 - startday;
        int sunIdx = 7 - startday;        
        if(setIdx < 0)
            setIdx = 6;
        
        int cnt =0;
        boolean check = true;
        
        int human = schedules.length;
        for(int i=0; i<human; i++)
        {
            check = true;
            for(int j=0; j<7; j++)
            {
                if(j == setIdx || j == sunIdx)
                    continue;               
                
                if(schedules[i] < timelogs[i][j])
                {
                    int time = (timelogs[i][j] / 100) * 60 * 60 + (timelogs[i][j] % 100) * 60;
                    int schedulesTime = (schedules[i] / 100) * 60 * 60 + (schedules[i] % 100) * 60;
                    
                    if(time - schedulesTime > 600)
                        check=false;
                }           
            }            
                            
            if(check)
                cnt++;
        }
        
        answer = cnt;
        
        return answer;
    }
}