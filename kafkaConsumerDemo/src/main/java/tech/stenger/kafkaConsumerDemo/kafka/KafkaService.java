package tech.stenger.kafkaConsumerDemo.kafka;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaService {

  private KafkaConsumer kafkaConsumer;
  private Properties kafkaProps;

  public void init() {
    kafkaProps = new Properties();

    kafkaProps.put("bootstrap.servers", "localhost:29092");
    kafkaProps.setProperty("group.id", "my-group-id");
    kafkaProps.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    kafkaProps.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    kafkaProps.setProperty("enable.auto.commit", "true");
    kafkaProps.setProperty("auto.commit.interval.ms", "1000");

    kafkaConsumer = new KafkaConsumer<String, String>(kafkaProps);
  }

  public void readMessages() {
    kafkaConsumer.subscribe(List.of("testTopic"));

    while (true) {

      ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));
      for (ConsumerRecord<String, String> record : records) {
        System.out.printf("received message: %s\n", record.value());
      }
    }
  }
}
