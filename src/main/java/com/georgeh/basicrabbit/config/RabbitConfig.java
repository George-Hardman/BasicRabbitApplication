package com.georgeh.basicrabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create a Rabbit pipeline with 3 queues, direct exchanges and a single fanout exchange
 */
@Configuration
public class RabbitConfig {
    // Get the names from application.properties
    @Value("${rabbit.queue.queue1.name}")
    private String queue1Name;
    @Value("${rabbit.queue.queue2.name}")
    private String queue2Name;
    @Value("${rabbit.queue.queue3.name}")
    private String queue3Name;
    @Value("${rabbit.exchange.exchange1.name}")
    private String exchangeName;
    @Value("${rabbit.routingKey.routingKey1.name}")
    private String routingKey1;
    @Value("${rabbit.routingKey.routingKey2.name}")
    private String routingKey2;
    @Value("${rabbit.routingKey.routingKey3.name}")
    private String routingKey3;
    @Value("${rabbit.exchange.fanout.name}")
    private String fanout;

    /**
     * Create the RabbitMQ structure required
     * @return the vatious Rabbit components.
     */
    @Bean
    public Declarables fanoutBinding() {
        Queue queue1 = new Queue(queue1Name);
        Queue queue2 = new Queue(queue2Name);
        Queue queue3 = new Queue(queue3Name);
        Exchange exchange = ExchangeBuilder.directExchange(exchangeName).build();
        FanoutExchange fanoutExchange = new FanoutExchange(fanout);

        Binding binding1 = BindingBuilder.bind(queue1).to(exchange).with(routingKey1).noargs();
        Binding binding2 = BindingBuilder.bind(queue2).to(exchange).with(routingKey2).noargs();
        Binding binding3 = BindingBuilder.bind(queue3).to(exchange).with(routingKey3).noargs();

        Binding fan1 = BindingBuilder.bind(queue1).to(fanoutExchange);
        Binding fan2 = BindingBuilder.bind(queue2).to(fanoutExchange);
        Binding fan3 = BindingBuilder.bind(queue3).to(fanoutExchange);

        return new Declarables(
                queue1,
                queue2,
                queue3,
                exchange,
                fanoutExchange,
                binding1,
                binding2,
                binding3,
                fan1,
                fan2,
                fan3
        );

    }
}
