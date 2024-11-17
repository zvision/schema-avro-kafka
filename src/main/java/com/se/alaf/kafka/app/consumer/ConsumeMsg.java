package com.se.alaf.kafka.app.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.se.alaf.kafka.app.model.Person;

@Component
public class ConsumeMsg {


    @KafkaListener(topics = "${topic.name}", groupId = "my-group-id" /*, clientIdPrefix ="consumer-my-group-id"*/ )
    public void listen(ConsumerRecord<String, Person> message) {
        System.out.println("Received message: " + message.value());
    }

}
