package bruteforce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo1260 {
	public static int graph[][];
	public static boolean visit[];
	public static int N;
	public static int M;
	public static int V;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		graph = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		
		
		dfs(V);
		visit = new boolean[N+1];
		System.out.println();
		bfs(V);
		
	}
	public static void dfs(int start) {
		if (!visit[start]) {
			System.out.print(start+" ");
			visit[start] = true;
		}
		for (int end = 1; end <= N; end++) {
			if (graph[start][end] == 1 && !visit[end]) {
				dfs(end);
			}
		}
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			int now = q.poll();
			if (!visit[now]) {
				visit[now] = true;
				System.out.print(now + " ");
			}
			for (int next = 1; next <= N; next++) {
				if (graph[now][next] == 1 && !visit[next]) {
					q.add(next);
				}
			}
		}
	}
}

/*
1260번
DFS와 BFS 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	42383	13201	7936	29.489%
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 
탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
한 간선이 여러 번 주어질 수도 있는데, 간선이 하나만 있는 것으로 생각하면 된다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력 1 
4 5 1
1 2
1 3
1 4
2 4
3 4
예제 출력 1 
1 2 4 3
1 2 3 4
*/