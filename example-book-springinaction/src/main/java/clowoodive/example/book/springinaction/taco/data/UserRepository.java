package clowoodive.example.book.springinaction.taco.data;

import clowoodive.example.book.springinaction.taco.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
