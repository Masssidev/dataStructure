package lab;

import java.util.Scanner;

public class Lab0_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_3:마재희");

		Scanner sc = new Scanner(System.in);
		System.out.println("정수 갯수를 입력하세요: ");

		int n = sc.nextInt();// 정수 갯수를 입력받아 변수에 저장
		int[] arr = new int[n];// 입력 크기 만큼의 배열을 만듦

		System.out.println(n + "개의 정수를 입력하세요: ");

		int max = 0;//최대값을 저장할 변수 선언

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		} // 사용자로 부터 지정한 갯수만큼의 입력을 받아 배열에 저장

		max = arr[0];// 순차 검색을 위한 초기값 설정

		for (int i = 0; i < n; i++) {
			if (arr[i] > max)
				max = arr[i];
		} // 배열을 순차검색하며 최대값을 찾음

		System.out.println("최댓값: " + max);

		sc.close();
	}

}
