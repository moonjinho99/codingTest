import java.util.*;

//붕대 감기
//t초 동안 붕대 -> 1초마다 x만큼의 체력
//t초 연속으로 붕대를 감는데 성공 -> y만큼 체력 추가 회복
//최대 체력 존재

//공격당하면 붕대감기 취소
//즉시 다시 사용, 연속 성공시간 0

//공격 받으면 정해진 피해량 만큼 체력이 줄어듦. 0이하가 되면 사망
//붕대 감기 기술의 정보, 최대 체력, 공격 패턴이 주어짐 -> 끝까지 생존 가능한지 확인
//붕대 감기 - 시전 시간, 1초당 회복량, 추가 회복량 > bandage
//최대 체력 > health
//공격 시간, 피해량 > attacks
//남은 체력을 리턴 체력이 0이하면 -1로 표시

class Solution {
    
    private int[] bandage;
    private int health;
    private int[][] attacks;
    private int c_time = 0;
    private int c_health = 0;
    private int seq_time = 0;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        this.bandage = bandage;
        this.health = health;
        this.attacks = attacks;
        c_health = health;
        
        answer = play();
                
        return answer;
    }
       
    private int play()
    {       
        while(c_time <= attacks[attacks.length-1][0])
        {                       
            seq_time++;

            //1. 현재 시간에 공격이 있는지 확인
            //있다면 아래 메서드에서 처리
            if(checkDamage())
            {                
                //데미지 처리 후 체력이 0보다 작거나 같으면 게임 종료
                if(c_health <= 0)
                    return -1;
            }
            else{                            
                //2. 공격이 없다면 연속시간 증가, 붕대 회복
                heal();
            }
                       
            c_time++;
        }
                
        return c_health;
    }
    
    private void heal()
    {        
        if(c_health < health)
        {
            if(seq_time == bandage[0])
            {
                seq_time = 0;
                c_health += bandage[2];
            }
            
            c_health += bandage[1];            
            
            if(c_health > health)
                c_health = health;
        }
        
    }
    
    private boolean checkDamage()
    {
        for(int i=0; i<attacks.length; i++)
        {            
            if(c_time == attacks[i][0])                
            {
                c_health -= attacks[i][1];
                seq_time = 0;

                return true;
            }    
        }
        
        return false;
    }
}