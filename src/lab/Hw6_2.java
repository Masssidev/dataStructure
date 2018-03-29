//***************************
 // 파일명: Hw6_2.java
 // 작성자: 마재희
 // 작성일: 2017-09-24
 // 설명:  자바 API의 LinkedList를 연습한다.
 //***************************
package lab;

import java.util.LinkedList;
import java.util.Scanner;

public class Hw6_2 {

	public static void main(String[] args) {
		System.out.println("hw6_2: 마재희\n");
		// (1) 정수형을 저장할 LinkedList 객체생성하여 변수 list에 지정(raw type 사용 금지)
		LinkedList<Integer> list = new LinkedList<>();

		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;//메뉴선택 변수 선언
		int item = 0;//값을 넣을 변수 선언
		int index = 0;//인덱스를 정할 변수 선언

		// 종료를 선택할 때까지 반복하여 메뉴를 제공하고 그에 맞는 작업을 수행
		do {
			System.out.print("1:리스트출력 2:맨앞삽입 3:맨앞삭제 4:검색 5:인덱스삽입 6:인덱스삭제 9:종료 --->");
			menu = scan.nextInt();
			switch(menu) {//선택 메뉴에 따른 스위치문
			case 1:
				System.out.println("리스트출력을 수행합니다.");
				System.out.println(list);		//리스트를 출력한다
				break;
			case 2:
				System.out.println("맨앞삽입을 수행합니다.");
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();
				list.addFirst(item);		//리스트의 맨 앞에 값을 삽입
				break;
			case 3:
				System.out.println("맨앞삭제를 수행합니다.");
				System.out.println("삭제한 원소 = " + list.removeFirst());	//리스트의 맨 앞 값을 삭제한 뒤 그 값을 출력
				break;
			case 4:
				System.out.println("검색을 수행합니다.");
				System.out.print("검색할 정수 입력:");
				item = scan.nextInt();//검색할 정수를 입력하여 변수에 저장
				if(list.contains(item))			//해당 값이 리스트에 있는지를 검사하는 메소드 호출
					System.out.println("검색 성공");
				else
					System.out.println("검색 실패");
				break;
			case 5:
				System.out.println("인덱스삽입을 수행합니다.");
				System.out.print("인덱스 입력:");
				index = scan.nextInt();//인덱스를 입력받아 변수에 저장
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();//정수를 입력받아 변수에 저장
				list.add(index, item);	//리스트에 해당인덱스자리에 정수를 저장
				break;
			case 6:
				System.out.println("인덱스삭제를 수행합니다.");
				System.out.print("인덱스 입력:");
				index = scan.nextInt();//인덱스를 입력받아 변수에 저장
				System.out.println("삭제한 원소 = " + list.remove(index));	//해당 인덱스의 원소를 삭제한 뒤 그 값을 출력
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		} while(menu != 9);
	}
}


