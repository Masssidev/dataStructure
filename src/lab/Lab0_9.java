package lab;

public class Lab0_9 {

	public static void main(String[] args) {
		System.out.println("lab0_9: 마재희");

		// int형 배열 1 ~ 5 를 선언
		int[] array1 = { 22, 11, 33 };
		int[] array2 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] array3 = { 10, 40, 10, 50, 20 };
		int[] array4 = { -2 };
		int[] array5 = {};

		// 배열 1 ~ 5의 합을 출력
		System.out.println("합을 출력합니다.");
		System.out.println(sum(array1, 0, array1.length - 1)); // 66
		System.out.println(sum(array2, 0, array2.length - 1)); // 45
		System.out.println(sum(array3, 0, array3.length - 1)); // 130
		System.out.println(sum(array4, 0, array4.length - 1)); // -2
		System.out.println(sum(array5, 0, array5.length - 1)); // 0

		// 배열 1 ~ 5의 최소값을 출력
		System.out.println("최소값을 출력합니다.");
		System.out.println(min(array1, 0, array1.length - 1)); // 11
		System.out.println(min(array2, 0, array2.length - 1)); // 1
		System.out.println(min(array3, 0, array3.length - 1)); // 10
		System.out.println(min(array4, 0, array4.length - 1)); // -2
		System.out.println(min(array4, 0, array5.length - 1)); // 예외 발생하고 종료
	}

	// array[lb..ub] 의 합을 리턴하는 메소드
	public static int sum(int[] array, int lb, int ub) {
		if (lb > ub) { // 범위에 해당하는 원소 수가 0인 경우
			return 0;
		} else { // lb <= ub인 경우. 즉, 범위에 해당하는 원소 수가 1 이상인 경우
			return array[lb] + sum(array, lb + 1, ub);
		}
	}

	// array[lb..ub] 의 최소값을 리턴하는 메소드 - 단, 원소 수가 1 이상인 경우(lb <= ub)만 작동
	public static int min(int[] array, int lb, int ub) {
		int min = array[ub];
		// 범위에 해당하는 원소 수가 0인 경우 예외 발생
		if (lb > ub) {
			throw new IllegalArgumentException("lb:" + lb + " ub:" + ub);
		} else if (lb == ub) {
			return array[lb];
		} else
			min = (min(array, lb, ub-1) < min) ? min(array, lb, ub-1) : min;

		// 문제: 범위에 해당하는 원소 수가 1이면 그 원소가 최소값이고, 그 이상이면 재귀적으로 최소값을 구하여 리턴

		// ...

		return min;// 이 라인은 메소드 완성 후 지울 것
	}

}
