//***************************
// 파일명: Hw8_2.java
// 작성자: 마재희
// 작성일: 2017-11-16
// 설명:  연결자료구조를 이용한 큐 구현을 연습한다.
//***************************
package lab;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Hw8_2 {

	public static void main(String[] args) throws NoSuchElementException {
		// TODO Auto-generated method stub
		System.out.println("hw8_2: 마재희\n");

		MyLinkedQueue q = new MyLinkedQueue();// 큐생성

		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;
		int item = 0;
		do {
			System.out.print("1:삽입 2:삭제 3:전체삭제 4:종료 --->");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("삽입을 수행합니다.");
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();
				q.enQueue(item);// 큐에 삽입할 정수를 삽입
				break;
			case 2:
				System.out.println("삭제를 수행합니다.");
				System.out.println("삭제한 원소 = " + q.deQueue());// 큐에서 원소를 삭제해 출력
				break;
			case 3:
				System.out.println("전체삭제를 수행합니다.");
				if (q.isEmpty())
					throw new NoSuchElementException("삭제실패: 큐가 비어있습니다.");// 큐가
																			// 비어있으면
																			// 예외
																			// 발생
				while (!q.isEmpty()) {
					System.out.print("삭제한 원소 =" + q.deQueue() + " ");// 큐의 원소를
																		// 모두 삭제
				}
				System.out.println();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		} while (menu != 4);
	}

}

class MyLinkedQueue {
	private Node front;// 머리부분 변수 선언
	private Node rear;// 꼬리부분 변수 선언

	public MyLinkedQueue() {// 매개변수로 배열의 사이즈를 받아 사용하는 생성자
		super();
		this.front = null;
		this.rear = null;
	}

	public boolean isEmpty() {// 큐가 비어있는지 여부를 리턴
		if (front == null)
			return true;
		else
			return false;
	}

	public void enQueue(int item) {// 큐가 꽉차지 않았으면 원소를 꼬리에 삽입
		Node newNode = new Node(item);

		if (isEmpty()) {
			rear = newNode;
			front = newNode;
		} else {
			rear.link = newNode;
			rear = newNode;
		}
	}

	public int deQueue() throws NoSuchElementException {// 큐가 비어있지 않으면 머리의 원소를
														// 삭제하고 리턴

		int removeValue = 0;

		if (isEmpty()) {
			throw new NoSuchElementException("삭제실패: 큐가 비어있습니다.");
		} else {
			removeValue = front.data;
			front = front.link;
			if (front == null)
				rear = null;
			return removeValue;
		}
	}

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
