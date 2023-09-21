package org.example.utils;

import org.example.dto.MessageDto;
import org.example.dto.UserDto;
import org.example.store.entity.Message;
import org.example.store.entity.User;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {
    public UserDto mapToUserDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastname(user.getLastname());
        dto.setSurname(user.getSurname());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public User mapToUser(UserDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setLastname(dto.getLastname());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());
        return user;
    }

    public MessageDto mapToMessageDto(Message message){
        MessageDto dto = new MessageDto();
        dto.setId(message.getId());
        dto.setMessageSend(message.getMessageSend());
        dto.setDateSending(message.getDateSending());
        dto.setUser(message.getUser());
        return dto;
    }

    public Message mapToMessage(MessageDto dto){
        Message message = new Message();
        message.setId(dto.getId());
        message.setMessageSend(dto.getMessageSend());
        message.setDateSending(dto.getDateSending());
        message.setUser(dto.getUser());
        return message;
    }

}
