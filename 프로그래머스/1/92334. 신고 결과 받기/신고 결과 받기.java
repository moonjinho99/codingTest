import java.util.*;

//불량 이용자 신고 , 처리 결과 메일 발송

//각 유저는 한 번에 한 명의 유저 신고
//신고 횟수 제한 X, 한 유저를 여러번 신고해도 동일한 유저는 1회로 처리

//k번 이상 신고된 유저는 게시판 이용 정지, 해당 유저를 신고한 모든 유저에게 정지 사실 메일로 발송
//유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용정지, 정지 메일 발송


//1. 리포트 분리 -> 신고인과 피신고인을 정리(메일 발송 시 사용), 피신고인의 카운트 누적
//2. 피신고인의 카운트가 k보다 많으면 피신고인을 신고한 유저들에게 메일 발송

class Solution {
        
    String[] id_list;
    Map<String,List<String>> de_map = new HashMap<>();
    Map<String,Integer> cnt_map = new HashMap<>();
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        this.id_list = id_list;
        answer = new int[id_list.length]; 
        
        //1. report 분리
        for(String dev : report)
        {
            String[] users = dev.split(" ");
            
            if(de_map.containsKey(users[0]))
            {
                //같지 않을때만 넣기, 중복 방지
                if(!de_map.get(users[0]).contains(users[1]))
                    de_map.get(users[0]).add(users[1]);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(users[1]);
                de_map.put(users[0],list);
            }
        }
        
        //2. 카운트 누적
        for(String key : de_map.keySet())
        {
            List<String> de_map_list = de_map.get(key);
            
            for(String de_id : de_map_list)
            {
                if(cnt_map.containsKey(de_id))
                {
                    cnt_map.put(de_id, cnt_map.get(de_id) + 1);
                }
                else{
                     cnt_map.put(de_id, 1);
                }
            }
            
        }                
        
        //3.k와 값 비교
        for(String key : cnt_map.keySet())
        {   
            if(cnt_map.get(key) >= k)
            {
                //id = 신고한 계정
                //de_map_list = 신고당한 계정
                for(String id : de_map.keySet())
                {
                    List<String> de_map_list = de_map.get(id);
                    
                    if(de_map_list.contains(key))
                    {
                        answer[Arrays.asList(id_list).indexOf(id)] += 1;     
                    }                    
                }
            }
            
        }                       
        
        return answer;
    }
}