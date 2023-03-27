package bg.softuni.ToolShop.model.view;

import bg.softuni.ToolShop.model.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserViewModel {
    private String firstName;
    private String lastName;
    private Integer countOfTools;
    private List<Order> orders;

}
