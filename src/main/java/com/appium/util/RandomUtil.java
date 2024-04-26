package com.appium.util;

import java.util.Random;

public class RandomUtil {
	public synchronized static long getRandomNumber(final int digCount) {
		return getRandomNumber(digCount, new Random());
	}

	private synchronized static Long getRandomNumber(final int digCount, Random rnd) {
		final char[] ch = new char[digCount];
		for (int i = 0; i < digCount; i++) {
			ch[i] = (char) ('0' + (i == 0 ? rnd.nextInt(9) + 1 : rnd.nextInt(10)));
		}
		return Long.parseLong(new String(ch));
	}
}
