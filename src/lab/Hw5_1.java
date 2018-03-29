
//***************************
// 파일명: Lab0_7.java
// 작성자: 마재희
// 작성일: 2017-09-09
// 설명:  클래스 작성, 객체 생성과 사용을 연습한다.
//***************************

package lab;

import java.util.Scanner;

public class Hw5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hw5_1:마재희");

		Scanner sc = new Scanner(System.in);

		MyList2 list = new MyList2();// 리스트 객체 생성(같은 패키지라 이름 바꿨습니다.)

		list.add(20);// 리스트에 20삽입
		list.add(30);// 리스트에 30삽입
		list.add(20);// 리스트에 20삽입
		list.add(40);// 리스트에 40삽입
		list.add(-999);// 리스트에 -999삽입
		list.add(50);// 리스트에 50삽입
		list.add(90);// 리스트에 90삽입
		list.add(10);// 리스트에 10삽입
		
		System.out.println(list);// 리스트 출력
		System.out.println("리스트의 크기= " + list.size());// 리스트 크기를 출력

		System.out.println("조회할 인덱스 입력: ");
		int n = sc.nextInt();// 조회할 인덱스를 입력받아 변수에 저장
		System.out.println("인덱스 " + n + "의 원소= " + list.get(n));//해당인덱스의 원소를 받아 출력

		System.out.println("777로 갱신할 인덱스 입력: ");
		int n2 = sc.nextInt();// 갱신할 인덱스를 입력받아 변수에 저장
		list.set(n2, 777);//입력받은 인덱스에 777로대치
		System.out.println(list);//리스트출력

		System.out.println("999를 삽입할 인덱스 입력: ");
		int n3 = sc.nextInt();//삽입할 인덱스를 입력받아 변수에 저장
		list.add(n3, 999);//입력받은 인덱스에 999를 삽입
		System.out.println(list);//리스트출력

		System.out.println("삭제할 인덱스 입력: ");
		int n4 = sc.nextInt();// 삭제할 인덱스를 입력받아 변수에 저장
		int re = list.remove(n4);//해당인덱스의 원소를 리턴받아 변수에 저장
		System.out.println("인덱스 " + n4 + "의 원소= " + re);//인덱스와 해당 원소를 출력
		System.out.println(list);//리스트 출력

		list.add(999);// 리스트에 1삽입
		list.add(2);// 리스트에 2삽입
		list.add(3);// 리스트에 3삽입
		list.add(4);// 리스트에 4삽입
		list.add(5);// 리스트에 5삽입
		list.add(6);// 리스트에 6삽입
		list.add(7);// 리스트에 7삽입
		list.add(8);// 리스트에 8삽입
		list.add(9);// 리스트에 9삽입
		list.add(10);// 리스트에 10삽입
		list.add(11);// 리스트에 11삽입
		list.add(12);// 리스트에 12삽입
		list.add(13);// 리스트에 13삽입
		list.add(14);// 리스트에 14삽입
		list.add(15);// 리스트에 15삽입
		list.add(16);// 리스트에 16삽입
		list.add(17);// 리스트에 17삽입
		list.add(18);// 리스트에 18삽입
		list.add(19);// 리스트에 19삽입
		list.add(20);// 리스트에 20삽입
		list.add(21);// 리스트에 21삽입
		list.add(22);// 리스트에 22삽입
		list.add(23);// 리스트에 23삽입
		list.add(24);// 리스트에 24삽입
		list.add(25);// 리스트에 25삽입
		System.out.println(list);
		
		sc.close();
	}

}

class MyList2 {
	private int[] arr;// 정수형 배열 선언
	private int cap;//배열 용량 변수 선언
	private int count;// 저장된 갯수 변수 선언

	public MyList2() {
		super();
		this.cap = 10;// 저장용량을 초기화
		this.arr = new int[cap];// 배열을 초기화
		this.count = 0;// 갯수 초기화
	}

	public void add(int x) {
		if (cap == count)
			extend();//확장메소드호출
		arr[count++] = x;//배열에 값 추가
	}// 정수를 매개변수로 받아 배열에 순서대로 삽입

	public void print() {
		System.out.print("[");

		for (int i = 0; i < arr.length; i++) {
			if (i < count) {
				System.out.print(arr[i]);
				if (i < count - 1)
					System.out.print(", ");
			}
		} // 출력화면에 맞게 출력
		System.out.println("]");
	}// 출력메소드

	public int get(int idx) {
		if (idx < count) {
			int value = arr[idx];//허용되는 인덱스 번위일 경우 그 인덱스의 원소를 변수에 저장한다
			return value;//저장된 원소를 리턴
		} else {
			System.out.println("허용되는 범위가 아닙니다. 프로그램을 종료합니다.");
			System.exit(0);
			return 0;
		}//허용되지 않는 인덱스 일경우 프로그램을 종료시킨다.

	}// 인덱스를 매개변수로 받아 해당 원소값을 리턴

	public void set(int idx, int value) {
		if (idx < count) {
			arr[idx] = value;//허용되는 인덱스 번위일 경우 그 인덱스에 값을 넣는다(대치)
		} else {
			System.out.println("허용되는 범위가 아닙니다. 프로그램을 종료합니다.");
			System.exit(0);
		}//허용되지 않는 인덱스 일경우 프로그램을 종료시킨다.
	}// 인덱스와 정수를 매개변수로 받아 해당 인덱스 값을 정수로 대치

	public int size() {
		return count;
	}// 현재 배열에 저장된 원소 수를 리턴

	public void add(int idx, int value) {
		if (cap == count)
			extend();//배열이 꽉찼을 경우 확장메소드 호출
		if (count >= idx) {//허용되는 범위일경우
			for (int i = count - 1; i >= idx; --i) {
				arr[i + 1] = arr[i];
			}//해당인덱스까지 배열의 원소를 옮긴다(큰쪽으로 옮겨 비어있게 만든다)
			arr[idx] = value;//해당인덱스에 값을 대입
			count++;//저장원소 증가
		} else {
			System.out.println("허용되는 범위가 아닙니다. 프로그램을 종료합니다.");
			System.exit(0);
		}//허용되지 않을경우 시스템 종료
	}//원하는 인덱스에 값을 대입하는 메소드

	public int remove(int idx) {
		if (count > idx) {//허용되는범위일경우
			int result = arr[idx];//해당인덱스의 값을 변수에 저장
			for (int i = idx; i < count-1; ++i) {
				arr[i] = arr[i + 1];
			}//리스트에서 값을 없애기 위해 해당인덱스까지 큰값들을 옮긴다
			count--;//저장원소 감소
			return result;//삭제한 값을 리턴
		} else {
			System.out.println("허용되는 범위가 아닙니다. 프로그램을 종료합니다.");
			System.exit(0);
			return 0;
		}//허용되지 않는 범위일 경우 시스템 종료
	}

	public void extend() {
		System.out.print("용량 증가 " + cap + "-->");
		cap = cap * 2;//배열 용량을 두배로 증가시킨다
		System.out.println(cap);
		int[] arr2 = new int[cap];//두배로 증가시킨 용량으로 새 배열을 만든다
		for (int i = 0; i < count; ++i) {
			arr2[i] = arr[i];
		}//원래 배열의 원소들을 새 배열에 복사시킨다.
		arr = arr2;//원래배열이 새로운 배열을 참조함
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("[");//스트링 버퍼를 통해 가비지가 안나오게 효율을 높힘
		for (int i = 0; i < count - 1; i++) {
			str.append(arr[i] + ", ");
		}//배열의 모든 원소를 스트링 버퍼에 순차적으로 붙힌다
		str.append(arr[count - 1]);//마지막 원소 처리
		str.append("]");
		return str.toString();//스트링 버퍼를 스트링 형으로 변환해 리턴
	}

}
