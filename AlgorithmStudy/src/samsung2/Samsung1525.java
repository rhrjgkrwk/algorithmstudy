package samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
  //FSF
public class Samsung1525 {
	public static HashMap<String, Integer> map = new HashMap<>();
	public static int moveability[] = { -1, 1, -3, 3 };
	public static String board = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				board += st.nextToken();
			}
		}
		dfs(board.indexOf('0'), 0);
		
		if (map.containsKey("123456780")) {
			System.out.println(map.get("123456780"));
		}
		else System.out.println(-1);
	}

	public static void dfs(int pos, int count) {
		map.put(board, count);
		
		for (int i = 0; i < moveability.length; i++) {
			int npos = -1;
			if (moveability[i] == -1) {
				if (pos % 3 != 0) {
					npos = pos + moveability[i];
				}
			} else if (moveability[i] == 1) {
				if (pos % 3 != 2) {
					npos = pos + moveability[i];
				}
			} else {
				npos = pos + moveability[i];
			}

			if (npos < 9 && npos >= 0) {
				swap(pos, npos);
				if (!map.containsKey(board)) {
					dfs(npos, count + 1);
				}
				else {
					if (map.get(board)>count) {
						map.put(board, count);
					}
				}
				swap(pos, npos); // ?õê?ÉÅÎ≥µÍ?
			}
		}
		return;
	}

	public static void swap(int i, int j) {
		char[] copy = board.toCharArray();
		char tmp = copy[i];
		copy[i] = copy[j];
		copy[j] = tmp;
		board = String.valueOf(copy);
	}
}
