package com.message.service.controller;

import com.message.service.domain.Message;
import com.message.service.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<?> getMessage(@RequestBody Message message){
        Message savedMessage = messageService.getMessage(message);
        return ResponseEntity.ok(savedMessage);
    }
}
