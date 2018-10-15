package nhn;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Item implements Comparable<Item> {
	int num;
	int age;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int num, int age) {
		super();
		this.num = num;
		this.age = age;
	}

	@Override
	public int compareTo(Item o) {
		return this.age - o.age;
	}
}

public class MockExamQ1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		PriorityQueue<Item> pq = new PriorityQueue<>();
		boolean flag = true; // flag가 false이면 버린 아이템이 있는 것.
		int age = 1;
		
		while (st.hasMoreTokens()) {
			int newItem = Integer.parseInt(st.nextToken());
			boolean duplicationCheck = false;
			if (pq.size() < 3) {
				for (Item item : pq) {
					if (newItem == item.num) {
						pq.remove(item);
						pq.add(new Item(newItem, age++));
						duplicationCheck = true;
						break;
					}
				}
				if (!duplicationCheck) {
					pq.add(new Item(newItem, age++));
				}
				
			}
			else {
				for (Item item : pq) {
					if (newItem == item.num) {
						pq.remove(item);
						pq.add(new Item(newItem, age++));
						duplicationCheck = true;
						break;
					}
				}
				if (!duplicationCheck) {
					System.out.println(pq.poll().num);
					flag = false;
					pq.add(new Item(newItem, age++));
				}				
			}
		}
		if (flag) {
			System.out.println(0);
		}
	}
}
