package com.javabase;

public class Singleton {
	//饿汉模式：类一旦加载就将单例初始化
	private static Singleton onlyone = new Singleton();
	private Singleton() {}
	public static Singleton getInstance() {
		return onlyone;
	}
}
