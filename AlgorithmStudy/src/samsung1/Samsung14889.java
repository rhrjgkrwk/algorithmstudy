package samsung1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Samsung14889 {
	public static int N;
	public static int team[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		team = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int j = 1;
			while (st.hasMoreTokens()) {
				if(i<j)team[i][j] += Integer.parseInt(st.nextToken());
				else team[j][i] += Integer.parseInt(st.nextToken());
				j++;
			}
		}
		System.out.println(dfs(0,1,new boolean[N+1]));
	}
	public static int dfs(int count, int now, boolean []list){
		if (now == N+1 && count < N/2) {
			return Integer.MAX_VALUE;
		}
		if (count == N / 2) {
			return calculateGap(list);
		}
		list[now] = false;
		int n = dfs(count, now + 1, list.clone());
		list[now] = true;
		int m = dfs(count+1, now + 1, list.clone());
		return n>m?m:n;
	}
	public static int calculateGap(boolean[] list){
		int startSum = 0;
		int linkSum = 0;
		for (int i = 1; i < list.length-1; i++) {
			if (list[i]) {
				for (int j = i+1; j < list.length; j++) {
					if (list[j]) {
						startSum+=team[i][j];
					}
				}
			}
			else {
				for (int j = i+1; j < list.length; j++) {
					if (!list[j]) {
						linkSum+=team[i][j];
					}
				}
			}
		}
//		System.out.println(startSum+"-"+linkSum);
		return Math.abs(startSum-linkSum);
	}
}
/*
��ŸƮ�� ��ũ Ǯ��
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	512 MB	1350	701	456	50.110%
����
������ ��ŸƮ��ũ�� �ٴϴ� ������� �𿩼� �౸�� �غ����� �Ѵ�. �౸�� ���� ���Ŀ� �ϰ� �ǹ� ������ �ƴϴ�. �౸�� �ϱ� ���� ���� ����� �� N���̰� �ű��ϰԵ� N�� ¦���̴�. ���� N/2������ �̷���� ��ŸƮ ���� ��ũ ������ ������� ������ �Ѵ�.

BOJ�� ��ϴ� ȸ�� ��� ������� ��ȣ�� 1���� N������ �����߰�, �Ʒ��� ���� �ɷ�ġ�� �����ߴ�. �ɷ�ġ Sij�� i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�̴�. ���� �ɷ�ġ�� ���� ���� ��� ���� �ɷ�ġ Sij�� ���̴�. Sij�� Sji�� �ٸ� ���� ������, i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�� Sij�� Sji�̴�.

N=4�̰�, S�� �Ʒ��� ���� ��츦 ���캸��.

i\j	1	2	3	4
1	 	1	2	3
2	4	 	5	6
3	7	1	 	2
4	3	4	5	 
���� ���, 1, 2���� ��ŸƮ ��, 3, 4���� ��ũ ���� ���� ��쿡 �� ���� �ɷ�ġ�� �Ʒ��� ����.

��ŸƮ ��: S12 + S21 = 1 + 4 = 5
��ũ ��: S34 + S43 = 2 + 5 = 7
1, 3���� ��ŸƮ ��, 2, 4���� ��ũ ���� ���ϸ�, �� ���� �ɷ�ġ�� �Ʒ��� ����.

��ŸƮ ��: S13 + S31 = 2 + 7 = 9
��ũ ��: S24 + S42 = 6 + 4 = 10
�౸�� ����ְ� �ϱ� ���ؼ� ��ŸƮ ���� �ɷ�ġ�� ��ũ ���� �ɷ�ġ�� ���̸� �ּҷ� �Ϸ��� �Ѵ�. ���� ������ ���� ��쿡�� 1, 4���� ��ŸƮ ��, 2, 3�� ���� ��ũ ���� ���ϸ� ��ŸƮ ���� �ɷ�ġ�� 6, ��ũ ���� �ɷ�ġ�� 6�� �Ǿ ���̰� 0�� �ǰ� �� ���� �ּ��̴�.

�Է�
ù° �ٿ� N(4 �� N �� 20, N�� ¦��)�� �־�����. ��° �ٺ��� N���� �ٿ� S�� �־�����. �� ���� N���� ���� �̷���� �ְ�, i�� ���� j��° ���� Sij �̴�. Sii�� �׻� 0�̰�, ������ Sij�� 1���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�.

���
ù° �ٿ� ��ŸƮ ���� ��ũ ���� �ɷ�ġ�� ������ �ּҰ��� ����Ѵ�.

���� �Է� 
4
0 1 2 3
4 0 5 6
7 1 0 2
3 4 5 0
���� ��� 
0
���� �Է� 2 
6
0 1 2 3 4 5
1 0 2 3 4 5
1 2 0 3 4 5
1 2 3 0 4 5
1 2 3 4 0 5
1 2 3 4 5 0
���� ��� 2 
2
���� �Է� 3 
8
0 5 4 5 4 5 4 5
4 0 5 1 2 3 4 5
9 8 0 1 2 3 1 2
9 9 9 0 9 9 9 9
1 1 1 1 0 1 1 1
8 7 6 5 4 0 3 2
9 1 9 1 9 1 0 9
6 5 4 3 2 1 9 0
���� ��� 3 
1
*/