package lab;

public class Lab0_8 {

	public static void main(String[] args) {
		System.out.println("lab0_8 : 마재희");

		f(4); // 1 2 3 4
		System.out.println();

		g(4); // 4 3 2 1
		System.out.println();

		System.out.println(sum(4)); // 10
	}

	private static void f(int n) {
		if (n > 0) {
			f(n - 1);
			System.out.print(n + " ");
		}
	}

	// 양의 정수 n을 매개변수로 받아 n부터 1까지 출력
	private static void g(int n) {
		if (n > 0) {
			System.out.print(n + " ");
			g(n - 1);
		}

	}

	// 양의 정수 n을 매개변수로 받아 1부터 n까지 정수합을 리턴하는 재귀 메소드
	private static int sum(int n) {
		// ...
		int sum = 0;
		if (n > 0)
			sum=n+sum(n-1);
		return sum; // 이 라인은 메소드 완성 후 지울 것
	}

}
