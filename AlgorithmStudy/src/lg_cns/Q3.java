package lg_cns;

import java.util.ArrayList;
import java.util.Collections;


public class Q3 {
	public static void main(String[] args) {
		int[] healths = { 200, 120, 150 };
		int[][] items = { { 30, 100 }, { 500, 30 }, { 100, 400 } };
		new Q3().solution(healths, items);
	}

	public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public int[] solution(int[] healths, int[][] items) {
		boolean[] isSelected = new boolean[items.length];
		int max = dfs(healths, items, isSelected, new ArrayList<Integer>(), 0);
		int[] answer = {};
		
		for (int i = 0; i < list.size(); i++) {
			int sum = 0;
			for (int j = 0; j < list.get(i).size(); j++) {
				sum+=list.get(i).get(j);
			}
			if (sum == max) {
				int m = 0;
				answer = new int[list.get(i).size()];
				Collections.sort(list.get(i));
				for (int n : list.get(i)) {
					for (int j = 0; j < items.length; j++) {
						if (n==items[j][0]) {
							answer[m++] = j+1;
						}
					}
				}
			}
		}
		
//		for (int i = 0; i < answer.length; i++) {
//			System.out.println(answer[i]);
//		}
		
//		
//		for (ArrayList<Integer> l : list) {
//			for (Integer i : l) {
//				System.out.print(i + " ");
//			}System.out.println();
//		}
		return answer;
	}

	public int dfs(int[] healths, int[][] items, boolean[] isSelected, ArrayList<Integer> selectedItems, int depth) {
		if (depth == healths.length) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (Integer i : selectedItems) {
				temp.add(i);
			}
			list.add(temp);
			return 0;
		}
		int max = 0;
		for (int i = 0; i < items.length; i++) {
			if (!isSelected[i]) {
				int t1 = 0;
				int t2 = 0;
				int t3 = 0;
				if (healths[depth] - items[i][1] >= 100) {
					isSelected[i] = true;
					selectedItems.add(items[i][0]);
					t1 = dfs(healths, items, isSelected, selectedItems, depth + 1) + items[i][0];
					selectedItems.remove((Integer)items[i][0]);
					isSelected[i] = false;
					t2 = dfs(healths, items, isSelected, selectedItems, depth + 1);
				}
				else {
					t3 = dfs(healths, items, isSelected, selectedItems, depth + 1);
				}
				max = Math.max(Math.max(Math.max(t1, t2), t3),max);
			}
		}
		return max;
	}
}

// healths items return
// [200,120,150] [[30,100],[500,30],[100,400]] [1,2]
// [300,200,500] [[1000, 600], [400, 500], [300, 100]] [3]
// boolean[] check = new boolean[items.length];
//
// for (int i = 0; i < healths.length; i++) {
// for (int j = 0; j < items.length; j++) {
// if (healths[i] - items[j][1] >= 100 && !check[j]) {
// check[j] = true;
// }
// }
// }
//
// int count = 0;
// for (int i = 0; i < check.length; i++) {
// if (check[i]) {
// count++;
// }
// }
//
// int j = 0;
// int[] answer = new int[count];
// for (int i = 0; i < check.length; i++) {
// if (check[i]) {
// answer[j++] = i+1;
// }
// }
//
// return answer;