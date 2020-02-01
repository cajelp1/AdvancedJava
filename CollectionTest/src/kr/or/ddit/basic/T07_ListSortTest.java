package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T07_ListSortTest {
	public static void main(String[] args) {
		
		List<Member> memList = new ArrayList<>();
		
		memList.add(new Member(1,"홍길동", "010-1111-1111"));
		memList.add(new Member(5,"변학도", "010-2222-2222"));
		memList.add(new Member(9,"성춘향", "010-3333-3333"));
		memList.add(new Member(4,"이순신", "010-4444-4444"));
		memList.add(new Member(3,"김기철", "010-555-5555"));
		memList.add(new Member(2,"가나다", "010-666-6666"));
		
		System.out.println("정렬 전 : ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------");
		
		
		//정렬하기
		Collections.sort(memList);
		
		System.out.println("이름 오른차순 정렬 후 : ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------");
		
		
		//외부정렬기준을 이용한 정렬하기
		Collections.sort(memList, new SortNumDesc());
		
		System.out.println("번호 내림차순 정렬 후 : ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------");
		
		
	}
}
/*
	정렬 기준의 외부 선언을 위해서는 Comparator 인터페이스를 구현하면 된다.
	Member의 번호(num)의 내림차순으로 정렬하기
	
 */
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
//		if(mem1.getNum() > (mem2.getNum())) {
//			return -1;
//		}
//		else if(mem1.getNum() == mem2.getNum()) {
//			return 0;
//		}
//		else return 1;
		
		
		// Wrapper 클래스에서 제공하는 메서드를 이용하는 방법 1
		// 내림차순일 경우에는 -1을 곱해준다.
//		return Integer.compare(mem1.getNum(), mem2.getNum())*-1;
		
		// Wrapper 클래스에서 제공하는 메서드를 이용하는 방법 2
		return new Integer(mem1.getNum()).compareTo(mem2.getNum())*-1;
		
		// 왜 바로 쓸 수는 없지? Integer을 int 타입으로 형변환하면 되어야 하는거 아닌가?
		// int는 시스템에 있는 타입이라 comparable을 implement하지 않아서?
//		return mem1.getNum().compareTo(mem2.getNum());
	}
	
}



class Member implements Comparable<Member>{
	private int num; //번호
	private String name; //이름
	private String tel; //전화번호
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "Member [num=" + num+", name="+name+", tel="+tel+"]";
	}
	
	//이름을 기준으로 오름차순 정렬이 되도록 설정한다
	@Override
	public int compareTo(Member mem) {
		return getName().compareTo(mem.getName());
	}
	
}

