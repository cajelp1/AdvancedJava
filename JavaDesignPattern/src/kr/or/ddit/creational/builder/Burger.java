package kr.or.ddit.creational.builder;

abstract class Burger implements Item{

	@Override
	abstract public String name();

	@Override
	public Packing packing() {
		// TODO Auto-generated method stub
		return new Wrapper();
	}

	@Override
	abstract public float price();

}
