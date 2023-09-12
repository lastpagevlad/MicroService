package org.example.store.repository;

import org.example.store.entity.Message;
import org.example.store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    // такое объявление методов чувствительно к названию, тк по нему генерит то что-то будет внутри
    // про это тоже надо почитать - QueryByExampleExecutor
//    List<Message> findAllByName(String name);
}
