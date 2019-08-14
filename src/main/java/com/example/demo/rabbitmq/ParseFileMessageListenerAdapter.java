package com.example.demo.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component("parseFileMessageListenerAdapter")
public class ParseFileMessageListenerAdapter extends MessageListenerAdapter {

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		   try {
	            String messageBody = new String(message.getBody());
	            
	            // 逻辑处理 todo ..
	            System.out.println("=======================Mq客户端接收到消息：" + messageBody +"  =====================");
	            //Thread.sleep(10000000);
	         int a = 1/0;
	            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
	        }catch (Exception e){
	            e.printStackTrace();
	            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
	        }
	}
	
}
