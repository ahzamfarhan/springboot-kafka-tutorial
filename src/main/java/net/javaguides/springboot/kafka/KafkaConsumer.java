package net.javaguides.springboot.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaConsumer {

	private final static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	/*
          We have subscribed the subscribe method by using @KafkaListener annotation. We also
	  provided the name of the topic to topics attribute to receive the 
	  event and message. we assigned the javaguides topic name to topics attribute.
       ??You can assign more than one topic??
 
      we created, configured and inject javaguides topic in our SpringBoot Context as spring
      managed bean by using configuration class which name is KafkaTopicConfig. This class is
      annotated with @Configuration

	  The event and message is received by this method as argument.
	  We also need to associate our subscribed consumer to some consumer group for that we
	  we specified myGroup to groupId attribute. myGroup is the consumer groupId. We have created
	  this group in application.properties file using following key value pair

		spring.kafka.consumer.group-id: myGroup
	*/

	//@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.group.name}")

	@KafkaListener(topics = "javaguides", groupId = "myGroup")
	public void subscribe(String message) {

		String formattedMessage = String.format("Message received -> %s", message);
		LOGGER.info(formattedMessage);
		System.out.println(formattedMessage);
	}
}