package com.example.demo.multithread;

import lombok.Data;

@Data
public class RunableTest implements Runnable {

	private Integer i;
	
	RunableTest(Integer i){
		this.i = i ;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " 处理完成 第 " + i + " 个任务 ！");
	}

}
