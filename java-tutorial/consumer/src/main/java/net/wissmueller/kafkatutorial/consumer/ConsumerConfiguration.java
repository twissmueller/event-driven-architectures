package net.wissmueller.kafkatutorial.consumer;

import java.util.HashMap;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class ConsumerConfiguration {

  @Bean
  public ConsumerFactory<String, TimestampEvent> consumerFactory() {
    var timestampEventDeserializer = new JsonDeserializer<TimestampEvent>(TimestampEvent.class);
    timestampEventDeserializer.setRemoveTypeHeaders(false);
    timestampEventDeserializer.addTrustedPackages("*");
    timestampEventDeserializer.setUseTypeMapperForKey(true);

    var props = new HashMap<String, Object>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "tutorialGroup");

    return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), timestampEventDeserializer);
  }

  @Bean
  public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, TimestampEvent>> kafkaListenerContainerFactory() {
    var factory = new ConcurrentKafkaListenerContainerFactory<String, TimestampEvent>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }

  @Bean
  public NewTopic timestampTopic() {
    return TopicBuilder.name("timestamp")
                       .build();
  }

}
