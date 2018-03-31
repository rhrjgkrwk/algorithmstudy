package samsung1;

import java.util.Scanner;

public class Samsung14499 {
	public static int horizental[] = {0,0,0,0};
	public static int vertical[] = {0,0,0,0};
	public static int map[][];
	public static int verNow = 1;
	public static int horNow = 1;
	public static int x; //시작 x
	public static int y; //시작 y
	public static int N; //가로
	public static int M; //세로
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K; //명령의 개수
		N = sc.nextInt();
		M = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < K; i++) {
			roll(sc.nextInt());
		}
		sc.close();
	}
	public static void roll(int command){
		if (command==1 && y+1<M) {
			y++;
			//1. 동쪽
			horNow = (4+horNow-1)%4;
			vertical[verNow] = horizental[horNow];
			//여기서 밑면의 숫자 이동.
			if (map[x][y]>0) {
				horizental[(4+horNow-2)%4] = map[x][y];
				map[x][y]=0;
			}
			else {
				map[x][y] = horizental[(4+horNow-2)%4];
			}
			vertical[(4+verNow-2)%4] = horizental[(4+horNow-2)%4];
			System.out.println(vertical[verNow]);
		}
		else if (command==2 && y-1>=0) {
			y--;
			//2 : 서쪽
			horNow = (4+horNow+1)%4;
			vertical[verNow] = horizental[horNow];
			//여기서 밑면의 숫자 이동.
			if (map[x][y]>0) {
				horizental[(4+horNow-2)%4] = map[x][y];
				map[x][y]=0;
			}
			else {
				map[x][y] = horizental[(4+horNow-2)%4];
			}
			vertical[(4+verNow-2)%4] = horizental[(4+horNow-2)%4];
			System.out.println(vertical[verNow]);
		}
		else if (command==3 && x-1>=0) {
			x--;
			//3 : 북쪽
			verNow = (4+verNow+1)%4;
			horizental[horNow] = vertical[verNow];
			//여기서 밑면의 숫자 이동.
			if (map[x][y]>0) {
				vertical[(4+verNow-2)%4] = map[x][y];
				map[x][y]=0;
			}
			else {
				map[x][y] = vertical[(4+verNow-2)%4];
			}
			horizental[(4+horNow-2)%4] = vertical[(4+verNow-2)%4]; //반대편에 있는 수가 바뀜
			System.out.println(vertical[verNow]);
		}
		else if (command==4 && x+1<N) {
			x++;
			//4 : 남쪽
			verNow = (4+verNow-1)%4;
			horizental[horNow] = vertical[verNow];
			//여기서 밑면의 숫자 이동.
			if (map[x][y]>0) {
				vertical[(4+verNow-2)%4] = map[x][y];
				map[x][y]=0;
			}
			else {
				map[x][y] = vertical[(4+verNow-2)%4];
			}
			horizental[(4+horNow-2)%4] = vertical[(4+verNow-2)%4]; //반대편에 있는 수가 바뀜
			System.out.println(vertical[verNow]);
		}
	}
}



/*
14499번
제출
맞은 사람
숏코딩
풀이
풀이 작성
풀이 요청
재채점/수정
채점 현황
내 소스
강의
질문 검색
주사위 굴리기 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	5499	1933	1488	37.472%
문제
크기가 N×M인 지도가 존재한다. 지도의 오른쪽은 동쪽, 위쪽은 북쪽이다. 이 지도의 위에 주사위가 하나 놓여져 있으며, 주사위의 전개도는 아래와 같다. 지도의 좌표는 (r, c)로 나타내며, r는 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로부터 떨어진 칸의 개수이다. 

  2
4 1 3
  5
  6
주사위는 지도 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 있으며, 놓여져 있는 곳의 좌표는 (x, y) 이다. 가장 처음에 주사위에는 모든 면에 0이 적혀져 있다.

지도의 각 칸에는 정수가 하나씩 쓰여져 있다. 주사위를 굴렸을 때, 이동한 칸에 써 있는 수가 0이면, 주사위의 바닥면에 써 있는 수가 칸에 복사된다. 0이 아닌 경우에는 칸에 써 있는 수가 주사위의 바닥면으로 복사되며, 칸에 써 있는 수는 0이 된다.

주사위를 놓은 곳의 좌표와 이동시키는 명령이 주어졌을 때, 주사위가 이동했을 때 마다 상단에 써 있는 값을 구하는 프로그램을 작성하시오.

주사위는 지도의 바깥으로 이동시킬 수 없다. 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안된다.

입력
첫째 줄에 지도의 세로 크기 N, 가로 크기 M (1 ≤ N, M ≤ 20), 주사위를 놓은 곳의 좌표 x y(0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1), 그리고 명령의 개수 K (1 ≤ K ≤ 1,000)가 주어진다.

둘째 줄부터 N개의 줄에 지도에 써 있는 수가 북쪽부터 남쪽으로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 주사위를 놓은 칸에 써 있는 수는 항상 0이다. 지도의 각 칸에 써 있는 수는 10을 넘지 않는 자연수이다.

마지막 줄에는 이동하는 명령이 순서대로 주어진다. 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.

출력
이동할 때마다 주사위의 윗 면에 써 있는 수를 출력한다. 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안된다.

예제 입력 
4 2 0 0 8
0 2
3 4
5 6
7 8
4 4 4 1 3 3 3 2
예제 출력 
0
0
3
0
0
8
6
3
예제 입력 2 
3 3 1 1 9
1 2 3
4 0 5
6 7 8
1 3 2 2 4 4 1 1 3
예제 출력 2 
0
0
0
3
0
1
0
6
0
예제 입력 3 
2 2 0 0 16
0 2
3 4
4 4 4 4 1 1 1 1 3 3 3 3 2 2 2 2
예제 출력 3 
0
0
0
0
예제 입력 4 
3 3 0 0 16
0 1 2
3 4 5
6 7 8
4 4 1 1 3 3 2 2 4 4 1 1 3 3 2 2
예제 출력 4 
0
0
0
6
0
8
0
2
0
8
0
2
0
8
0
2
*/