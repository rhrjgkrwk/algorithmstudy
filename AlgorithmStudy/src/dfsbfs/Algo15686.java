package dfsbfs;

import java.util.ArrayList;
import java.util.Scanner;

class P15686 {
	int r;
	int c;
	boolean isOpen = true;
	public P15686(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	@Override
	public String toString() {
		return "r : " + r + " c : " + c + " isOpen : " + isOpen;
	}
}

public class Algo15686 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<P15686> chickenList = new ArrayList<>();
	public static ArrayList<P15686> houseList = new ArrayList<>();
	public static int minimumCityChickenDistance = Integer.MAX_VALUE;
	public static int[][] map;
	public static int N;
	public static int M;

	public static void dfs(int selected, int chickenIndex) {
//		System.out.println("====================");
//		System.out.println("selected : " + selected);
//		System.out.println("index : " + chickenIndex);
//		for (P15686 c : chickenList) {
//			System.out.println(c);
//		}
		
		
		if (selected == chickenList.size() - M) {
			int newCityChickenDistance = getCityChickenDistance();
			minimumCityChickenDistance = minimumCityChickenDistance > newCityChickenDistance ? newCityChickenDistance : minimumCityChickenDistance;
			return;
		}
		
		if (chickenIndex >= chickenList.size()) {
			return;
		}

		P15686 now = chickenList.get(chickenIndex);
		now.isOpen = false;
		dfs(selected+1, chickenIndex + 1);
		now.isOpen = true;
		dfs(selected, chickenIndex + 1);
	}

	public static int getCityChickenDistance() {
		int chickenDistance = 0;
		for (P15686 house : houseList) {
			int minDist = Integer.MAX_VALUE;
			for (P15686 chicken : chickenList) {
				if (chicken.isOpen) {
					int temp = Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c);
					minDist = minDist > temp ? temp : minDist;
				}
			}
			chickenDistance += minDist;
		}
		return chickenDistance;
	}

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				if (temp == 1) {
					houseList.add(new P15686(i, j));
				} else if (temp == 2) {
					chickenList.add(new P15686(i, j));
				}
			}
		}
		dfs(0,0);
		System.out.println(minimumCityChickenDistance);
	}
}
