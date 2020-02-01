package kr.or.ddit.basic;

/*
	wait()메서드 : 동기화 영역에서 락을 풀고 wait-set영역(공유객체별 존재)으로 이동시킨다.
	notify() 또는 nofityAll() 메서드 : wait-set영역에 있는 쓰레드를 깨워서 실행될 수 있도록 한다.
		notify()는 하나, notifyAll()은 wait-set에 있는 전부를 깨운다.
	
	wait(), notify(), notifyAll()은 동기화 영역에서만 실행할 수 있고, Object클래스에서 제공하는 메서드이다.
 */


// wait과 notify를 이용한 두 쓰레드가 번갈아가면서 한번씩 실행하는 예제
public class T19_WaitNotifyTest {
	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		Thread1 th1 = new Thread1(workObj);
		Thread2 th2 = new Thread2(workObj);
		
		th1.start();
		th2.start();
	}
}


// 공동으로 사용할 객체
class WorkObject{
	public synchronized void method1() {
		System.out.println("method1 작업중...");
		
		notify();
		
		try {
			wait();
		}catch(InterruptedException e) {e.printStackTrace();}
	}
	
	public synchronized void method2() {
		System.out.println("method2 작업중...");

		notify();
		
		try {
			wait();
		}catch(InterruptedException e) {e.printStackTrace();}
	}
}


// WorkObject의 method1만 호출하는 쓰레드
class Thread1 extends Thread{
	private WorkObject workObj;
	
	public Thread1(WorkObject workobj) {
		this.workObj = workobj;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <=10; i++) {
			workObj.method1();
		}
		System.out.println("Thread1 종료");
	}
}


//WorkObject의 method2만 호출하는 쓰레드
class Thread2 extends Thread{
	private WorkObject workObj;
	
	public Thread2(WorkObject workobj) {
		this.workObj = workobj;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <=10; i++) {
			workObj.method2();
		}
		System.out.println("Thread2 종료");
	}
}






