package etc;
import java.util.Scanner;

/*�Է�
T : �׽�Ʈ���̽� ��
N : ���� ���� (0�� ����)
a(n) : ���� ��ǥ
K : ������ �ִ��̵� �Ÿ�


���
�� TC���� Case #T�� ���
�������� ������ ���� �̵��� �� �ִ� �ּ�����Ƚ��
�Ұ����� ��� -1


�Է� ����
1
8
1 2 5 7 9 10 12 15
4
*/


public class AlgoFrog {
	static int Answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �Է�
		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			int N = sc.nextInt();
			int[] a = new int[N + 1];
			for (int j = 1; j < N + 1; j++) {
				a[j] = sc.nextInt();
			}
			int K = sc.nextInt();

			System.out.println("Case #"+(test_case+1));
			
			
			
			// ���
			int pos = 0; // ���� ��ġ(���� ���� ��ġ). not an index,
			Answer = 0; // �� ���� Ƚ��
			while (a[pos] < a[a.length - 1]) { 
				if (K<a[pos+1]-a[pos]) { //���� ���ٸ��� �� �ָ� ������ ��. count = -1
					Answer = -1;
					break;
				}
				else {
					int temp = pos;
					for (int j = pos + 1; j < a.length; j++) { 
						// a[j(pos+1~a.length-1)]-a[pos] �� K���� ���ų� �����鼭 ���� ū��
						if (K>=a[j] - a[pos]) {
							temp = j;
						}
						else{
							break;
						}
					}
					pos = temp;
					Answer++;
				}
			}

			System.out.println(Answer);
		}
	}
}
