package org.example.service;

import org.example.store.entity.Message;

import java.util.List;

public interface MessageService {

    void create(Message message);
    List<Message> readAll();
    Message read(int message_id);
    boolean update(Message message, int message_id);
    boolean delete(int id);
}
