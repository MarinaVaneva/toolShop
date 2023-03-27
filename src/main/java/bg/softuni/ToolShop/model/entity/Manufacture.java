package bg.softuni.ToolShop.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "manufactures")
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//@OneToMany(mappedBy = "manufactures", fetch = FetchType.EAGER)
    @Transient
    private  List<Tool> tools;
//    private List<Tool> tools;
}
