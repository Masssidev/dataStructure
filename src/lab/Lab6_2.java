package lab;
/*
 * 파일명: MyDoublyLinkedListTest.java
 * 작성자: 마재희
 * 작성일: 2017년 9월 29일
 * 내용: MyDoublyLinkedList 객체를 생성하고 삽입, 출력 기능을 테스트하는 프로그램
 */

import java.util.Scanner;

public class Lab6_2 {
	public static void main(String[] args) {

		System.out.println("lab6_2: 마재희\n");

		MyDoublyLinkedList list = new MyDoublyLinkedList();

		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;
		int item = 0;
		do {
			System.out.print("1:리스트출력 2:맨앞삽입 3:맨앞삭제 4:값삭제 8:양방향연결확인 9:종료 --->");
			menu = scan.nextInt();
			switch (menu) {
			// case 1:
			// System.out.println("리스트출력을 수행합니다.");
			// System.out.println(list.toString());
			// break;
			case 2:
				System.out.println("맨앞삽입을 수행합니다.");
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();
				list.addFirst(item);
				break;
				// case 3:
				// System.out.println("맨앞삭제를 수행합니다.");
				// System.out.println("삭제한 원소 = " + list.removeFirst());
				// break;
				// case 4:
				// System.out.println("값삭제를 수행합니다.");
				// System.out.print("삭제할 정수 입력:");
				// item = scan.nextInt();
				// list.remove(item);
				// break;
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

/*
 * 파일명: MyDoublyLinkedList.java 작성자: 홍길동 작성일: 2017년 9월 21일 내용: 이중연결자료구조로 선형리스트를
 * 구현한 MyDoublyLinkedList 클래스
 */

class MyDoublyLinkedList {

	private Node head; // 리스트의 첫번째 노드를 가리킬 변수
	private int count; // 리스트의 원소 수를 나타내는 변수

	public MyDoublyLinkedList() {
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
