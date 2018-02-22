package etc;

import java.util.Arrays;

// 배열의 sorting을 해보자. 01222
//내부 정렬 : memory sort - 메모리 내부에서
/*- raddix sort : 10번대 20번대 30번대 분류 후 각각에서 1의 자리 정렬.
- bubble sort : 앞뒤 계속 바꿈.
- insertion : 삽입정렬
- shell : 
- selection sort : 선택정렬 제일 큰거 선택 맨뒤로, 이 작업을 반복.
===여기까지는 O(n^2)===

- quick sort : O(nlogn) : 기준점(중간값)잡고 큰건 뒤로 작은건 앞으로 --> 반복 & 마지막에는 버블이나 삽입정렬로 마무리. 

- 배열 넘겨주기
	- int arr[] 이 있을때 arr은 배열의 첫번째 주소를 가리키므로 배열의 대표이름 arr만 넘겨주면 된다. 
	- 주소를 넘겨주기때문에 매개변수 측에서 변수의 값을 읽고 변경할 수 있따. 
	- 이를 call by reference라고 함
- 값넘겨주기
	- 변수의 값만 복사해서 넘겨줌. 변경이 불가능하다.
	- call by value
*/	

		
//외부 정렬 : 보조기억장치 sort - 하드디스크나 마그네틱 테잎에서.

public class AlgoSorting {
	public static void main(String[] args) {
		int arr[] = { 50,100,30,70,52,3 };
		
		System.out.println("정렬 전");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		
		System.out.println("오름차순 정렬");
		selectionSort1(arr);//오름차순
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		
		System.out.println("내림차순 정렬");
		selectionSort(arr);//내림차순
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
		Arrays.sort(arr1); //별다른 말이 없으면 이걸 쓰도록 하자.
		for (int i : arr1) { //foreach

		}
		for (int i = arr1.length-1; i >= 0; i--) {
			System.out.print(arr1[i]+"\t");			
		}
		
	}
		
	public static void selectionSort1(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i]>arr[j]) { //오름차순 정렬을 해보자.
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	public static void selectionSort(int[] arr) {
		/*
		1. 내림차순으로 정렬한다고 해보자
		2. 첫번째와 2~4번째랑 비교해서 가장 큰 걸 첫번째 자리에 넣자.
		3. 첫번째에는 최대값이 들어있게 된다.
		4. 이제 두번째와 나머지(첫번째를 제외한)를 비교해본다.
		5. 두번째에는 두번째로 큰 수가 들어가게 된다.
		6. 반복.
		*/
		for (int i = 0; i < arr.length-1; i++) { //기준점 i
			for (int j = i+1; j < arr.length; j++) { //기준점과의 비교대상( i+1~)
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
		1. 쌍으로 비교하면서 나아감
		2. 마지막 자리가 먼저 소팅됨
		3. 소팅이 완료된 부분 뺴면서 둘둘 비교해서 swap하면 소팅이 완성된다.
		4. 첫번째 시도에 정렬이 된 경우를 생각해보자. -
		5. swap을 체크해서 swap이 없었으면 정렬이 이미 된 것이므로 조기종료
		*/
		
		for (int i = 0; i < arr.length-1; i++) {
			boolean swap=false;
			for (int j = 0; j < arr.length-1-i; j++) {
								// -1 한 것은 j+1을 쓰기 때문
								// i를 빼는 것은 이미 sorting 완료된 부분을 또 건드리지 않기 위해서
				if (arr[j]<arr[j+1]) {//swap
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					swap = true; //swap을 카운트한다.
				}
			}
			if (swap==false) { //한 바퀴 돌고 swap이 없었다면 정렬이 된 것이므로 종료.
				break;
			}
		}
	}
}
