package com.program.console;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("beans.xml");
	}

}
