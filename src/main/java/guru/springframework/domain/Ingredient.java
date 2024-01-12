package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal amount;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitofMeasure;

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitofMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitofMeasure = unitofMeasure;
    }

}
