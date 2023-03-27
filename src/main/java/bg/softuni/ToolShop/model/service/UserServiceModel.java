package bg.softuni.ToolShop.model.service;

import bg.softuni.ToolShop.model.entity.UserRoleEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserServiceModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String country;
    private String password;
    private String email;
    private UserRoleEntity role;
}
