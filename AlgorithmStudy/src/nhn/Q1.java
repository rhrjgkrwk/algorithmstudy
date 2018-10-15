package nhn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//카드 섞기.
public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int P = sc.nextInt();
		
		List<Integer> cards = new ArrayList<>();
		for (int i = 1; i <= C; i++) {
			cards.add(i);
		}
		
		LinkedList<Integer> l = new LinkedList<>();
		
		for (int i = 0; i < P; i++) {
			List<Integer> result;
			int N = sc.nextInt();
			int swapSize = 0;
			int totalSize = cards.size();
			do {
				swapSize = totalSize - 2*N;
				
				List<Integer> temp = cards.subList(N, totalSize-N);
				for (int t : cards.subList(N, totalSize-N)) {
					temp.add(t);
				}
				cards.subList(N, totalSize-N).clear();
				cards.addAll(0, temp);
				
				totalSize = swapSize;
				
			} while (swapSize > 2*N);
			
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println(cards.get(i));
		}
		
	}
}
