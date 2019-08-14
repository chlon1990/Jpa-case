package com.example.demo.multithread;

import java.util.concurrent.Callable;

public class CallableTest implements Callable<Integer> {
	
	private Integer i ;
	
	CallableTest(int i){
		this.i = i;
	}

	@Override
	public Integer call() throws Exception {
		Thread.sleep(3000);
		System.out.println(Thread.currentThread().getName() + " 处理完成 第 " + i + " 个任务 ！");
		return i;
	}

}
