package com.message.service.service;

import com.message.service.domain.Message;
import com.message.service.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message getMessage(Message message) {
        return messageRepository.save(message);
    }
}
