package com.example.demo.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.example.demo.service.BaiduExcelParseService;

@Service("parseService")
//@Service()	
@Scope(value="prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BaiduExcelParseServiceImpl implements BaiduExcelParseService {

}
