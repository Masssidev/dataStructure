//***************************
 // 파일명: lab11_1.java
 // 작성자: 마재희
 // 작성일: 2017-12-08
 // 프로그램 설명:버블 정렬 알고리즘을 이해한다.
 //***************************
package lab;

import java.util.Arrays;
import java.util.Scanner;

public class Lab11_1 {
	
	private static void bubbleSort(int[] num){
		for(int i=num.length-1; i>0; --i){
			for(int j=0; j<i; ++j){
				if(num[j]>num[j+1]){
					int temp = num[j];
					num[j]=num[j+1];
					num[j+1]=temp;
				}
					
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab11_1:마재희\n");
		
		System.out.println("정수 갯수 입력: ");
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		int[] num = new int[count];
		
		System.out.println(count+"개 정수 갯수 입력: ");
		for(int i=0; i<count; ++i){
			num[i]=scan.nextInt();
		}
		
		System.out.println(Arrays.toString(num));
		
		bubbleSort(num);
		
		System.out.println(Arrays.toString(num));
		scan.close();
	}

}
