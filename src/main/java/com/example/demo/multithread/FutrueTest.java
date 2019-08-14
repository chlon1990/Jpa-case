package com.example.demo.multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//  随机性  227秒
//  顺序     203秒
//  先完成   先处理结果   耗时 50S

public class FutrueTest {
	public static void main(String[] args) throws Exception, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(10);

		Map<String, Future<Integer>> taskMap = new HashMap<>();
		
		
		long begin = System.currentTimeMillis();

		for (int i = 1; i <= 100; i++) {
			System.out.println("提交第  " + i + "  个任务！！");
			CallableTest task = new CallableTest(i);
			Future<Integer> future =  es.submit(task);
			taskMap.put(String.valueOf(i), future);
		}
		
		es.shutdown();
		while(!es.awaitTermination(1, TimeUnit.SECONDS)) {
			System.out.println("等待结束");
		}
		System.out.println("关闭连接池 !!");
		long end = System.currentTimeMillis();
		System.out.println("耗时 " + (end - begin) / 1000 + "秒！");
	}
	
	public static void sleep() throws Exception {
		Thread.sleep(2000);
	}
	
}
