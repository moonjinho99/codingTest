import java.util.*;

//동영상 재생기
//10초 전 이동, 10초 후 이동, 오프닝 건너뛰기
//prev : 10초 전으로 이동, 현재 위치가 10초 전이면 처음 위치로 이동(0분 0초)
//next : 10초 후로 이동, 남은 시간이 10초 미만이면 마지막 위치로 이동(동영상 길이)
//현재 재생위치가 op_start <= 현재 재생 위치 <= op_end인 경우 자동으로 오프닝이 끝나는 위치로 이동

class Solution {
    private int videoLen;  
    private int pos;       
    private int opStart;   
    private int opEnd;     

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        this.videoLen = toSeconds(video_len);
        this.pos = toSeconds(pos);
        this.opStart = toSeconds(op_start);
        this.opEnd = toSeconds(op_end);

        for (String command : commands) {
            checkOp();

            switch (command) {
                case "prev":
                    prev();
                    break;
                case "next":
                    next();
                    break;
            }
        }
        checkOp();

        return toStringTime(this.pos);
    }

    private void checkOp() {
        if (pos >= opStart && pos <= opEnd) {
            pos = opEnd; 
        }
    }

    private void prev() {        
        if(pos - 10 < 0)
        {
            pos = 0;
            return;
        }           
        pos -= 10;
    }

    private void next() {
        
        if(pos + 10 > videoLen)
        {
            pos = videoLen;
            return;
        }        
        pos += 10;
    }

    private int toSeconds(String time) {
        String[] sp = time.split(":");
        int h = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);
        return h * 60 + m;
    }

    private String toStringTime(int sec) {
        int h = sec / 60;
        int m = sec % 60;
        return String.format("%02d:%02d", h, m);
    }
}
