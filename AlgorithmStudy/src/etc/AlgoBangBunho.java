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

/*�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	128 MB	8106	2752	2470	41.794%
����
�ټ��̴� �������� ������ ���� �̻�Դ�. �ټ��̴� �ڱ� �� ��ȣ�� ���� �ö�ƽ ���ڷ� ���� ���̷��� �Ѵ�.

�ټ����� ���������� �ö�ƽ ���ڸ� �� ��Ʈ�� �Ǵ�. �� ��Ʈ���� 0������ 9������ ���ڰ� �ϳ��� ����ִ�. �ټ����� �� ��ȣ�� �־����� ��, �ʿ��� ��Ʈ�� ������ �ּҰ��� ����Ͻÿ�. (6�� 9�� ����� �̿��� �� �ְ�, 9�� 6�� ����� �̿��� �� �ִ�.)

�Է�
ù° �ٿ� �ټ����� �� ��ȣ N�� �־�����. N�� 1,000,000���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.

���
ù° �ٿ� �ʿ��� ��Ʈ�� ������ ����Ѵ�.

���� �Է�  ����
9999
���� ���  ����
2
*/