package org.example.service;

import org.example.dto.MessageDto;
import org.example.store.entity.Message;
import org.example.store.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.example.store.repository.UserRepository;
import org.example.utils.MappingUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
    public List<MessageDto> readAll() {
        return messageRepository.findAll().stream().map(MappingUtils::mapToMessageDto).collect(Collectors.toList());
    }

    @Override
    public MessageDto read(int id) {
        var a = MappingUtils.mapToMessageDto(messageRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException(String.format("message with id: %s not found", id))));
        return a;
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
