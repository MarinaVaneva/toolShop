package bg.softuni.ToolShop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Positive
    @Column(nullable = false)
    private BigDecimal price;


    @ManyToOne
    private UserEntity customer;

    @OneToMany
    private List<Tool> tools;

    private Date orderTime;


}
