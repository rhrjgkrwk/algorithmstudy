package hanhwa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class P1987{
	int x;
	int y;
	String visit="";
	public P1987(int x, int y, String visit) {
		super();
		this.x = x;
		this.y = y;
		this.visit = visit;
	}
}

public class Hanhwa1987 {
	public static int r;
	public static int c;
	public static char[][] map = new char[30][30];
	public static int[] dx={0,0,1,-1};
	public static int[] dy={1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		for (int i = 0; i < r; i++) {
			String tmp = sc.nextLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		System.out.println(DFS(0,0,String.valueOf(map[0][0])));
		
	}
	public static int DFS(int x, int y, String visit){
		int tmp = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx>=0 && nx<r && ny>=0 && ny<c && !visit.contains(String.valueOf(map[nx][ny]))) {
				
				tmp = Math.max(tmp, DFS(nx, ny, visit+map[nx][ny]));
			}
		}
		return Math.max(visit.length(),tmp);
	}
	
	public static int BFS(){
		Queue<P1987> q = new LinkedList<>();
		int res = 1;
		q.add(new P1987(0, 0, String.valueOf(map[0][0])));
		while (!q.isEmpty()) {
			P1987 now = q.poll();
			
			if (res<=now.visit.length()) {
				res = now.visit.length();
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx>=0 && nx<r && ny>=0 && ny<c && !now.visit.contains(String.valueOf(map[nx][ny]))) {
					q.add(new P1987(nx, ny, now.visit+map[nx][ny]));
				}
			}
		}
		return res;
	}
	
}
/*
5 5
ABCDD
BBBBB
CCCCC
DDDDD
EEEEE
*/
