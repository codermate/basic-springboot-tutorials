package com.denpaden.rabbitmqpublisher.rabbitmq.config;




import org.springframework.amqp.core.*;
//import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by DenPaden on 19/08/2022.
 */
@Configuration
public class UserMessageConfig {
    public static final String QUEUE_GET_USER = "queue_get_user";
    public static final String EXCHANGE_GET_USER = "exchange_get_user";
    public static final String BIND_GET_USER = "bind_get_user";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_GET_USER);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_GET_USER);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BIND_GET_USER);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;

    }
}
