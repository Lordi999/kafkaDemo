package tech.stenger.kafkaProducerDemo.controller.dto;

public class KafkaMessageDto {
  private String topic;
  private String message;

  public String getTopic() {
    return topic;
  }

  public String getMessage() {
    return message;
  }

}
