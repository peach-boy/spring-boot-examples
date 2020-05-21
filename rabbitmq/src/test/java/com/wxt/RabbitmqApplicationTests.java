package com.wxt;

import com.rabbitmq.client.Channel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

	@Test
	public void contextLoads() {
		Channel channel=null;
		try {
			channel.confirmSelect();//将信道设置为confirm模式
			channel.basicPublish("exchange_name","routingKey",null,"msg".getBytes());
			if(!channel.waitForConfirms()){
				System.out.println("send msg failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}




	}

}
