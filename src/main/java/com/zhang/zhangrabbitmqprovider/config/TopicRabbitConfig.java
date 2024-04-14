package com.zhang.zhangrabbitmqprovider.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class TopicRabbitConfig {
    @Bean
    public Queue firstQueue() {
        return new Queue("topicMan",true);
    }
    @Bean
    public Queue secondQueue() {
        return new Queue("topicWoman",true);
    }
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange",true,false);
    }
    @Bean
    Binding bindingExchangeMessage1() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with("topicMan");
    }
    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topicWoman");
    }

}
