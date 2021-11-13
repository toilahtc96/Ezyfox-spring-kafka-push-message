package org.example.app.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.app.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSpringMessageHandler {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @KafkaListener(topics = "message", groupId = "group-id")
    public void listen(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        Message kafkaMessage = new Message();
        try {
            kafkaMessage = objectMapper.readValue(data, Message.class);
        } catch (JsonProcessingException e) {
            System.out.println("Khong dung dinh dang message");
            e.printStackTrace();
            return;
        }

        System.out.println("Received Message in group - group-id: " + kafkaMessage.getData().get("message"));
        AppConfig.responseFactory.newObjectResponse()
                .command("message")
                .usernames(kafkaMessage.getUsername())
                .data(kafkaMessage.getData())
                .execute();
    }


}
