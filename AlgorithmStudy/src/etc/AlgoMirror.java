package etc;

/*NxN ���簢�� ���ڱ��� ���� ��� �߿��� 
� �濡�� �밢�� ������ ���ſ��� �ִ�.a

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
   
   
   3
2
02
11
3
201
220
210
4
2121
0102
2101
2121

Case #1
3
Case #2
5
Case #3
8


 */
class AlgoMirror {
	static int Answer;

	public static void main(String args[]) throws Exception {

		/*
		 * Make new scanner from standard input System.in, and read data.
		 */
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int T = Integer.parseInt(br.readLine()); // tc<=20
		for (int test_case = 0; test_case < T; test_case++) {
			// �Է�
			int N = Integer.parseInt(br.readLine());
			char arr[][] = new char[N][N];
			boolean chk[][] = new boolean[N][N];
			for (int i = 0; i < arr.length; i++) { // �濡 �ſ��� �Է�����.
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < temp.length; j++) {
					arr[i][j] = temp[j];
				}
			}
			int i = 0, j = 0, lastI, lastJ;

			// ���⵵ ����ؾ���. j ��������, i ��������
			// �ʿ� . lastI, lastJ

			//����� ���⼭ ��Ű��.
			
			while (i >= N || j >= N) {
				lastI = i;
				lastJ = j;
				switch (arr[i][j]) {
				case '0':
					
					
					break;
				case '1':

					break;
				case '2':

					break;
				}
			}
			// switch

			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);
		}
	}
	public static int checkDirection(int i, int j, int lasti, int lastj){
		if (i-lasti>0) return 1;
		if (i-lasti<0) return 2;
		if (j-lastj>0) return 3;
		if (j-lastj<0) return 4;
		return -1;
	}
}