package KafkaDemo.producer;

import KafkaDemo.dto.OrderEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
    private final String topic;

    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate,
                         @Value("${app.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendOrder(OrderEvent order) {
        kafkaTemplate.send(topic, order.getOrderId(), order)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.printf("""
                            Sent key=%s partition=%d offset=%d%n""",
                                order.getOrderId(),
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());
                    } else {
                        System.err.println("Failed to send message: " + ex.getMessage());
                    }
                });
    }

}
