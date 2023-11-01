package clowoodive.example.book.springinaction.taco;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
// @Data에 의한 인자가 있는 생성자는 noArgs 설정으로 제거되지만 @RequiredArgsConstructor를 붙이면 계속사용 할수 있음.
// noArgs 생성자는 final 속성들로 인해 허용되지 않지만, force=true로 해결하고, 클래스 외부에서 사용하지 못하도록 AccessLevel.PRIVATE로 설정함.
// 따라서 Lombok의 자동 생성자에서 final 속성들을 null로 세팅함.
@NoArgsConstructor(access = AccessLevel.PRIVATE, force=true)
@Entity
public class Ingredient {
    @Id
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}

