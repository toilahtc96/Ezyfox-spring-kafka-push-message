package org.youngmonkeys.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageInfoData {
    private String username;
    private MessageContent messageContent;

    @Override
    public String toString() {
        return "{" +
                "\"username\":\"" + username + "\"" +
                ", \"data\":" + messageContent.toString() +
                '}';
    }
}

