package com.itskb.ws01;

import java.util.Random;

public class RandomUtil {

	public int getRandomInt1(int from, int to) {
		// from : 20
		// to : 60
		// to - from + 1 : 41
		// Math.random() * (to - from + 1) : 0.xxx ~ 40.xxx
		// (int) Math.random() * (to - from + 1) : 0 ~ 40
		// (int) Math.random() * (to - from + 1) + from : 20 ~ 60
		
		return (int) (Math.random() * (to - from + 1)) + from;
	}
	
	public int getRandomInt2(int from, int to) {
		// from : 20
		// to : 60
		// to - from + 1 : 41
		// Random.nextInt(to - from + 1) : 0 ~ 40
		// Random.nextInt(to - from + 1) + from : 20 ~ 60
		Random random = new Random();
		return random.nextInt(to - from + 1) + from;
	}

}
