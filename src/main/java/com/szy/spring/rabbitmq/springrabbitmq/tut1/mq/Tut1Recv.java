package com.szy.spring.rabbitmq.springrabbitmq.tut1.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author sunzhengyu
 * @create 2019/8/21
 * @since 1.0.0
 */
@RabbitListener(queues = "hello")
public class Tut1Recv {

    @RabbitHandler
    public void recv(String in) {
        System.out.println(" [x] Received '" + in + "'");
    }
}