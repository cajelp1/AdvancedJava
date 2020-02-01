package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
	문제) Set을 이용하여 숫자야구 게임 프로그램을 작성하라
		컴퓨터 숫자는 난수를 이용하여 구현
		스트라이크는 S, 볼은 B로 출력

 */

public class T11_BaseBallTest {
	
	public static void main(String[] args) {
		
		Set<Integer> hs = new HashSet<>();
		
		while(hs.size() < 4) {
			int tmp = (int)(Math.random()*9)+1; //1~9까지의 수 랜덤으로 만듦
			hs.add(tmp);
		}
		
		List<Integer> ans = new ArrayList<>(hs);
		Collections.shuffle(ans); //숫자섞기
		
		System.out.println(ans);
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		do { System.out.println("1~9까지 네자리 숫자를 입력해주세요");
			
			int write = Integer.parseInt(sc.nextLine());
			
			count++;
			
			int strike = 0;
			int ball = 0;
			
			int a = write%10; //네번째 숫자
			write /= 10;
			int b = write%10; //세번째 숫자
			write /= 10;
			int c = write%10; //두번째 숫자
			write /= 10;
			int d = write%10; //첫번째 숫자
			
			if(a == ans.get(3)) {strike++;}
			if(b == ans.get(2)) {strike++;}
			if(c == ans.get(1)) {strike++;}
			if(d == ans.get(0)) {strike++;}
			
			if(a == ans.get(2) || a == ans.get(1) || a == ans.get(0)) {ball++;}
			if(b == ans.get(3) || b == ans.get(1) || b == ans.get(0)) {ball++;}
			if(c == ans.get(3) || c == ans.get(2) || c == ans.get(0)) {ball++;}
			if(d == ans.get(3) || d == ans.get(2) || d == ans.get(1)) {ball++;}
			
			if(strike == 4) {break;}
			
			System.out.println(strike+"S "+ball+"B");
			
		}while(true);
		
		System.out.println("축하합니다! "+count+"회 만에 맞추셨습니다!");
		
		sc.close();
	}
}
