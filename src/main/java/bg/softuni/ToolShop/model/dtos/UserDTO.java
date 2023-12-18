package bg.softuni.ToolShop.model.dtos;

import jakarta.validation.constraints.NotNull;

public class UserDTO {
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String email;
    @NotNull
    private RoleDTO role;

    public RoleDTO getRole() {
        return role;
    }

    public UserDTO setRole(RoleDTO role) {
        this.role = role;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}