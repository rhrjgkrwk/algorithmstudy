package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Samsung12100_FAI {
	public static int map[][];
	public static int start[] = {3,0,0,3};
	public static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while (st.hasMoreTokens()) {
				map[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
			
		}
		
		
		System.out.println(dfs(-1,0));
	}
	public static int dfs(int direction, int count){
		if (count==5) {
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max < map[i][j]) {
						max = map[i][j];
					}
				}
			}
			return max;
		}
		
		//여기서 맵을 움직인다.
		Queue<Integer> q = new LinkedList<>();
		if (direction==0) { 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					q.add(map[j][i]);
				}
				int last = 0;
				int j = 0;
				while (j < N) {
					int curr = -1;
					if (!q.isEmpty()) curr = q.poll();
					map[j][i] = 0;
					if (curr>0) {
						if (curr==last) {
							map[j][i] = curr*2;
							last = curr;
							j++;
						}
						else {
							map[j][i] = last;
							last = curr;
							j++;
						}
					}
					else if (curr==0) {
						continue;
					}
					else if (curr==-1) {
						map[j][i]=0;
						j++;
					}
				}
			}
		} else if (direction==1) {
			for (int i = N-1; i >= 0; i--) {
				for (int j = N-1; j >= 0; j--) {
					q.add(map[i][j]);
				}
				int last = 0;
				int j = N-1;
				while (j>=0) {
					int curr = -1;
					if (!q.isEmpty()) curr = q.poll();
					map[i][j] = 0;
					if (curr>0) {
						if (curr==last) {
							map[i][j] = curr*2;
							last = curr;
							j--;
						}
						else {
							map[i][j] = last;
							last = curr;
							j--;
						}
					}
					else if (curr==0) {
						continue;
					}
					else if (curr==-1) {
						map[i][j]=0;
						j--;
					}
				}
			}
		} else if (direction==2) {
			for (int i = N-1; i >= 0; i--) {
				for (int j = N-1; j >= 0; j--) {
					q.add(map[j][i]);
				}
				int last = 0;
				int j = N-1;
				while (j>=0) {
					int curr = -1;
					if (!q.isEmpty()) curr = q.poll();
					map[j][i] = 0;
					if (curr>0) {
						if (curr==last) {
							map[j][i] = curr*2;
							last = curr;
							j--;
						}
						else {
							map[j][i] = last;
							last = curr;
							j--;
						}
					}
					else if (curr==0) {
						continue;
					}
					else if (curr==-1) {
						map[j][i]=0;
						j--;
					}
				}
			}
		} else if (direction==3){
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					q.add(map[i][j]);
				}
				int last = 0;
				int j = 0;
				while (j<N) {
					int curr = -1;
					if (!q.isEmpty()) curr = q.poll();
					map[i][j] = 0;
					if (curr>0) {
						if (curr==last) {
							map[i][j] = curr*2;
							last = curr;
							j++;
						}
						else {
							map[i][j] = last;
							last = curr;
							j++;
						}
					}
					else if (curr==0) {
						continue;
					}
					else if (curr==-1) {
						map[i][j]=0;
						j++;
					}
				}
			}
		}
		
		System.out.println("----------------------");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
		
		return Math.max(dfs(0, count+1), Math.max(dfs(1, count+1), Math.max(dfs(2, count+1), dfs(3, count+1))));
	}
}
