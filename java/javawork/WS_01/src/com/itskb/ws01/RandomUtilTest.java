package com.itskb.ws01;

public class RandomUtilTest {

	public static void main(String[] args) {
		RandomUtil ru = new RandomUtil();
		int from = 20;
		int to = 60;
//		for (int i = 0; i < 100; i++) {
//			System.out.printf( "%4d", ru.getRandomInt1(from, to) );
//		}
		for (int i = 0; i < 100; i++) {
			System.out.printf( "%4d", ru.getRandomInt2(from, to) );
		}
		
	}

}
