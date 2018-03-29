package lab;
//파일명: Hw6_1.java

//작성자: 마재희
//작성일: 2017년 10월 3일
//내용: 단순연결리스트 구현을 연습한다.

import java.util.Scanner;

public class Hw6_1 {
	public static void main(String[] args) {
		System.out.println("hw6_1: 마재희\n");

		// 비어있는 리스트를 생성하고 출력
		MyLinkedList2 list = new MyLinkedList2();
		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;// 메뉴선택 변수 선언
		int item = 0;// 값을 넣을 변수 선언
		int index = 0;// 인덱스를 정할 변수 선언
		int x = 0;// 지정값을 정할 변수 선언
		int y = 0;// 값을 넣을 변수 선언
		// 종료를 선택할 때까지 반복하여 메뉴를 제공하고 그에 맞는 작업을 수행
		do {
			System.out.print("1:리스트출력 2:맨앞삽입 3:맨앞삭제 4:검색 5:인덱스삽입 6:인덱스삭제 7:값삽입 8:값삭제 9:종료 --->");
			menu = scan.nextInt();
			switch (menu) {// 선택 메뉴에 따른 스위치문
			case 1:
				System.out.println("리스트출력을 수행합니다.");
				System.out.println(list); // 리스트를 출력한다
				break;
			case 2:
				System.out.println("맨앞삽입을 수행합니다.");
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();
				list.addFirst(item); // 리스트의 맨 앞에 값을 삽입
				break;
			case 3:
				System.out.println("맨앞삭제를 수행합니다.");
				System.out.println("삭제한 원소 = " + list.removeFirst()); // 리스트의 맨앞
																		// 값을
																		// 삭제한 뒤
																		// 그 값을
																		// 출력
				break;
			case 4:
				System.out.println("검색을 수행합니다.");
				System.out.print("검색할 정수 입력:");
				item = scan.nextInt();// 검색할 정수를 입력하여 변수에 저장
				if (list.contains(item)) // 해당 값이 리스트에 있는지를 검사하는 메소드 호출
					System.out.println("검색 성공");
				else
					System.out.println("검색 실패");
				break;
			case 5:
				System.out.println("인덱스삽입을 수행합니다.");
				System.out.print("인덱스 입력:");
				index = scan.nextInt();// 인덱스를 입력받아 변수에 저장
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();// 정수를 입력받아 변수에 저장
				list.add(index, item); // 리스트에 해당인덱스자리에 정수를 저장
				break;
			case 6:
				System.out.println("인덱스삭제를 수행합니다.");
				System.out.print("인덱스 입력:");
				index = scan.nextInt();// 인덱스를 입력받아 변수에 저장
				System.out.println("삭제한 원소 = " + list.remove(index)); // 해당 인덱스의
																		// 원소를
																		// 삭제한 뒤
																		// 그 값을
																		// 출력
				break;
			case 7:
				System.out.println("값삽입을 수행합니다.");
				System.out.print("위치값 입력:");
				x = scan.nextInt();// 위치값을 입력받아 변수에 저장
				System.out.print("삽입할 정수 입력:");
				y = scan.nextInt();// 삽입할 정수를 입력받아 변수에 저장
				list.nextToValue(x, y);// 리스트의 위치값 다음에 정수를 저장
				break;
			case 8:
				System.out.println("값삭제를 수행합니다.");
				System.out.print("삭제값 입력:");
				x = scan.nextInt();// 삭제할 값을 입력받아 변수에 저장
				list.removeValue(x);// 리스트의 입력받은 값을 삭제
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

class MyLinkedList2 {
	// (1) 인스턴스 변수 head 선언: 연결리스트의 첫번째 노드를 가리킬 변수 선언
	private Node head;

	// (2) 리스트 길이(원소 수)를 나타내는 인스턴수 변수 선언
	private int count;

	// (3) 비어있는 리스트를 생성(인스턴스 변수를 null과 0으로 초기화)
	public MyLinkedList2() {
		this.head = null;
		this.count = 0;
	}

	// (4) 리스트의 맨 앞에 item을 삽입
	public void addFirst(int item) {
		// data 필드가 item인 새로운 Node 객체를 생성(newNode)
		Node newNode = new Node(item);
		// head가 가리키는 연결리스트의 맨 앞에 newNode를 삽입
		newNode.link = head;
		head = newNode;
		count++;

	}

	// 리스트의 맨 앞 원소를 삭제하고 원소값을 리턴
	public int removeFirst() {
		int removeValue = 0;// 리턴할 원소값을 저장할 변수 선언
		if (head == null) {
			System.out.println("리스트가 비어있어 삭제할 수 없습니다. 프로그램을 종료합니다.");
			System.exit(0);
		} else {
			removeValue = head.data;// 맨앞원소를 변수에 저장
			head = head.link;// 맨앞 원소 삭제
			count--;
		}
		return removeValue;
	}

	// 정수값을 매개변수로 받아 검색결과를 리턴
	public boolean contains(int item) {
		Node temp = new Node();// 비어있는 노드생성
		temp = head;
		while (temp != null) {// 리스트의 원소 하나하나를 가리킴
			if (temp.data == item)// 원하는 결과일경우
				return true;
			temp = temp.link;// 다음원소를 가리킴
		}
		return false;// 원하는 결과가 없을경우
	}

	// 인덱스와 정수값을 매개변수로 리스트의 인덱스 위치에 정수값을 삽입
	public void add(int idx, int value) {
		if (idx > count) {
			System.out.println("허용되는 범위가 아닙니다. 시스템을 종료합니다.");
			System.exit(0);
		} else {
			Node temp = new Node();// 비어있는 노드생성
			temp = head;
			Node newNode = new Node(value);// 값을 넣기 위한 노드생성
			if (idx == 0) {// 맨앞삽입
				newNode.link = head;
				head = newNode;
			} else {// 해당인덱스만큼 비어있는 노드를 이동시킨다
				for (int i = 0; i < idx - 1; i++) {
					temp = temp.link;
				}
				newNode.link = temp.link;// 이동시킨만큼 그자리에 새로운 노드를 삽입
				temp.link = newNode;
			}
			count++;
		}

	}

	// 인덱스를 매개변수로 받아 리스트의 인덱스 위치 원소를 삭제하고 원소값을 리턴
	public int remove(int idx) {
		int removeValue = 0;// 리턴할 원소를 저장할 변수 선언
		if (idx >= count) {
			System.out.println("허용되는 범위가 아닙니다. 시스템을 종료합니다.");
			System.exit(0);
		} else {
			Node temp = new Node();// 비어있는 노드생성
			temp = head;
			if (idx == 0) {// 맨앞원소삭제
				removeValue = head.data;
				head = temp.link;
			} else {
				for (int i = 0; i < idx - 1; i++) {// 해당인덱스만큼 비어있는 노드를 이동시킨다
					temp = temp.link;
				}
				removeValue = temp.link.data;// 이동시킨자리에서 값을 삭제
				temp.link = temp.link.link;
			}
			count--;
		}
		return removeValue;// 삭제한 원소를 리턴
	}

	// 사용자로부터 x, y를 입력받아 리스트의 첫번째 x 뒤에 y를 삽입
	public void nextToValue(int value, int item) {
		Node temp = new Node();// 비어있는 노드생성
		Node newNode = new Node(item);// 원하는 값을 저장한 노드생성
		temp = head;
		while (temp != null) {// 리스트탐색
			if (temp.data == value) {// 위치값을찾았을경우 그 다음에 값을 삽입
				newNode.link = temp.link;
				temp.link = newNode;
				count++;
				break;
			}
			temp = temp.link;// 리스트 순차탐색
		}
	}

	// 사용자로부터 x를 입력받아 리스트의 첫번째 x를 삭제
	public void removeValue(int value) {
		Node temp = new Node();// 비어있는 노등생성
		temp = head;
		if (head == null)// 리스트가 비어있을 경우 메소드종료
			return;
		else if (head.link == null) {// 리스트에 하나만 있을 경우
			if (head.data == value) {// 하나가 원하는 값이면 삭제
				head = head.link;
				count--;
			}
		} else {// 리스트에 여러원소가 있을 경우
			while (temp.link != null) {
				if (head.data == value) {// 처음원소일경우 삭제
					head = head.link;
					count--;
					break;
				} else if (temp.link.data == value) {// 처음이 아닐경우 삭제
					temp.link = temp.link.link;
					count--;
					break;
				}
				temp = temp.link;// 리스트 순차탐색
			}
		}
	}

	// 리스트를 출력
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("[");// 스트링버퍼생성
		Node temp = new Node();//비어있는 노드생성
		temp = head;
		while (temp != null) {
			str.append(temp.data);//리스트의 값을 순차적으로 버퍼에 저장
			temp = temp.link;//다음 원소를 가리킴
			if (temp != null)//마지막이 아닐경우 
				str.append(", ");//문자 삽입
		}
		str.append("]");//마지막 문자삽입
		return str.toString();//스트링으로 리턴
	}

	// (5) 리스트의 길이를 리턴
	public int size() {
		return count;
	}

	// 리스트 원소들을 모두 출력
	public void printList() {
		Node temp = head;
		System.out.print("[");
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.link;
			if (temp != null)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	// 리스트에서 item이 저장된 노드를 탐색하는 private 메소드 -- lab6_1에서는 호출하지 않음
	private Node searchNode(int item) {
		Node temp = head;
		while (temp != null) {
			if (item == temp.data)
				return temp; // 탐색 성공시 해당 노드 리턴
			else
				temp = temp.link;
		}
		return temp; // 탐색 실패시 null 리턴
	}

	// 연결리스트 노드 구조를 표현하는 private 클래스
	private class Node {
		int data; // (6) 정수값을 저장할 데이터 필드 data 선언
		Node link; // (7) 다음 노드 참조값을 저장할 링크 필드 link 선언

		Node() {
			data = 0;
			link = null;
		}

		Node(int data) {
			this.data = data;
			this.link = null;
		}

		Node(int data, Node link) {
			this.data = data;
			this.link = link;
		}
	}
}
