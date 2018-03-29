/*
 * 파일명: Hw7_1.java
 * 작성자: 마재희
 * 작성일: 2017년 10월 20일
 * 내용: 스택 활용을 이해한다.
 */
package lab;

import java.util.Scanner;
import java.util.Stack;

public class Hw7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw7_1: 마재희\n");

		Stack<Character> stack = new Stack<>();// 스택생성

		Scanner scan = new Scanner(System.in);
		System.out.print("괄호식 입력: ");

		String exp = scan.nextLine();//입력한 한줄을 읽어서 변수에 저장

		boolean b = test(stack, exp);//수식을 검사

		if (b == true)
			System.out.println("올바른 괄호식입니다.");
		else
			System.out.println("올바르지 않은 괄호식입니다.");

	}

	static boolean test(Stack<Character> stack, String exp) {
		int i = 0;//인덱스를 위한 변수선언
		char popChar;//삭제한값을 저장할 변수선언
		char c;//한문자를 저장할 변수선언

		do {//입력한 한줄을 한문자씩 읽어서 검사한다
			c = exp.charAt(i);//한문자씩 저장
			i++;

			switch (c) {
			case '('://여는 괄호들을 만날시
			case '{':
			case '[':
			case '<':
				stack.push(c);//푸쉬
				break;
			case ')'://닫는 괄호들을 만날시
			case '}':
			case ']':
			case '>':
				if (stack.isEmpty())//스택이 비어있으면 올바르지 않음
					return false;
				else {//비어있지 않으면
					popChar = stack.pop();//제일 이의 값을 팝하여
					if ((c == ')') && (popChar != '(') || (c == ']') && (popChar != '[')
							|| (c == '}') && (popChar != '{') || (c == '>') && (popChar != '<')) {//짝이 안맞으면
						return false;//올바르지 않음
					} else {//짝이 맞을경우
						break;//그대로 진행
					}
				}
			}
		} while (i < exp.length());//문자열의 길이만큼 반복
		if (stack.isEmpty())//다 검사한후 스택이 비어있으면
			return true;//올바름
		else//비어있지 않으면
			return false;//올바르지 않음
	}
}
