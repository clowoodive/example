package clowoodive.example.book.springinaction.taco.web;

import clowoodive.example.book.springinaction.taco.Ingredient;
import clowoodive.example.book.springinaction.taco.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> { // request에서(아마도) 파라미터를 컨버팅하기 위한 용도(db에 저장되어 있으므로)
    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
//        return ingredientRepo.findById(id);
        Optional<Ingredient> optionalIngredient = ingredientRepo.findById(id);
        return optionalIngredient.isPresent() ? optionalIngredient.get() : null;
    }
}
