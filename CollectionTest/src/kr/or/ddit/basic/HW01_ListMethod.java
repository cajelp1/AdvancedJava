package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class HW01_ListMethod {

	public static void main(String[] args) {
		
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		
		
		//add
		list1.add("a");
		list1.add("b");
		list1.add("cc");
		list2.add("aa");
		list2.add("bb");
		list2.add("cc");
		
		
		//addAll
		list1.addAll(0,list2);
		
		
		//get, indexOf, lastIndexOf
		System.out.println(list1);
		System.out.println(list1.get(0));
		System.out.println(list1.indexOf("cc"));
		System.out.println(list1.lastIndexOf("cc"));
		
		
		//iterator
		List A = (List)list1; //뭐여 안 써도 되쟈너
		ListIterator li = list1.listIterator();
		
		while(li.hasNext()) {
			System.out.print(li.next()+",");
		}//이거 어디다 쓰지????
		System.out.println();
		System.out.print("li2 = > ");
		ListIterator li2 = list1.listIterator(2);
		while(li2.hasNext()) {
			System.out.print(li2.next()+",");
		}
		System.out.println();
		
		
		//remove, set
		list1.remove(5);
		System.out.println(list1);
		list1.set(3, "set");
		System.out.println(list1);
		
		
		//subList
		List list3 = list1.subList(1, 5); //엥 list1에는 index5가 없는데?
		System.out.println(list3);
		
		
		//sort는 어떻게 해야할지 모르겠음... comparator.....
		list1.sort(new C());
		System.out.println(list1);
		
		
	}

}


class C implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2) * -1;
	}
}

