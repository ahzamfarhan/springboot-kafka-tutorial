package net.javaguides.springboot.controllers;

import net.javaguides.springboot.kafka.JsonKafkaProducer;
import net.javaguides.springboot.payloads.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka/json")
public class JsonMessageController {

	private JsonKafkaProducer jsonKafkaProducer;

	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {

		this.jsonKafkaProducer = jsonKafkaProducer;
	}

	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user) {

		jsonKafkaProducer.sendMessage(user);

		return ResponseEntity.ok("Json message sent to kafka topic");
	}
}