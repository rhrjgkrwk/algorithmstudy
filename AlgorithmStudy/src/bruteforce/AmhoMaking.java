package bruteforce;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class AmhoMaking {
	public static char[] moeum = new char[]{
			'a','e','i','o','u'
	};
	public static int C;
	public static int L;
	public static char[] ch;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = Integer.parseInt(sc.next());
		C = Integer.parseInt(sc.next());
		ch = new char[C];
		for (int i = 0; i < ch.length; i++) {
			ch[i] = sc.next().charAt(0);
		}
		Arrays.sort(ch);
		//System.out.println(ch);
		String str ="";
		solve(0,0,0,str);
		sc.close();
	}
	public static void solve(int i, int nom, int noj, String temp){ //number of moeum
		if (temp.length()==L && nom>=1 && noj>=2) {
			System.out.println(temp);
			return;
		}
		if (temp.length()<L && i<C) {
			if (isMoeum(ch[i])) {
					solve(i+1, nom+1, noj, temp+ch[i]);
					solve(i+1, nom, noj, temp);
			}
			else { //������ ���
				solve(i+1, nom, noj+1, temp+ch[i]);
				solve(i+1, nom, noj, temp);
			}
		}
		
	}
	public static boolean isMoeum(char c){
		for (int i = 0; i < moeum.length; i++) {
			if (c==moeum[i]) {
				return true;
			}
		}
		return false;
	}
}

/*
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	128 MB	6633	2833	2052	43.706%
����
�ٷ� ���� �ֹ��� ������ �� ���踦 �ָӴϿ� ���� ä �����ϰ� ����� �� ������ 
Ȳ���� ��Ȳ�� ������ ��������, 702ȣ�� ���ο� ���� �ý����� ��ġ�ϱ�� �Ͽ���. 
�� ���� �ý����� ���谡 �ƴ� ��ȣ�� �����ϰ� �Ǿ� �ִ� �ý����̴�.

��ȣ�� ���� �ٸ� L���� ���ĺ� �ҹ��ڵ�� �����Ǹ� �ּ� �� ���� ������ 
�ּ� �� ���� �������� �����Ǿ� �ִٰ� �˷��� �ִ�. 
���� ���ĵ� ���ڿ��� ��ȣ�ϴ� �������� �������� �̷�� ���� 
��ȣ�� �̷�� ���ĺ��� ��ȣ���� �����ϴ� ������ �迭�Ǿ��� ���̶�� �����ȴ�. 
��, abc�� ���ɼ��� �ִ� ��ȣ������ bac�� �׷��� �ʴ�.

�� ���� �ý��ۿ��� �������� ��ȣ�� ������� ���� ������ ������ C������ �ִٰ� �Ѵ�. 
�� ���ĺ��� �Լ��� �ν�, ���� ������ �������� �濡 ħ���ϱ� ���� ��ȣ�� ������ ������ �Ѵ�. 
C���� ���ڵ��� ��� �־����� ��, ���ɼ� �ִ� ��ȣ���� ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù°�ٿ� �� ���� L, C�� �־�����. (3��L��C��15) ���� �ٿ��� C���� ���ڵ��� �������� ���еǾ� �־�����. 
�־����� ���ڵ��� ���ĺ� �ҹ����̸�, �ߺ��Ǵ� ���� ����.

���
�� �ٿ� �ϳ���, ���������� ���ɼ� �ִ� ��ȣ�� ��� ����Ѵ�.

���� �Է� 
4 6
a t c i s w
���� ��� 
acis
acit
aciw
acst
acsw
actw
aist
aisw
aitw
astw
cist
cisw
citw
istw

*/