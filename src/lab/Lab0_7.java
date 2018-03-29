//***************************
 // 파일명: Lab0_7.java
 // 작성자: 마재희
 // 작성일: 2017-09-09
 // 설명:  클래스 작성, 객체 생성과 사용을 연습한다.
 //***************************

package lab;

public class Lab0_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("lab0_7:마재희");
		MyList list = new MyList();//리스트 객체 생성

		list.print();//리스트출력

		list.add(2);//리스트에 2삽입
		list.print();//리스트출력

		list.add(3);//리스트에 3삽입
		list.print();//리스트출력

		list.add(2);//리스트에 2삽입
		list.print();//리스트출력
		
	}

}

class MyList {
	private int[] arr;//정수형 배열 선언
	private int count;//저장된 갯수 변수 선언

	public MyList() {
		super();
		this.arr = new int[10];//배열을 초기화
		this.count = 0;//갯수 초기화
	}

	public void add(int x) {
		try {
			arr[count] = x;
			count++;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("배열크기를 벗어났습니다.");
		}//인덱스의 범위를 벗어나면 에러메세지 출력
	}//정수를 매개변수로 받아 배열에 순서대로 삽입

	public void print() {
		System.out.print("[");

		for (int i = 0; i < arr.length; i++) {
			if (i < count) {
				System.out.print(arr[i]);
				if (i < count - 1)
					System.out.print(", ");
			}
		}//출력화면에 맞게 출력
		System.out.println("]");
	}//출력메소드

}