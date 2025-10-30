package com.list.todolist2.repository;

import com.list.todolist2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
    public User findByUsername(String username);
    public User findByUsernameAndPassword(String username, String password);
//    public User findById(int id);
}
