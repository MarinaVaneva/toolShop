package bg.softuni.ToolShop.sec;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Setter
@Getter
@NoArgsConstructor
@Component
@SessionScope
public class CurrentUser {
//    private Long id;
    private String username;
}
