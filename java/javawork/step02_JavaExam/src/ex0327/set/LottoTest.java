package ex0327.set;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class LottoTest extends TreeSet<Integer> {
	
	public LottoTest() {
		Random r = new Random();
		while(super.size() < 6) {
			int n = r.nextInt(45)+1;
			super.add(n);
		}
		System.out.println(this);
		
		Iterator<Integer> it =this.descendingIterator();
		
		while(it.hasNext()) System.out.println(it.next());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LottoTest();
	}

}
