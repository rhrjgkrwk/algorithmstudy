package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Bus{
	int vertex;
	int adjVertex;
	int w;
	public Bus(int v, int adjV, int w) {
		this.vertex = v;
		this.adjVertex = adjV;
		this.w = w;
	}
}
public class ShortestPath1916 {
	public static int n;//도시 수  - 도시이름은 1부터 시작.
	public static int m;//버스 수
	public static int dest;//도착지
	public static int start;//출발지
	public static int d[];
	public static boolean visit[];
	public static ArrayList<Bus>[] list;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1]; //1부터 시작. 0은 사용안한다.
		d = new int[n+1];
		visit = new boolean[n+1];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) { //인접 arraylist & d배열 초기화
			list[i] = new ArrayList<>();
			d[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int vertex = Integer.parseInt(st.nextToken());
			int adjVertex = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[vertex].add(new Bus(vertex, adjVertex, weight)); //인접리스트 입력.
		}
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());
		//output 
		d[start] = 0;
		shortestPath();
		
		System.out.println(d[dest]);
	}
	public static void shortestPath(){
		for (int i = 0; i < n; i++) { 
			//시작점으로 부터 가장 가까운 점 선택 - 이 부분을 pq로 구현하면 복잡도가 좀 줄어든닫고 한다.ㅇ
			int min = Integer.MAX_VALUE;
			int minAdj = -1;
			for (int j = 1; j <= n; j++) { //도시번호는 1부터.
				if (!visit[j] && d[j] < min) {
					min = d[j];
					minAdj = j;
				}
			}
			visit[minAdj] = true; 
			// 아직 방문하지 않은 곳이면서 시작점으로부터 가장 가까운 정점을 방문한다.
			
			
			//목적지에 도착하면 함수를 종료한다.
			if (minAdj==dest) {
				break;
			}
			
			
			//위에서 선택한 방문하지 않았고 시작점으로부터 가장 가까운 점으로부터 인접한 점들을 살펴보고 
			//그 인접점까지의 거리가 기존 입력된 값보다 더 짧으면 업데이트한ㄷ.
			//초기에는 d배열이 inf로 초기화되어있으므로  시작점의 인접점까지의 거리가 담긴다.
			
			for (Bus b : list[minAdj]) { 
				//현재경로로부터 나온 거리와 기존 입력된 거리 비교.
				if (!visit[b.adjVertex] && d[b.adjVertex] > d[b.vertex] + b.w) { 
					//방문한 적 없고 새로운 경로로부터 온 거리가 더 짧으면
					d[b.adjVertex] = d[b.vertex] + b.w;
				}
			}
		}
	}
}


/*
1916번
최소비용 구하기 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	11561	3805	2166	30.294%
문제
n(1≤n≤1,000)개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1≤m≤100,000)개의 버스가 있다. 우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. 그러면 A번째 도시에서 B번째 도시 까지 가는데 드는 최소비용을 출력하여라.

입력
첫째 줄에 도시의 개수 n(1≤n≤1,000)이 주어지고 둘째 줄에는 버스의 개수 m(1≤m≤100,000)이 주어진다. 
그리고 셋째 줄부터 m+2줄까지 다음과 같은 버스의 정보가 주어진다. 
먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 
그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 
버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.

그리고 m+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.

예제 입력 1 
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5
예제 출력 1 
4
*/