package dp;

import java.util.Scanner;

public class Pelindrom1695_x {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int []arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int count = arr.length-2;
		int temp = arr.length-1;
		for (int front = 0; front < arr.length-count; front++) {
			for (int rear = temp; rear > front ; rear--) {
				//System.out.println("arr["+front+"] = "+arr[front]+" arr["+rear+"] = "+arr[rear]);
				if (arr[front]==arr[rear]) {
					count--;
					System.out.println("��ġ! "+count);
					temp = rear -1;
				}
			}
		}
		System.out.println(arr.length%2==0 && count == arr.length/2?0:count);
		sc.close();
	}
}
/*
1695��
����
���� ���
���ڵ�
Ǯ��
Ǯ�� �ۼ�
Ǯ�� ��û
��ä��/����
ä�� ��Ȳ
�� �ҽ�
����
���� �˻�
�Ӹ���� �����
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	128 MB	1577	604	438	39.495%
����
�տ��� �ڷ� ����, �ڿ��� ������ ���� ���� ������ �Ӹ���� �̶�� �Ѵ�. ���� ��� {1}, {1, 2, 1}, {1, 2, 2, 1}�� ���� ������ �Ӹ���� ������, {1, 2, 3}, {1, 2, 3, 2} ���� �Ӹ������ �ƴϴ�.

�� ������ �־����� ��, �� ������ �ּ� ������ ���� ���� �־� �Ӹ������ ������� �Ѵ�. �ּ� �� ���� ���� ���� ������ �Ǵ����� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ ���� N(1��N��5,000)�� �־�����. ���� �ٿ��� N���� ������ �̷�� ������ �־�����. �� ������ int �����̴�.

���
ù° �ٿ� ���� ���� ������ �ּ� ������ ����Ѵ�.

���� �Է� 
5
1 2 3 4 2
���� ��� 
2
*/

