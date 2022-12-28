package tech.stenger.kafkaProducerDemo.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaService {

  private KafkaProducer kafkaProducer;
  private Properties kafkaProps;

  public KafkaService() {
    kafkaProps = new Properties();

    kafkaProps.put("bootstrap.servers", "localhost:29092");
    kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    kafkaProps.put("acks", "all");
    kafkaProps.put("retries", 0);
    kafkaProps.put("linger.ms", 0);
    kafkaProps.put("partitioner.class",
                   "org.apache.kafka.clients.producer.internals.DefaultPartitioner");
    kafkaProps.put("request.timeout.ms", 30000);
    kafkaProps.put("timeout.ms", 30000);
    kafkaProps.put("max.in.flight.requests.per.connection", 5);
    kafkaProps.put("retry.backoff.ms", 5);

    kafkaProducer = new KafkaProducer<String, String>(kafkaProps);
  }

  public void sendMessage(String topic, String message) {
    ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
    try {
      kafkaProducer.send(record).get();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
