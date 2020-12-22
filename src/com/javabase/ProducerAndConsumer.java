package com.javabase;

public class ProducerAndConsumer {
	
	public static void main(String[] args) {
		SyncStack stack = new SyncStack();
		new Thread(new Producer(stack),"生产者线程").start();
		new Thread(new Consumer(stack),"消费者线程").start();
	}
}

class SyncStack{
	int baozi = 0;
	int themost = 10;
	public synchronized void produceBaozi() {
		try {
			if(baozi>=themost){
				this.wait();
				System.out.println("【生产者】：生产量已冲顶 ；【现仓储量】为"+baozi);
			}else {
				this.notify();
				baozi++;
				System.out.println("【生产者】：产生了一个产品 ；【现仓储量】为"+baozi);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void consumeBaozi() {
		try {
			if(baozi==0) {
				this.wait();
				System.out.println("【消费者】：糟糕，没有产品了 ；【现仓储量】为"+baozi);
			}else {
				this.notify();
				baozi--;
				System.out.println("【消费者】：消耗了一个产品 ；【现仓储量】为"+baozi);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Producer implements Runnable{
	SyncStack stack;
	public Producer(SyncStack stack) {
		this.stack = stack;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			stack.produceBaozi();
			try {
				Thread.sleep((int)Math.random()*5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
class Consumer implements Runnable{
	SyncStack stack;
	public Consumer(SyncStack stack) {
		this.stack = stack;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			stack.consumeBaozi();
			try {
				Thread.sleep((int)Math.random()*5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}