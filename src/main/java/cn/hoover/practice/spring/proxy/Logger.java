package cn.hoover.practice.spring.proxy;

import java.util.Date;

public class Logger {

	public static void start() {
		System.out.println(new Date() + " say hello start...");
	}

	public static void end() {
		System.out.println(new Date() + " say hello end");
	}
}
