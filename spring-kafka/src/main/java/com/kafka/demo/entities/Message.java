package com.kafka.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private MessageInfoData data;
    private String topic;


}
