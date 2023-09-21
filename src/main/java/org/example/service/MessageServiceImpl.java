package org.example.service;

import jakarta.validation.ValidationException;
import org.example.store.entity.Message;
import org.example.store.repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor

public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;


    @Override
    public Message create(Message message) {
            message.setUser(userRepository.findById(message.getUser().getId()).get());
            return messageRepository.save(message);
    }

    @Override
    public List<Message> readAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message read(int id) {
        return messageRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException(String.format("message with id: %s not found", id)));
    }

    @Override
    public Message update(Message message, int id) {
        var updateMessage = messageRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException(String.format("message with id: %s not found", id))
        );
        if (message.getUser() == null || message.getUser().getId()==null) {
            updateMessage.setUser(null);
        } else
        {
            var idUser = message.getUser().getId();
            updateMessage.setUser(userRepository.findById(idUser).orElseThrow(() ->
                    new NoSuchElementException(String.format("user with id: %s not found", idUser)))
            );
        }
        updateMessage.setMessageSend(message.getMessageSend());
        updateMessage.setDateSending(message.getDateSending());
        return messageRepository.save(updateMessage);
    }

    @Override
    public void delete(int id) {
        messageRepository.deleteById(id);
    }
}
