import java.util.*;

//4개의 지표로 성격 유형을 구분. 각 지표에서 하나로 결정
//1 - R,T
//2 - C,F
//3 - J,M
//4 - A,N
// 성격 유형은 16가지 
// n개의 질문
// 각 질문은 1가지 지표로 성격 유형 점수를 판단
// 질문에 따라 동의/비동의가 어떤 성격유형의 점수인지 주어짐
// [동의] 3 2 1 0 1 2 3 [비동의] - 이런식으로 점수 분배
// [동의] 1 2 3 4 5 6 7 [비동의] - choice
// ex) RT - R: 비동의 , T: 동의
// R - 5(1),6(2),7(3) / T = 1(3), 2(2), 3(1) 

class Solution {
    
    private Map<Character,Integer> map = new HashMap<>();
    private char[] type = {'R','T','C','F','J','M','A','N'};
    private String[] survey;
    private int[] choices;
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        this.survey = survey;
        this.choices = choices;
        
        //1. 값 초기화
        for(char c : type)
        {
            map.put(c,0);
        }
        
        //2. 검사
        test();       
        
        //3. 결과 추출
        answer = result();
        
        return answer;
    }
    
    private void test()
    {
        //1. survey 분리 - 앞이 비동의 뒤가 동의
        for(int i=0; i<survey.length; i++)
        {
            char no = survey[i].charAt(0);
            char yes = survey[i].charAt(1);
            int choice = choices[i];
            
            //비동의 점수
            if(choice < 4)
            {
                map.put(no, map.get(no)+(4-choice));
            }
            
            //동의 점수
            if(choice > 4)
            {
                map.put(yes, map.get(yes)+(choice-4));
            }
            
        }        
    }
    
    private String result()
    {
        String answer = "";
        
        //1. RT
        if(map.get('R') < map.get('T'))
            answer += "T";
        else
            answer += "R";
        
        //2. CF
        if(map.get('C') < map.get('F'))
            answer += "F";
        else
            answer += "C";
        
        //3. JM
        if(map.get('J') < map.get('M'))
            answer += "M";
        else
            answer += "J";
        
        //4. AN
        if(map.get('A') < map.get('N'))
            answer += "N";
        else
            answer += "A";
        
        
        return answer;
    }
    
    
}