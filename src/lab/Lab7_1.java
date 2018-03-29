package lab;

import java.util.Scanner;

public class Lab7_1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("lab7_1: 마재희\n");

		MyArrayStack stack = new MyArrayStack();//스택생성

		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;
		int item = 0;
		do {
			System.out.print("1:삽입 2:삭제 3:조회 4:전체삭제 5:종료 --->");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("삽입을 수행합니다.");
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();
				stack.push(item);//스택에 삽입할 정수를 삽입
				break;
			case 2:
				System.out.println("삭제를 수행합니다.");
				System.out.println("삭제한 원소 = " + stack.pop());//스택에서 원소를 삭제해 출력
				break;
			case 3:
				System.out.println("조회를 수행합니다.");
				System.out.println("조회한 원소 = " + stack.peek());//스택에서 맨위의 값을 조회
				break;
			case 4:
				System.out.println("전체삭제를 수행합니다.");
				while(!stack.isEmpty()){
					System.out.print("삭제한 원소 =" + stack.pop() + " ");//스택의 원소를 모두 삭제
				}
				System.out.println();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		} while (menu != 9);
	}

}

class MyArrayStack {
	private int[] stack = new int[10];//정수값을 저장할 배열
	private int top = -1;//맨위를 가리키는 변수선언

	public boolean isFull() {//스택이 꽉 찼는지 여부를 리턴
		return (top == 9);
	}

	public boolean isEmpty() {//스택이 비어있는지 여부를 리턴
		return (top == -1);
	}

	public void push(int item) throws Exception {//스택이 꽉차지 않았으면 원소를 맨위에 삽입
		if (isFull()) {
			throw new Exception("push 실패:스택이 꽉 찼음");
		} else {
			stack[++top] = item;
		}
	}

	public int pop() throws Exception {//스택이 비어있지 않으면 맨위의 원소를 삭제하고 리턴
		int popValue = 0;
		if (isEmpty()) {
			throw new Exception("pop 실패:스택이 비어있음");
		} else {
			popValue = stack[top--];
		}
		return popValue;
	}

	public int peek() throws Exception {//스택이 비어있지 않으면 맨위의 원소를 리턴
		int peekValue = 0;
		if (isEmpty()) {
			throw new Exception("peek 실패:스택이 비어있음");
		} else {
			peekValue = stack[top];
		}
		return peekValue;
	}

}