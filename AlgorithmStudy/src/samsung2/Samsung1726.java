package samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P1726 {
	int x;
	int y;
	int dir;

	public P1726(int x, int y, int d) {
		super();
		this.x = x;
		this.y = y;
		if (d == 1) {
			this.dir = 1;
		} else if (d == 2) {
			this.dir = 3;
		} else if (d == 3) {
			this.dir = 2;
		} else if(d == 4){
			this.dir = 0;
		}
	}
}

public class Samsung1726 {
	public static int dx[] = { -1, 0, 1, 0 };
	public static int dy[] = { 0, 1, 0, -1 };
	//public static int dirGuide[] = { 4, 1, 3, 2 }; // ????λ‘? ??€λ₯Έμ??Ό
	public static int dirNow;
	public static int N, M; // M?Έλ‘? Nκ°?λ‘?
	public static int map[][];
	public static boolean visit[][];
	public static int minComm = Integer.MAX_VALUE;
	public static P1726 destination;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N]; // map? 0,0λΆ??° ????λ‘νκ³? ??, ?μ°©μ??  ?? ₯? μ’ν?? κ°κ° 1?© λΉΌμ.
		visit = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//??? .
		st = new StringTokenizer(br.readLine(), " ");
		P1726 departure = new P1726(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
		//?μ°©μ .
		st = new StringTokenizer(br.readLine(), " ");
		destination = new P1726(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
		dfs(departure, departure.dir, 0, false);
		System.out.println(minComm);
	}

	public static void dfs(P1726 now, int dir, int countComm, boolean lastComm) { //lastComm?΄ true?΄λ©? μ§μ§??€? κ²?.
		visit[now.x][now.y]=true;
		if (countComm>minComm) {
			visit[now.x][now.y]=false;
			return;
		}
		//?μ°©μ?? ? μ’ν, λ°©ν₯κ³? ?ΌμΉνλ©? μ’λ£.
		if (now.x == destination.x && now.y == destination.y ) {
			
			if (dir != destination.dir){
					if ((4+dir+1)%4 == destination.dir) {// ??¬κΈ°μ? ?€λ₯Έμ‘±?Έκ²½μ°
						countComm+=1; //λ°©ν₯? ? 1
					}
					else if ((4+dir-1)%4 == destination.dir) { //??¬ κΈ°μ? ?Όμͺ?
						countComm+=1; //λ°©ν₯? ? 1
					}else {
					countComm+=2; //λ°©ν₯? ? 2
				}
			}
			minComm = minComm>countComm?countComm:minComm;
			visit[now.x][now.y]=false;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = now.x + dx[i];
			int ny = now.y + dy[i];
			if (nx>=0 && nx<M && ny>=0 && ny<N && map[nx][ny]!=1 && !visit[nx][ny]) { //κ°μ ??κ°?!
				//λ°©ν₯?ΌμΉμ¬λΆ?λ₯? ??¨
				if (i!=dir) { //?ΌμΉνμ§? ?? κ²½μ°
						dfs(new P1726(nx, ny, i), i, countComm+2, false);
				}
				else { //?ΌμΉν? κ²½μ°
						dfs(new P1726(nx, ny, i), i, countComm, true);
				}
			}
		}
		visit[now.x][now.y]=false;
	}
}



/*




4 2
0 0
0 0
1 0
0 0
1 1 3
4 1 3





//μΆλ ₯?΄λ³΄μ.
System.out.println("*****************");
System.out.println("count : "+ countComm);
System.out.println("dir : "+dir);
for (int i = 0; i < M; i++) {
	for (int j = 0; j < N; j++) {
		if (i==now.x && j==now.y) {
			System.out.print("n ");
		}
		else if (i==destination.x && j == destination.y) {
			System.out.print("d ");
		}

		else System.out.print(map[i][j]+" ");
	}System.out.println();
}
for (int i = 0; i < M; i++) {
	for (int j = 0; j < N; j++) {
		if (i==now.x && j==now.y) {
			System.out.print("n    ");
		}
		else if (i==destination.x && j == destination.y) {
			System.out.print("d    ");
		}

		else System.out.print(visit[i][j]+" ");
	}System.out.println();
}
System.out.println(minComm);









*/