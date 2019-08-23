package com.szy.spring.rabbitmq.springrabbitmq.tut2.config;

import com.szy.spring.rabbitmq.springrabbitmq.tut2.mq.Tut2Receiver;
import com.szy.spring.rabbitmq.springrabbitmq.tut2.mq.Tut2Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author sunzhengyu
 * @create 2019/8/22
 * @since 1.0.0
 */
@Profile({"tut2", "work-queues"})
@Configuration
public class Tu2Config {

    @Bean
    public Queue queue() {
        return new Queue("hello");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean
        public Tut2Receiver receiver1() {
            return new Tut2Receiver(1);
        }

        @Bean
        public Tut2Receiver receiver2() {
            return new Tut2Receiver(2);
        }
    }

    @Profile("sender")
    @Bean
    public Tut2Sender sender() {
        return new Tut2Sender();
    }
}