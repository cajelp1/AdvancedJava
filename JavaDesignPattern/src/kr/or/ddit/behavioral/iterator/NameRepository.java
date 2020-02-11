package kr.or.ddit.behavioral.iterator;

public class NameRepository implements Container {

	public String names[] = {"강현철", "이지형", "정보람", "이승재", "이예림"};
	
	@Override
	public Iterator getIterator() {
		return new NameIterator();
	}
	
	private class NameIterator implements Iterator {
		
		int index;
		
		@Override
		public boolean hasNext() {
			if(index < names.length) {
				return true;
			}
			return false;
		}
		
		@Override
		public Object next() {
			if(this.hasNext()) {
				return names[index++];
			}
			return null;
		}
		
	}
}
