package etc;
import java.util.Scanner;

public class AlgoBangBunho {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int count[] = new int[10];
		String num = scanner.nextLine();
		int max=0;
		for (int i = 0; i < num.length(); i++) {
			count[(int)(num.charAt(i)-'0')]++;
		}
		for (int i = 0; i < 10; i++) {
			if (count[max]<count[i]) {
				max = i;
			}
		}
		if (max==6||max==9) System.out.println((int)Math.ceil((count[6]+count[9])/2.0));
		else System.out.println(count[max]);
		
		scanner.close();
	}
}

/*시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	8106	2752	2470	41.794%
문제
다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.

다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최소값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)

입력
첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 필요한 세트의 개수를 출력한다.

예제 입력  복사
9999
예제 출력  복사
2
*/