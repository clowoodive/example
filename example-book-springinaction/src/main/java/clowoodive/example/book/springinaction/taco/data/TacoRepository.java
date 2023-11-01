package clowoodive.example.book.springinaction.taco.data;

import clowoodive.example.book.springinaction.taco.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
//    Taco save(Taco design);
}
