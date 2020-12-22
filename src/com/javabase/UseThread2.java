package com.javabase;

public class UseThread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		Thread t1 = new Thread(new UseThread2(),"线程1");
		t1.start();
		System.out.println(t1.getName());
		UseThread2 t2 = new UseThread2();
		t2.run();
	}

}
