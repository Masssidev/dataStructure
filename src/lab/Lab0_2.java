package lab;

import java.util.Scanner;

public class Lab0_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_2:마재희");

		Scanner sc = new Scanner(System.in);
		System.out.println("10개의 정수를 입력하세요.");

		int[] arr = new int[10];//크기가 10인 정수 배열 생성
		int sum = 0;//모든 입력값을 더해서 대입할 변수선언
		double avr = 0;//평균을 구하기 위한 변수 선언

		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}//사용자로 부터 10개의 입력을 받아 배열에 저장하면서 합을 구함

		avr = (double) sum / 10;//10개의 입력 값의 평균을 구함

		System.out.println("평균 = " + avr);
		System.out.print("평균 이상인 값 = ");

		for (int i = 0; i < 10; ++i) {
			if (arr[i] >= avr) {
				System.out.print(arr[i] + " ");
			}
		}//평균 이상인 값만 출력
		sc.close();
	}
}
