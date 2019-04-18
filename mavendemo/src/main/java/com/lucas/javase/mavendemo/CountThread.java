package com.lucas.javase.mavendemo;

public class CountThread extends Thread{
	public static void count() throws InterruptedException{
		Thread t=new CountThread();
		t.start();
		t.join();
	}

	@Override
	public void run() {
		int count=2;
		for (int i = 0; i < count; i++) {
			System.out.println("count :"+(i+1));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
	}
	
	
}
