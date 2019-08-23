package com.szy.spring.rabbitmq.springrabbitmq.tut1.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author sunzhengyu
 * @create 2019/8/21
 * @since 1.0.0
 */
public class Tut1Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;


    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String msg = "hello world!";
        this.rabbitTemplate.convertAndSend(queue.getName(), msg);
        System.out.println(" [x] Sent '" + msg + "'");
    }
}