package bg.softuni.ToolShop.model.dtos;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ManufactureDTO {

    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "manufactures")
    private List<ToolDTO> tools;
}
