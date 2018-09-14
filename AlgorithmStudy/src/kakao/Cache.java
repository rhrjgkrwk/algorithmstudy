package kakao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cache {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cacheSize;
		int cacheMiss = 0;
		int cacheHit = 0;
		int runtime = 0;
		int n = Integer.parseInt(sc.nextLine());
		cacheSize = Integer.parseInt(sc.nextLine());
		Queue<String> cities = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String city = sc.nextLine().toLowerCase();
			//hit
			if (cities.contains(city)) {
				cacheHit++;
				cities.remove(city);
				cities.add(city);
			} 
			//miss
			else {
				cacheMiss++;
				cities.add(city);
				if(cities.size() > cacheSize) cities.poll();
			}
		}
		runtime = cacheHit + cacheMiss*5;
		System.out.println(runtime);
	}
}



