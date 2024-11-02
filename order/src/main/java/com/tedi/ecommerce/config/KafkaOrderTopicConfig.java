package com.tedi.ecommerce.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author Tedi Kondakçiu
 */

@Configuration
public class KafkaOrderTopicConfig {

    @Bean
    public NewTopic orderTopic(){
        return TopicBuilder.name("order-topic").build();
    }
}
