package bg.softuni.ToolShop.model.binding;

import bg.softuni.ToolShop.model.entity.Tool;
import bg.softuni.ToolShop.model.entity.UserEntity;
import bg.softuni.ToolShop.model.enums.CategoryNameEnum;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class OrderAddBindingModel {

    private Long id;

    @NonNull
    @Positive
    private BigDecimal price;

    private UserEntity customer;

    private List<Tool> tools;

    private Date orderTime;


}
