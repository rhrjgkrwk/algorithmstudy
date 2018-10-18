package bruteforce;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Gear {
	// N극 = 0
	// S극 = 1
	int[] wing = new int[8];
	int left;
	int right;
	int top;
	boolean visit = false;

	public Gear() {
	}

	public Gear(int[] wing, int left, int right, int top) {
		super();
		this.wing = wing;
		this.left = left;
		this.right = right;
		this.top = top;
	}
}

public class Algo15662 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Gear> gears = new ArrayList<>();
	public static int T;

	public static void main(String[] args) {
		T = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < T; i++) {
			Gear temp = new Gear();
			String s = sc.nextLine();
			for (int j = 0; j < 8; j++) {
				temp.wing[j] = s.charAt(j) - '0';
			}

			temp.top = 0;
			temp.right = 2;
			temp.left = 6;

			gears.add(temp);
		}
		int numOfCommands = Integer.parseInt(sc.nextLine());
		int answer = 0;
		for (int i = 0; i < numOfCommands; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			int gearNum = Integer.parseInt(st.nextToken()) - 1;
			int directionAndRotation = Integer.parseInt(st.nextToken());
			rotate(gearNum, directionAndRotation);
		}

		for (Gear gear : gears) {
			if (gear.wing[gear.top] == 1) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static void rotate(int gearNum, int directionAndRotation) {
		
		Gear now = gears.get(gearNum);
		Gear beforeRotate = new Gear(now.wing, now.left, now.right, now.top);
		
		now.top = (now.top + (-directionAndRotation % 8 + 8)) % 8;
		now.left =(now.left + (-directionAndRotation % 8 + 8)) % 8;
		now.right = (now.right + (-directionAndRotation % 8 + 8)) % 8;
		now.visit = true;
		
		int leftGear = gearNum - 1;
		int rightGear = gearNum + 1;
		
		
		// left gear
		if (leftGear >= 0 && beforeRotate.wing[beforeRotate.left] != gears.get(leftGear).wing[gears.get(leftGear).right]
				&& !gears.get(leftGear).visit) { // 왼쪽에 기어가 있고, 극이 다르면 회전.
//			int otherDirection = directionAndRotation > 0 ? -1 : 1;
//			rotate(leftGear, otherDirection);
			rotate(leftGear, -directionAndRotation);
		}
		// right gear.
		if (rightGear < T && beforeRotate.wing[beforeRotate.right] != gears.get(rightGear).wing[gears.get(rightGear).left]
				&& !gears.get(rightGear).visit) {
//			int otherDirection = directionAndRotation > 0 ? -1 : 1;
//			rotate(rightGear, otherDirection);
			rotate(rightGear, -directionAndRotation);
		}
		
		now.visit = false;
	}
}
