package com.lucas.javase.mavendemo;

import org.junit.Test;

public class GreetingTest {

	@Test
	public void test() {
		new Greeting();
		Greeting.print("lucas");
		Greeting.main(null);
	}

}
