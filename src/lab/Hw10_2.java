package lab;

import java.util.LinkedList;

/* 
 * 파일명: Hw10_2.java
 * 작성일: 2017.12.05
 * 작성자: 마재희
 * 설명: adjacency matrix로 구현한 그래프의 DFS, BFS를 이해한다
 */

import java.util.Scanner;

public class Hw10_2 {
	public static void main(String[] args) {
		System.out.println("hw10_2 : 마재희");

		// 정점 수 n 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("정점 수 입력: ");
		int n = scan.nextInt();

		// 정점 수가 n인 무방향 그래프를 생성
		MatrixGraph2 graph = new MatrixGraph2(n);

		System.out.println("\n메뉴 번호를 입력하세요.");
		int menu = 0;
		int item = 0;
		int v1 = 0;
		int v2 = 0;

		// 종료를 선택할 때까지 반복하여 메뉴를 제공하고 그에 맞는 그래프 연산을 수행
		do {
			System.out.print("\n1:간선삽입 2:인접정점출력 3:DFS 4:BFS 5:종료 --->");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.print("정점 v1 입력: ");
				v1 = scan.nextInt();
				System.out.print("정점 v2 입력: ");
				v2 = scan.nextInt();
				graph.addEdge(v1, v2);
				break;
			case 2:
				System.out.print("정점 입력:");
				v1 = scan.nextInt();
				graph.printAdjacentVertices(v1);
				break;
			case 3:
				System.out.println("깊이우선탐색 순서대로 정점을 출력합니다.");
				graph.depthFirstSearch();
				break;
			case 4:
				System.out.println("너비우선탐색 순서대로 정점을 출력합니다.");
				graph.breadthFirstSearch();
				break;
			case 5:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류 - 메뉴를 다시 선택하세요.");
			}
		} while (menu != 5);
	}
}

class MatrixGraph2 {

	private int max;
	private int[][] matrix;
	private boolean[] visited;
	private LinkedList<Integer> queue = new LinkedList<Integer>();

	public MatrixGraph2(int v) {
		super();
		this.max = v;
		this.matrix = new int[max][max];
		this.visited = new boolean[max];
	}

	public void addEdge(int v1, int v2) {
		if (v2 < 0 || v1 < 0 || v2 > max - 1 || v1 > max - 1)
			System.out.println("잘못된 정점 번호입니다.");
		else if (matrix[v1][v2] == 1 || matrix[v2][v1] == 1)
			System.out.println("이미 존재하는 간선입니다");
		else {
			matrix[v1][v2] = 1;
			matrix[v2][v1] = 1;
		}
	}

	public void breadthFirstSearch() {

		for (int i = 0; i < visited.length; ++i) {
			visited[i] = false;
		}

		for (int j = 0; j < visited.length; ++j) {
			if (visited[j] == false)
				bfs(j);
		}
	}

	public void bfs(int v) {


		visited[v] = true;
		System.out.println(v + " ");

		queue.addLast(v);

		while (!queue.isEmpty()) {
			int w = queue.removeFirst();
			for (int m = 0; m < matrix[w].length; ++m) {
				if (matrix[w][m] == 1) {
					if (visited[m] == false) {
						visited[m] = true;
						System.out.println(m);
						queue.addLast(m);
					}
				}
			} 
		}
	}

	public void depthFirstSearch() {

		for (int i = 0; i < visited.length; ++i) {
			visited[i] = false;
		}

		for (int j = 0; j < visited.length; ++j) {
			if (visited[j] == false)
				dfs(j);
		}
	}

	public void dfs(int v) {

		visited[v] = true;
		System.out.println(v + " ");

		for (int k = 0; k < matrix[v].length; ++k) {
			if (matrix[v][k] == 1) {
				if (visited[k] == false)
					dfs(k);
			}
		}
	}

	public void printAdjacentVertices(int v) {
		if (v < 0 || v > max - 1)
			System.out.println("잘못된 정점 번호입니다.");
		else {
			StringBuffer str = new StringBuffer(v + "에 인접한 정점 =");// 스트링버퍼생성

			for (int i = 0; i < max; i++) {
				if (matrix[v][i] == 1)
					str.append(i + " ");
			}
			System.out.println(str.toString());
		}
	}

}