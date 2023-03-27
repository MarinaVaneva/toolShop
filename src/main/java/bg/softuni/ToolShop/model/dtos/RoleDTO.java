package bg.softuni.ToolShop.model.dtos;

import bg.softuni.ToolShop.model.enums.UserRoleEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RoleDTO {

    private Long id;

    @NotNull
    private UserRoleEnum role;
}
