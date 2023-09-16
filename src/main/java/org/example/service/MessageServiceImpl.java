package org.example.service;

import org.example.store.entity.Message;
import org.example.store.repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //почитай про аннотацию
@RequiredArgsConstructor

public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;


    @Override
    public Message create(Message message) {
        int n = 5;
        return messageRepository.save(message); //проверка создания запроса
    }

    @Override
    public List<Message> readAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message read(int id) {
        return messageRepository.findById(id).orElseThrow();
    }

    @Override
    public Message update(Message message, int id) {
        var updateMessage = messageRepository.findById(id).orElseThrow();
        updateMessage.setMessageSend(message.getMessageSend());
        updateMessage.setDate_sending(message.getDate_sending());
        return messageRepository.save(updateMessage);
    }

    @Override
    public void delete(int id) {
        messageRepository.deleteById(id);
    }
}
