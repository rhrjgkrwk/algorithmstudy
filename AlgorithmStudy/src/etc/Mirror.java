package etc;
import java.io.FileInputStream;
import java.util.Scanner;

/*
�Է� ����

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

��� ����

Case #1
3
Case #2
5
Case #3
8
*/
public class Mirror {
	static int Answer;
	static int roooms[][];
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int T = sc.nextInt();	
		System.out.println(T);
		for(int test_case = 0; test_case < T; test_case++) {
			int N = sc.nextInt();
			System.out.println(N);
			roooms = new int[N][N];
			for (int i = 0; i < N; i++) {
				String tmp = sc.nextLine();
				System.out.println(tmp);
				for (int j = 0; j < N; j++) { //�濡 ���� �Է�
					roooms[i][j] = (int)(tmp.charAt(j)-'0');
					System.out.print(tmp.charAt(j)+"\t");
				}System.out.println();
			};
			
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			//System.out.println(Answer);
		}
	}
}

