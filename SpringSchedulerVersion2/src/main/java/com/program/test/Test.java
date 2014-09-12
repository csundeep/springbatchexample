package com.program.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new ClassPathXmlApplicationContext("beans.xml");

	}

}
