package bg.softuni.ToolShop.model.entity;

import bg.softuni.ToolShop.model.enums.CategoryNameEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tools")
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;


    private CategoryNameEnum categories;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @NonNull
    @Positive
    @Column(nullable = false)
    private Double price;

    @ManyToOne
     private Manufacture manufactures;

    public Tool setId(Long id) {
        this.id = id;
        return this;
    }

    public Tool setTitle(String title) {
        this.title = title;
        return this;
    }

    public Tool setCategories(CategoryNameEnum categories) {
        this.categories = categories;
        return this;
    }

    public Tool setDescription(String description) {
        this.description = description;
        return this;
    }

    public Tool setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Tool setManufactures(Manufacture manufactures) {
        this.manufactures = manufactures;
        return this;
    }
}

