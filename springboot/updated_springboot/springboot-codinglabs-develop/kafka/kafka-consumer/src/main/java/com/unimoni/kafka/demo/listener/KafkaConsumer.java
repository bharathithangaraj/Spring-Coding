package com.unimoni.kafka.demo.listener;

import com.unimoni.kafka.demo.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }

    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json1",
        containerFactory = "userKafkaListenerFactory")
    public void consumeJson2(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }

}
