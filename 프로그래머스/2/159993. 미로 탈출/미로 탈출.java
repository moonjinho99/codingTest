import java.util.*;

class Solution {
    
    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,1,-1};

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        int sx = 0, sy = 0;
        int lx = 0, ly = 0;
        int ex = 0, ey = 0;
        
        // 시작, 레버, 출구 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    sx = j; sy = i;
                } else if (c == 'L') {
                    lx = j; ly = i;
                } else if (c == 'E') {
                    ex = j; ey = i;
                }
            }
        }
        
        int toLever = bfs(maps, sx, sy, 'L');
        if (toLever == -1) return -1;
        
        int toEnd = bfs(maps, lx, ly, 'E');
        if (toEnd == -1) return -1;
        
        return toLever + toEnd;
    }
    
    private int bfs(String[] maps, int startX, int startY, char target) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startY][startX] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if (maps[y].charAt(x) == target) {
                return dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (visited[ny][nx]) continue;
                if (maps[ny].charAt(nx) == 'X') continue;
                
                visited[ny][nx] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }
        
        return -1; // target을 못 찾음
    }
}
