package org.example.service;

import org.example.dto.MessageDto;
import org.example.store.entity.Message;

import java.util.List;

public interface MessageService {

    Message create(Message message);
    List<MessageDto> readAll();
    MessageDto read(int id);
    Message update(Message message, int id);
    void delete(int id);
}
