package bg.softuni.ToolShop.repository;


import bg.softuni.ToolShop.model.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface  ToolRepository extends JpaRepository <Tool, Long>{

}
