package net.wissmueller.kafkatutorial.producer;

import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
  private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

  @Autowired
  private KafkaTemplate<String, TimestampEvent> kafkaTemplate;

  @Scheduled(fixedRate = 5000)
  public void reportCurrentTime() {
    var event = new TimestampEvent(ZonedDateTime.now());
    kafkaTemplate.send("timestamp", event);
    log.info("Sent: {}", event.getTimestamp().toString());
  }
}
