package bg.softuni.ToolShop.repository;

import bg.softuni.ToolShop.model.entity.UserRoleEntity;
import bg.softuni.ToolShop.model.enums.UserRoleEnum;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
  Optional<UserRoleEntity> findUserRoleEntityByRole(UserRoleEnum role);
}
