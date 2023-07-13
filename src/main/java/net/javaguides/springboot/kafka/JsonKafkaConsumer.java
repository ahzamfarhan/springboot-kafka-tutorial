package net.javaguides.springboot.kafka;

/*
import net.javaguides.springboot.payloads.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

	*//*
	   Listener method consume(User user) annotated with @KafkaListener 
	   annotation will automatically get json format
	   message converted into Java instance of type User automatically 
	   due to JsonDeserializer will be working behind the scene
	*//*

	//@KafkaListener(topics = "${spring.kafka.json_topic.name}", groupId="${spring.kafka.group.name}")
	@KafkaListener(topics = "javaguides_json", groupId="myGroup")
	public void consumer(User user) {
		
		LOGGER.info(String.format("Json message received : %s", user.toString()));
	}
}
*/