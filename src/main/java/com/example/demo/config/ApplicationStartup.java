//package com.example.demo.config;
//
//import java.text.SimpleDateFormat;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//
//public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
//	private static final Logger logger = Logger.getLogger(ApplicationStartup.class);
//
//	@Autowired
//	SpringContextConfig springContextConfig;
//
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//
//		if (event.getApplicationContext().getParent() == null) {// root application context 没有parent
//			ApplicationContext applicationContext = SpringContextConfig.getApplicationContext();
//			MappingJackson2HttpMessageConverter bean = applicationContext
//					.getBean(MappingJackson2HttpMessageConverter.class);
//			bean.getObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//		}
//
//	}
//
//}