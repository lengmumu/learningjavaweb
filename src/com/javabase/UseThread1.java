package com.javabase;

public class UseThread1 extends Thread{
	//以继承Thread类重写run()方法方式创建线程
	
	/*待掌握知识点：
	 * 1、线程的关闭
	 * 2、getState()线程有五种状态：NEW(未启动状态)、RUNNABLE(就绪状态)、WAITING(等待)、BLOCKED(阻塞)、TERMINATED(终止状态)
	 * 	
	 * 3、所谓“等待”，指的是使线程处于不再活动的状态，即是从调度队列中剔除
	 * 效果上还是在这种没有进展的进进出出中等待，这种情形类似于所谓的忙等待 （busy waiting）。
	 * */
	
	//调用父类的构造方法
	UseThread1(String name){
		super(name);
	}
	UseThread1(){
		super();
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(this.getName()+"--"+i);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		UseThread1 t1 = new UseThread1("线程1");
		if(String.valueOf(t1.getState()) == "NEW") System.out.println("尚未启动");
		UseThread1 t2 = new UseThread1();
		t1.start();
		if(String.valueOf(t1.getState()) == "RUNNABLE") System.out.println("正在运行");
		t2.start();
		t1.yield();
		if(t1.getState() == Thread.State.WAITING) System.out.println("就绪状态");
		
		//当前线程激活数
		int num = Thread.activeCount();
		
	}
}
