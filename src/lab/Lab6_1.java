package lab;
//파일명: MyLinkedListTest.java
//작성자: 마재희
//작성일: 2017년 9월 22일
//내용: MyLinkedList 객체를 생성하고 삽입, 출력 기능을 테스트하는 프로그램

public class Lab6_1 {
	public static void main(String[] args) {
		System.out.println("lab6_1: 마재희\n");

		// 비어있는 리스트를 생성하고 출력
		MyLinkedList list = new MyLinkedList();
		list.printList();

		// 리스트의 앞부분에 세개의 값을 삽입하고 출력
		list.addFirst(111);
		list.printList();
		list.addFirst(222);
		list.printList();
		list.addFirst(333);
		list.printList();

		// 리스트의 길이를 출력
		System.out.println(list.size());
	}
}

/*
 * 파일명: MyLinkedList.java 작성자: 홍길동 작성일: 2017년 9월 21일 내용: 연결자료구조로 선형리스트를 구현한
 * MyLinkedList 클래스
 */
class MyLinkedList {
	// (1) 인스턴스 변수 head 선언: 연결리스트의 첫번째 노드를 가리킬 변수 선언
	private Node head;

	// (2) 리스트 길이(원소 수)를 나타내는 인스턴수 변수 선언
	private int count;

	// (3) 비어있는 리스트를 생성(인스턴스 변수를 null과 0으로 초기화)
	public MyLinkedList() {
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
