package clowoodive.example.book.springinaction.taco.data;

import clowoodive.example.book.springinaction.taco.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
}
