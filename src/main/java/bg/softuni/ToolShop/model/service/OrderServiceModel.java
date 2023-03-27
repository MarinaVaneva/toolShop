package bg.softuni.ToolShop.model.service;

import bg.softuni.ToolShop.model.entity.Tool;
import bg.softuni.ToolShop.model.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class OrderServiceModel {
    private Long id;

    private BigDecimal price;

    private String description;

    private UserEntity customer;

    private List<Tool> tools;

}
