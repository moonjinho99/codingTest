import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = findMin(numbers[i]);
        }

        return answer;
    }

    private long findMin(long num) {
        // 짝수는 무조건 num + 1이 답
        if (num % 2 == 0) {
            return num + 1;
        }

        // 이진 문자열로 변환
        String binary = Long.toBinaryString(num);

        binary = "0" + binary;

        // 뒤에서부터 '01' 찾기 
        char[] arr = binary.toCharArray();
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] == '0' && arr[i + 1] == '1') {
                // 0 → 1, 1 → 0 스왑
                arr[i] = '1';
                arr[i + 1] = '0';
                break;
            }
        }

        return Long.parseLong(String.valueOf(arr), 2);
    }
}
