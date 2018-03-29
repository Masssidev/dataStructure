//파일명: Hw6_3.java
//작성자: 마재희
//작성일: 2017년 10월 5일
//내용: 이중연결리스트 구현을 연습한다.
package lab;

import java.util.Scanner;

public class Hw6_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw6_3: 마재희\n");

		MyDoublyLinkedList2 list = new MyDoublyLinkedList2();

		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;
		int item = 0;
		do {
			System.out.print("1:리스트출력 2:맨앞삽입 3:맨앞삭제 4:값삭제 8:양방향연결확인 9:종료 --->");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("리스트출력을 수행합니다.");
				System.out.println(list.toString());// 리스트출력
				break;
			case 2:
				System.out.println("맨앞삽입을 수행합니다.");
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();// 삽입할 정수를 입력받아 변수에 저장
				list.addFirst(item);// 리스트의 맨 앞에 정수를 삽입
				break;
			case 3:
				System.out.println("맨앞삭제를 수행합니다.");
				System.out.println("삭제한 원소 = " + list.removeFirst());// 리스트의 맨앞
																		// 원소를
																		// 삭제후
																		// 출력
				break;
			case 4:
				System.out.println("값삭제를 수행합니다.");
				System.out.print("삭제할 정수 입력:");
				item = scan.nextInt();// 삭제할 정수를 입력받아 변수에 저장
				list.remove(item);// 리스트에서 해당 값을 삭제
				break;
			case 8:
				System.out.println("양방향 연결을 확인합니다.");
				list.printLink();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		} while (menu != 9);
	}

}

class MyDoublyLinkedList2 {

	private Node head; // 리스트의 첫번째 노드를 가리킬 변수
	private int count; // 리스트의 원소 수를 나타내는 변수

	public MyDoublyLinkedList2() {
		head = null;
		count = 0;
	}

	// 리스트 길이를 리턴
	public int size() {
		return count;
	}

	// 리스트의 맨 앞에 item을 삽입
	public void addFirst(int item) {

		// (1) 데이터가 item인 새로운 노드 생성
		Node newNode = new Node(item);

		// (2) 새로운 노드를 리스트의 맨 앞에 삽입

		newNode.rlink = head;
		if (head != null)

			newNode.rlink.llink = newNode;
		head = newNode;

		// (3) 원소 수 1 증가
		count++;

	}

	// 리스트 맨앞 원소를 삭제하고 리턴
	public int removeFirst() {
		int removeValue = 0;// 리턴할 삭제값을 저장할 변수선언
		if (head == null) {// 공백리스트일경우
			System.out.println("공백리스트임. 시스템을 종료.");
			System.exit(0);
		} else {// 공백리스트가 아닐경우
			removeValue = head.data;// 맨앞원소를 변수에저장
			if (head.rlink == null) {// 리스트에 원소가 하나일경우
				head = head.rlink;
				count--;
			} else {// 리스트에 원소가 여러개일경우
				head.rlink.llink = head.llink;
				head = head.rlink;
				count--;
			}
		}
		return removeValue;// 삭제값을 리턴
	}

	// 리스트에서 원하는 값을 삭제
	public void remove(int item) {
		if (head == null)// 공백리스트일경우 메소드종료
			return;
		else if (head.rlink == null) {// 리스트에 원소가 하나일경우
			if (head.data == item) {// 해당값이 맞으면 삭제
				head = head.rlink;
				count--;
			}
		} else {// 리스트에 원소가 여러개일경우
			Node temp = new Node();// 비어있는 노드생성
			temp = head;
			if (head.data == item) {// 해당값이 맨앞에있는경우 삭제
				head.rlink.llink = head.llink;
				head = head.rlink;
				count--;
			} else {// 맨앞에 있지 않은 경우 삭제
				while (temp.rlink.rlink != null) {// 리스트 순차검색
					if (temp.rlink.data == item) {// 해당값을 찾으면 삭제
						temp.rlink.rlink.llink = temp;
						temp.rlink = temp.rlink.rlink;
						count--;
						break;
					}
					temp = temp.rlink;
				}

				if (temp.rlink.rlink == null) {
					if (temp.rlink.data == item) {// 맨뒤에 값이 해당값이면 삭제
						temp.rlink = temp.rlink.rlink;
						count--;
					}
				}
			}
		}
	}

	// 리스트가 양방향연결이 제대로 이루어졌는지 확인
	public void printLink() {
		if (head == null) {
			System.out.println("공백리스트임");
		} else {
			// 리스트를 순방향으로 출력
			Node temp = head;
			System.out.print("리스트 길이=" + count + " 순방향 링크: ");
			while (temp.rlink != null) {
				System.out.print(temp.data + "->");
				temp = temp.rlink;
			}
			System.out.print(temp.data);

			// 리스트를 역방향으로 출력
			System.out.print(" 역방향 링크: ");
			while (temp.llink != null) {
				System.out.print(temp.data + "->");
				temp = temp.llink;
			}
			System.out.println(temp.data);
		}
	}

	// 리스트를 출력
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("[");// 스트링버퍼생성
		Node temp = new Node();// 비어있는 노드생성
		temp = head;
		while (temp != null) {
			str.append(temp.data);// 리스트의 값을 순차적으로 버퍼에 저장
			temp = temp.rlink;// 다음 원소를 가리킴
			if (temp != null)// 마지막이 아닐경우
				str.append(", ");// 문자 삽입
		}
		str.append("]");// 마지막 문자삽입
		return str.toString();// 스트링으로 리턴
	}

	// 이중연결리스트 노드 구조
	private class Node {
		int data;
		Node llink;
		Node rlink;

		Node() {
			this(0, null, null);
		}

		Node(int data) {
			this(data, null, null);
		}

		Node(int data, Node llink, Node rlink) {
			this.data = data;
			this.llink = llink;
			this.rlink = rlink;
		}
	}
}