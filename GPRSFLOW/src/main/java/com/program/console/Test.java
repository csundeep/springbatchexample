package com.program.console;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("beans.xml");
	}

}
