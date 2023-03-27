package bg.softuni.ToolShop.model.dtos;

import bg.softuni.ToolShop.model.enums.CategoryNameEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ToolDTO {
    private Long id;

    @NonNull
    private String title;

    @Enumerated(EnumType.STRING)
    private CategoryNameEnum category;

    private String description;

    @NonNull
    @Positive
    private Double price;


    private ManufactureDTO manufactures;
}
