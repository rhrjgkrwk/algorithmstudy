package samsung1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BodyPart {
	int x;
	int y;

	public BodyPart(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class Comm {
	int X;// 방향 전환 시간.
	String C; // 방향

	public Comm(int x, String c) {
		super();
		X = x;
		C = c;
	}
}

public class Samsung3190 {
	

	public static void main(String[] args) {
		int N;// size of map
		int K;// 사과 수
		int L;// command 수
		int seconds = 0; // 진행 시간 체크
		int map[][]; // 진행 시간 체크
		int dx[] = { 0, 1, 0, -1 }; // 순서대로 오른 아래 왼 위
		int dy[] = { 1, 0, -1, 0 };
		int direction = 0; // 현재 방향, 초기 방향은 오른족
		ArrayList<BodyPart> snake; // 뱀
		Queue<Comm> commands; // 명령어 목록, 진행된 명령은 poll
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N + 1][N + 1];
		
		snake = new ArrayList<>();
		commands = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			map[sc.nextInt()][sc.nextInt()] = 1;
		}
		L = sc.nextInt();
		for (int i = 0; i < L; i++) {
			commands.add(new Comm(sc.nextInt(), sc.next()));
		}

		sc.close();

		// 초기 뱀
		snake.add(new BodyPart(1, 1));
		
		while (true) {
			
			Comm comm = null;
			if (!commands.isEmpty() && commands.peek().X == seconds) { 
				// 현재 초에 해당하는 명령이 있으면
				comm = commands.poll();
				if (comm.C.equals("L")) {
					direction = (4 + direction - 1) % 4;
				} else if (comm.C.equals("D")) {
					direction = (4 + direction + 1) % 4;
				}
			}
			// 여기서 이동.
			int nx = snake.get(0).x + dx[direction]; //뱀 대가리 + dx, dy
			int ny = snake.get(0).y + dy[direction];

			if (nx < 1 || nx > N || ny < 1 || ny > N || isMyBody(nx, ny, snake)) { // 벽이거나 자기 몸일때
				System.out.println(seconds+1); // 출력하고 종료.
				return;
			} else { // 갈 수 있는 곳일때 실제로 이동.
						// 사과 인지 아닌지 .
				if (map[nx][ny] == 1) { // 사과 이면
					map[nx][ny] = 0;
					snake.add(0, new BodyPart(nx, ny));
				} else { // 사과가 아니면
					snake.add(0, new BodyPart(nx, ny)); // 앞으로는 늘리고
					snake.remove(snake.size() - 1); // 맨뒤는 지운다.
				}
			}
			seconds++;
		}
	}

	public static boolean isMyBody(int x, int y, ArrayList<BodyPart> snake) {
		for (BodyPart p : snake) {
			if (p.x == x && p.y == y && snake.lastIndexOf(p)!=snake.size()) {
				return true;
			}
		}
		return false;
	}
}

/*
3190번
뱀 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	7752	1470	1021	18.911%
문제
 'Dummy' 라는 도스게임이 있다. 이 게임에는 뱀이 나와서 기어다니는데, 사과를 먹으면 뱀 길이가 늘어난다. 뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딫히면 게임이 끝난다.

게임은 NxN 정사각 보드위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있다. 보드의 상하좌우 끝에 벽이 있다. 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다. 뱀은 처음에 오른쪽을 향한다.

뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.

먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다.(즉, 몸길이는 변하지 않는다.) 
사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초(seconds)후에 끝나는지 계산하라.

입력
첫째줄에 N이 주어진다. ( 2 ≤ N ≤ 100 )

다음줄에 사과의 개수 K가 주어진다.( 0 ≤ K ≤ 100 )

그리고 K개의 줄에는 사과의 위치가 주어지는데, 첫번째 숫자는 행(row), 두번째 숫자는 열(column) 위치를 의미한다.
사과들의 위치는 모두 다르며, 맨 위 맨 좌측(1행 1열)에는 사과가 없다.

그리고 뱀의 방향변환 개수 L 이 주어진다. ( 1 ≤ L ≤ 100 )

그리고 L개의 줄에는 뱀의 방향변환 정보가 주어지는데,  숫자 X와 문자 C로 이루어져 있다. X초 후에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 방향을 변경 한다는 뜻이다. X는 10,000 이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 주어진다.

출력
문제의 정답,  즉 초(seconds) 를 첫째줄에 출력하라.

예제 입력 
6
3
3 4
2 5
5 3
3
3 D
15 L
17 D
예제 출력 
9
*/