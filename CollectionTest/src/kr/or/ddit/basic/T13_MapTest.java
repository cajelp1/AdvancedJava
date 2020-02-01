package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*

	Map -> key 값과 value값을 한 쌍으로 관리하는 객체
			Key 값은 중복을 허용하지 않고 순서가 없다. (Set의 특징)
			value 값은 중복을 허용한다.

 */

public class T13_MapTest {
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		
		
		//자료추가 : push(key, value)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map : "+map);
		
		
		//자료수정 : 데이터를 저장할 때 key 값이 같으면 나중에 입력한 값이 저장된다.
		//			put(key, value)
		map.put("addr", "서울");
		System.out.println("map : "+map);
		
		
		//자료삭제 : remove(key)
		map.remove("name");
		System.out.println("map : "+map);
		
		
		//자료읽기 : get(key)
		System.out.println("addr : "+map.get("addr"));
		System.out.println("=====================================");
		
		
		// key 값들을 읽어와 자료를 출력하는 방법
		
		// 방법1 : keySet() 메서드 이용하기
		// keySet() 메서드 : Map의 key를 읽어와서 set 형으로 변환
		
		Set<String> keyset = map.keySet();
		
		System.out.println("Iterator를 이용한 방법");
		
		Iterator<String> it = keyset.iterator();
		
		while(it.hasNext()) {
			String Key = it.next();
			System.out.println(Key + " : "+ map.get(Key));
		}
		System.out.println("-------------------------------------");
		
		// 방법2 : Set 형의 데이터를 '향상된 for문'으로 처리하면 Iterator를 사용하지 않아도 됨
		System.out.println("향상된 for문을 이용하는 방법");
		for(String key : keyset) {
			System.out.println(key+" : "+ map.get(key));
		}
		System.out.println("-------------------------------------");
		
		// 방법3 : value 값만 읽어와 출력한다. value() 메서드 이용
		System.out.println("value() 메서드를 이용하는 방법");
		for(String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("-------------------------------------");
		
		
		// 방법4 : Map에는 Entry 라는 내부 class가 만들어져 있다. 
		//			이 Entry 클래스는 key와 value 라는 멤버변수로 구성되어 있다.
		//			Map에서 이 Entry 클래스들은 Set 형식으로 저장하여 관리한다.
		
		// Entry 객체 전체를 가져오기 (가져온 Entry 들은 Set 형식으로 되어있다)
		// => entrySet() 메서드를 이용해서 가져온다
		
		Set<Map.Entry<String, String>> mapset = map.entrySet();
		
		// 가져온 Entry 객체들을 순서대로 처리하기 위해서 Iterator 객체로 변환
		Iterator<Map.Entry<String, String>> entryIt = mapset.iterator();
		
		while(entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();
			
			System.out.println("key값 : "+entry.getKey());
			System.out.println("value값 : "+entry.getValue());
			System.out.println();
			
		}
	}
}
