import java.util.*;

//progresses - 작업 진도
//speeds - 작업 속도
//뒤에 기능이 먼저 개발된다면, 앞의 기능 배포시에 같이 배포
//하루에 하나씩 배포
//작업 진도에 작업 속도만큼 추가하는 반복문이 필요
//반복문안에는 반복문의 싸이클 종료시 마다 작업 진도를 체크하는 로직이 필요
//반복문 탈출 조건은 작업 Queue가 비워졌을때로 하자

class Solution {
    
    private Queue<List<Integer>> workQueue = new LinkedList();
    private List<Integer> finCntList = new ArrayList();
    
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};       
        
        for(int i=0; i<progresses.length; i++)
        {
            List<Integer> work = new ArrayList<>();
            work.add(progresses[i]);
            work.add(speeds[i]);
            
            workQueue.offer(work);
        }        
        
        while(!workQueue.isEmpty())
        {
            int finCnt = 0;
            
            //작업 로직 - 모든 작업을 진행(한 싸이클)
            for(int i=0; i<workQueue.size(); i++)
            {
                List<Integer> work = workQueue.poll();
                int progress = work.get(0);
                int speed = work.get(1);
                work.clear();
                work.add(progress + speed);
                work.add(speed);
                workQueue.offer(work);
            }

            //검사 로직 - 첫 작업이 완료되었는지 확인
           while (!workQueue.isEmpty() && workQueue.peek().get(0) >= 100) {
                workQueue.poll();
                finCnt++;
            }
            
            if(finCnt != 0)
                finCntList.add(finCnt);
            
        }
        
        answer = new int[finCntList.size()];
        
        for(int i=0; i<answer.length; i++)
        {
            answer[i] = finCntList.get(i);
        }
        
        return answer;
    }
}