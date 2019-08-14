//package com.example.demo.config;
//
//import java.text.SimpleDateFormat;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.socket.server.standard.ServerEndpointExporter;
//
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Configuration  
//public class HttpConvertConfig {  
//	
//    @Bean  
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {  
//    	MappingJackson2HttpMessageConverter convert = new MappingJackson2HttpMessageConverter();
//    	
//    	ObjectMapper objectMapper = new ObjectMapper();
//    	objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		objectMapper.setSerializationInclusion(Include.NON_NULL);
//		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//		convert.setObjectMapper(objectMapper);
//        return convert;
//    }  

//   也可以参考  HttpMessageConvertersAutoConfiguration 及 JacksonAutoConfiguration JacksonProperties 、

// 即在 spring 配置中添加配置： spring.jackson.dateFormat=yyyy-MM-dd HH:mm:ss
//  
//} 
