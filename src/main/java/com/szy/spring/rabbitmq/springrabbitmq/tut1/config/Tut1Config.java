package com.szy.spring.rabbitmq.springrabbitmq.tut1.config;

import com.szy.spring.rabbitmq.springrabbitmq.tut1.mq.Tut1Recv;
import com.szy.spring.rabbitmq.springrabbitmq.tut1.mq.Tut1Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author sunzhengyu
 * @create 2019/8/21
 * @since 1.0.0
 */
@Profile({"tut1", "hello-world"})
@Configuration
public class Tut1Config {

    @Bean
    public Queue queue() {
        return new Queue("hello");
    }

    @Profile("sender")
    @Bean
    public Tut1Sender sender() {
        return new Tut1Sender();
    }

    @Profile("receiver")
    @Bean
    public Tut1Recv receiver() {
        return new Tut1Recv();
    }

}