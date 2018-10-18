package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


class P14502 {
	int x;
	int y;

	public P14502(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class Algo14502 {
	public static Scanner sc = new Scanner(System.in);
	
	public static final int dx[] = {0,1,0,-1};
	public static final int dy[] = {1,0,-1,0};
	
	public static int N;
	public static int M;
	
	public static int[][] originalMap;
	public static boolean[][] visit;
	
	public static void main(String[] args) {
		List<P14502> emptySpace = new ArrayList<>();
		List<P14502> originalViruses = new ArrayList<>();
		
		N = sc.nextInt();
		M = sc.nextInt();
		originalMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				originalMap[i][j] = sc.nextInt();
				if (originalMap[i][j] == 0) {
					emptySpace.add(new P14502(i, j));
				} else if (originalMap[i][j] == 2) {
					originalViruses.add(new P14502(i, j));
				}
			}
		}
		
		int answer = 0;
		for (P14502 a : emptySpace) {
			for (P14502 b : emptySpace) {
				for (P14502 c : emptySpace) {
					int[][] map = new int[N][M];
					
					for (int i = 0; i < originalMap.length; i++) {
						map[i] = Arrays.copyOf(originalMap[i], originalMap[i].length);
					}
					
					map[a.x][a.y] = 1;
					map[b.x][b.y] = 1;
					map[c.x][c.y] = 1;
					
					List<P14502> temp = originalViruses;
					Collections.copy(temp, originalViruses);
					Queue<P14502> viruses = new LinkedList<>(temp);
					while (!viruses.isEmpty()) {
						P14502 now = viruses.poll();
						map[now.x][now.y] = 2;
						for (int i = 0; i < 4; i++) {
							int nx = now.x + dx[i];
							int ny = now.y + dy[i];
							if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
								map[nx][ny] = 2;
								viruses.add(new P14502(nx, ny));
							}
						}
					}
					
					for (int i = 0; i < map.length; i++) {
						for (int j = 0; j < map[i].length; j++) {
							System.out.print(map[i][j] + " ");
						}System.out.println();
					}
					System.out.println();
					int count = 0;
					for (int i = 0; i < map.length; i++) {
						for (int j = 0; j < map[i].length; j++) {
							
							if (map[i][j] == 0) {
								count++;
							}
						}
					}
					if (count >= answer) {
						answer = count;
					}
				}
			}
		}
		
		
		System.out.println(answer);
		
	}
}
