package com.se.alaf.kafka.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.se.alaf.kafka.app.model.Person;
import com.se.alaf.kafka.app.producer.ProduceMsg;

@RestController
public class DemoController {

	@Autowired
	private ProduceMsg messageProducer;

	@Value("${topic.name}")
	private String topic;

	@PostMapping("/event")
	public String send(@RequestBody Person person) {
		// we must use the newBuilder() method of the Avro generated class
		// in order for the default values to be picked
		Person aPerson = Person.newBuilder().build();
		aPerson.setFirstname(person.getFirstname());
		aPerson.setLastname(person.getLastname());
		if (person.getAge() != 0)
			aPerson.setAge(person.getAge());
		messageProducer.send(topic, aPerson);
		return "Message sent: " + aPerson.toString();
	}

}
