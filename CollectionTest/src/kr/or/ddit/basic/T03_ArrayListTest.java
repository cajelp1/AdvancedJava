package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class T03_ArrayListTest {

	public static void main(String[] args) {
		
		// 문제: 5명의 사람 이름을 입력하여 ArrayList에 저장
		// 이 중 '김'씨 성의 이름을 출력하라
		// 입력은 Scanner를 이용해서 입력받는다...
		
		ArrayList<String> names = new ArrayList<>();
		
		names.add("이예림");
		names.add("Steven");
		names.add("홍길동");
		names.add("김철수");
		names.add("수영희");
		
		System.out.println("리스트에서 찾을 성씨를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		String type = sc.nextLine();
		
		for(int i = 0; i < names.size(); i++) {
			
//			if(names.get(i).substring(0, 1).equals(type)) { 
//				//이 경우에는... type... 문자열을 비교하기 때문에 equals 메소드를 쓰라구우ㅜ ㅠㅠㅠ
//				System.out.println(names.get(i));
//			}
			
//			if(names.get(i).contains(type)) {
//				System.out.println(names.get(i)); //이러면 type에 있는 내용을 가진 사람이 다 나오는디... 
//			}
			
//			if(names.get(i).indexOf(type.charAt(0))==0) {
//				System.out.println(names.get(i));
//			}
			
//			if(names.get(i).charAt(0) == type.charAt(0)) {
//				System.out.println(names.get(i));
//			}
			
			if(names.get(i).startsWith(type)) {
				System.out.println(names.get(i));
			}
		}
		
		
		//문제1 : 5명의 별명을 입력해서 ArrayList에 저장하고 별명의 길이가 제일 긴 별명을 출력.
		//		(단, 각 별명의 길이는 모두 달라야 함..)
		//문제2 : 문제1에서 별명의 길이가 같은 것을 여러개 입력했을 때도 처리되도록 하시오?
		
		ArrayList<String> nick = new ArrayList<>(5);
		
		System.out.println("별명 5개를 입력해주세요");
		for(int i = 0; i < 5; i ++) {
			nick.add(sc.nextLine()); //next(); 라는 메소드도 사용 가능. 띄어쓰기 하면 다른 개체로 인식함...
		}
		System.out.println();
		
//		nick.add("개구리");
//		nick.add("귀뚜라기");
//		nick.add("바보");
//		nick.add("경");
//		nick.add("하모니카맨");
		
		String longname = "";
		
		//문제1
		for(String a : nick) {
			if(a.length() > longname.length()){
				longname = a;
			}
		}System.out.println(longname);
		
		//문제2는
		for(String a : nick) {
			if(a.length() > longname.length()){
				longname = a;
			}
		}//이러면 제일 긴 애가 일단 담기고
		System.out.println("길이가 긴 별명은 : ");
		for(String a : nick) {
			if(a.length() == longname.length()) {
				System.out.println(a); 
				//아 그리고 longname도 이 중에서 어차피 출력되니까 마지막에 따로 출력할 필요 없구나..
			}
		}
		
		sc.close();
	}

}
