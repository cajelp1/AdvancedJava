package kr.or.ddit.creational.simplefactory;

public class FactoryPatternDemo {
	public static void main(String[] args) {
		
		ShapeFactory sf = new ShapeFactory();
		
		Shape sp1 = sf.getShape("Circle");
		sp1.draw();
		
		Shape sp2 = sf.getShape("rectaNGLE");
		sp2.draw();
		
		Shape sp3 = sf.getShape("SQUARE");
		sp3.draw();
		
	}
}
