package bg.softuni.ToolShop.model.dtos;

import bg.softuni.ToolShop.model.entity.Tool;
import bg.softuni.ToolShop.model.entity.UserEntity;
import bg.softuni.ToolShop.model.enums.UserRoleEnum;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public class OrderDTO {

    private Long id;

    @NotNull
    private BigDecimal price;

    private UserEntity customer;

    private List<Tool> tools;

}
