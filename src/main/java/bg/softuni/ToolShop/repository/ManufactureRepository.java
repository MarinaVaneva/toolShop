package bg.softuni.ToolShop.repository;

import bg.softuni.ToolShop.model.entity.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Long> {
   Optional<Manufacture> findManufactureByName(String name);
}
