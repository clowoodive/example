package clowoodive.example.book.springinaction.taco.data;

import clowoodive.example.book.springinaction.taco.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
//    Order save(Order order);
}
