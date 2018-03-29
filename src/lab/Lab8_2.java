package lab;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
 * 파일명 : SynchronizedQueueTest.java
 * 작성일: 2017년 11월 03일
 * 작성자: 마재희
 * 내용: 하나의 원형 큐를 공유하는 생산자, 소비자 스레드를 실행하는 프로그램
 */

public class Lab8_2 {
	public static void main(String[] args) {
		System.out.println("lab8_2: 마재희");

		// 크기 5인 원형 큐를 생성
		SynchronizedQueue2 queue = new SynchronizedQueue2(5);

		// 원형 큐를 공유하는 생산자 스레드, 소비자 스레드를 실행
		Thread producer1 = new ProducerThread2(queue);		
		Thread consumer1 = new ConsumerThread2(queue);
		
		//모든 스레드 실행
		producer1.start();
		consumer1.start();
	}
}


class ProducerThread2 extends Thread {
	private SynchronizedQueue2 queue;//큐 인스턴스변수

	public ProducerThread2(SynchronizedQueue2 queue) {//생성자
		this.queue = queue;
	}

	@Override
	public void run() {//생성자 스레드 실행시 수행
		for(int i = 1; i <= 20; i++) {//1부터 20까지 반복한다
			System.out.println(currentThread().getName() + ": " + i + " 생산");//현재 스레드의 이름을 생산
			try {
				queue.enQueue(i);//큐에 정수를 삽입
				sleep((int) (Math.random() * 1000));//0~1초사이의 랜덤 수면
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class ConsumerThread2 extends Thread {
	private SynchronizedQueue2 queue;//큐 인스턴스 변수

	public ConsumerThread2(SynchronizedQueue2 queue) {//생성자
		this.queue = queue;
	}

	@Override
	public void run() {//소비자 스레드 실행시 수행
		int sum = 0;//합산 결과 변수선언
		try {
			sleep(3000);//3초간 수면
			for(int i = 0; i < 20; i++) {//0부터 19인덱스의 큐를 탐색
				int value = queue.deQueue();//큐에 값을 삭제후 변수에 대입	
				System.out.println("\t\t\t" + currentThread().getName() + ": " + value + " 소비");//현재 스레드의 이름과 소비 되는 값 출력
				sum += value;//소비되는 값을 계속 합산한다
				sleep((int) (Math.random() * 500));//0~0.5초사이의 랜덤수면
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("소비자가 계산한 정수 합 = " + sum);//합산 결과 출력
	}
}





/*
 * 파일명 : SynchronizedQueue.java
 * 작성일: 2017년 11월 3일
 * 작성자: 마재희
 * 내용: 배열로 구현한 동기화된 원형 큐
 */



class SynchronizedQueue2 {
	private final Lock lock = new ReentrantLock();// 락을 거는 변수선언
	private final Condition notFull  = lock.newCondition(); //락에서  꽉차지 않음 상태를 선언
	private final Condition notEmpty = lock.newCondition(); //락에서 비어있지 않음 상태를 선언
	private int[] array; //배열 선언
	private int capacity;//용량 변수 선언
	private int front = 0;//머리선언변수
	private int rear = 0;//꼬리선언변수
	private int count=0;
	
	public SynchronizedQueue2(int capacity) {//생성자
		this.capacity = capacity;
		array = new int[capacity];
	}
	
	public boolean isEmpty() {//비어있는지 여부를 리턴
		return count==0;
	}
	
	public boolean isFull() {//꽉찼는지 여부를 리턴
		return count==capacity;
	}

	public void enQueue(int item) throws InterruptedException {//삽입 메소드
		lock.lock();//락을 건다
		try {
			while (isFull()) {//꽉찼으면 안내문 출력
				System.out.println("enQueue : 큐가 가득차서 기다립니다.");
				notFull.await();	//소비될때까지 기다림		
			}
			rear = (rear + 1) % capacity;//원형큐의 꼬리부분에 생성
			array[rear] = item;
			count++;
			notEmpty.signal();//생성 후에는 비어있어서 기다리는 곳에 신호를 보내서 깨운다
			System.out.println(item+"저장");
		} finally {
			lock.unlock();//락을 푼다
		}
	}

	public int deQueue() throws InterruptedException {//삭제 메소드
		lock.lock();//락을건다
		try {
			while (isEmpty()) {//비어있으면 안내문 출력
				System.out.println("\t\tdeQueue : 큐가 비어서 기다립니다.");
				notEmpty.await();//생성될때까지 기다림
			}
			front = (front + 1) % capacity;//원형큐의 머리부분에 소비
			int item = array[front];
			count--;
			notFull.signal();//소비 후에는 꽉차서 기다리는 곳에 신호를 보내서 깨운다
			return item;//
		} finally {
			lock.unlock();//락을푼다
		}
	}
}

