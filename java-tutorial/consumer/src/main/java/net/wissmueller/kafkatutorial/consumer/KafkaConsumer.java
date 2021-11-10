package net.wissmueller.kafkatutorial.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
  private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

  @KafkaListener(topics = "timestamp", containerFactory = "kafkaListenerContainerFactory")
  void listener(TimestampEvent event) {
    log.info("Received: {}", event.getTimestamp()
                                  .toString());
  }
}
