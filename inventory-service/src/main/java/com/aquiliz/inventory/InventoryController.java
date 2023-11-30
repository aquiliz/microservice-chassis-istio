package com.aquiliz.inventory;

import jakarta.websocket.server.PathParam;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/inventory")
@Slf4j
public class InventoryController {

  @GetMapping("/{productId}")
  public Integer getAvailableQuantity(@PathParam("productId") String productId) {
    log.info("Entered inventory service with productId={}", productId);
    return new Random().nextInt();
  }
}
