import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length() - k;  // 최종 자리수
        int start = 0;                  // 탐색 시작 위치
        
        for (int i = 0; i < len; i++) {
            int end = k + i;            // 이번 자리에서 탐색할 끝 위치
            char max = '0';
            int maxIndex = start;
            
            // 현재 구간에서 최댓값 찾기
            for (int j = start; j <= end; j++) {
                char c = number.charAt(j);
                if (c > max) {
                    max = c;
                    maxIndex = j;
                    // 최적화: '9' 만나면 더 볼 필요 없음
                    if (max == '9') break;
                }
            }
            
            answer.append(max);
            start = maxIndex + 1; // 다음 탐색 시작 위치 갱신
        }
        
        return answer.toString();
    }
}
