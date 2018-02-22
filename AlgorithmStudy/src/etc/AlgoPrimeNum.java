package etc;
import java.util.ArrayList;
import java.util.Scanner;
//N개의 숫자
//a,b,c,d,,,,가 입력으로 주어지고
//그 중 몇개가 prime number인지 출력하는 프로그램.
public class AlgoPrimeNum {
	public static void main(String[] args) {
		int N;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int count = N;
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}
		//prime number를 찾아보자
		for (int i = 0; i < N; i++) {
			if (arr.get(i)!=1) {
				for (int j = 2; j <= arr.get(i)/2; j++) {
					if (arr.get(i)%j==0) {
						count--;
						break;
					}
				}
			}
			else count--;
		}
		System.out.println(count);
		sc.close();
	}
}
