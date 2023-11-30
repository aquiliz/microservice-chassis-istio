package com.aquiliz.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

  private OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  public void placeOrder(@RequestBody Order order) {
    log.info("Placing order: {}", order);
    orderService.order(order.productId, order.quantity);
    log.info("Successfully placed order: {}", order);
  }

  public record Order(String productId, Integer quantity) {};
}
