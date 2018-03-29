//***************************
// 파일명: Lab0_7.java
// 작성자: 마재희
// 작성일: 2017-09-09
// 설명:  클래스 작성, 객체 생성과 사용을 연습한다.
//***************************
package lab;

import java.util.ArrayList;
import java.util.Scanner;

public class Hw5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw5_2:마재희");
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();//integer arraylist객체 생성
		
		list.add(20);// 리스트에 20삽입
		list.add(30);// 리스트에 30삽입
		list.add(20);// 리스트에 20삽입
		list.add(40);// 리스트에 40삽입
		list.add(-999);// 리스트에 -999삽입
		list.add(50);// 리스트에 50삽입
		list.add(90);// 리스트에 90삽입
		list.add(10);// 리스트에 10삽입
		
		System.out.println(list);//리스트출력
		
		System.out.println("리스트의 크기= " + list.size());
		
		System.out.println("조회할 인덱스 입력: ");
		int n = sc.nextInt();// 조회할 인덱스를 입력받아 변수에 저장
		System.out.println("인덱스 " + n + "의 원소= " + list.get(n));//해당인덱스의 원소를 출력
		
		System.out.println("777로 갱신할 인덱스 입력: ");
		int n2 = sc.nextInt();// 갱신할 인덱스를 입력받아 변수에 저장
		list.set(n2, 777);//해당인덱스의 원소를 777로 대치
		System.out.println(list);//리스트출력
		
		System.out.println("999를 삽입할 인덱스 입력: ");
		int n3 = sc.nextInt();// 삽입할 인덱스를 입력받아 변수에 저장
		list.add(n3, 999);//해당인덱스에 999를 삽입
		System.out.println(list);//리스트 출력
		
		System.out.println("삭제할 인덱스 입력: ");
		int n4 = sc.nextInt();// 삭제할 인덱스를 입력받아 변수에 저장
		int re = list.remove(n4);//해당인덱스의 원소를 받아 변수에 저장
		System.out.println("인덱스 " + n4 + "의 원소= " + re);//해당 원소를 출력
		System.out.println(list);//리스트 출력
		
		sc.close();
	}

}
