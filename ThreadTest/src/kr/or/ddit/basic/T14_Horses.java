package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T14_Horses {
	public static void main(String[] args) {
		
		int track = 50; //말들이 달릴 트랙의 길이
		
		List<Horses> list = new ArrayList<>(); //말들이 담길 배열
		
		list.add(new Horses("1번말", track));
		list.add(new Horses("2번말", track));
		list.add(new Horses("3번말", track));
		list.add(new Horses("4번말", track));
		list.add(new Horses("5번말", track));
		list.add(new Horses("6번말", track));
		list.add(new Horses("7번말", track));
		list.add(new Horses("8번말", track));
		list.add(new Horses("9번말", track));
		list.add(new Horses("0번말", track));
		
		//말들이 달리는걸 관리하고 프린트하는 스레드
		Thread hr = new Thread(new HorseRun(list));
		
		//스레드 모두 시작
		for(int i = 0; i<list.size(); i++) {
			list.get(i).start();
		}
		
		hr.start();
	}
}

class HorseRun implements Runnable{
	
	private List<Horses> list;
	
	public HorseRun(List<Horses> list) {
		this.list = list;
	}
	
	@Override
	public void run(){
		
		int rank = 1;
		
		//말이 달리는 동안 일정 시간을 두고 출력한다. 모든 말의 랭킹이 정해지면 while문을 벗어난다.
		while(rank<=list.size()) {
			
			for(int i = 0; i<list.size(); i++) {
				list.get(i).print();
				
				//말의 현재 위치가 골을 넘어섰다면 랭킹을 걸어준다. finish 표식이 되지 않은 말이어야 한다.
				if(!list.get(i).finish && list.get(i).now == list.get(i).place.length-1) {
					list.get(i).setRank(rank);
					rank++;
					list.get(i).finish = true;//finish 표식을 주어 이미 랭킹을 받은 말은 새로 랭킹을 주지 않는다.
				}
				
			}System.out.println();
			
			// 위치 프린트하는 시간 간격
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
		
		System.out.println("=================== 경기 끝 ===================");
		Collections.sort(list); //순위대로 정렬
		
		//다 끝나면 출력한다.
		for(int i = 0; i<list.size(); i++) {
			System.out.println((i+1)+"등 : "+list.get(i).gethorName());
		}
	}
}




class Horses extends Thread implements Comparable<Horses> {

	private String horName;
	private int rank;
	
	String[] place; 			//말이 달리는 트랙
	int now; 					//말의 현재 위치
	boolean finish = false;		//골인여부 (rank를 세팅할 때 필요함)
	
	public Horses(String name, int trackLength) {
		this.horName = name;
		this.rank = 1;
		place = new String[trackLength+1];
		
		//말이 얼마나 달린건지 트랙의 크기를 정하고 말의 위치를 초기화한다
		place[0]=" "; place[1]=">";
		for(int i = 2; i < place.length; i++) {
			place[i]="-";
		}
	}
	
	
	//다른 말과 랭킹을 비교하는 메소드
	@Override
	public int compareTo(Horses horse) {
		//Integer.compare(this.rank, horse.rank);
		return new Integer(rank).compareTo(horse.getRank());
	}
	
	//말이 달릴 때마다 위치가 바뀐다
	@Override
	public void run() {
		
		//달릴 때마다 now의 값 위치가 달라진다
		for (now = 1; now < place.length; ) {
			
			int dist = (int)(Math.random()*3)+1; //랜덤으로 1~3칸을 움직인다
			int now2 = now + dist;
			
			if(now2 >= place.length) {	//트랙 길이보다 긴 길이의 값이 나오면 말을 트랙 맨 끝에 위치시키고 break;
				now2 = place.length-1;

				place[now] = "-";
				place[now2] = ">";
				now = now2;
				
				break;
			}
			else {	//트랙의 길이보다 짧은 값이 나오면 말의 위치가 움직인다.
			
			place[now] = "-";
			place[now2] = ">";
			now = now2;
			}
			
		try {
			Thread.sleep(700); //sleep 시간이 print 메소드의 반이기에 실제로 말은 1~4칸까지 움직인다.
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
	public void print() {
		String nogada = "";
		for(int i = 0; i < place.length; i++) {
			nogada += place[i];
		}
		System.out.println(horName + nogada);
	}
	
	
	public String gethorName() {
		return horName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}