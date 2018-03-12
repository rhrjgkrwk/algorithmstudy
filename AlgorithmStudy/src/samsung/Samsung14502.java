package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point14502 {
	int x;
	int y;

	public Point14502(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Samsung14502 {
	public static int N;
	public static int M;
	public static int map[][];
	public static int dx[] = { 0, 0, 1, -1 };
	public static int dy[] = { -1, 1, 0, 0 };
	public static ArrayList<Point14502> blank = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Queue<Point14502> tmpQ = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while (st.hasMoreTokens()) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) tmpQ.add(new Point14502(i, j)); // 바이러스의 위치를 가지고 있는다.
				if (map[i][j] == 0) blank.add(new Point14502(i, j)); // 공백의 위치를 가짖ㄴ다.
				j++;
			}
		}
		int max = 0;
		for (int i = 0; i < blank.size()-2; i++) {
			for (int j = i+1; j < blank.size()-1; j++) {
				for (int k = j+1; k < blank.size(); k++) {
					Queue<Point14502> q = new LinkedList<>(tmpQ); //큐초기화. 바이러스의 위치를 저장.
					int [][]tmp = new int[N][M];
					boolean visit[][] = new boolean[N][M];
					for (int l = 0; l < N; l++) {
						for (int l2 = 0; l2 < M; l2++) {
							tmp[l][l2] = map[l][l2];
							visit[l][l2] = false;
						}
					}
					
					tmp[blank.get(i).x][blank.get(i).y] = 1;
					tmp[blank.get(j).x][blank.get(j).y] = 1;
					tmp[blank.get(k).x][blank.get(k).y] = 1;
					
					
					int count = 0; // 2의 갯수.
					///////////BFS///////////
					while (!q.isEmpty()) {
						Point14502 p = q.peek();
						q.poll();
						 //바이러스의 수를 센다.
						for (int direction = 0; direction < 4; direction++) {
							int nx = p.x + dx[direction];
							int ny = p.y + dy[direction];
							if (nx >= 0 && ny >= 0 && nx < N && ny < M && tmp[nx][ny] == 0 && visit[nx][ny]==false) {
								tmp[nx][ny] = 2;
								visit[nx][ny] = true;
								q.add(new Point14502(nx, ny));
							}
						}
					}
					for (int l = 0; l < N; l++) {
						for (int l2 = 0; l2 < M; l2++) {
							if (tmp[l][l2]==0) {
								count++;
							}
						}
					}
					//max chk
					if (count>max) { 
						max = count;
					}
				}
			}
		}
		System.out.println(max);
		br.close();
	}
}


/*
14502번

예제 입력 
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
예제 출력 
27
예제 입력 2 
4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2
예제 출력 2 
9
예제 입력 3 
8 8
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
예제 출력 3 
3

for (int l = 0; l < N; l++) {
						for (int l2 = 0; l2 < M; l2++) {
							System.out.print(tmp[l][l2]+" ");
						}System.out.println();
					}

연구소 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	3659	1997	1333	55.472%
문제
인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.

연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 

일부 칸은 바이러스가 존재하며, 이 바이러스는 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.

예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.

2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
이 때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.

2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.

2 1 0 0 1 1 0
1 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 1 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
바이러스가 퍼진 뒤의 모습은 아래와 같아진다.

2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.

연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최대값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)

둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.

빈 칸의 개수는 3개 이상이다.

출력
첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.


*/