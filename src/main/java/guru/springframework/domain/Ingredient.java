package guru.springframework.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitofMeasure;

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitofMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitofMeasure = unitofMeasure;
    }

    public UnitOfMeasure getUnitofMeasure() {
        return unitofMeasure;
    }

    public void setUnitofMeasure(UnitOfMeasure unitofMeasure) {
        this.unitofMeasure = unitofMeasure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
