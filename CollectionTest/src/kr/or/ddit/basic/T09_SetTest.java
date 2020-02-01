package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*

	- List 와 Set의 차이점
	
	1. List
	  - 입력한 데이터의 순서가 있다.
	  - 중복되는 데이터를 저장할 수 있다.
	  
	2. Set
	  - 입력한 데이터의 순서가 없다
	  - 중복되는 데이터를 저장할 수 없다.

 */


public class T09_SetTest {
	public static void main(String[] args) {
		
		Set hs1 = new HashSet<>();
		
		// Set에 데이터를 추가할 때도 add 메소드를 사용
		
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set 데이터 : "+hs1);
		System.out.println();
		
		// Set은 데이터의 순서가 없고, 중복을 허용하지 않는다.
		// 그래서 이미 있는 데이터를 add하면 false를 반환하고, 데이터는 추가되지 않는다.
		
		boolean isAdd = hs1.add("FF");
		System.out.println("중복되지 않을 때 : "+isAdd);
		System.out.println("Set 데이터 : "+hs1);
		System.out.println();
		
		isAdd = hs1.add("CC");
		System.out.println("중복될 때 : "+isAdd);
		System.out.println("Set 데이터 : "+hs1);
		System.out.println();
		
		// Set의 데이터를 수정하려면 수정하는 명령이 따로 없기 때문에 해당자료를 삭제한 후 새로운 자료를 추가해야 한다.
		
		// 삭제하는 메소드
		// 1) clear() : Set 데이터 전체 삭제
		// 2) remove(삭제할자료) : 해당자료 삭제
		// 예) "FF"를 "EE"로 수정하기
		
		hs1.remove("FF");
		System.out.println("삭제한 후 Set 데이터 : "+hs1);
		System.out.println();
		
		hs1.add("EE");
		System.out.println("수정한 후 Set 데이터 : "+hs1);
		System.out.println();
		
		hs1.clear(); //전체자료 삭제
		System.out.println("Clear후 Set 데이터 : "+hs1);
		
		// Set은 데이터의 순서가 없기 때문에 List처럼 인덱스로 데이터를 하나씩 불러올 수 없다
		// 그래서 데이터를 하나씩 얻기 위해 Iterator로 변환해야 함
		// Set의 데이터를 Iterator로 변환하기 -> Set의 iterator() 메서드를 호출
		
		Iterator it = hs1.iterator();
		
		// 데이터 개수만큼 반복하기
		// hasNext() 메서드 : 포인터 다음위치에 데이터가 있으면 true, 없으면 false 반환
		
		while(it.hasNext()) { //다음 자료가 있는지 검사
			// next() 메서드 : 포인터를 다음 자료위치로 이동하고, 이동한 위치의 자료를 반환함.
			System.out.println(it.next());
		}
		
		
		// 1~100 사이의 중복되지 않는 점수 5개 만들기
		Set<Integer> intRnd = new HashSet<>();
		
		while(intRnd.size() < 5) { 
			// 5개까지 넣어줌... 잉 그런데 이러면 4개만 들어가는거 아녀?? 뭐여! 얘도 0부터 시작하는 순서 있음?!
			// 뀨.. 순서라기보다는 capacity라고 해야하나... size는 capacity랑 다른데...
			int num = (int)(Math.random()*100)+1; //1~100 사이의 난수
			intRnd.add(num);
		}
		System.out.println("만들어진 난수들 : "+intRnd);
		
		
		// Collection 유형의 객체들은 서로 다른 자료 구조로 쉽게 변경해서 사용할 수 있다. 
		// 다른 종류의 객체를 생성할 때 생성자에 변경할 데이터를 넣어주면 된다... 뭐야 그럼 그냥 생성할 때만?
		// 												      난 이미 있는거에 넣고싶다!
		
		List<Integer> intRndList = new ArrayList<Integer>(intRnd);
		//난 intRnd의 길이보다 capacity가 10 더 큰 리스트를 만들어서 거기다 넣고싶은데!!!!! 왜 그 생성자는 없냐!?
		
		List<Integer> inttt = new ArrayList<>(intRnd.size()+10); //오 이건 되네
		//inttt = (List<Integer>) intRnd; 
		//java.lang.ClassCastException: java.util.HashSet cannot be cast to java.util.List
		
		
		System.out.println("리스트 자료 출력 : ");
		
		for(int i = 0 ; i < intRndList.size(); i ++) {
			System.out.println(intRndList.get(i));
		}
		
		for(Integer num : intRndList) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		
		// Set을 배열에 넣으려면?
		
		// Integer 오토언박싱 해주라주라1!!! String으로 어떻게 바꾸지
		
		//String[] arst2 = intRnd.toArray(new String[0]);
		//java.lang.ArrayStoreException: java.lang.Integer ㅜㅜ
		
		// Object로 하면 쉽긴 한데....
		Object[] arst = intRnd.toArray();
		
		for(Object a : arst) {
			System.out.println(a.toString());
		}
		
	}
}
