package org.example.dto;
import lombok.Data;
import org.example.store.entity.User;

import java.util.Date;

@Data
public class MessageDto {
    Integer id;
    String messageSend;
    Date dateSending;
    Integer userId;
}
