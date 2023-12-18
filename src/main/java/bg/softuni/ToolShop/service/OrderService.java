package bg.softuni.ToolShop.service;


import bg.softuni.ToolShop.model.entity.Order;
import bg.softuni.ToolShop.model.service.OrderServiceModel;
import bg.softuni.ToolShop.model.view.OrderViewModel;
import bg.softuni.ToolShop.repository.OrderRepository;
import bg.softuni.ToolShop.service.sec.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService  {
private final OrderRepository orderRepository;
private final ModelMapper modelMapper;
private final UserService userService;
private final CurrentUser currentUser;


@Autowired
    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper, UserService userService, CurrentUser currentUser) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;

    this.currentUser = currentUser;
}


    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = modelMapper.map(orderServiceModel, Order.class);
        order.setCustomer(userService.findById(currentUser.getId()));


        orderRepository.save(order);
    }


    public List<OrderViewModel> findAllOrderByPriceDesc() {
        return orderRepository.findAllByOrderByPriceDesc().stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }


    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
