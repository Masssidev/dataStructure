//***************************
 // 파일명: hw11_1.java
 // 작성자: 마재희
 // 작성일: 2017-12-08
 // 프로그램 설명:삽입 정렬 알고리즘을 이해하고, 객체의 정렬을 연습한다.
 //***************************
package lab;

import java.util.Arrays;
import java.util.Scanner;

public class Hw11_1 {
	
	private static void insertionSort (Student[] num){
		int i, j;
		Student item;
		for(i=1; i<num.length; ++i){
			item=num[i];

			for(j=i; (j>0) && (num[j-1].getAge()>item.getAge()); --j){
				num[j]=num[j-1];                      
			}
			num[j]=item;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw11_1:마재희");
		
		System.out.print("학생 수 입력: ");
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		Student[] num = new Student[count];
		
		System.out.println(count+"개 학생정보입력");
		for(int i=0; i<count; ++i){
			Student student = new Student();
			System.out.print("학번: ");
			student.setStudentNo(scan.nextInt());
			System.out.print("나이: ");
			student.setAge(scan.nextInt());
			num[i]=student;
		}
		
		System.out.println(Arrays.toString(num));
		
		insertionSort(num);
		
		System.out.println(Arrays.toString(num));
		scan.close();
	}

}

class Student{
	private int studentNo;
	private int age;
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "[studentNo=" + studentNo + ", age=" + age + "]";
	}
	
}
