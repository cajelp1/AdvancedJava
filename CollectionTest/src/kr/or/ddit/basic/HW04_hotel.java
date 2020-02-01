package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HW04_hotel {
	
	private Scanner sc;
	private Map<Integer, String> room;
	
	public HW04_hotel() {
		sc = new Scanner(System.in);
		room = new HashMap<>();
	}
	
	
	public static void main(String[] args) {
		
		System.out.println();
		System.out.println("************************");
		System.out.println("          호텔 문을 열었습니다.");
		System.out.println("************************");
		
		new HW04_hotel().work(); 
		//아이고오... 이렇게 만들 때만 생성자를 통해 스캐너가 생성되는구만....
	}
	
	private void work() {
		
		int menu;
		
		do {
		System.out.println();
		System.out.println("**************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인.  2.체크아웃.  3.객실상태.  4.업무종료");
		System.out.println("**************************************");
		System.out.print("메뉴선택 : ");
		
		menu = sc.nextInt();
		
		//예외처리?
//		while(true) {
//			try {menu = sc.nextInt();}
//			catch(Exception e) {menu = 0; break;}
//		}
		//아뉘 예외가 생기면 이걸 무한반복하쟈녀.........
		
			switch(menu){
				case 1 : checkin();
					break;
				case 2 : checkout();
					break;
				case 3 : roomstate();
					break;
				case 4 : 
					System.out.println();
					System.out.println("************************");
					System.out.println("          호텔 문을 닫았습니다.");
					System.out.println("************************");
					return;
				default :
					System.out.println("잘못 입력했습니다. 다시입력하세요.");
			}
		}while(true);
	}

	private void roomstate() {
		//몰라 순서 안지킬꼬야ㅏ아ㅏ
		Set<Integer> key = room.keySet();
		
		//투숙객이 하나도 없을 경우
		if(key.size() == 0) {
			System.out.println("투숙객이 없습니다"); return;
		}
		
		//투숙객이 있을 경우 key값을 이용해서 프린트아웃
		System.out.println();
		for(Integer Key : key) {
			System.out.println("방번호 : "+Key+"\t 투숙객 : "+room.get(Key));
		}
	}


	private void checkout() {
		
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 : ");
		int roomno = sc.nextInt();
		
		Set<Integer> key = room.keySet();
		
		//해시맵에 값이 하나도 없을 경우
		if(key.size() == 0) {
			System.out.println("해당 방에는 투숙객이 없습니다"); return;
		}
		
		//room 해시맵에 해당하는 방번호가 있을 경우 체크아웃 진행
		for(Integer Key : key) {
			if(Key == roomno) {
				room.remove(roomno);
				System.out.println("체크아웃 되었습니다.");
				return;
			}
		}
		
		//room 해시맵에 해당하는 방번호가 없을 경우 
		System.out.println("해당 방에는 투숙객이 없습니다");
	}

	private void checkin() {
		
		System.out.println();
		System.out.println("어느 방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 : ");
		int roomno = sc.nextInt();
		
		Set<Integer> key = room.keySet();
		
		//입력한 방 번호 값이 이미 있는 경우
		for(Integer Key : key) {
			if(Key == roomno) {System.out.println("해당 방에 이미 투숙객이 있습니다."); return;}
		}
		
		//입력한 방 번호 값이 없을 경우 체크인 진행
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		//room 해시맵에 추가
		room.put(roomno, name);
		System.out.println("체크인 되었습니다");
	}
	
}
