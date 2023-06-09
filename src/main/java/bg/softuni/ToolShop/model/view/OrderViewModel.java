package bg.softuni.ToolShop.model.view;


import bg.softuni.ToolShop.model.enums.CategoryNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class OrderViewModel {

    private Long  id;

    private String title;

    private BigDecimal price;

    private CategoryNameEnum category;

    private String description;

    private String toolUrl;



}
