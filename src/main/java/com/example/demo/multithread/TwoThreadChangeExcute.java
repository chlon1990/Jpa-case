package com.example.demo.multithread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TwoThreadChangeExcute {

	static int i = 0;

	static Object obj = new Object();

	public static void main(String[] args) throws Exception {
		test2();
	}
	
	public static void test2() throws Exception {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

		ExecutorService es = Executors.newSingleThreadExecutor();

		for (Integer integer : list) {
			es.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(integer);
				}
			});
		}
		es.shutdown();
		while(!es.awaitTermination(1, TimeUnit.SECONDS)) {
			System.out.println("等待结束");
		}

	}
	
	public static void test1() {

		final List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (obj) {
					while (i < list.size()) {
						if (i % 2 != 0) {
							try {
								obj.notifyAll();
								obj.wait();
								continue;
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						Integer integer = list.get(i);
						System.out.println(Thread.currentThread().getName() + "  " + integer);
						i++;
					}
					obj.notifyAll();
				}
			}
		}, "thread1");

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (obj) {
					while (i < list.size()) {
						if (i % 2 == 0) {
							try {
								obj.notifyAll();
								obj.wait();
								continue;
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						Integer integer = list.get(i);
						System.out.println(Thread.currentThread().getName() + "  " + integer);
						i++;
					}
					obj.notifyAll();
				}
			}
		}, "thread2");
		thread1.start();
		thread2.start();

	
	}

}