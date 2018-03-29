package lab;

import java.util.Scanner;

public class Lab0_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_6:마재희");

		Scanner sc = new Scanner(System.in);
		System.out.print("두 정수를 입력하세요: ");

		int n1 = sc.nextInt();// 입력받은 첫 번째 정수 저장
		int n2 = sc.nextInt();// 입력받은 두 번째 정수 저장
		
		MyPair myPair=new MyPair(n1, n2);//입력값을 매개변수로 주면서 MyPair객체생성
		
		System.out.println(myPair.toString());
		System.out.println("합: "+myPair.sum());
		System.out.println("평균: "+myPair.average());
		
		myPair.swap();
		System.out.println("swap 수행 후");
		
		System.out.println(myPair.toString());
		System.out.println("합: "+myPair.sum());
		System.out.println("평균: "+myPair.average());
		
		sc.close();
	}

}

class MyPair{
	private int x, y;//속성선언

	public MyPair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}//매개변수를 속성에 대입시키는 생성자선언
	
	public int sum(){
		return x+y;
	}//합을 리턴하는 메소드
	
	public double average(){
		return (double)(x+y)/2;
	}//평균을 리턴하는 메소드
	
	public void swap(){
		int temp=0;
		temp=x;
		x=y;
		y=temp;
	}//swap하는 메소드

	@Override
	public String toString() {
		return "MyPair [x=" + x + ", y=" + y + "]";
	}//toString 오버라이드
	
}