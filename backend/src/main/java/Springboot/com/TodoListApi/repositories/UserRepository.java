package Springboot.com.TodoListApi.repositories;

import Springboot.com.TodoListApi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {


}
