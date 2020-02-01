package kr.or.ddit.basic;

/*
	문제) 태양계 행성을 나타내는 enum Planet을 이용하여 구하시오.
	(단, enum 객체 생성시 반지름을 이용하도록 정의하시오.) 
	
	예) 행성의 반지름(KM):
	수성(2439), 금성(6052), 지구(6371), 화성(3390), 
	목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622)

 */

public class HW05_EnumPlanet {
	
	public static void main(String[] args) {
		
//		planet pl = planet.토성;
//		
//		System.out.println(pl.radius);
		
		planet[] enumArr = planet.values();
		for(int i = 0; i < enumArr.length; i ++) {
			System.out.println(
					enumArr[i].name() + 
					"의 면적 : \t" + 
					String.format("%, 16.0f", 
							enumArr[i].area(enumArr[i].getRadius())
					)+" km²");
		}	
		
		//https://micropai.tistory.com/48
	}
	
	public enum planet {
		
		수성(2439), 금성(6052), 지구(6371), 화성(3390), 목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);
		
		private int radius;
		
		planet(int radius){ 
		//아항.. 여기에 int가 들어가는건 위에 있는 행성이름(반지름)을 정의하는거구나.. planet(int radius)
			this.radius = radius;
		}
		
		public int getRadius(){
			return radius;
		}
		
		public double area(int radius) {
			return 4*Math.PI*radius*radius;
		}
	}
}
