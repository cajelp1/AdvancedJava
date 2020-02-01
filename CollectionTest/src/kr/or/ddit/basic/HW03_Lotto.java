package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HW03_Lotto {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		do {
		System.out.println("=============================");
		System.out.println("Lotto 프로그램");
		System.out.println("-----------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("=============================");
		System.out.print("메뉴 선택 : ");
		
		int ans = Integer.parseInt(sc.nextLine());
		
		if(ans == 1) {buy();}
		else if(ans == 2) {break;}
		
		}while(true);
		
		System.out.println();
		System.out.println("감사합니다");
	}
	
	public static void buy() {
		System.out.println();
		System.out.println("Lotto 구입 시작");
		System.out.println();
		System.out.println("(1000원에 로또 하나입니다.)");
		System.out.print("금액 입력 : ");
		
		int money = Integer.parseInt(sc.nextLine());
		
		if(money < 1000) {System.out.println("입력하신 금액으로 로또를 구입하실 수 없습니다.");}
		else {
			System.out.println();
			System.out.println("행운의 로또번호는 아래와 같습니다");
			int lot = money/1000;
			
			for(int i = 1; i <= lot; i++) {
				Set<Integer> lotto = new HashSet<>();
				while(lotto.size()<6) {
					int tmp = (int)(Math.random()*45)+1;
					lotto.add(tmp);
				}
				System.out.println("로또번호"+(i)+" : "+lotto);
//				Iterator<Integer> it = lotto.iterator();
//				while(it.hasNext()) {
//					System.out.print(it.next()+" ");
//				}
			}System.out.println();
			
			if(money%1000>0) {
			System.out.println("받은 금액은 "+money+"원이고 거스름돈은 "+money%1000+"원입니다");}
			
			System.out.println();
		}
		
	}
}
