package net.javaguides.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String textTopic;

    @Value("${spring.kafka.json_topic.name}")
    private String jsonTopic;

    /*
    * Creating Topic  by specified name and then injecting it
    * in the SpringBoot context. Type of the topic is NewTopic from Kafka
    * where TopicBuilder is from SpringBoot.
    *
    * org.apache.kafka.clients.admin.NewTopic
    * org.springframework.kafka.config.TopicBuilder
    *
    * */
    @Bean
    public NewTopic javaguidesTopic() {

           /*
           Use following code snipet if you want to create the customize number of
           of the partions in the topic instead of relying on default number of
           partions provided during creation of topic by kafka. In the following
           we specify that our topic should have 10 partions in it

         */
        return TopicBuilder.name("javaguides")
            //.partitions(10)
                .build();
    }

}
