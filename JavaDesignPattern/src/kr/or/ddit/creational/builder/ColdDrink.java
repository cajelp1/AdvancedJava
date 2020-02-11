package kr.or.ddit.creational.builder;

abstract class ColdDrink implements Item{

	@Override
	abstract public String name();

	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	abstract public float price();
	
}
