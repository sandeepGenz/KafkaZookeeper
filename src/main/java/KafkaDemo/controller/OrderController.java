package KafkaDemo.controller;

import KafkaDemo.dto.OrderEvent;
import KafkaDemo.producer.OrderProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    public OrderProducer orderProducer;
    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderEvent orderEvent) {
        orderProducer.sendOrder(orderEvent);
        return ResponseEntity.ok("Order published to: " + orderEvent.getOrderId());
    }
}
