package lab;

import java.util.Scanner;

public class Lab0_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_4:마재희");

		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수를 입력하세요: ");

		int n1 = sc.nextInt();// 입력받은 첫 번째 정수 저장
		int n2 = sc.nextInt();// 입력받은 두 번째 정수 저장

		System.out.print("최댓값 = " + findMax(n1, n2));// 두 정수를 파라미터로 findMax 메소드를 호출하여 리턴값을 출력한다.

		sc.close();
	}

	private static int findMax(int n1, int n2) {
		return (n1 > n2) ? n1 : n2;
	}
}
