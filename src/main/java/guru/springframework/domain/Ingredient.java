package guru.springframework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal amount;

    @ManyToOne
//    @EqualsAndHashCode.Exclude
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitofMeasure;

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitofMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitofMeasure = unitofMeasure;
    }

}
