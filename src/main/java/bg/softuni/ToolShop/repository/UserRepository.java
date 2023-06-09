package bg.softuni.ToolShop.repository;

import bg.softuni.ToolShop.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findUserEntityByEmail(String email);

  @Query("select u from UserEntity u order by size(u.orders) DESC")
  List<UserEntity> findAllUserAndCountOfOrdersOrderByCountDesc();
}
