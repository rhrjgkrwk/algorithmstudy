package bruteforce;
import java.util.Scanner;

public class QuadTree1992 {
	public static int N;
	public static char[][] display;

	// public static String s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		display = new char[N][N];
		for (int i = 0; i < N; i++) {
			String temp = sc.nextLine();
			display[i] = temp.toCharArray();
		}
		System.out.println(solve(0,0,N));
		sc.close();
	}

	public static String solve(int i, int j, int d) {
		if (d == 1) {
			String tmp = String.valueOf(display[i][j]);
			return tmp;
		}
		String temp = "("+solve(i, j, d/2) + solve(i, j+d/2, d/2) + solve(i+d/2, j, d/2) + solve(i+d/2, j+d/2, d/2)+")";
		if (temp.equals("(0000)")) {
			return "0";
		}
		else if (temp.equals("(1111)")) {
			return "1";
		}
		else {
			return temp;
		}
	}
}
/*
 * �ð� ���� �޸� ���� ���� ���� ���� ��� ���� ���� 2 �� 128 MB 4122 2348 1826 57.603% ���� ��� ������
 * �����Ͽ� ǥ���ϴ� ������ ������ ���� Ʈ��(Quad Tree)��� ����� �ִ�. �� ���� ��Ÿ���� 0�� ���� ���� ��Ÿ���� 1�θ� �̷����
 * ����(2���� �迭)���� ���� ������ ������ �� ���� ���� ����������, ���� Ʈ�������� �̸� �����Ͽ� ������ ǥ���� �� �ִ�.
 * 
 * �־��� ������ ��� 0���θ� �Ǿ� ������ ���� ����� "0"�� �ǰ�, ��� 1�θ� �Ǿ� ������ ���� ����� "1"�� �ȴ�. ���� 0�� 1��
 * ���� ������ ��ü�� �� ���� ��Ÿ������ ���ϰ�, ���� ��, ������ ��, ���� �Ʒ�, ������ �Ʒ�, �̷��� 4���� �������� ������ �����ϰ�
 * �Ǹ�, �� 4���� ������ ������ ����� ���ʴ�� ��ȣ �ȿ� ��� ǥ���Ѵ�
 * 
 * 
 * 
 * �� �׸����� ������ ������ �������� �迭�� ���� ���ڷ� �־�����, �� ������ ���� Ʈ�� ������ �̿��Ͽ� �����ϸ�
 * "(0(0011)(0(0111)01)1)"�� ǥ���ȴ�. N ��N ũ���� ������ �־��� ��, �� ������ ������ ����� ����ϴ� ���α׷���
 * �ۼ��Ͻÿ�.
 * 
 * �Է� ù° �ٿ��� ������ ũ�⸦ ��Ÿ���� ���� N �� �־�����. N �� ������ 2�� �������� �־�����, 1��N ��64�� ������ ������. ��
 * ��° �ٺ��ʹ� ���� N �� ���ڿ��� N �� ���´�. �� ���ڿ��� 0 �Ǵ� 1�� ���ڷ� �̷���� ������, ������ �� ������ ��Ÿ����.
 * 
 * ��� ������ ������ ����� ����Ѵ�.
 * 
 * ���� �Է� 8 11110000 11110000 00011100 00011100 11110000 11110000 11110011
 * 11110011 ���� ��� ((110(0101))(0010)1(0001))
 * 
 * ((110(0101))(0010)1(0001)) 
 */