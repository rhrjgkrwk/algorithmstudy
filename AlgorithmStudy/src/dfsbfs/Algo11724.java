package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo11724 {
	public static int graph [][];
	public static boolean visit [];
	public static int N; //정점 수 
	public static int M; //간선 수 
	
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new int[N+1][N+1];
		visit = new boolean[N+1];
		int result = 0;
		
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u][v] = 1;
			graph[v][u] = 1;
		}
		
		for (int i = 1; i <= N ; i++) {
			if (!visit[i]) {
				q.add(i);
				result++;
				while (!q.isEmpty()) {
					int now = q.poll();
					visit[now] = true;
					for (int next = 1; next <= N; next++) {
						if (graph[now][next] == 1 && !visit[next]) {
							q.add(next);
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}

/*
11724번
연결 요소의 개수
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
3 초	256 MB	9501	4840	3242	48.569%
문제
방향 없는 그래프가 주어졌을 때, 
연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
(1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 
둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. 
(1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

출력
첫째 줄에 연결 요소의 개수를 출력한다.

예제 입력 1 
6 5
1 2
2 5
5 1
3 4
4 6
예제 출력 1 
2
예제 입력 2 
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3
예제 출력 2 
1
*/