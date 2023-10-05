package org.example.store.repository;

import org.example.store.entity.Message;
import org.example.store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
//    @Query(nativeQuery = true, value = )
//    List<Message> findAllByUser_Id(Integer id);
}
