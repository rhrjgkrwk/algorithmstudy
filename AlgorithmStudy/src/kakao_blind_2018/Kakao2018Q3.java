package kakao_blind_2018;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Perm { 
	Set<Integer> set;
	boolean flag;
}

public class Kakao2018Q3 {
	private ArrayList<ArrayList<Perm>> p;

	public static void main(String[] args) {

	}

	public int solution(String[][] relation) {
		int row = relation.length;
		int col = relation[0].length;
		// stage는 1, 2, 3 ... 개씩 합쳤을 때, 최소성, 유일성이보장 되는지 체크. 이미 최소성/유일성이 보장된 col들은 제외.
		for (int stage = 0; stage < col; stage++) {
			Set<String> set = new HashSet<>();
			

		}

		int answer = 0;
		return answer;

	}

	public void perm(int n, int r, int i, Set<Integer> colNums) {
		if (n==r) {
			return;
		}
		
	}
}
