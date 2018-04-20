package hanhwa;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Hanhwa1107 {
	public static boolean remoteControl[] = new boolean[12];// 0-9 10:+ 11:-
	// 편의를 위해 고장난 버튼 = true
	public static int channel; // 목표 채널

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		channel = Integer.parseInt(sc.nextLine());
		int tmp = Integer.parseInt(sc.nextLine());
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		for (int i = 0; i < tmp; i++) {
			remoteControl[Integer.parseInt(st.nextToken())] = true;
		}
		boolean remoteCon = false;
		for (int i = 0; i < 10; i++) {
			if (!remoteControl[i]) {
				remoteCon = true;
			}
		}
		int count = 0;
		// 큰 수 중 가장 작은 값과 gap1

		if (remoteCon) {

			int largeNum = Integer.MAX_VALUE;
			for (int i = channel;; i++) {
				String num = String.valueOf(i);
				boolean flag = true;
				for (int j = 0; j < num.length(); j++) {
					if (remoteControl[(int) (num.charAt(j) - '0')]) {
						flag = false;
					}
				}
				if (flag) {
					largeNum = i;
					break;
				}
			}
			// 작은 수 중 가장 작은 값과 gap2
			int smallNum = Integer.MAX_VALUE;
			for (int i = channel;; i--) {
				String num = String.valueOf(i);
				boolean flag = true;
				for (int j = 0; j < num.length(); j++) {
					if (remoteControl[(int) (num.charAt(j) - '0')]) {
						flag = false;
					}
				}
				if (flag) {
					smallNum = i;
					break;
				}
			}

			HashMap<Integer, Integer> map = new HashMap<>();
			map.put(largeNum - channel, largeNum);
			map.put(channel - smallNum, smallNum);
			map.put(Math.abs(channel - 100), 100);

			int val = map.get(Math.min(Math.min(largeNum - channel, channel - smallNum), Math.abs(channel - 100)));

			if (val != 100) {
				count = String.valueOf(val).length() + Math.abs(channel - val);
			}
		}
		else {
			count = Math.abs(channel - 100);
		}
		
		System.out.println(count);
	}
}

/*
500000
10
0 1 2 3 4 5 6 7 8 9
11117
 */
