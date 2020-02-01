
package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*

학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.

생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.

이 Student객체들은 List에 저장하여 관리한다.

List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과 총점의 역순으로 정렬하는 부분을 프로그램 하시오.

(총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)

(학번 정렬기준은 Student클래스 자체에서 제공하도록 하고, 총점 정렬기준은 외부클래스에서 제공하도록 한다.)

 */


public class HW02_StudentListSort {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("1","aa", 50, 80, 30));
		list.add(new Student("2","bb", 40, 20, 80));
		list.add(new Student("3","cc", 40, 70, 90));
		list.add(new Student("5","nn", 10, 30, 60));
		
		
		//총점을 기준으로 등수를 세팅해준다. 총점을 기준으로 하는 정렬은 Com을 사용하면 되므로 먼저 외부클래스 기준 정렬을 실행한다
		Collections.sort(list, new Com());
		
		System.out.println("외부 정렬 : ");
		for(int i = 0; i < list.size(); i++) {
			list.get(i).setRank(i+1); //여기서 등수를 정해준다
			System.out.println(list.get(i));
		}
		System.out.println("--------------------------------");
	
		
		Collections.sort(list);
		
		System.out.println("그냥 정렬 : ");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("--------------------------------");
		
		
	}

}

class Com implements Comparator<Student>{
	
	@Override
	public int compare(Student stu1, Student stu2) {
		int value = new Integer(stu1.getSum()).compareTo(stu2.getSum());
		if(value == 0) {
			return stu1.getStuNo().compareTo(stu2.getStuNo())*-1;
		}
		else
		return value;
	}
}


class Student implements Comparable<Student>{
	
	private String stuNo;
	private String name;
	private int korean;
	private int english;
	private int math;
	private int sum;
	private int rank;
	
	public Student(String stuNo, String name, int korean, int english, int math) {
		super();
		this.stuNo = stuNo;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.sum = korean+english+math;
	}
	
	@Override
	public String toString() {
		return "학번:"+stuNo+
				", 이름:"+name+
				", 국어점수:"+korean+
				", 영어점수:"+english+
				", 수학점수:"+math+
				", 총점:"+sum+
				", 등수:"+rank
				;
	}

	@Override
	public int compareTo(Student stu) {
		return getStuNo().compareTo(stu.getStuNo()); //오름차순
	}
	

	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
}

