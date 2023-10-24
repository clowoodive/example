package clowoodive.example.book.springinaction.taco.data;

import clowoodive.example.book.springinaction.taco.Order;

public interface OrderRepository {
    Order save(Order order);
}
