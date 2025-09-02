import java.util.*;

//n개의 퍼즐풀기
//diff : 난이도, time_cur : 소요시간, time_prev : 이전 퍼즐 소요시간, level : 숙련도
//diff <= level : 퍼즐을 틀리지 않고 time_cur 만큼의 시간을 사용하여 해결
//diff > level : 퍼즐의 틀린횟수 > diff - level, time_cur만큼 시간 사용 + time_prev 만큼 시간을 사용하여 이전 퍼즐 다시 풀고옴 --> 이전퍼즐을 다시풀때는 틀리지 않음, time_cur만큼 시간 사용

//난이도가 높을때는 diff-level만큼 틀린다. 소요시간 : (time_cur + time_prev) * (diff-level) + time_cur
//limit : 제한시간
//숙련도의 최솟값구하기 - level

class Solution {
    
    private int[] diffs;
    private int[] times;
    long limit;
        
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        List<Integer> chkMax = new ArrayList<>();
        for(int diff : diffs)
        {
            chkMax.add(diff);
        }        
        Collections.sort(chkMax);
        int max = chkMax.get(chkMax.size()-1);
            
        long minPlayTime = limit;
        int minLevel = max;
        
        int left = 1;
        int right = max;

        while (left <= right) {
            int mid = (left + right) / 2;
            long playTime = PlayPuzzle(mid);

            if (playTime <= limit) {
                // 조건 만족 → 더 작은 레벨에서도 만족하는지 왼쪽 구간 탐색
                minLevel = mid;
                right = mid - 1;
            } else {
                // 조건 불만족 → 더 큰 레벨에서만 가능
                left = mid + 1;
            }
        }
        
        return minLevel;
    }
    
    private long PlayPuzzle(int level)
    {
        long sumPlayTime = 0;
        for(int i=0; i<diffs.length; i++)
        {
            if(i == 0)
            {
                sumPlayTime += times[0];
                continue;
            }
            
            int chkLevel = diffs[i] - level;
            
            if(chkLevel <= 0)
            {
                sumPlayTime += times[i];
            }
            else{                
                sumPlayTime += ReplayTimeCalCulate(times[i], times[i-1], chkLevel);                
            }    
            
            if (sumPlayTime > limit) return sumPlayTime;
        }        
        return sumPlayTime;
    }
    
    
    //숙련도가 낮을때의 시간 구하기
    private long ReplayTimeCalCulate(int time_cur, int time_prev, int cnt)
    {
        return (time_cur + time_prev) * cnt + time_cur;
    }
    
}