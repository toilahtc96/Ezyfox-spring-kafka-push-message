package com.kafka.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageContent {
    private String message;

    @Override
    public String toString() {
        return "{" +
                "\"message\":\"" + message + "\"" +
                '}';
    }
}
