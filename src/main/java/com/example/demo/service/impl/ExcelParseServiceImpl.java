package com.example.demo.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.service.BaiduExcelParseService;

@Component
public class ExcelParseServiceImpl {
	@Autowired
	@Qualifier("parseService")
	private BaiduExcelParseService baiduExcelParseService;

	public BaiduExcelParseService getBaiduExcelParseService() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baiduExcelParseService;
	}

	public void setBaiduExcelParseService(BaiduExcelParseService baiduExcelParseService) {
		this.baiduExcelParseService = baiduExcelParseService;
	}
}

