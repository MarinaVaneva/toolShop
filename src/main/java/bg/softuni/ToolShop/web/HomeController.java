package bg.softuni.ToolShop.web;


import bg.softuni.ToolShop.model.view.OrderViewModel;
import bg.softuni.ToolShop.service.sec.CurrentUser;
import bg.softuni.ToolShop.service.OrderService;
import bg.softuni.ToolShop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

private final CurrentUser currentUser;
private final OrderService orderService;

private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping()
    public String Index(Model model){
        if(currentUser.getId() == null) {
            return "index";
        }
        List<OrderViewModel> orders = orderService.findAllOrderByPriceDesc();

        model.addAttribute("orders", orders);


      model.addAttribute("users", userService.findAllUserAndCountOfOrdersOrderByCountDesc());

        return "home";
    }
}
