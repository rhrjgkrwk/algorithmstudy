package kakao;

import java.util.ArrayList;
import java.util.Collections;

public class CodingTestQ12 {
	public static void main(String[] args) {
		String s = "abcd";
		StringBuilder sb = new StringBuilder(s);
		int leftShifts=1;
		int rightShifts=2;
		int temp = (leftShifts - rightShifts) % sb.length();
		//ls - rs % stringlen 에 절대값을 씌우r고 이 수치대로 ls또는 rs하게 되면 최종 String 이 나온다.
		if (temp > 0) { //left shift
			sb.append(sb.substring(0, temp));
			sb.delete(0, temp);
		}
		else if(temp < 0){ // right shift.
			sb.insert(0, sb.substring(sb.length()-Math.abs(temp)));
			sb.delete(sb.length()-Math.abs(temp), sb.length());
		}
        
        String res = sb.toString();
        System.out.println(res);
//		문제가 정렬인데 빈도 - 숫자 크기 순 정렬 이어씅ㅁ.
		int a[] = {3,1,2,2,4};
		int freq[] = new int [1000001]; // 각 element 별로 빈도를 체크  
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			freq[a[i]]++;
			if (max < freq[a[i]]) {
				max = freq[a[i]]; // 아래 for 문을 위해서 빈도를 체크하면서 가장높은 빈도를 max 에 저장하자..
			}
		}
		ArrayList<ArrayList<Integer>> res1 = new ArrayList<>();
//        실수로 메모리 낭비를 해버렸다. 아래에서 그냥 sysout 할 거면. 위 처럼 이중 arrlist 로 선언할 필요가 없다. 
        
		for (int i = 1; i <= max; i++) { // 빈도가 1인 것부터 max 인것까지 for 문 돌면서 chk.
			res1.add(new ArrayList<>()); // 여기서 ㅁrrlist 를 메모리에 할당한다.
			for (int j = 0; j < a.length; j++) {
				if(freq[a[j]] == i) {}
			}
			Collections.sort(res1.get(i-1)); // 정렬한다. 
			for (int j : res1.get(i-1)) { // 출력한다. 
				System.out.println(j);
			}
		}
	}
}
