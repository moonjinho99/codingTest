import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] cities;
    static int[] load; // 거리 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시

        cities = new ArrayList[N + 1];
        load = new int[N + 1];
        Arrays.fill(load, -1); // 방문하지 않은 도시의 거리 값은 -1로 설정

        for (int i = 1; i <= N; i++) {
            cities[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());
            cities[city1].add(city2); // 단방향 그래프
        }

        bfs(X);

        // 결과 저장
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (load[i] == K) {
                sb.append(i).append("\n");
            }
        }

        // 결과 출력
        System.out.print(sb.length() == 0 ? "-1" : sb.toString());
        br.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        load[start] = 0; // 시작 도시의 거리 = 0

        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int next : cities[city]) {
                if (load[next] == -1) { // 방문하지 않은 도시만 탐색
                    queue.add(next);
                    load[next] = load[city] + 1; // 거리 갱신
                }
            }
        }
    }
}
