package samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//ï¿½ì‡±?Š‚?‚‰?š¯?Š‚
class Puyo {
	int x;
	int y;
	char ch;

	public Puyo(int x, int y, char ch) {
		this.x = x;
		this.y = y;
		this.ch = ch;
	}
}

public class Samsung11559 {
	public static char[][] map = new char[12][6];
	public static boolean visit[][];
	public static int dx[] = { 1, 0, -1, 0 };
	public static int dy[] = { 0, 1, 0, -1 };
	public static int yeonsoe = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		boolean flag = true; // flagê°? true?´ë©? ?´ë²? ?ƒ?ƒ‰?—?„œ ë¿Œìš”ê°? ?„°ì¡‹ë‹¤?Š” ê²?.
		while (flag) {
			flag = false;
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						boolean tmp = removePuyo(new Puyo(i, j, map[i][j]));
						if (tmp)
							flag = true; // ?•œë²ˆì´?¼?„ ?„°ì¡‹ìœ¼ë©? true;
					}
				}
			}
			if (flag) {
				yeonsoe++;
				goingDown();
			}
		}

		System.out.println(yeonsoe);
		br.close();
	}

	public static boolean removePuyo(Puyo p) {
		Queue<Puyo> q = new LinkedList<>();
		q.add(p);
		int cnt = 0;
		boolean flag = false;
		visit = new boolean[12][6];
		visit[p.x][p.y] = true;
		while (!q.isEmpty()) {
			Puyo puyo = q.poll();
			cnt++;

			if (cnt >= 4) {
				flag = true;
			}
			for (int i = 0; i < 4; i++) {
				int nx = puyo.x + dx[i];
				int ny = puyo.y + dy[i];
				if (nx < 12 && nx >= 0 && ny < 6 && ny >= 0 && map[nx][ny] == puyo.ch && !visit[nx][ny]) {
					q.add(new Puyo(nx, ny, map[nx][ny]));
					visit[nx][ny] = true;
				}
			}
		} // ?—¬ê¸°ì„œ ?„°ì§? ë¶?ë¶„ì„ ì§??›Œì¤??‹¤.
		if (flag) {
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (visit[i][j] == true) {
						map[i][j] = '.';
					}
				}
			}
		}
		return flag;
	}

	public static void goingDown() {
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 1; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] == '.' && map[i - 1][j] != '.') {
						map[i][j] = map[i - 1][j];
						map[i - 1][j] = '.';
						flag = true;
					}
				}
			}
		}
	}
}

/*
 * ï¿½ì‚ï¿½ì £ ï¿½ì—¯ï¿½ì ° 1 ...... ...... ...... ...... ...... ...... ...... ...... .Y....
 * .YG... RRYG.. RRYGG. ï¿½ì‚ï¿½ì £ ?•°?’•? ° 1 3
 */