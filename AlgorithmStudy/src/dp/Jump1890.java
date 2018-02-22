package dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//bfs + memo
public class Jump1890 {
	public static int N;
	public static long [][] d;
	public static int [][] a;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = sc.nextInt();
		a = new int[N][N];
		d = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		d[0][0]=1;
		dp();
		//bfs();
		//dfs();
		sc.close();
	}
	
	public static void dp() {
		
		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++) {
				if (a[i][j]!=0) {
					if (i+a[i][j]<N) {
						d[i+a[i][j]][j] += d[i][j];
					}
					if (j+a[i][j]<N) {
						d[i][j+a[i][j]] += d[i][j];
					}
				}
				else {
					continue;
				}
			}
		}
		System.out.println(d[N-1][N-1]);
	}
	
	public static void bfs(){
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		d[0][0] = 1;
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (a[p.x][p.y] != 0) {
				int nx = p.x + a[p.x][p.y]; // 아래로
				int ny = p.y + a[p.x][p.y]; // 오른
				if (nx >= 0 && nx < N) { // 아래로 갈 수 있으면
					q.add(new Point(nx, p.y));
					d[nx][p.y] += 1;
				}
				if (ny >= 0 && ny < N) { // 오른쪽으로 갈 수 있으면
					q.add(new Point(p.x, ny));
					d[p.x][ny] += 1;
				}
			}
		}
		System.out.println(d[N-1][N-1]);
	}
}
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
/*

점프 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	8667	2508	1903	28.089%
문제
N×N 게임판에 수가 적혀져 있다. 이 게임의 목표는 가장 왼쪽 위 칸에서 
가장 오른쪽 아래 칸으로 규칙에 맞게 점프를 해서 가는 것이다.

각 칸에 적혀있는 수는 현재 칸에서 갈 수 있는 거리를 의미한다. 
반드시 오른쪽이나 아래쪽으로만 이동해야 한다. 0은 더 이상 진행을 막는 종착점이며, 
항상 현재 칸에 적혀있는 수만큼 오른쪽이나 아래로 가야 한다.

가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 
이동할 수 있는 경로의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 게임 판의 크기 N (4 ≤ N ≤ 100)이 주어진다. 그 다음 N개 줄에는 
각 칸에 적혀져 있는 수가 N개씩 주어진다. 칸에 적혀있는 수는
 0보다 크거나 같고, 9보다 작거나 같은 정수이며,
  가장 오른쪽 아래 칸에는 항상 0이 주어진다.

출력
가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 문제의 규칙에 맞게 갈 수 있는 
경로의 개수를 출력한다. 경로의 개수는 263-1보다 작거나 같다.


4
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 0

예제 입력 
4
2 3 3 1
1 2 1 3
1 2 3 1
3 1 1 0
예제 출력 
3

*/