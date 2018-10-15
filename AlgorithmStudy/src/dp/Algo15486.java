package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Algo15486 {
	public static HashMap<Integer, ArrayList<Task>> sche;
	public static int N;
	public static int dp[];
	public static Scanner sc;

	static {
		sche = new HashMap<>();
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		N = sc.nextInt();
		dp = new int[N + 2];
		for (int i = 1; i <= N; i++) {
			int duration = sc.nextInt();
			int price = sc.nextInt();
			int start = i;
			int end = start + duration - 1;

			if (!sche.containsKey(end)) {
				sche.put(end, new ArrayList<>());
			}
			
			sche.get(end).add(new Task(start, end, price, duration));
		}

		// DP
		for (int today = 1; today <= N; today++) {
			int maxValueForToday = 0;
			if(sche.containsKey(today)) {
				for (Task task : sche.get(today)) { 
					if (task.end == today && maxValueForToday <= dp[today - task.duration] + task.price) {
						maxValueForToday = dp[today - task.duration] + task.price;
					}
				}
			}
			dp[today] = maxValueForToday < dp[today - 1] ? dp[today - 1] : maxValueForToday;
		}

		System.out.println(dp[N]);

	}

}

class Task {
	int start;
	int end;
	int price;
	int duration;

	public Task() {
		super();
	}

	public Task(int start, int end, int price, int duration) {
		super();
		this.start = start;
		this.end = end;
		this.price = price;
		this.duration = duration;
	}

}