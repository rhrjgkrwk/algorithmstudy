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
		
		//ê°?ë¡œë¡œ ë°”ê¾¸?–´ë³´ì.
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) { //?•˜?‚˜ ?„ ?ƒ?•´?„œ ë°”ê¾¸?–´ë³?
				swap(i, j, i, j-1);
				int tmp = longestCandy();
				longest = tmp>longest?tmp:longest;
				swap(i, j, i, j-1); //?›?ƒë³µê?.
			}
		}
		//?„¸ë¡œë¡œ ë°”ê¾¸?–´ë³´ì. ?„¸ë¡œí• ?•Œ?Š”???¥?œlongestqë³´ë‹¤ ê¸´ì? ?™•?¸ ?›„ ???¥.
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) { //?¸? ‘?•œ ?‘˜ ?„ ?ƒ?•´?„œ ë°”ê¾¸?–´ë³?
				swap(j, i, j-1, i);
				int tmp = longestCandy();
				longest = tmp>longest?tmp:longest;
				swap(j, i, j-1, i); //?›?ƒë³µê?.
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
?…? ¥
ì²«ì§¸ ì¤„ì— ë³´ë“œ?˜ ?¬ê¸? N?´ ì£¼ì–´ì§„ë‹¤. (3 ?‰¤ N ?‰¤ 50)

?‹¤?Œ Nê°? ì¤„ì—?Š” ë³´ë“œ?— ì±„ì›Œ? ¸ ?ˆ?Š” ?‚¬?ƒ•?˜ ?ƒ‰?ƒ?´ ì£¼ì–´ì§„ë‹¤. ë¹¨ê°„?ƒ‰?? C, ?ŒŒ???ƒ‰?? P, ì´ˆë¡?ƒ‰?? Z, ?…¸???ƒ‰?? Yë¡? ì£¼ì–´ì§„ë‹¤.

ì¶œë ¥
ì²«ì§¸ ì¤„ì— ?ƒê·¼ì´ê°? ë¨¹ì„ ?ˆ˜ ?ˆ?Š” ?‚¬?ƒ•?˜ ìµœë? ê°œìˆ˜ë¥? ì¶œë ¥?•œ?‹¤.

?˜ˆ? œ ?…? ¥ 1 
5
YCPZY
CYZZP
CCPPP
YCYZC
CPPZZ
?˜ˆ? œ ì¶œë ¥ 1 
4
*/