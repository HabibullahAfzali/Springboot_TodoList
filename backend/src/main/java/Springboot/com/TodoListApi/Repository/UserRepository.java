package Springboot.com.TodoListApi.Repository;
import Springboot.com.TodoListApi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
