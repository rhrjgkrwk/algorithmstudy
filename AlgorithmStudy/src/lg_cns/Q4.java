package lg_cns;

public class Q4 {
	public static void main(String[] args) {
		int N = 5;
		int directory[][] = { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 2, 5 } };
		int query[][] = { { 1, 5 }, { 2, 5 }, { 3, 5 }, { 4, 5 } };
		
		int[] answer = new Q4().solution(N, directory, query);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public int[] solution(int N, int[][] directory, int[][] query) {
		int[] answer = new int[query.length];
		int[][] map = new int[N + 1][N + 1];

		for (int i = 0; i < directory.length; i++) {
			map[directory[i][0]][directory[i][1]] = 1;
			map[directory[i][1]][directory[i][0]] = 1;
		}
		
		for (int i = 0; i < query.length; i++) {
			boolean[] visit = new boolean[N + 1];
			answer[i] = dfs(map, visit, query[i], query[i][0]);
		}
		return answer;
	}

	public int dfs(int[][] map, boolean[] visit, int[] query, int now) {
		visit[now] = true;
		if (now == query[1]) {
			return 1;
		}
		int min = 100001;
		for (int i = 0; i < map.length; i++) {
			if (map[now][i] == 1 && !visit[i]) {
				int temp = dfs(map, visit, query, i);
				if (temp < min) {
					min = temp;
				}
			}
		}
		return min + 1;
	}
}
