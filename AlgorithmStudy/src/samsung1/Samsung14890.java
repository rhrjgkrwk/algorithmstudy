package samsung1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Samsung14890 {

	public static void main(String[] args) throws IOException {
		
		int [][]map;
		int N;
		int L;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int count = 0; //��ü �� ī��Ʈ.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while (st.hasMoreTokens()) { 
				map[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		//����/////////////////////////////////////////////////
		for (int i = 0; i < N; i++) {
			int lastN = 1;
			boolean [] visit = new boolean[N];
			int [] chk = new int[N];
			
			for (int j = 1; j < N; j++) {
				if (map[i][j] == map[i][j-1]) { //������
					lastN++;
					visit[j-1] = true;
				}
				else {
					int tmp = map[i][j]-map[i][j-1];
					if (tmp==1 && lastN>=L) { //������ ���°� 1��ŭ ũ�� ���θ� �Ѽ� ������
						visit[j-1] = true;
						lastN = 0;
						for (int k = 1; k <= L; k++) {
							if (j-k >=0 && chk[j-k]==0)chk[j-k] = 1;
							else visit[j-k] = false;
						}
					}
					else
						lastN = 0;
				}
			}
			
			
			lastN = 1;
			for (int j = N-2; j >= 0; j--) {
				if (map[i][j] == map[i][j+1]) { //������
					lastN++;
					visit[j+1] = true;
				}
				else {
					int tmp = map[i][j]-map[i][j+1];
					if (tmp==1 && lastN>=L) { //������ ���°� 1��ŭ ũ�� ���θ� �Ѽ� ������
						visit[j+1] = true;
						lastN = 0;
						for (int k = 1; k <= L; k++) {
							if (j+k<N && chk[j+k]==0)chk[j+k] = 1;
							else visit[j+k] = false;
						}
					}
					else lastN = 0;
				}
			}
			boolean flag = true;
			for (int j = 0; j < visit.length; j++) {
				if (!visit[j]) { 
					flag = false;
					break;
				}
			}
			count += flag?1:0;
		}
		
		//����/////////////////////////////////////////////////////////////////////
		for (int j = 0; j < N; j++) {
			int lastN = 1;
			boolean [] visit = new boolean[N];
			int [] chk = new int[N];
			
			for (int i = 1; i < N; i++) {
				if (map[i][j] == map[i-1][j]) { //������
					lastN++;
					visit[i-1] = true;
				}
				else {
					int tmp = map[i][j]-map[i-1][j];
					if (tmp==1 && lastN>=L) { //������ ���°� 1��ŭ ũ�� ���θ� �Ѽ� ������
						visit[i-1] = true;
						lastN = 0;
						for (int k = 1; k <= L; k++) {
							if (i-k >=0 && chk[i-k]==0)chk[i-k] = 1;
							else visit[i-k] = false;
						}
					}
					else
						lastN = 0;
				}
			}
			
			lastN = 1;
			for (int i = N-2; i >= 0; i--) {
				if (map[i][j] == map[i+1][j]) { //������
					lastN++;
					visit[i+1] = true;
				}
				else {
					int tmp = map[i][j]-map[i+1][j];
					if (tmp==1 && lastN>=L) { //������ ���°� 1��ŭ ũ�� ���θ� �Ѽ� ������
						visit[i+1] = true;
						lastN = 0;
						for (int k = 1; k <= L; k++) {
							if (i+k<N && chk[i+k]==0)chk[i+k] = 1;
							else visit[i+k] = false;
						}
					}
					else lastN = 0;
				}
			}
			boolean flag = true;
			for (int i = 0; i < visit.length; i++) {
				if (!visit[i]) { 
					flag = false;
					break;
				}
			}
			count += flag?1:0;
		}
		System.out.println(count);
	}
}
/*
����

�Է�
ù° �ٿ� N (2 �� N �� 100)�� L (1 �� L �� N)�� �־�����. ��° �ٺ��� N���� �ٿ� ������ �־�����. �� ĭ�� ���̴� 10���� �۰ų� ���� �ڿ����̴�.

���
ù° �ٿ� ������ �� �ִ� ���� ������ ����Ѵ�.

���� �Է� 
6 2
3 3 3 3 3 3
2 3 3 3 3 3
2 2 2 3 2 3
1 1 1 2 2 2
1 1 1 3 3 1
1 1 2 3 3 2
���� ��� 
3
���� �Է� 2 
6 2
3 2 1 1 2 3
3 2 2 1 2 3
3 2 2 2 3 3
3 3 3 3 3 3
3 3 3 3 2 2
3 3 3 3 2 2
���� ��� 2 
7
���� �Է� 3 
6 3
3 2 1 1 2 3
3 2 2 1 2 3
3 2 2 2 3 3
3 3 3 3 3 3
3 3 3 3 2 2
3 3 3 3 2 2
���� ��� 3 
3
���� �Է� 4 
6 1
3 2 1 1 2 3
3 2 2 1 2 3
3 2 2 2 3 3
3 3 3 3 3 3
3 3 3 3 2 2
3 3 3 3 2 2
���� ��� 4 
11

�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	512 MB	811	380	292	47.173%
����
ũ�Ⱑ N��N�� ������ �ִ�. ������ �� ĭ���� �� ���� ���̰� ������ �ִ�. 

������ �� �������� ������ �� �ִ� ���� �� �� �ִ��� �˾ƺ����� �Ѵ�. ���̶� �� �� �Ǵ� �� �� ���θ� ��Ÿ����, ���� ������ �ٸ��� ������ �������� ���̴�. 

������ ���� N=6�� ��� ������ ���캸��.



�� ��, ���� �� 2N���� ������, �Ʒ��� ����.



���� ������ �� �������� �濡 ���� ��� ĭ�� ���̰� ��� ���ƾ� �Ѵ�. �Ǵ�, ���θ� ���Ƽ� ������ �� �ִ� ���� ���� �� �ִ�. ���δ� ���̰� �׻� 1�̸�, ���̴� L�̴�. ��, ������ �ſ� ���� ������ ���� ����. ���δ� ���� ĭ�� ���� ĭ�� �����ϸ�, �Ʒ��� ���� ������ �����ؾ��Ѵ�.

���δ� ���� ĭ�� ������, L���� ���ӵ� ĭ�� ������ �ٴ��� ��� ���ؾ� �Ѵ�.
���� ĭ�� ���� ĭ�� ���� ���̴� 1�̾�� �Ѵ�.
���θ� ���� ���� ĭ�� ���̴� ��� ���ƾ� �ϰ�, L���� ĭ�� ���ӵǾ� �־�� �Ѵ�.
�Ʒ��� ���� ��쿡�� ���θ� ���� �� ����.

���θ� ���� ���� �� ���θ� ���� ���
���� ĭ�� ���� ĭ�� ���� ���̰� 1�� �ƴ� ���
���� ������ ĭ�� ���̰� ��� ���� �ʰų�, L���� ���ӵ��� ���� ���
���θ� ���ٰ� ������ ����� ���
L = 2�� ��쿡 ���θ� ���� �� �ִ� ��츦 �׸����� ��Ÿ���� �Ʒ��� ����.



���θ� ���� �� ���� ���� �Ʒ��� ����.



���� �׸��� ���� ���ʺ��� 1��, 2��, 3��, 4�� ������� ���� ��, 1���� ���� ���̰� 1�� �ƴ϶�, 2���� ���θ� �ٴڰ� ���ϰ� ���� �ʾƼ�, 3���� ���ļ� ���Ƽ�, 4���� ����̰� ���Ƽ� �Ұ����� ����̴�.

���� ���� �־��� �׸� ���� ��쿡 ������ �� �ִ� ���� �ʷϻ�����, ������ �� ���� ���� ���������� ǥ�õǾ� ������, �Ʒ��� ����. ������ ���� L = 2�̴�.



������ �־����� ��, ������ �� �ִ� ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/
