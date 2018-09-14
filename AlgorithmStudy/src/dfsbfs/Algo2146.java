package dfsbfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Position2146 {
	int x;
	int y;
	public Position2146(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Algo2146 {
	public static HashMap<Integer,Queue<Position2146>> islandList = new HashMap<>();
	
	public static int map [][];
	public static int memo [][];
	public static int N;
	
	public static int dx[] = {0,1,-1,0};
	public static int dy[] = {-1,0,0,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		map = new int [N][N];
		
		for (int i = 0; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//섬 구분
		int islandNumber = -1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					islandList.put(islandNumber, new LinkedList<Position2146>());

					Queue<Position2146> q = new LinkedList<>();
					q.add(new Position2146(i, j));
					map[i][j] = islandNumber;
					
					while (!q.isEmpty()) {
						islandList.get(islandNumber).add(q.peek());
						Position2146 now = q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = now.x + dx[k];
							int ny = now.y + dy[k];
							if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
								map[nx][ny] = islandNumber;
								q.add(new Position2146(nx, ny));
							}
						}
					}
					islandNumber--;
				}
			}
		}
		
		//섬 별 최단 거리 측정 
		int min = Integer.MAX_VALUE;
		for (Integer n : islandList.keySet()) {
			int temp = bfs(islandList.get(n), n);
			if (temp < min) {
				min = temp;
			}
		}
		
		System.out.println(min);
		
	}
	
	public static int bfs(Queue<Position2146> q, int islandNumber) {
		int memo[][] = new int[N][N];
		while (!q.isEmpty()) {
			Position2146 now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (map[nx][ny] != 0 && map[nx][ny] != islandNumber) { //다른 섬에 도달했을 경우.
						return memo[now.x][now.y]; //최초 도달 == 최단 거리 이므로 바로 리턴해버린다..
					}
					if (map[nx][ny] == 0 && memo[nx][ny] == 0) { //바다인 경우 진행한다. 
						memo[nx][ny] = memo[now.x][now.y] + 1;
						q.add(new Position2146(nx, ny));
					}
				}
			}
		}
		return Integer.MAX_VALUE; //다른 섬이 없는 경우 maximum integer를 리턴하도록 하자.
	}
}


/*
2146번
다리 만들기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	7073	2274	1450	30.805%
문제
여러 섬으로 이루어진 나라가 있다. 이 나라의 대통령은, 섬들을 잇는 다리를 만들겠다는 공약으로 인기몰이를 해 당선될 수 있었다. 하지만 막상 대통령에 취임하자, 다리를 놓는다는 것이 아깝다는 생각을 하게 되었다. 그래서 그는, 생색내는 식으로 한 섬과 다른 섬을 잇는 다리 하나만을 만들기로 하였고, 그 또한 다리를 가장 짧게 하여 돈을 아끼려 하였다.

이 나라는 N×N크기의 이차원 평면상에 존재한다. 이 나라는 여러 섬으로 이루어져 있으며, 섬이란 동서남북으로 육지가 붙어있는 덩어리를 말한다. 다음은 세 개의 섬으로 이루어진 나라의 지도이다.



위의 그림에서 색이 있는 부분이 육지이고, 색이 없는 부분이 바다이다. 이 바다에 가장 짧은 다리를 놓아 두 대륙을 연결하고자 한다. 가장 짧은 다리란, 다리가 격자에서 차지하는 칸의 수가 가장 작은 다리를 말한다. 다음 그림에서 두 대륙을 연결하는 다리를 볼 수 있다.



물론 위의 방법 외에도 다리를 놓는 방법이 여러 가지 있으나, 위의 경우가 놓는 다리의 길이가 3으로 가장 짧다(물론 길이가 3인 다른 다리를 놓을 수 있는 방법도 몇 가지 있다).

지도가 주어질 때, 가장 짧은 다리 하나를 놓아 두 대륙을 연결하는 방법을 찾으시오.

입력
첫 줄에는 지도의 크기 N(100이하의 자연수)가 주어진다. 그 다음 N줄에는 N개의 숫자가 빈칸을 사이에 두고 주어지며, 0은 바다, 1은 육지를 나타낸다. 항상 두 개 이상의 섬이 있는 데이터만 입력으로 주어진다.

출력
첫째 줄에 가장 짧은 다리의 길이를 출력한다.

예제 입력 1 
10
1 1 1 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 1 0 0 0 0 1
0 0 0 1 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0
예제 출력 1 
3
*/
