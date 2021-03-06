package samsung2;

import java.util.Scanner;

public class Samsung3085 {
	public static char[][] map;
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
		int longest = 0;
		
		//κ°?λ‘λ‘ λ°κΎΈ?΄λ³΄μ.
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) { //?? ? ??΄? λ°κΎΈ?΄λ³?
				swap(i, j, i, j-1);
				int tmp = longestCandy();
				longest = tmp>longest?tmp:longest;
				swap(i, j, i, j-1); //??λ³΅κ?.
			}
		}
		//?Έλ‘λ‘ λ°κΎΈ?΄λ³΄μ. ?Έλ‘ν ?????₯?longestqλ³΄λ€ κΈ΄μ? ??Έ ? ???₯.
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) { //?Έ? ? ? ? ??΄? λ°κΎΈ?΄λ³?
				swap(j, i, j-1, i);
				int tmp = longestCandy();
				longest = tmp>longest?tmp:longest;
				swap(j, i, j-1, i); //??λ³΅κ?.
			}
		}
		System.out.println(longest);
		sc.close();
	}
	public static int longestCandy() {
		int longest = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int count = 1;
			int tmp = -1;
			for (int j = 1; j < N; j++) {
				if (map[i][j]==map[i][j-1]) {
					count++;
					tmp = tmp<count?count:tmp;
				}
				else count = 1;
			}
			if (longest<tmp) {
				longest = tmp;
			}
		}
		
		for (int i = 0; i < N; i++) {
			int count = 1;
			int tmp = -1;
			for (int j = 1; j < N; j++) {
				if (map[j][i]==map[j-1][i]) {
					count++;
					tmp = tmp<count?count:tmp;
				}
				else count = 1;
			}
			if (longest<tmp) {
				longest = tmp;
			}
		}		
		return longest;
	}
	public static void swap(int i, int j, int i2, int j2) {
		char tmp = map[i][j];
		map[i][j] = map[i2][j2];
		map[i2][j2] = tmp;
	}
}
/*
?? ₯
μ²«μ§Έ μ€μ λ³΄λ? ?¬κΈ? N?΄ μ£Όμ΄μ§λ€. (3 ?€ N ?€ 50)

?€? Nκ°? μ€μ? λ³΄λ? μ±μ? Έ ?? ?¬?? ???΄ μ£Όμ΄μ§λ€. λΉ¨κ°??? C, ?????? P, μ΄λ‘??? Z, ?Έ????? Yλ‘? μ£Όμ΄μ§λ€.

μΆλ ₯
μ²«μ§Έ μ€μ ?κ·Όμ΄κ°? λ¨Ήμ ? ?? ?¬?? μ΅λ? κ°μλ₯? μΆλ ₯??€.

??  ?? ₯ 1 
5
YCPZY
CYZZP
CCPPP
YCYZC
CPPZZ
??  μΆλ ₯ 1 
4
*/