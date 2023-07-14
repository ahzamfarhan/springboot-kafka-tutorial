package net.javaguides.springboot.kafka;

import net.javaguides.springboot.payloads.User;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

	/*
	   Listener method consume(User user) annotated with @KafkaListener 
	   annotation will automatically get json format
	   message converted into Java instance of type User automatically 
	   due to JsonDeserializer will be working behind the scene
	*/

	public JsonKafkaConsumer () {

		System.out.println("### TOPIC NAME ###");
		System.out.println("${spring.kafka.consumer-group}");
	}

	@KafkaListener(topics = "${spring.kafka.json.topic.name}",
			groupId="${spring.kafka.consumer-group}")
	public void consumer(User user) {
		
		LOGGER.info(String.format("Json message received : %s", user.toString()));
	}
}