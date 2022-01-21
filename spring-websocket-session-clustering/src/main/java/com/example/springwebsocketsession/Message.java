package com.example.springwebsocketsession;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String type;
    private String sender;
    private String receiver;
    private Object data;
}