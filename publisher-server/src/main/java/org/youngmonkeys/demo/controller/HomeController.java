package org.youngmonkeys.demo.controller;


import org.youngmonkeys.demo.entities.Message;
import org.youngmonkeys.demo.kafka.listener.KafkaTopicListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private KafkaTopicListener kafkaTopicListener;
    @PostMapping(value = "/send-msg-topic")
    public String sendMsgToTopic(@RequestBody Message message){
        kafkaTopicListener.sendMessage(message.getTopic(),message.getData().toString());
        return "Conght";
    }

    @GetMapping(value = "/")
    public String Home(){

        return "";
    }
}
