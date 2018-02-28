package etc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SymmetricDifferenceSet1269 {
	public static void main(String[] args) {
		Set<Integer> a = new HashSet<>();
		Set<Integer> b = new HashSet<>();
		Set<Integer> aub = new HashSet<>();
		Set<Integer> anb = new HashSet<>();
		Scanner sc = new Scanner(System.in);

		int sizeA = sc.nextInt();
		int sizeB = sc.nextInt();

		for (int i = 0; i < sizeA; i++) {
			a.add(sc.nextInt());
		}
		for (int i = 0; i < sizeB; i++) {
			b.add(sc.nextInt());
		}
		//������
		aub.addAll(a);
		aub.addAll(b);
		
		//������
		for (Integer i : a) {
			if (b.contains(i)) {
				anb.add(i);
			}
		}
		//aub-anb
		for (Integer i : anb) {
			if (aub.contains(i)) {
				aub.remove(i);
			}
		}
		System.out.println(aub.size());
	}
}

/*
1269��

��Ī ������ Ǯ��
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	128 MB	1624	735	557	45.285%
����
�ڿ����� ���ҷ� ���� �������� �ƴ� �� ���� A�� B�� �ִ�. �� ��, �� ������ ��Ī �������� ������ ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�. �� ���� A�� B�� ���� ��, (A-B)�� (B-A)�� �������� A�� B�� ��Ī �������̶�� �Ѵ�.

���� ���, A = { 1, 2, 4 } �̰�, B = { 2, 3, 4, 5, 6 } ��� �� ��,  A-B = { 1 } �̰�, B-A = { 3, 5, 6 } �̹Ƿ�, ��Ī �������� ������ ������ 1 + 3 = 4���̴�.

�Է�
ù° �ٿ� ���� A�� ������ ������ ���� B�� ������ ������ �� ĭ�� ���̿� �ΰ� �־�����. ��° �ٿ��� ���� A�� ��� ���Ұ�, ��° �ٿ��� ���� B�� ��� ���Ұ� �� ĭ�� ���̿� �ΰ� ���� �־�����. �� ������ ������ ������ 200,000�� ���� ������, ��� ������ ���� 100,000,000�� ���� �ʴ´�.

���
ù° �ٿ� ��Ī �������� ������ ������ ����Ѵ�.

���� �Է� 
3 5
1 2 4
2 3 4 5 6
���� ��� 
4
*/