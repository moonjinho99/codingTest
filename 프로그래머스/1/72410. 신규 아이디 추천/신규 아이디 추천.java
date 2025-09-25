import java.util.*;

//새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발

//아이디 길이 3~15
//알파벳 소문자, 숫자, -, _, . 만 사용가능
//.은 처음과 끝에는 사용할 수 없고 연속 사용불가

//1. 모든 문자 소문자로 치환
//2. 알파벳 소문자, 숫자, -, _, . 제외 모두 제거
//3. .가 2번 이상 연속된다면 .하나로 치환
//4. .이 처음과 끝에 있다면 제거
//5. 빈 문자열이면 a대입
//6. new_id가 16자 이상이면 첫 15개 제외 나머지 모두 삭제, 15번째가 . 이면 .까지 제거
//7. new_id가 2자 이하라면, new_id의 마지막 문자를 길이가 3이 될 때까지 반복해서 붙임


class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        answer = phase1(new_id);
        answer = phase2(answer);
        answer = phase3(answer);
        answer = phase4(answer);        
        answer = phase5(answer);
        answer = phase6(answer);
        answer = phase7(answer);
           
        return answer;
    }
    
    //1단계
    private String phase1(String new_id)
    {
        if(new_id.length() == 0)
            return new_id;
        
        return new_id.toLowerCase();
    }
    
    //2단계
    private String phase2(String new_id)
    {
        
        if(new_id.length() == 0)
            return new_id;
        
        String change_id = "";
        for(int i=0; i<new_id.length(); i++)
        {
            char c = new_id.charAt(i);
            
            if(c == '-' || c == '_' || c == '.' || Character.isDigit(c) || Character.isLowerCase(c))
            {
                change_id += Character.toString(c);
            }
            
        }
        
        return change_id;
        
    }
    
    //3단계
    private String phase3(String new_id)
    {
        if(new_id.length() == 0)
            return new_id;
               
        String change_id = "";
        int cnt = 0;
        for(int i=0; i<new_id.length(); i++)
        {      
            char c = new_id.charAt(i);
            
            if(c == '.')
            {
                cnt++;                
                if(cnt == 2)
                {
                    cnt = 1;
                    continue;
                }
            }
            else{
                cnt = 0;
            }
            
            change_id += c;
        }
        
        return change_id;
    }
    
    //4단계
    private String phase4(String new_id)
    {
        if(new_id.length() == 0)
            return new_id;
        
        char first = new_id.charAt(0);
        char last = new_id.charAt(new_id.length()-1);
        
        if(first == '.')
            new_id = new_id.substring(1, new_id.length());
        
        if(new_id.length() == 0)
            return new_id;
        
        if(last == '.')
            new_id = new_id.substring(0,new_id.length()-1);
        
        return new_id;
    }
    
    //5단계
    private String phase5(String new_id)
    {
        if(new_id.length() == 0)
            new_id = "a";
        
        return new_id;
    }
    
    //6단계
    private String phase6(String new_id)
    {
        if(new_id.length() >= 16)
        {
            new_id = new_id.substring(0,15);
            char last = new_id.charAt(new_id.length()-1);
            
            if(last == '.')
                new_id = new_id.substring(0,new_id.length()-1);      
        }
        
        return new_id;
    }
    
    //7단계
    private String phase7(String new_id)
    {
        if(new_id.length() <= 2)
        {
            
            String last = Character.toString(new_id.charAt(new_id.length()-1));
            
            while(new_id.length() < 3)
            {
                new_id += last;
            }
        }
        
        return new_id;
    }
}