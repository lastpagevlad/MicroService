package org.example.utils;

import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.example.dto.MessageDto;
import org.example.dto.UserDto;
import org.example.store.entity.Message;
import org.example.store.entity.User;
import org.example.store.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MappingUtils {

    private  final UserRepository userRepository;
    public static UserDto mapToUserDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastname(user.getLastname());
        dto.setSurname(user.getSurname());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static User mapToUser(UserDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setLastname(dto.getLastname());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());
        return user;
    }

    public static MessageDto mapToMessageDto(Message message){
        MessageDto dto = new MessageDto();
        dto.setId(message.getId());
        dto.setMessageSend(message.getMessageSend());
        dto.setDateSending(message.getDateSending());
        dto.setUserId(message.getId());
        return dto;
    }

    public  Message mapToMessage(MessageDto dto){
        Message message = new Message();
        message.setId(dto.getId());
        message.setMessageSend(dto.getMessageSend());
        message.setDateSending(dto.getDateSending());
        message.setUser(userRepository.findById(dto.getUserId()).orElseThrow(() ->
                new NoSuchElementException(String.format("user with id: %s not found", dto.getUserId()))));
        return message;
    }

}
