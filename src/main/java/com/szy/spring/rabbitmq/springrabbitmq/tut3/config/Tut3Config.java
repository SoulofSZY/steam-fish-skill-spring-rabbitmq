package com.szy.spring.rabbitmq.springrabbitmq.tut3.config;

import com.szy.spring.rabbitmq.springrabbitmq.tut3.mq.Tut3Receiver;
import com.szy.spring.rabbitmq.springrabbitmq.tut3.mq.Tut3Sender;
import org.springframework.amqp.core.*;
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
@Profile({"tut3", "pub-sub", "publish-subscribe"})
@Configuration
public class Tut3Config {

    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("tut.fanout");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean
        public Queue autoDeleteQueue1(){
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue2(){
            return new AnonymousQueue();
        }

        @Bean
        public Binding binding1(FanoutExchange fanout, Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
        }

        @Bean
        public Binding binding2(FanoutExchange fanout, Queue autoDeleteQueue2) {
            return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
        }

        @Bean
        public Tut3Receiver receiver() {
            return new Tut3Receiver();
        }

    }

    @Profile("sender")
    @Bean
    public Tut3Sender sender() {
        return new Tut3Sender();
    }
}