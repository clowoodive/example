package clowoodive.example.book.springinaction.taco.data;

import clowoodive.example.book.springinaction.taco.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> { // 첫번째 매개변수 : 저장되는 개체 타입, 두번째 매개변수 : 개체 ID 속성
//    Iterable<Ingredient> findAll();
//    Ingredient findById(String id);
//    Ingredient save(Ingredient ingredient);
}
