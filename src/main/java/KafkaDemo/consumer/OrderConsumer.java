package KafkaDemo.consumer;

import KafkaDemo.dto.OrderEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
 @Service
 public class OrderConsumer {

        @KafkaListener(topics = "${app.topic}", groupId = "order-consumer-group")
        public void listen(ConsumerRecord<String, OrderEvent> record) {
            OrderEvent event = record.value();
            System.out.println("Consumed record: offset=" + record.offset() + " key=" + record.key() + " value=" + event);
            // Simulate processing:
            // e.g., update inventory DB, call payment service, etc.
            //
        }
 }

