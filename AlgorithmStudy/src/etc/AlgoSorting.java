package etc;

import java.util.Arrays;

// �迭�� sorting�� �غ���. 01222
//���� ���� : memory sort - �޸� ���ο���
/*- raddix sort : 10���� 20���� 30���� �з� �� �������� 1�� �ڸ� ����.
- bubble sort : �յ� ��� �ٲ�.
- insertion : ��������
- shell : 
- selection sort : �������� ���� ū�� ���� �ǵڷ�, �� �۾��� �ݺ�.
===��������� O(n^2)===

- quick sort : O(nlogn) : ������(�߰���)��� ū�� �ڷ� ������ ������ --> �ݺ� & ���������� �����̳� �������ķ� ������. 

- �迭 �Ѱ��ֱ�
	- int arr[] �� ������ arr�� �迭�� ù��° �ּҸ� ����Ű�Ƿ� �迭�� ��ǥ�̸� arr�� �Ѱ��ָ� �ȴ�. 
	- �ּҸ� �Ѱ��ֱ⶧���� �Ű����� ������ ������ ���� �а� ������ �� �ֵ�. 
	- �̸� call by reference��� ��
- ���Ѱ��ֱ�
	- ������ ���� �����ؼ� �Ѱ���. ������ �Ұ����ϴ�.
	- call by value
*/	

		
//�ܺ� ���� : ���������ġ sort - �ϵ��ũ�� ���׳�ƽ ���ٿ���.

public class AlgoSorting {
	public static void main(String[] args) {
		int arr[] = { 50,100,30,70,52,3 };
		
		System.out.println("���� ��");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		
		System.out.println("�������� ����");
		selectionSort1(arr);//��������
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		
		System.out.println("�������� ����");
		selectionSort(arr);//��������
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		
		int arr1[] = {100,45,6,35,16};
		Arrays.sort(arr1); //���ٸ� ���� ������ �̰� ������ ����.
		for (int i : arr1) { //foreach

		}
		for (int i = arr1.length-1; i >= 0; i--) {
			System.out.print(arr1[i]+"\t");			
		}
		
	}
		
	public static void selectionSort1(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i]>arr[j]) { //�������� ������ �غ���.
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	public static void selectionSort(int[] arr) {
		/*
		1. ������������ �����Ѵٰ� �غ���
		2. ù��°�� 2~4��°�� ���ؼ� ���� ū �� ù��° �ڸ��� ����.
		3. ù��°���� �ִ밪�� ����ְ� �ȴ�.
		4. ���� �ι�°�� ������(ù��°�� ������)�� ���غ���.
		5. �ι�°���� �ι�°�� ū ���� ���� �ȴ�.
		6. �ݺ�.
		*/
		for (int i = 0; i < arr.length-1; i++) { //������ i
			for (int j = i+1; j < arr.length; j++) { //���������� �񱳴��( i+1~)
				if (arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void bubbleSort(int[] arr) {
	/*	
		1. ������ ���ϸ鼭 ���ư�
		2. ������ �ڸ��� ���� ���õ�
		3. ������ �Ϸ�� �κ� ���鼭 �ѵ� ���ؼ� swap�ϸ� ������ �ϼ��ȴ�.
		4. ù��° �õ��� ������ �� ��츦 �����غ���. -
		5. swap�� üũ�ؼ� swap�� �������� ������ �̹� �� ���̹Ƿ� ��������
		*/
		
		for (int i = 0; i < arr.length-1; i++) {
			boolean swap=false;
			for (int j = 0; j < arr.length-1-i; j++) {
								// -1 �� ���� j+1�� ���� ����
								// i�� ���� ���� �̹� sorting �Ϸ�� �κ��� �� �ǵ帮�� �ʱ� ���ؼ�
				if (arr[j]<arr[j+1]) {//swap
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					swap = true; //swap�� ī��Ʈ�Ѵ�.
				}
			}
			if (swap==false) { //�� ���� ���� swap�� �����ٸ� ������ �� ���̹Ƿ� ����.
				break;
			}
		}
	}
}
