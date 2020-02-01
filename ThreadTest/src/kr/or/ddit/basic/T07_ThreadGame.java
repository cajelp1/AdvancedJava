package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
	컴퓨터와 가위바위보를 진행하는 프로그램을 작성하시오
	컴퓨터 가위바위보는 난수를 이용해서 구하고
	사용자 가위바위보는 showInputDialog() 메서드를 이용해 입력받는다.
	
	입력시간은 5초로 제한. 카운트다운 진행.
	5초 동안 입력이 없으면 진 것으로 처리.
	
	5초 안에 입력 완료되면 승패 출력
 */

public class T07_ThreadGame {
	
	public static boolean check = false;
	public static String user = "";
	
	public static void main(String[] args) {
		
		String com = "";
		
		Thread th1 = new GetInput();
		Thread th2 = new Count();
		
		th1.start();
		th2.start();
		
		try {th1.join(); th2.join();}
		catch(InterruptedException e) {e.printStackTrace();}
		
		int comIn = (int)Math.random()*3+1;
		if(comIn == 1) {com="가위";}
		else if(comIn == 2) {com="바위";}
		else {com="보";}
		
		System.out.println("컴퓨터 : "+com);
		System.out.println("유저 : "+user);
		
		if(com.equals(user)) {System.out.println("비겼습니다");}
		else if(com.equals("가위") && user.equals("보") ||
				com.equals("바위") && user.equals("가위") ||
				com.equals("보") && user.equals("바위")) 
		{System.out.println("컴퓨터가 이겼습니다");}
		else if(com.equals("가위") && user.equals("바위") ||
				com.equals("바위") && user.equals("보") ||
				com.equals("보") && user.equals("가위")) 
		{System.out.println("컴퓨터가 이겼습니다");}
	}
}


class GetInput extends Thread {
	
	@Override
	public void run() {
		String str = "";
		
		do {
		str = JOptionPane.showInputDialog("가위바위보 중 하나를 입력하세요(5초)");
		}while(!str.equals("가위")&&!str.equals("바위")&&!str.equals("보"));
		
		T07_ThreadGame.check = true;
		T07_ThreadGame.user = str;
	}
}

class Count extends Thread{
	
	@Override
	public void run() {
		for(int i = 5; i >0; i--) {
			
			if(T07_ThreadGame.check) {return;}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000); //1초동안 멈추기
			}catch(InterruptedException e) {e.printStackTrace();}
		}
		
		System.out.println("5초가 지났습니다. 유저가 졌습니다.");
		System.exit(0);
	}
}





