package clowoodive.example.book.springinaction.taco.data;

import clowoodive.example.book.springinaction.taco.Taco;

public interface TacoRepository {
    Taco save(Taco design);
}
