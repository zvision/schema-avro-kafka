package com.se.alaf.kafka.app.producer;



import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.se.alaf.kafka.app.model.Person;

@Component
public class ProduceMsg {

    @Autowired
    private KafkaTemplate<String, Person> kafkaPersonTemplate;
    
  
    
    public void send(String topic, Person message) {
        CompletableFuture<SendResult<String, Person>> futureResult =  kafkaPersonTemplate.send(topic, message);
        
        futureResult.whenComplete((res, ex) -> {
        	if (ex == null) {
        		System.out.println("Sent message= [" + message + "] with offset=[" + res.getRecordMetadata().offset() +"]");
        		
        	} else {
        		System.out.println("Unable to send message= [" + ex + "] due to: " + ex.getMessage());
        	}
        });
    }

}


