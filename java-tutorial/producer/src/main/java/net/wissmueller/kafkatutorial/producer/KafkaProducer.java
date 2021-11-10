package net.wissmueller.kafkatutorial.producer;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
  private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  private KafkaTemplate<String, String> kafkaTemplate;

  KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  void sendMessage(String message, String topicName) {
    kafkaTemplate.send(topicName, message);
  }

  @Scheduled(fixedRate = 5000)
  public void reportCurrentTime() {
    String timestamp = dateFormat.format(new Date());
    sendMessage(timestamp, "timestamp");
    log.info("Sent: {}", timestamp);
  }
}
