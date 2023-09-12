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
    public void create(Message message) {

    }

    @Override
    public List<Message> readAll() {
        return null;
    }

    @Override
    public Message read(int message_id) {
        return null;
    }

    @Override
    public boolean update(Message message, int message_id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
