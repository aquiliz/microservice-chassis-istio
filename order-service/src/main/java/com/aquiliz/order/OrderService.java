package com.aquiliz.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class OrderService {

  public static final String INVENTORY_SERVICE_URL = "http://inventory-service:8080/inventory/";

  private RestTemplate restTemplate;

  public OrderService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public void order(String productId, Integer quantity) {
    var result = restTemplate.getForObject(INVENTORY_SERVICE_URL + productId, Integer.class);
    log.info("Retreived from inventory service quantity={} for productId={}", result, productId);
    log.info("Placing order...");
  }
}
