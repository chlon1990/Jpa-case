package com.example.demo;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.config.SpringContextConfig;
import com.example.demo.service.impl.BaiduExcelParseServiceImpl;
import com.example.demo.service.impl.ExcelParseServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScopeTests {

	@Autowired
	private SpringContextConfig app;
	
	@Autowired
	ExcelParseServiceImpl excelParseService; 
	
//	@Test
//	public void test(){
//
//		BaiduExcelParseService bean1 = app.getApplicationContext().getBean(ExcelParseServiceImpl.class).getBaiduExcelParseService();
//		BaiduExcelParseService bean2 = app.getApplicationContext().getBean(ExcelParseServiceImpl.class).getBaiduExcelParseService();
//
//		BaiduExcelParseService bean3 = app.getApplicationContext().getBean(BaiduExcelParseService.class);
//		BaiduExcelParseService bean4 = app.getApplicationContext().getBean(BaiduExcelParseService.class);
//		System.out.println("---" + bean1);
//		System.out.println("---" + bean2);
//		System.out.println();
//		System.out.println("---" + bean3);
//		System.out.println("---" + bean4);
//	}
	
	@Test
	public void test1() throws Exception{
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		threadPool.submit(() ->{System.out.println(excelParseService.getBaiduExcelParseService().toString());});
		threadPool.submit(() ->{System.out.println(excelParseService.getBaiduExcelParseService().toString());});
		threadPool.submit(() ->{System.out.println(excelParseService.getBaiduExcelParseService().toString());});
		threadPool.submit(() ->{System.out.println(excelParseService.getBaiduExcelParseService().toString());});
		threadPool.submit(() ->{System.out.println(excelParseService.getBaiduExcelParseService().toString());});
		Thread.sleep(5000);
		System.out.println(Arrays.toString(app.getApplicationContext().getBeanNamesForType(BaiduExcelParseServiceImpl.class)));
		System.out.println(app.getApplicationContext().getBeansOfType((BaiduExcelParseServiceImpl.class)).size());
		
		
		
	}

}
