package samsung1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class P {
	int dir; //0,1,2,3 순서대로 위 오른쪽 아래 왼쪽 
	int r;
	int c;
	public P() {
		// TODO Auto-generated constructor stub
	}
	public P(int r, int c, int dir) {
		this.r = r;
		this.c = c;
		this.dir = dir;
	}
}
public class Samsung14503 {
	public static int dr[] = {0,-1,0,1}; ////0,1,2,3 순서대로 위 오른쪽 아래 왼쪽 
	public static int dc[] = {-1,0,1,0};
	public static void main(String[] args) {
		Queue<P> q = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int map[][] = new int[N][M];
		q.add(new P(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		boolean flag = true;
		while (!q.isEmpty() && flag) {
			P p = q.poll();			
			map[p.r][p.c] = -1; //청소를 한 곳은 -1
			
			int initDir = p.dir;
			boolean chk = false;
			
			for (int i = 0; i < 4; i++) {//0,1,2,3 순서대로 위 오른쪽 아래 왼쪽 
				int nr;
				int nc;
				int ndir;
				if (p.dir==i) {
					nr = p.r+dr[i];
					nc = p.c+dc[i];
					ndir = (4+p.dir-1)%4; //왼쪽으로 돈다.
					
					if (nr>=0 && nr < N && nc>=0 && nc < M && map[nr][nc]==0) { //갈 수 있으면
						q.add(new P(nr, nc, ndir));
						chk = true;
						break; //갈 수 있으면 루프 종료.(갈 수 있으면 바로 이동한다.)
					}
					else if (nr>=0 && nr < N && nc>=0 && nc < M && map[nr][nc]!=0) { //갈 수 없으면
						p.dir = ndir;
						if (initDir==p.dir) {
							chk = false;
							break;
						}
						i=-1;
					}	
				}
			}
			if (!chk) { //사방으로 갈 수 없으면 방향을 유지하고 그대로 한칸 뒤로 간다.
				for (int i = 0; i < 4; i++) {//0,1,2,3 순서대로 위 오른쪽 아래 왼쪽 
					int nr;
					int nc;
					int ndir;
					if (p.dir==i) {
						nr = p.r+dr[(3+i)%4]; //현재 방향 기준 뒤로 한칸간다.
						nc = p.c+dc[(3+i)%4];
						ndir = p.dir; //방향은 유지.
						
						if (nr>=0 && nr < N && nc>=0 && nc < M && map[nr][nc]!=1) { //갈 수 있으면 뒤로한칸간다.
							q.add(new P(nr, nc, ndir));
						}
						else if (nr>=0 && nr < N && nc>=0 && nc < M && map[nr][nc]==1) { //갈 수 없으면
							flag = false;
						}	
					}
				}
			}
			
		}
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j]==-1) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		sc.close();
	}
}
