package etc;
import java.util.ArrayList;
import java.util.Scanner;
//N���� ����
//a,b,c,d,,,,�� �Է����� �־�����
//�� �� ��� prime number���� ����ϴ� ���α׷�.
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
		//prime number�� ã�ƺ���
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
